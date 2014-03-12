package com.vteba.spider.task;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
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
import com.vteba.spider.processor.MySteelPageProcessor;
import com.vteba.spider.service.InventoryService;

/**
 * 我的钢铁网页抓取任务。
 * @author yinlei
 * 2014-3-5 上午11:01:26
 */
public class MySteelSpiderTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MySteelSpiderTask.class);
	private static final String HTML = "http://list.sososteel.com/res/p--------------------------------";
	private static final String EXT = ".html";
	
	private int page;
	private InventoryService inventoryService;
	
	public MySteelSpiderTask() {
		super();
	}

	public MySteelSpiderTask(int page) {
		super();
		this.page = page;
	}
	
	public MySteelSpiderTask(int page, InventoryService inventoryService) {
		super();
		this.page = page;
		this.inventoryService = inventoryService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Spider spider = Spider.create(new MySteelPageProcessor());
        ResultItems resultItems = spider.<ResultItems>get(HTML + page + EXT);
        List<String> bodyList = resultItems.get("content");
        
        int i = 0;
        for (String tbody : bodyList) {
        	if (i++ == 0) {
        		continue;
        	}
        	logger.info(tbody);
        	tbody = tbody.replace("&nbsp;", " ");
        	try {
        		SAXReader saxReader = new SAXReader();
        		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
            	Document document = saxReader.read(inputStream);
            	Element rootElement = document.getRootElement();
            	List<Element> trList = rootElement.elements("tr");
            	
            	List<Inventory> inventoryList = new ArrayList<Inventory>();
            	
            	for (Element trElement : trList) {
            		List<Element> tdList = null;
            		
            		if (i != 1) {
            			tdList = trElement.elements("td");
            		}
            		
            		if (tdList == null || tdList.size() < 8) {
            			continue;
            		}
            		
            		int j = 1;
            		Inventory inventory = new Inventory();
            		for (Element tdElement : tdList) {
            			if (j == 1) {//品名 嵌套多层，取a节点
        					Element href = (Element)tdElement.selectSingleNode("//a");
        					String pm = href.getTextTrim();
        					logger.info(pm);
        					inventory.setPm(pm);
            			} else if (j == 2) {//简单值，材质
            				String cz = tdElement.getTextTrim();
            				logger.info(cz);
            				inventory.setCz(cz);
            			} else if (j == 3) {//简单值，规格
            				String gg = tdElement.getTextTrim();
            				logger.info(gg);
            				inventory.setGg(gg);
            			} else if (j == 4) {//城市 仓库
            				String value = tdElement.getTextTrim();
            				String[] strs = StringUtils.split(value, " ");
            				String city = strs[0];
            				logger.info(city);
            				inventory.setCity(city);
            				
            				String warehouse = strs[1];
            				logger.info(warehouse);
            				inventory.setWarehouse(warehouse);
            			} else if (j == 5) {//简单值，钢厂/产地
            				String cd = tdElement.getTextTrim();
            				logger.info(cd);
            				inventory.setCd(cd);
            			} else if (j == 6) {//价格和数量
            				//价格
            				Element span = (Element)tdElement.selectSingleNode("//span");
            				Double price = Double.valueOf(span.getTextTrim().replaceAll("[\u4e00-\u9fa5]", ""));
            				logger.info(price.toString());
            				inventory.setPrice(price);
            				
            				//数量
            				String value = tdElement.getTextTrim();
            				logger.info(value);
            				try {
            					Double amount = Double.valueOf(value.replaceAll("[\u4e00-\u9fa5]", "")
            							.replace("吨", "").replace("T", "")
            							.replace("/", "").replace("\\", "").trim());
            					inventory.setAmount(amount);
							} catch (Exception e) {
								logger.info("重量格式化错误，给默认值1");
								inventory.setAmount(1D);
							}
            				
            			} else if (j == 7) {//公司
            				String company = tdElement.attributeValue("title").trim();
            				logger.info(company);
            				inventory.setCompany(company);
            			} else if (j == 8) {// 联系人，电话，手机
            				List<Element> aaElements = tdElement.elements("a");
            				for (Element aaElement : aaElements) {
            					String value = aaElement.attributeValue("onclick");
        						if (value != null && value.indexOf("showTel") > -1) {
        							String[] strs = StringUtils.split(value, ",");
        							
        							String tele = strs[3].trim();
        							tele = tele.substring(1, tele.length() - 1);
        							if (tele.length() > 30) {
        								tele = tele.substring(0, 30);
        							}
        							inventory.setTelephone(tele);
        							logger.info("电话" + tele);
        							
        							String contact = strs[4].trim();
        							contact = contact.substring(1, contact.length() - 1);
        							inventory.setContact(contact);
        							logger.info("联系人" + contact);
        							
        							String mobile = strs[5].trim();
        							mobile = mobile.substring(1, 12);
        							inventory.setMobilephone(mobile);
        							logger.info("手机" + mobile);
        						}
            				}
            			} else if (j == 9) {//简单值，时间
            				String value = tdElement.getTextTrim();
            				inventory.setUpdatedate(value);
            				inventory.setCreatedate(new Date());
            				logger.info(value);
            			} 
        				j++;
            			
            		}
            		inventoryList.add(inventory);
            	}
            	inventoryService.saveEntityBatch(inventoryList, 100);
    		} catch (Exception e) {
    			logger.error("我的钢铁网页数据分析错误。", e);
    		}
        }
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
