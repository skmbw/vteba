package com.vteba.utils.json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.collect.Lists;
import com.vteba.user.model.User;

/**
 * 基于Jackson进行JSON和Java对象的相互转换。单例模式
 * 
 * @author yinlei
 * @date 2013-3-29 下午9:48:06
 */
public class JacksonUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);
	private static JacksonUtils instance = new JacksonUtils();

	private JacksonUtils() {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(format);
	}

	/**
	 * 获得JacksonUtils单例。
	 */
	public static JacksonUtils get() {
		return instance;
	}

	public String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.warn("generate json string error, object is {}", object, e);
		}
		return null;
	}

	public byte[] toJsonBytes(Object object) {
		try {
			return objectMapper.writeValueAsBytes(object);
		} catch (JsonProcessingException e) {
			logger.warn("generate json byte[] error, object is {}", object, e);
		}
		return null;
	}

	public void toJson(File resultFile, Object value) {
		try {
			objectMapper.writeValue(resultFile, value);
		} catch (IOException e) {
			logger.warn("write json to File error, object is {}", value, e);
		}
	}

	public void toJson(OutputStream out, Object value) {
		try {
			objectMapper.writeValue(out, value);
		} catch (IOException e) {
			logger.warn("write json to OutputStream error, object is {}",
					value, e);
		}
	}

	public void toJson(Writer writer, Object value) {
		try {
			objectMapper.writeValue(writer, value);
		} catch (IOException e) {
			logger.warn("write json to Write error, object is {}", value, e);
		}
	}

	/**
	 * 将json字符串序列化成简单对象（非Collection，Map等）。可序列化对象数组。
	 * 
	 * @param json
	 *            要被反序列的json字符串
	 * @param clazz
	 *            要被转换成的类型
	 * @return 序列化后的java对象
	 */
	public <T> T fromJson(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error, json={}.", json, e);
		}
		return null;
	}

	/**
	 * 将json字符串反序列成复杂java对象（Collection，Map，数组等）。
	 * 
	 * @param json
	 *            要被反序列的json字符串
	 * @param valueTypeRef
	 *            如：new TypeReference&lt;Map&lt;String,
	 *            List&lt;User&gt;&gt;&gt;(){}，泛型参数即为你要反序列化的目标类型
	 * @return 序列化后的java对象
	 */
	public <T> T fromJson(String json, TypeReference<T> valueTypeRef) {
		try {
			return objectMapper.readValue(json, valueTypeRef);
		} catch (IOException e) {
			logger.warn("parse json string error, json={}.", json, e);
		}
		return null;
	}

	/**
	 * 将json字符串反序列成复杂java对象（Collection，Map，数组等）。
	 * 
	 * @param json
	 *            要被反序列的json字符串
	 * @param valueType
	 *            要被转换成的类型，可以使用下面相应的工具方法进行构造JavaType
	 * @return 序列化后的java对象
	 */
	public <T> T fromJson(String json, JavaType valueType) {
		try {
			return objectMapper.readValue(json, valueType);
		} catch (IOException e) {
			logger.warn("parse json string error, json={}.", json, e);
		}
		return null;
	}

	public <T> T fromJson(byte[] jsonBytes, Class<T> clazz) {
		try {
			return objectMapper.readValue(jsonBytes, clazz);
		} catch (IOException e) {
			logger.warn("parse json byte[] error, json={}.", new String(
					jsonBytes), e);
		}
		return null;
	}

	public <T> T fromJson(byte[] jsonBytes, TypeReference<?> valueTypeRef) {
		try {
			return objectMapper.readValue(jsonBytes, valueTypeRef);
		} catch (IOException e) {
			logger.warn("parse json byte[] error, json={}.", new String(
					jsonBytes), e);
		}
		return null;
	}

	public <T> T fromJson(byte[] jsonBytes, JavaType valueType) {
		try {
			return objectMapper.readValue(jsonBytes, valueType);
		} catch (IOException e) {
			logger.warn("parse json byte[] error, json={}.", new String(
					jsonBytes), e);
		}
		return null;
	}

	public <T> T fromJson(File src, Class<T> valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from File error.", e);
		}
		return null;
	}

	public <T> T fromJson(File src, TypeReference<?> valueTypeRef) {
		try {
			return objectMapper.readValue(src, valueTypeRef);
		} catch (IOException e) {
			logger.warn("parse json from File error.", e);
		}
		return null;
	}

	public <T> T fromJson(File src, JavaType valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from File error.", e);
		}
		return null;
	}

	public <T> T fromJson(Reader src, Class<T> valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from Reader error.", e);
		}
		return null;
	}

	public <T> T fromJson(Reader src, TypeReference<?> valueTypeRef) {
		try {
			return objectMapper.readValue(src, valueTypeRef);
		} catch (IOException e) {
			logger.warn("parse json from Reader error.", e);
		}
		return null;
	}

	public <T> T fromJson(Reader src, JavaType valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from Reader error.", e);
		}
		return null;
	}

	public <T> T fromJson(InputStream src, Class<T> valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from InputStream error.", e);
		}
		return null;
	}

	public <T> T fromJson(InputStream src, TypeReference<?> valueTypeRef) {
		try {
			return objectMapper.readValue(src, valueTypeRef);
		} catch (IOException e) {
			logger.warn("parse json from InputStream error.", e);
		}
		return null;
	}

	public <T> T fromJson(InputStream src, JavaType valueType) {
		try {
			return objectMapper.readValue(src, valueType);
		} catch (IOException e) {
			logger.warn("parse json from InputStream error.", e);
		}
		return null;
	}

	public ArrayType constructArrayType(Class<?> elementType) {
		return objectMapper.getTypeFactory().constructArrayType(elementType);
	}

	public ArrayType constructArrayType(JavaType elementType) {
		return objectMapper.getTypeFactory().constructArrayType(elementType);
	}

	public CollectionType constructCollectionType(
			Class<? extends Collection<?>> collectionClass,
			Class<?> elementClass) {
		return objectMapper.getTypeFactory().constructCollectionType(
				collectionClass, elementClass);
	}

	public CollectionType constructCollectionType(
			Class<? extends Collection<?>> collectionClass, JavaType elementType) {
		return objectMapper.getTypeFactory().constructCollectionType(
				collectionClass, elementType);
	}

	public MapType constructMapType(Class<? extends Map<?, ?>> mapClass,
			JavaType keyType, JavaType valueType) {
		return objectMapper.getTypeFactory().constructMapType(mapClass,
				keyType, valueType);
	}

	public MapType constructMapType(Class<? extends Map<?, ?>> mapClass,
			Class<?> keyClass, Class<?> valueClass) {
		return objectMapper.getTypeFactory().constructMapType(mapClass,
				keyClass, valueClass);
	}

	public JavaType uncheckedSimpleType(Class<?> cls) {
		return objectMapper.getTypeFactory().uncheckedSimpleType(cls);
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setAddress("asd");
		user.setRegisterDate(new Date());

		List<User> userList = Lists.newArrayList();
		userList.add(user);

		User user2 = new User();
		user2.setAddress("asd");
		userList.add(user2);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SerializationConfig config = objectMapper.getSerializationConfig().with(format);
		objectMapper.setDateFormat(format);
		
		try {
			System.out.println(objectMapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
//		for (int j = 0; j < 10; j++) {
//			User value = new User();
//			value.setAddress("asdfjklasdjf");
//			value.setGender(1);
//			value.setPassword("jkljklj");
//			value.setUserName("好啊");
//
//			List<String> strList = Lists.newArrayList();
//			Map<String, String> strMap = Maps.newHashMap();
//			Set<Integer> setInt = Sets.newHashSet();
//
//			for (int i = 0; i < 10; i++) {
//				strList.add("a" + i);
//				strMap.put("a" + i, "a" + i);
//				setInt.add(i);
//			}
//
//			// value.setSetInt(setInt);
//			// value.setStrList(strList);
//			// value.setStrMap(strMap);
//			userList.add(value);
//		}

		// -------------------TypeReference List-----------------------//
		String json = JacksonUtils.get().toJson(userList);
		long d = System.currentTimeMillis();
		TypeReference<List<User>> type = new TypeReference<List<User>>() {};
		List<User> userList2 = get().fromJson(json, type);
		System.err.println(System.currentTimeMillis() - d);
		User aUser = userList2.get(0);
		System.out.println(aUser);

		// -------------------JavaType List-----------------------//
		long d2 = System.currentTimeMillis();
		JavaType javaType = objectMapper.getTypeFactory()
				.constructCollectionType(List.class, User.class);
		List<User> userList3 = get().fromJson(json, javaType);
		System.err.println(System.currentTimeMillis() - d2);
		User bUser = userList3.get(0);
		System.out.println(bUser);

		// -----------------------数组-----------------------------//

		User[] userArray = new User[12];
		userList.toArray(userArray);

		String jsonArray = JacksonUtils.get().toJson(userArray);
		long d3 = System.currentTimeMillis();
		User[] userArray2 = JacksonUtils.get()
				.fromJson(jsonArray, User[].class);
		System.err.println(System.currentTimeMillis() - d3);
		System.out.println(userArray2[0]);
	}
}
