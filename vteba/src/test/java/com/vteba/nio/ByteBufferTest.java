package com.vteba.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class ByteBufferTest {
	public static void main(String[] args) throws IOException {
		// 创建一个 capacity 为 256 的 ByteBuffer
		ByteBuffer buf = ByteBuffer.allocate(256);
		while (true) {
			// 从标准输入流读入一个字符
			int c = System.in.read();
			// 当读到输入流结束时，退出循环
			if (c == -1)
				break;

			// 把读入的字符写入 ByteBuffer 中
			buf.put((byte) c);
			// 当读完一行时，输出收集的字符
			if (c == '\n') {
				// 调用 flip() 使 limit 变为当前的 position 的值 ,position 变为 0,
				// 为接下来从 ByteBuffer 读取做准备
				buf.flip();
				// 构建一个 byte 数组
				byte[] content = new byte[buf.limit()];
				// 从 ByteBuffer 中读取数据到 byte 数组中
				buf.get(content);
				// 把 byte 数组的内容写到标准输出
				System.out.print(new String(content));
				// 调用 clear() 使 position 变为 0,limit 变为 capacity 的值，
				// 为接下来写入数据到 ByteBuffer 中做准备
				buf.clear();
			}
		}
	}

	protected static void acceptConnections(int port) throws Exception {
		// 打开一个 Selector
		Selector acceptSelector = SelectorProvider.provider().openSelector();

		// 创建一个 ServerSocketChannel ，这是一个 SelectableChannel 的子类
		ServerSocketChannel ssc = ServerSocketChannel.open();
		// 将其设为 non-blocking 状态，这样才能进行非阻塞 IO 操作
		ssc.configureBlocking(false);

		// 给 ServerSocketChannel 对应的 socket 绑定 IP 和端口
		InetAddress lh = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(lh, port);
		ssc.socket().bind(isa);

		// 将 ServerSocketChannel 注册到 Selector 上，返回对应的 SelectionKey
		// SelectionKey acceptKey =
		ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);

		int keysAdded = 0;

		// 用 select() 函数来监控注册在 Selector 上的 SelectableChannel
		// 返回值代表了有多少 channel 可以进行 IO 操作 (ready for IO)
		while ((keysAdded = acceptSelector.select()) > 0) {
			// selectedKeys() 返回一个 SelectionKey 的集合，
			// 其中每个 SelectionKey 代表了一个可以进行 IO 操作的 channel 。
			// 一个 ServerSocketChannel 可以进行 IO 操作意味着有新的 TCP 连接连入了
			Set<SelectionKey> readyKeys = acceptSelector.selectedKeys();
			Iterator<SelectionKey> i = readyKeys.iterator();

			while (i.hasNext()) {
				SelectionKey sk = i.next();
				// 需要将处理过的 key 从 selectedKeys 这个集合中删除
				i.remove();
				// 从 SelectionKey 得到对应的 channel
				ServerSocketChannel nextReady = (ServerSocketChannel) sk
						.channel();
				// 接受新的 TCP 连接
				Socket s = nextReady.accept().socket();
				// 把当前的时间写到这个新的 TCP 连接中
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				Date now = new Date();
				out.println(now);
				// 关闭连接
				out.close();
			}
		}
		System.out.println(keysAdded);
	}
}
