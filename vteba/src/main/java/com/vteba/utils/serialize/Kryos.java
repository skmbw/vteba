package com.vteba.utils.serialize;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.vteba.service.xml.jibx.Customer;
import com.vteba.service.xml.jibx.Person;

/**
 * 基于kryo的序列化转换器。
 * @author yinlei
 * date 2013-4-6 下午2:50:09
 */
public class Kryos {
	private ThreadLocal<Kryo> kryoLocalThreadLocal = new ThreadLocal<Kryo>();

	private static Kryos instance = new Kryos();

	public static Kryos get() {
		return instance;
	}

	private Kryos() {

	}

	/**
	 * 获得当前线程的Kryo
	 * @return Kryo实例
	 * @author yinlei
	 * date 2013-4-6 下午2:50:52
	 */
	public Kryo getKryo() {
		Kryo kryo = kryoLocalThreadLocal.get();

		if (kryo == null) {
			kryo = new Kryo();
			kryo = new Kryo();
			kryo.setRegistrationRequired(true);
			kryo.setReferences(false);
			kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

			kryo.register(Class.class);
			
			kryo.register(byte[].class);
			kryo.register(char[].class);
			kryo.register(short[].class);
			kryo.register(int[].class);
			kryo.register(long[].class);
			kryo.register(float[].class);
			kryo.register(double[].class);
			kryo.register(boolean[].class);
			kryo.register(String[].class);
			kryo.register(Object[].class);
			
			kryo.register(StringBuffer.class);
			kryo.register(StringBuilder.class);
			
			kryo.register(ArrayList.class);
			kryo.register(LinkedList.class);
			kryo.register(CopyOnWriteArrayList.class);
			kryo.register(Vector.class);
			
			kryo.register(HashMap.class);
			kryo.register(TreeMap.class);
			kryo.register(LinkedHashMap.class);
			kryo.register(ConcurrentHashMap.class);

			kryo.register(HashSet.class);
			kryo.register(TreeSet.class);
			kryo.register(LinkedHashSet.class);
			kryo.register(CopyOnWriteArraySet.class);

			kryo.register(BigInteger.class);
			kryo.register(BigDecimal.class);
			kryo.register(Currency.class);
			
			//kryo.register(Enum.class);
			kryo.register(EnumSet.class);

			kryo.register(Date.class);
			kryo.register(java.sql.Date.class);
			kryo.register(Calendar.class);
			kryo.register(TimeZone.class);
			
			//**************注册自定义对象********************//
			kryo.register(Customer.class);
			kryo.register(Person.class);

			kryoLocalThreadLocal.set(kryo);
		}
		return kryo;
	}

	/**
	 * 将对象序列化为byte[]，对象要注册
	 * @param t 要转换的对象
	 * @return 字节数组
	 * @author yinlei
	 * date 2013-4-6 下午2:51:28
	 */
	public byte[] toBytes(Object t) {
		Kryo converter = getKryo();
		Output output = new Output(1024, 4 * 1024);
		converter.writeObject(output, t);

		return output.toBytes();
	}

	/**
	 * 将字节数组反序列化为对象，对象要注册
	 * @param bytes 被转换的字节数组
	 * @param clazz 要转换的对象类型
	 * @return 要转换的对象实例
	 * @author yinlei
	 * date 2013-4-6 下午2:52:11
	 */
	public <T> T fromBytes(byte[] bytes, Class<T> clazz) {
		Kryo converter = getKryo();
		Input input = new Input(bytes);
		return converter.readObject(input, clazz);
	}

	/**
	 * 将字节数组反序列化为对象List，对象要注册
	 * 
	 * @param bytes
	 *            被转换的字节数组
	 * @param clazz
	 *            要转换的对象类型
	 * @return 要转换的对象实例List
	 * @author yinlei date 2013-4-6 下午2:52:11
	 */
	public <T> List<T> fromBytesToList(byte[] bytes, Class<T> clazz) {
		Kryo kryo = getKryo();
		Input input = new Input(bytes);
		@SuppressWarnings("unchecked")
		List<T> list = kryo.readObject(input, ArrayList.class);
		return list;
	}

	public <K, V> Map<K, V> fromBytesToMap(byte[] bytes, Class<K> clazz,
			Class<V> vclass) {
		Kryo kryo = getKryo();
		Input input = new Input(bytes);
		@SuppressWarnings("unchecked")
		Map<K, V> map = kryo.readObject(input, HashMap.class);
		return map;
	}

	public <T> Set<T> fromBytesToSet(byte[] bytes, Class<T> clazz) {
		Kryo kryo = getKryo();
		Input input = new Input(bytes);
		@SuppressWarnings("unchecked")
		Set<T> set = kryo.readObject(input, HashSet.class);
		return set;
	}

	/**
	 * 将对象序列化为字节数组，对象无需注册，性能稍低。字节数变大
	 * @param object 要被序列化的对象
	 * @return 字节数组
	 * @author yinlei date 2013-4-7 下午9:52:43
	 */
	public byte[] serialize(Object object) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		Output out = new Output(2 * 1024, 128 * 1024);
		kryo.writeClassAndObject(out, object);
		return out.toBytes();
	}

	/**
	 * 将字节数组反序列化为对象，对象无需注册，性能稍低
	 * @param bytes 要反序列化的字节数组
	 * @return 反序列化后的对象
	 * @author yinlei date 2013-4-7 下午9:54:00
	 */
	public <T> T deserialize(byte[] bytes) {
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		Input input = new Input(bytes);
		@SuppressWarnings("unchecked")
		T obj = (T) kryo.readClassAndObject(input);
		return obj;
	}
	
	/**
	 * 深拷贝对象。完全新的一个对象。
	 * @param object 被拷贝对象
	 * @param clazz 被拷贝对象类型
	 * @return A new Object
	 */
	public <T> T copy(Object object, Class<T> clazz) {
		Kryo kryo = new Kryo();
		@SuppressWarnings("unchecked")
		T t = (T) kryo.copy(object);
		return t;
	}
	
	/**
	 * 前拷贝对象。新对象的内容将和原对象共享。还是原来的引用。
	 * @param object 被拷贝对象
	 * @param clazz 被拷贝对象类型
	 * @return A new Object
	 */
	public <T> T copyShallow(Object object, Class<T> clazz) {
		Kryo kryo = new Kryo();
		@SuppressWarnings("unchecked")
		T t = (T) kryo.copyShallow(object);
		return t;
	}
}
