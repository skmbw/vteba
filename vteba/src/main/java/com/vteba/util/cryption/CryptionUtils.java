package com.vteba.util.cryption;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;

import com.vteba.user.model.EmpUser;
import com.vteba.util.exception.Exceptions;
import com.vteba.util.serialize.Kryos;

/**
 * 各种格式的编码解码工具类。
 * 集成Commons-Codec，Commons-Lang及JDK提供的编解码方法。
 * @author yinlei
 * date 2012-9-20
 */
public final class CryptionUtils {

	private static final String AES = "AES";
	private static final String AES_CBC = "AES/CBC/PKCS5Padding";
	private static final String HMACSHA1 = "HmacSHA1";

	private static final int DEFAULT_HMACSHA1_KEYSIZE = 160; // RFC2401
	private static final int DEFAULT_AES_KEYSIZE = 128;
	private static final int DEFAULT_IVSIZE = 16;

	private static SecureRandom random = new SecureRandom();
	
	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	
	private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	/**
	 * Hex编码，将字节数组编码为16进制的字符串
	 * @param input 要被编码的字节数组
	 */
	public static String hexEncode(byte[] input) {
		return Hex.encodeHexString(input);
	}

	/**
	 * Hex解码，将16进制编码的字符串解码为字节数组
	 * @param input 被hex编码过的字符串
	 */
	public static byte[] hexDecode(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalStateException("Hex Decoder exception", e);
		}
	}

	/**
	 * Base64编码，将字节数组编码为base64的字符串
	 * @param input 字节数组
	 */
	public static String base64Encode(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}

	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符如+,/=转为其他字符, 见RFC3548)
	 */
	public static String base64UrlSafeEncode(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	/**
	 * Base64解码，将base64编码的字符创解码为字节数组
	 * @param input 要解码的base64字符串
	 */
	public static byte[] base64Decode(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * URL 编码, Encode默认为UTF-8
	 */
	public static String urlEncode(String input) {
		try {
			return URLEncoder.encode(input, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8
	 */
	public static String urlDecode(String input) {
		try {
			return URLDecoder.decode(input, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * Html 转码
	 */
	public static String htmlEscape(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * Html 解码
	 */
	public static String htmlUnescape(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * Xml 转码
	 */
	public static String xmlEscape(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}

	/**
	 * Xml 解码
	 */
	public static String xmlUnescape(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}
	
	/**
	 * 将对象序列化后，进行HEX编码，然后进行SHA1摘要，最后再转换为HEX字符串
	 * @param o 要被转换的对象
	 * @return 对象转换后的字符串
	 * @author yinlei
	 * date 2013-4-6 下午5:15:12
	 */
	public static String toHexString(Object o) {
		//return sha1Hex(hexEncode(NativeSerializerUtils.fromObjectToBinary(o)));
		return sha1Hex(hexEncode(Kryos.get().serialize(o)));
	}
	
	/**
	 * 将data进行MD5摘要之后，再转化为HEX String
	 * @param data 要被转换的String
	 * @return 转换后的String
	 * @author yinlei
	 * date 2013-4-6 下午5:08:34
	 */
    public static String md5Hex(String data) {
        if (data == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        byte[] bytes = digest("MD5", data);
        return toHexString(bytes);
    }

    /**
     * 将data进行SHA1摘要之后，再转化为HEX String
     * @param data 要被转换的String
     * @return 转换后String
     * @author yinlei
     * date 2013-4-6 下午5:06:46
     */
    public static String sha1Hex(String data) {
        if (data == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        byte[] bytes = digest("SHA1", data);
        return toHexString(bytes);
    }

    /**
     * 将字节数组转换为Hex String
     * @param bytes 要转换的字节数组
     * @return 转换后的String
     * @author yinlei
     * date 2013-4-6 下午5:04:46
     */
    private static String toHexString(byte[] bytes) {
        int l = bytes.length;
        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & bytes[i]) >>> 4];
            out[j++] = DIGITS[0x0F & bytes[i]];
        }
        return new String(out);
    }

    /**
     * 使用指定算法将string转换为byte[]
     * @param algorithm 算法名
     * @param data 要转换的string
     * @return
     * @author yinlei
     * date 2013-4-6 下午5:02:52
     */
    private static byte[] digest(String algorithm, String data) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return digest.digest(data.getBytes());
    }
    //-------------2013-09-14---------------------//
    private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

    /**
	 * 对输入字符串进行sha1散列.
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 * @param input 要散列的数据
	 * @param algorithm 算法，支持md5和sha1
	 * @param salt 盐值
	 * @param iterations 散列次数
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}

	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对文件进行md5散列.
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}

	/**
	 * 对文件进行sha1散列.
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}
	
	/**
	 * 对文件进行散列
	 * @param input 文件流
	 * @param algorithm 算法
	 * @return 散列后的值
	 * @throws IOException
	 * @author yinlei
	 * date 2013-9-14 下午10:43:04
	 */
	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8 * 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}
    
	//-------------2013-09-14----end-----------------//
	
    // -- HMAC-SHA1 funciton --//
 	/**
 	 * 使用HMAC-SHA1进行消息签名, 返回字节数组,长度为20字节.
 	 * 
 	 * @param input 原始输入字符数组
 	 * @param key HMAC-SHA1密钥
 	 */
 	public static byte[] hmacSha1(byte[] input, byte[] key) {
 		try {
 			SecretKey secretKey = new SecretKeySpec(key, HMACSHA1);
 			Mac mac = Mac.getInstance(HMACSHA1);
 			mac.init(secretKey);
 			return mac.doFinal(input);
 		} catch (GeneralSecurityException e) {
 			throw Exceptions.unchecked(e);
 		}
 	}

 	/**
 	 * 校验HMAC-SHA1签名是否正确.
 	 * 
 	 * @param expected 已存在的签名
 	 * @param input 原始输入字符串
 	 * @param key 密钥
 	 */
 	public static boolean isMacValid(byte[] expected, byte[] input, byte[] key) {
 		byte[] actual = hmacSha1(input, key);
 		return Arrays.equals(expected, actual);
 	}

 	/**
 	 * 生成HMAC-SHA1密钥,返回字节数组,长度为160位(20字节).
 	 * HMAC-SHA1算法对密钥无特殊要求, RFC2401建议最少长度为160位(20字节).
 	 */
 	public static byte[] generateHmacSha1Key() {
 		try {
 			KeyGenerator keyGenerator = KeyGenerator.getInstance(HMACSHA1);
 			keyGenerator.init(DEFAULT_HMACSHA1_KEYSIZE);
 			SecretKey secretKey = keyGenerator.generateKey();
 			return secretKey.getEncoded();
 		} catch (GeneralSecurityException e) {
 			throw Exceptions.unchecked(e);
 		}
 	}

 	// -- AES funciton --//
 	/**
 	 * 使用AES加密原始字符串.
 	 * 
 	 * @param input 原始输入字符数组
 	 * @param key 符合AES要求的密钥
 	 */
 	public static byte[] aesEncrypt(byte[] input, byte[] key) {
 		return aes(input, key, Cipher.ENCRYPT_MODE);
 	}

 	/**
 	 * 使用AES加密原始字符串.
 	 * 
 	 * @param input 原始输入字符数组
 	 * @param key 符合AES要求的密钥
 	 * @param iv 初始向量
 	 */
 	public static byte[] aesEncrypt(byte[] input, byte[] key, byte[] iv) {
 		return aes(input, key, iv, Cipher.ENCRYPT_MODE);
 	}

 	/**
 	 * 使用AES解密字符串, 返回原始字符串.
 	 * 
 	 * @param input Hex编码的加密字符串
 	 * @param key 符合AES要求的密钥
 	 */
 	public static String aesDecrypt(byte[] input, byte[] key) {
 		byte[] decryptResult = aes(input, key, Cipher.DECRYPT_MODE);
 		return new String(decryptResult);
 	}

 	/**
 	 * 使用AES解密字符串, 返回原始字符串.
 	 * 
 	 * @param input Hex编码的加密字符串
 	 * @param key 符合AES要求的密钥
 	 * @param iv 初始向量
 	 */
 	public static String aesDecrypt(byte[] input, byte[] key, byte[] iv) {
 		byte[] decryptResult = aes(input, key, iv, Cipher.DECRYPT_MODE);
 		return new String(decryptResult);
 	}

 	/**
 	 * 使用AES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
 	 * 
 	 * @param input 原始字节数组
 	 * @param key 符合AES要求的密钥
 	 * @param mode Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
 	 */
 	private static byte[] aes(byte[] input, byte[] key, int mode) {
 		try {
 			SecretKey secretKey = new SecretKeySpec(key, AES);
 			Cipher cipher = Cipher.getInstance(AES);
 			cipher.init(mode, secretKey);
 			return cipher.doFinal(input);
 		} catch (GeneralSecurityException e) {
 			throw Exceptions.unchecked(e);
 		}
 	}

 	/**
 	 * 使用AES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
 	 * 
 	 * @param input 原始字节数组
 	 * @param key 符合AES要求的密钥
 	 * @param iv 初始向量
 	 * @param mode Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
 	 */
 	private static byte[] aes(byte[] input, byte[] key, byte[] iv, int mode) {
 		try {
 			SecretKey secretKey = new SecretKeySpec(key, AES);
 			IvParameterSpec ivSpec = new IvParameterSpec(iv);
 			Cipher cipher = Cipher.getInstance(AES_CBC);
 			cipher.init(mode, secretKey, ivSpec);
 			return cipher.doFinal(input);
 		} catch (GeneralSecurityException e) {
 			throw Exceptions.unchecked(e);
 		}
 	}

 	/**
 	 * 生成AES密钥,返回字节数组, 默认长度为128位(16字节).
 	 */
 	public static byte[] generateAesKey() {
 		return generateAesKey(DEFAULT_AES_KEYSIZE);
 	}

 	/**
 	 * 生成AES密钥,可选长度为128,192,256位.
 	 * @param keysize 密钥长度
 	 */
 	public static byte[] generateAesKey(int keysize) {
 		try {
 			KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
 			keyGenerator.init(keysize);
 			SecretKey secretKey = keyGenerator.generateKey();
 			return secretKey.getEncoded();
 		} catch (GeneralSecurityException e) {
 			throw Exceptions.unchecked(e);
 		}
 	}

 	/**
 	 * 生成随机向量,默认大小为cipher.getBlockSize(), 16字节.
 	 */
 	public static byte[] generateIV() {
 		byte[] bytes = new byte[DEFAULT_IVSIZE];
 		random.nextBytes(bytes);
 		return bytes;
 	}
    
    public static void main(String[] args) {
		EmpUser user = new EmpUser();
		user.setAccountNonExpired(false);
		user.setName("yinlei");
		user.setPass("asdfsadfasd");
		user.setEmail("cvxbvcx");
		//user.setCreateDate(new Date());
		
		//System.out.println(NativeSerializerUtils.fromObjectToBinary(user));
		
		String k = CryptionUtils.toHexString(user);
		String sk = sha1Hex(k);
		System.out.println(k);
		System.out.println(sk);
	}
}
