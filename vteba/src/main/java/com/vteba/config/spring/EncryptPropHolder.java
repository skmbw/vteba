package com.vteba.config.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.vteba.util.cryption.DESUtils;

/**
 * Properties属性密文配置
 * 
 * @author yinlei date 2012-7-16 下午4:28:33
 */
public class EncryptPropHolder extends PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };
	private static Map<String, String> propertiesMap = new HashMap<String, String>();
	
	public EncryptPropHolder() {
		super();
	}

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			propertiesMap.put(propertyName, propertyValue);
			return super.convertPropertyValue(propertyValue);
		}

	}

	private boolean isEncryptProp(String propName) {
		for (String prop : encryptPropNames) {
			if (propName.equals(prop)) {
				return true;
			}
		}
		return false;
	}

	public static String get(String name) {
		return propertiesMap.get(name);
	}
	
}
