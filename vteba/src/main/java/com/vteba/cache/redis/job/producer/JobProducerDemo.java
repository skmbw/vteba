package com.vteba.cache.redis.job.producer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import redis.clients.jedis.JedisPool;

import com.vteba.cache.redis.benchmark.BenchmarkTask;
import com.vteba.cache.redis.benchmark.ConcurrentBenchmark;
import com.vteba.cache.redis.job.dispatcher.SimpleJobDispatcherDemo;
import com.vteba.cache.redis.scheduler.JobProducer;
import com.vteba.cache.redis.support.JedisPoolFactory;
import com.vteba.cache.redis.support.JedisUtils;

/**
 * 运行JobManager产生新的Job。
 * 
 * 可用系统参数重置相关变量，@see RedisCounterBenchmark
 * 
 * @author calvin
 */
public class JobProducerDemo extends ConcurrentBenchmark {
	private static final int DEFAULT_THREAD_COUNT = 5;
	private static final long DEFAULT_LOOP_COUNT = 100000;

	private static AtomicLong expiredMills = new AtomicLong(System.currentTimeMillis()
			+ (SimpleJobDispatcherDemo.DELAY_SECONDS * 1000));
	private static AtomicLong idGenerator = new AtomicLong(0);

	private long expectTps;
	private JedisPool pool;
	private JobProducer jobProducer;

	public static void main(String[] args) throws Exception {
		JobProducerDemo benchmark = new JobProducerDemo();
		benchmark.execute();
	}

	public JobProducerDemo() {
		super(DEFAULT_THREAD_COUNT, DEFAULT_LOOP_COUNT);
		this.expectTps = Long.parseLong(System.getProperty("benchmark.tps",
				String.valueOf(SimpleJobDispatcherDemo.EXPECT_TPS)));
	}

	@Override
	protected void setUp() {
		pool = JedisPoolFactory.createJedisPool(JedisUtils.DEFAULT_HOST, JedisUtils.DEFAULT_PORT,
				JedisUtils.DEFAULT_TIMEOUT, threadCount);
		jobProducer = new JobProducer("ss", pool);
	}

	@Override
	protected void tearDown() {
		pool.destroy();
	}

	@Override
	protected BenchmarkTask createTask() {
		return new JobProducerTask();
	}

	public class JobProducerTask extends BenchmarkTask {
		@Override
		public void execute(final int requestSequence) {
			long jobId = idGenerator.getAndIncrement();
			jobProducer.schedule("job:" + jobId, expiredMills.get() - System.currentTimeMillis(),
					TimeUnit.MILLISECONDS);

			// 达到期望的每秒的TPS后，expireTime往后滚动一秒
			if ((jobId % (expectTps)) == 0) {
				expiredMills.addAndGet(1000);
			}
		}
	}
}
