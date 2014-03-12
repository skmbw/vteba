package com.vteba.spider.task;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

import com.vteba.spider.model.Inventory;
import com.vteba.spider.processor.LangePageProcessor;
import com.vteba.spider.service.InventoryService;

/**
 * 兰格网页抓取任务。
 * @author yinlei
 * 2014-3-5 下午2:04:33
 */
public class LangeSpiderTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(LangeSpiderTask.class);
	private static final String HTML = "http://www.lange360.com/search.do?baosteel_page_no=";
	private static final String EXT = "&baosteel_page_size=30";
	private InventoryService inventoryService;
	private int page;
	
	public LangeSpiderTask(InventoryService inventoryService, int page) {
		super();
		this.inventoryService = inventoryService;
		this.page = page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		String html = HTML + page + EXT;
		
		Spider spider = Spider.create(new LangePageProcessor());
		ResultItems resultItems = spider.<ResultItems>get(html);
		List<String> bodyList = resultItems.get("content");
		
		String tbody = bodyList.get(0);//只有第一个是可用的
		tbody = tbody.replace("&nbsp;", " ");
		
    	try {
    		SAXReader saxReader = new SAXReader();
    		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
        	Document document = saxReader.read(inputStream);
        	Element rootElement = document.getRootElement();
        	List<Element> trList = rootElement.elements("tr");
        	
        	int i = 0;
        	List<Inventory> inventoryList = new ArrayList<Inventory>();
        	
        	for (Element trElement : trList) {
        		List<Element> tdList = null;
        		if (i++ == 0) {
        			continue;
        		} else {
        			tdList = trElement.elements("td");
        		}
        		
        		if (tdList == null || tdList.size() < 9) {
        			continue;
        		}
        		
        		int j = 1;
        		Inventory inventory = new Inventory();
        		inventoryList.add(inventory);
        		for (Element tdElement : tdList) {
        			if (j == 1) {//品名
        				inventory.setPm(tdElement.getTextTrim());
        			} else if (j == 2) {//材质
        				String value = tdElement.getTextTrim();
        				inventory.setCz(value);
        			} else if (j == 3) {//规格
        				String value = tdElement.getTextTrim();
        				inventory.setGg(value);
        			} else if (j == 4) {//价格
        				String value = tdElement.elementText("strong");
        				inventory.setPrice(Double.valueOf(value));
        			} else if (j == 5) {//数量
        				String value = tdElement.getTextTrim();
        				inventory.setAmount(Double.valueOf(value));
        			} else if (j == 6) {//钢厂
        				String value = tdElement.getTextTrim();
        				inventory.setCd(value);
        			} else if (j == 7) {//仓库/交割库
        				String value = tdElement.getTextTrim();
        				inventory.setWarehouse(value);
        			} else if (j == 8) {//计量方式
        				//System.out.println(tdElement.getTextTrim());
        			} else if (j == 9) {//所属企业
        				inventory.setCompany(tdElement.getTextTrim());
        			}
    				j++;
        		}
        	}
        	inventoryService.saveEntityBatch(inventoryList, 50);
		} catch (Exception e) {
			logger.error("兰格网页数据分析错误。", e);
		}
	}
}
