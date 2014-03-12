package com.vteba.spider.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.DelegatingErrorHandlingRunnable;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.stereotype.Component;

import com.vteba.spider.service.InventoryService;

/**
 * 抓取网页的定时任务，守护线程。
 * @author yinlei
 * 2014-3-5 上午11:02:55
 */
@Component
public class SpiderDaemonThread implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(SpiderDaemonThread.class);
	private ScheduledExecutorService spiderDaemonExecutor;
	private ExecutorService workExecutorService;
	
	@Autowired
	private InventoryService inventoryService;
	
	private long period = 6000;
	private long delay = 60;
	private int poolSize = 2;
	private int pageSize = 150;
	
	public SpiderDaemonThread() {
		super();
		spiderDaemonExecutor = Executors.newSingleThreadScheduledExecutor();
		Runnable task = new DelegatingErrorHandlingRunnable(this, TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);
		
		spiderDaemonExecutor.scheduleAtFixedRate(task, delay, period, TimeUnit.SECONDS);
		
		workExecutorService = Executors.newFixedThreadPool(poolSize);
		
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= pageSize; i++) {
				MySteelSpiderTask spiderTask = new MySteelSpiderTask(i, inventoryService);
				workExecutorService.submit(spiderTask);
				
				SteelHomeSpiderTask steelHomeTask = new SteelHomeSpiderTask(i, inventoryService);
				workExecutorService.submit(steelHomeTask);
				
				ZhaoGangSpiderTask zhaoGangSpiderTask = new ZhaoGangSpiderTask(i, inventoryService);
				workExecutorService.submit(zhaoGangSpiderTask);
			}
		} catch (Exception e) {
			logger.error("执行抓取网页任务失败。", e);
		}
		
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
