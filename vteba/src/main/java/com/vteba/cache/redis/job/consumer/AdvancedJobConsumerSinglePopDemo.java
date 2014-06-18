package com.vteba.cache.redis.job.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.vteba.cache.redis.benchmark.ConcurrentBenchmark;
import com.vteba.cache.redis.scheduler.AdvancedConsumer;
import com.vteba.cache.redis.scheduler.SimpleJobConsumer;
import com.vteba.cache.redis.support.JedisPoolFactory;
import com.vteba.cache.redis.support.JedisUtils;
import com.vteba.utils.common.Threads;

/**
 * 多线程运行ReliableJobConsumer，从"ss.job:ready" list中popup job进行处理。
 * 
 * 可用系统参数benchmark.thread.count 改变线程数.
 * 
 * @author calvin
 */
public class AdvancedJobConsumerSinglePopDemo extends SimpleJobConsumerDemo {

	private AdvancedConsumer consumer;

	public static void main(String[] args) throws Exception {

		threadCount = Integer.parseInt(System.getProperty(ConcurrentBenchmark.THREAD_COUNT_NAME,
				String.valueOf(THREAD_COUNT)));

		pool = JedisPoolFactory.createJedisPool(JedisUtils.DEFAULT_HOST, JedisUtils.DEFAULT_PORT,
				JedisUtils.DEFAULT_TIMEOUT, threadCount);

		ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
		for (int i = 0; i < threadCount; i++) {
			SimpleJobConsumerDemo demo = new SimpleJobConsumerDemo();
			threadPool.execute(demo);
		}

		System.out.println("Hit enter to stop");
		try {
			while (true) {
				char c = (char) System.in.read();
				if (c == '\n') {
					System.out.println("Shutting down");
					threadPool.shutdownNow();
					boolean shutdownSucess = threadPool.awaitTermination(
							SimpleJobConsumer.DEFAULT_POPUP_TIMEOUT_SECONDS + 1, TimeUnit.SECONDS);

					if (!shutdownSucess) {
						System.out.println("Forcing exiting.");
						System.exit(-1);
					}

					return;
				}
			}
		} finally {
			pool.destroy();
		}
	}

	public AdvancedJobConsumerSinglePopDemo() {
		consumer = new AdvancedConsumer("ss", pool);
		consumer.setReliable(true);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				String job = consumer.popupJob();
				if (job != null) {
					handleJob(job);
				} else {
					Threads.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handleJob(String job) {
		super.handleJob(job);
		consumer.ackJob(job);
	}
}
