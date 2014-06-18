package com.vteba.cache.memcached.transcoder;

import java.util.Date;

import net.rubyeye.xmemcached.transcoders.BaseSerializingTranscoder;
import net.rubyeye.xmemcached.transcoders.CachedData;
import net.rubyeye.xmemcached.transcoders.Transcoder;

import com.vteba.utils.serialize.Kryos;

/**
 * XMemcached基于Kryo的序列化转换器。
 * @author yinlei
 * @date 2013年9月28日 下午10:11:22
 */
public class KryoTranscoder extends BaseSerializingTranscoder implements Transcoder<Object> {
	private final int maxSize;
	private boolean primitiveAsString;

	// General flags
	public static final int SERIALIZED = 1;
	public static final int COMPRESSED = 2;

	// Special flags for specially handled types.
	public static final int SPECIAL_MASK = 0xff00;
	public static final int SPECIAL_BOOLEAN = (1 << 8);
	public static final int SPECIAL_INT = (2 << 8);
	public static final int SPECIAL_LONG = (3 << 8);
	public static final int SPECIAL_DATE = (4 << 8);
	public static final int SPECIAL_BYTE = (5 << 8);
	public static final int SPECIAL_FLOAT = (6 << 8);
	public static final int SPECIAL_DOUBLE = (7 << 8);
	public static final int SPECIAL_BYTEARRAY = (8 << 8);
	
	private final TranscoderUtils transcoderUtils = new TranscoderUtils(true);

	/**
	 * Get a serializing transcoder with the default max data size.
	 */
	public KryoTranscoder() {
		this(CachedData.MAX_SIZE);
	}

	/**
	 * Get a serializing transcoder that specifies the max data size.
	 */
	public KryoTranscoder(int max) {
		this.maxSize = max;
	}
	
	@Override
	public CachedData encode(Object o) {
		byte[] b = null;
		int flags = 0;
		if (o instanceof String) {
			b = encodeString((String) o);
		} else if (o instanceof Long) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeLong((Long) o);
			}
			flags |= SPECIAL_LONG;
		} else if (o instanceof Integer) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeInt((Integer) o);
			}
			flags |= SPECIAL_INT;
		} else if (o instanceof Boolean) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeBoolean((Boolean) o);
			}
			flags |= SPECIAL_BOOLEAN;
		} else if (o instanceof Date) {
			b = this.transcoderUtils.encodeLong(((Date) o).getTime());
			flags |= SPECIAL_DATE;
		} else if (o instanceof Byte) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeByte((Byte) o);
			}
			flags |= SPECIAL_BYTE;
		} else if (o instanceof Float) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeInt(Float.floatToRawIntBits((Float) o));
			}
			flags |= SPECIAL_FLOAT;
		} else if (o instanceof Double) {
			if (this.primitiveAsString) {
				b = encodeString(o.toString());
			} else {
				b = this.transcoderUtils.encodeLong(Double.doubleToRawLongBits((Double) o));
			}
			flags |= SPECIAL_DOUBLE;
		} else if (o instanceof byte[]) {
			b = (byte[]) o;
			flags |= SPECIAL_BYTEARRAY;
		} else {
			b = this.serialize(o);
			flags |= SERIALIZED;
		}
		assert b != null;
		if (this.primitiveAsString) {
			// It is not be SERIALIZED,so change it to string type
			if ((flags & SERIALIZED) == 0) {
				flags = 0;
			}
		}
		if (b.length > this.compressionThreshold) {
			byte[] compressed = compress(b);
			if (compressed.length < b.length) {
				if (log.isDebugEnabled()) {
					log.debug("Compressed " + o.getClass().getName() + " from "
							+ b.length + " to " + compressed.length);
				}
				b = compressed;
				flags |= COMPRESSED;
			} else {
				if (log.isDebugEnabled()) {
					log.debug("Compression increased the size of "
							+ o.getClass().getName() + " from " + b.length
							+ " to " + compressed.length);
				}
			}
		}
		return new CachedData(flags, b, this.maxSize, -1);
	}

	@Override
	public final Object decode(CachedData d) {
		byte[] data = d.getData();

		int flags = d.getFlag();
		if ((flags & COMPRESSED) != 0) {
			data = decompress(d.getData());
		}
		flags = flags & SPECIAL_MASK;
		return decodeInternal(d,data, flags);
	}

	/**
	 * 解码对象。子类可重载次方。
	 * @param cachedData
	 * @param data
	 * @param flags
	 * @return
	 */
	protected Object decodeInternal(CachedData cachedData,byte[] data, int flags) {
		Object rv = null;
		if ((cachedData.getFlag() & SERIALIZED) != 0 && data != null) {
			rv = this.deserialize(data);
		} else {
			if (this.primitiveAsString) {
				if (flags == 0) {
					return decodeString(data);
				}
			}
			if (flags != 0 && data != null) {
				switch (flags) {
				case SPECIAL_BOOLEAN:
					rv = Boolean.valueOf(this.transcoderUtils.decodeBoolean(data));
					break;
				case SPECIAL_INT:
					rv = Integer.valueOf(this.transcoderUtils.decodeInt(data));
					break;
				case SPECIAL_LONG:
					rv = Long.valueOf(this.transcoderUtils.decodeLong(data));
					break;
				case SPECIAL_BYTE:
					rv = Byte.valueOf(this.transcoderUtils.decodeByte(data));
					break;
				case SPECIAL_FLOAT:
					rv = new Float(Float.intBitsToFloat(this.transcoderUtils.decodeInt(data)));
					break;
				case SPECIAL_DOUBLE:
					rv = new Double(Double.longBitsToDouble(this.transcoderUtils.decodeLong(data)));
					break;
				case SPECIAL_DATE:
					rv = new Date(this.transcoderUtils.decodeLong(data));
					break;
				case SPECIAL_BYTEARRAY:
					rv = data;
					break;
				default:
					log.warn(String.format("Undecodeable with flags %x", flags));
				}
			} else {
				rv = decodeString(data);
			}
		}
		return rv;
	}

	@Override
	public void setPrimitiveAsString(boolean primitiveAsString) {
		this.primitiveAsString = primitiveAsString;
	}

	@Override
	public void setPackZeros(boolean packZeros) {
		this.transcoderUtils.setPackZeros(packZeros);
	}

	@Override
	public boolean isPrimitiveAsString() {
		return this.primitiveAsString;
	}

	@Override
	public boolean isPackZeros() {
		return this.transcoderUtils.isPackZeros();
	}

	public final int getMaxSize() {
		return this.maxSize;
	}
	
	public TranscoderUtils getTranscoderUtils() {
		return this.transcoderUtils;
	}
	
	/**
	 * Get the bytes representing the given serialized object.
	 */
	protected byte[] serialize(Object object) {
		return Kryos.get().serialize(object);
	}
	
	/**
	 * Get the object represented by the given serialized bytes.
	 */
	protected Object deserialize(byte[] bytes) {
		return Kryos.get().deserialize(bytes);
	}
}
