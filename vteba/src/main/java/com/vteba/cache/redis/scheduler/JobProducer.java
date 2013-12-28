package com.vteba.cache.redis.scheduler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPool;

import com.vteba.cache.redis.JedisTemplate;

/**
 * 任务管理，支持任务的安排与取消。
 * 任务分延时任务与立即执行任务两种, 未来或将支持固定间隔循环执行任务.
 */
public class JobProducer {

	private static Logger logger = LoggerFactory.getLogger(JobProducer.class);

	private JedisTemplate jedisTemplate;

	private String scheduledJobKey;

	private String readyJobKey;

	public JobProducer(String jobName, JedisPool jedisPool) {
		jedisTemplate = new JedisTemplate(jedisPool);
		scheduledJobKey = Keys.getScheduledJobKey(jobName);
		readyJobKey = Keys.getReadyJobKey(jobName);
	}

	/**
	 * 提交立即执行的任务。
	 */
	public void queue(final String job) {
		jedisTemplate.lpush(readyJobKey, job);
	}

	/**
	 * 安排延时执行任务.
	 */
	public void schedule(final String job, final long delay, final TimeUnit timeUnit) {
		final long delayTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(delay);
		jedisTemplate.zadd(scheduledJobKey, job, delayTimeMillis);
	}

	/**
	 * 尝试取消延时任务, 如果任务不存在或已被触发返回false, 否则返回true.
	 */
	public boolean cancel(final String job) {
		boolean removed = jedisTemplate.zrem(scheduledJobKey, job);

		if (!removed) {
			logger.warn("Can't cancel scheduld job by value {}", job);
		}

		return removed;
	}
}
