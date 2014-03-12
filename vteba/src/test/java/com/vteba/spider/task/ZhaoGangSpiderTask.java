package com.vteba.spider.task;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

import com.vteba.spider.model.Inventory;
import com.vteba.spider.processor.ZhaoGangPageProcessor;
import com.vteba.spider.service.InventoryService;

/**
 * 找钢网网页抓取任务。
 * @author yinlei
 * 2014-3-5 下午2:04:51
 */
public class ZhaoGangSpiderTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(ZhaoGangSpiderTask.class);
	private static final String HTML = "http://www.zhaogang.com/spot/?page=";
	private int page;
	private InventoryService inventoryService;
	
	public ZhaoGangSpiderTask() {
		super();
	}

	public ZhaoGangSpiderTask(int page, InventoryService inventoryService) {
		super();
		this.page = page;
		this.inventoryService = inventoryService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Spider spider = Spider.create(new ZhaoGangPageProcessor());
		ResultItems resultItems = spider.get(HTML + page);
		List<String> bodyList = resultItems.get("content");
		String tbody = bodyList.get(0);
		
    	try {
    		SAXReader saxReader = new SAXReader();
    		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
        	Document document = saxReader.read(inputStream);
        	Element rootElement = document.getRootElement();
        	List<Element> trList = rootElement.elements("tr");
        	
        	int i = 0;
        	Inventory inventory = new Inventory();
        	List<Inventory> inventoryList = new ArrayList<Inventory>();
        	for (Element trElement : trList) {
        		if (i++ % 2 == 0) {
        			inventory = new Inventory();
        			inventoryList.add(inventory);
        		}
        		List<Element> tdList = trElement.elements("td");
        		
        		if (tdList == null) {
        			continue;
        		}
        		
        		if (tdList.size() == 9) {
        			int j = 1;
            		for (Element tdElement : tdList) {
            			if (j == 1) {//品名
            				Element element = (Element)tdElement.element("div").elements("span").get(1);
            				String pm = element.elementTextTrim("a");
            				logger.info(pm);
            				inventory.setPm(pm);
            			} else if (j == 2) {//规格
            				String value = tdElement.elementTextTrim("a");
            				logger.info(value);
            				inventory.setGg(value);
            			} else if (j == 3) {//材质
            				String value = tdElement.elementTextTrim("a");
            				logger.info(value);
            				inventory.setCz(value);
            			} else if (j == 4) {//钢厂、产地
            				String value = tdElement.elementTextTrim("a");
            				logger.info(value);
            				inventory.setCd(value);
            			} else if (j == 5) {//仓库
            				String value = tdElement.getTextTrim();
            				logger.info(value);
            				inventory.setWarehouse(value);
            			} else if (j == 6) {//数量
            				String value = tdElement.getTextTrim();
            				logger.info(value);
            				inventory.setAmount(Double.valueOf(value));
            			} else if (j == 7) {//价格
            				String value = tdElement.getTextTrim();
            				logger.info(value);
            				inventory.setPrice(Double.valueOf(value));
            			} else if (j == 8) {//公司
            				String company = tdElement.getTextTrim();
            				logger.info(company);
            				inventory.setCompany(company);
            			}
        				j++;
            			
            		}
        		} else if (tdList.size() == 1) {
        			List<Element> elements = tdList.get(0).element("div").elements("span");
        			String contact = elements.get(1).getTextTrim().substring(4).trim();
        			inventory.setContact(contact);
        			logger.info(contact);
        			
        			String tele = elements.get(2).getTextTrim().substring(5).trim();
        			String[] phones = StringUtils.split(tele, " ");
        			if (phones.length == 2) {
        				inventory.setMobilephone(phones[0]);
        				inventory.setTelephone(phones[1]);
        			} else {
        				inventory.setMobilephone(tele);
        			}
        			
        			String address = elements.get(3).getTextTrim().substring(5).trim();
        			inventory.setAddress(address);
        		}
        	}
        	inventoryService.saveEntityBatch(inventoryList, 50);
		} catch (Exception e) {
			logger.error("找钢网，网页数据分析错误。", e);
		}
	}
}
