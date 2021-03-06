package com.vteba.cache.memcached.util.counter;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A simple counter implementation
 * 
 * @author <a href="mailto:asanoujam@terracottatech.com">Abhishek Sanoujam</a>
 * @since 1.7
 * 
 */
public class CounterImpl implements Counter, Serializable {

	private static final long serialVersionUID = 1L;
	private AtomicLong value;

    /**
     * Default Constructor
     */
    public CounterImpl() {
        this(0L);
    }

    /**
     * Constructor with initial value
     * 
     * @param initialValue
     */
    public CounterImpl(long initialValue) {
        this.value = new AtomicLong(initialValue);
    }

    /**
     * {@inheritDoc}
     */
    public long increment() {
        return value.incrementAndGet();
    }

    /**
     * {@inheritDoc}
     */
    public long decrement() {
        return value.decrementAndGet();
    }

    /**
     * {@inheritDoc}
     */
    public long getAndSet(long newValue) {
        return value.getAndSet(newValue);
    }

    /**
     * {@inheritDoc}
     */
    public long getValue() {
        return value.get();
    }

    /**
     * {@inheritDoc}
     */
    public long increment(long amount) {
        return value.addAndGet(amount);
    }

    /**
     * {@inheritDoc}
     */
    public long decrement(long amount) {
        return value.addAndGet(amount * -1);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(long newValue) {
        value.set(newValue);
    }

}
