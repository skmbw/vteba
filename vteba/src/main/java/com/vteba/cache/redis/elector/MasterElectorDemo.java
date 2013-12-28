package com.vteba.cache.redis.elector;

import redis.clients.jedis.JedisPool;

import com.vteba.cache.redis.support.JedisPoolFactory;
import com.vteba.cache.redis.support.JedisUtils;

public class MasterElectorDemo {

	public static void main(String[] args) throws Exception {

		JedisPool pool = JedisPoolFactory.createJedisPool(JedisUtils.DEFAULT_HOST, JedisUtils.DEFAULT_PORT,
				JedisUtils.DEFAULT_TIMEOUT, 1);
		try {
			MasterElector masterElector = new MasterElector(pool, 5);

			masterElector.start();

			System.out.println("Hit enter to stop.");
			while (true) {
				char c = (char) System.in.read();
				if (c == '\n') {
					System.out.println("Shuting down");
					masterElector.stop();
					return;
				}
			}
		} finally {
			pool.destroy();
		}
	}

}
