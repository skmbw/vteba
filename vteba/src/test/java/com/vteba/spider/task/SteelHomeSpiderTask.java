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
import com.vteba.spider.processor.SteelHomePageProcessor;
import com.vteba.spider.service.InventoryService;

/**
 * 钢之家网页抓取任务。
 * @author yinlei
 * 2014-3-5 下午4:26:54
 */
public class SteelHomeSpiderTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(SteelHomeSpiderTask.class);
	private static final String HTML = "http://www.steelhome.cn/biz/biz_search.php?view=search_xh&page=";
	private InventoryService inventoryService;
	private int page;
	
	public SteelHomeSpiderTask() {
		super();
	}

	public SteelHomeSpiderTask(int page) {
		super();
		this.page = page;
	}
	
	public SteelHomeSpiderTask(int page, InventoryService inventoryService) {
		super();
		this.page = page;
		this.inventoryService = inventoryService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Spider spider = Spider.create(new SteelHomePageProcessor());
		ResultItems resultItems = spider.get(HTML + page);
		
		List<String> bodyList = resultItems.get("content");
		String tbody = bodyList.get(12);
		//这个是因为，页面中有一些错误，通过正则表达式将其删去
		tbody = tbody.replace("&nbsp;", " ").replaceAll("[A-Za-z0-9]+'\\)\"=\"\"", "");
		logger.info(tbody);
		
		try {
			SAXReader saxReader = new SAXReader();
    		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
        	Document document = saxReader.read(inputStream);
        	Element rootElement = document.getRootElement();
        	List<Element> trList = rootElement.elements("tr");
        	
        	List<Inventory> inventoryList = new ArrayList<Inventory>();
        	int omit = 0;
        	for (Element trElement : trList) {
        		if (omit++ == 0) {
        			continue;
        		}
        		Inventory inventory = new Inventory();
        		inventoryList.add(inventory);
        		
        		List<Element> tdList = trElement.elements("td");
        		
        		if (tdList == null) {
        			continue;
        		}
        		
        		int j = 1;
        		for (Element tdElement : tdList) {
        			if (j == 1) {//checkbox 省略
        				j++;
        				continue;
        			} else if (j == 2) {//公司 联系人 电话
        				Element tbodyElement = (Element)tdElement.element("div").element("table").element("tbody");
        				List<Element> elements = tbodyElement.elements("tr");
        				
        				if (elements.size() == 2) {
        					Element companyElement = elements.get(0).element("td").element("strong");//公司
        					String company = companyElement.getTextTrim();
        					logger.info(company);
        					inventory.setCompany(company);
        					
        					Element contactElement = elements.get(1).element("td");
        					String contactPerson = contactElement.getTextTrim();
        					System.out.println(contactPerson);
        					String[] contacts = StringUtils.split(contactPerson, "：");
        					String contact = contacts[1].replace("电 话", "").trim();//联系人
        					inventory.setContact(contact);
        					String telephone = contacts[2].replace("传 真", "").trim();//电话
        					inventory.setTelephone(telephone);
        				}
        			} else if (j == 3) {//空行省略
        				j++;
        				continue;
        			} else if (j == 4) {//品名
        				String value = tdElement.elementTextTrim("a");
        				logger.info(value);
        				inventory.setPm(value);
        			} else if (j == 5) {//材质
        				String value = tdElement.getTextTrim();
        				logger.info(value);
        				inventory.setCz(value);
        			} else if (j == 6) {//规格
        				String value = tdElement.getTextTrim();
        				logger.info(value);
        				inventory.setGg(value);
        			} else if (j == 7) {//价格
        				String value = tdElement.getTextTrim();
        				logger.info(value);
        				inventory.setPrice(Double.valueOf(value));
        			} else if (j == 8) {//数量
        				String amount = tdElement.getTextTrim();
        				logger.info(amount);
        				inventory.setAmount(Double.valueOf(amount));
        			} else if (j == 9) {//钢厂/产地
        				String cd = tdElement.getTextTrim();
        				logger.info(cd);
        				inventory.setCd(cd);
        			} else if (j == 10) {//地址/交货点
        				String address = tdElement.getTextTrim();
        				logger.info(address);
        				inventory.setAddress(address);
        			} 
        			j++;
        		}
        	}
        	inventoryService.saveEntityBatch(inventoryList, 50);
		} catch (Exception e) {
			logger.error("钢之家数据解析任务错误。", e);
		}
	}
}
