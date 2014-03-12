package com.vteba.spider;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

public class SpiderTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(SpiderTask.class);
	private String url;
	private InventoryService inventoryService;
	
	public SpiderTask() {
		super();
	}

	public SpiderTask(String url) {
		super();
		this.url = url;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Spider spider = Spider.create(new SpiderPageProcessor()).addUrl(url);
        ResultItems resultItems = spider.<ResultItems>get(url);
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
            	
            	for (Element trElement : trList) {
            		List<Element> tdList = null;
            		if (i == 2) {
            			tdList = trElement.elements("th");
            		} else {
            			tdList = trElement.elements("td");
            		}
            		
            		if (tdList == null || tdList.size() < 8) {
            			continue;
            		}
            		
            		int j = 1;
            		for (Element tdElement : tdList) {
            			if (i == 2) {//标题
            				String value = tdElement.getTextTrim();
                			if (value == null || value.equals("")) {
                				Element href = (Element)tdElement.selectSingleNode("//a");
                				if (href == null) {
                					Element div = tdElement.element("div");
                					System.out.println(div.getTextTrim().trim());
                				} else {
                					System.out.println(href.getTextTrim());
                				}
                			} else {
                				System.out.println(value);
                			}
            			} else {//内容
            				if (j == 1) {//品名 嵌套多层，取a节点
            					Element href = (Element)tdElement.selectSingleNode("//a");
            					System.out.println(href.getTextTrim());
            					
                			} else if (j == 2 || j == 3 || j == 5 || j == 9) {//简单值，直接取（材质，规格，钢厂，时间）
                				String value = tdElement.getTextTrim();
                				System.out.println(value);
                			}  else if (j == 4) {//城市 仓库
                				String value = tdElement.getTextTrim();
                				String[] strs = StringUtils.split(value, " ");
                				System.out.println(strs[0]);
                				System.out.println(strs[1]);
                			} else if (j == 6) {//价格和数量
                				//价格
                				Element span = (Element)tdElement.selectSingleNode("//span");
                				System.out.print(span.getTextTrim());
                				
                				//数量
                				String value = tdElement.getTextTrim();
                				System.out.println(value);
                			} else if (j == 7) {//公司
                				System.out.println(tdElement.attributeValue("title"));
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
            							System.out.println("电话" + tele);
            							
            							String contact = strs[4].trim();
            							contact = contact.substring(1, contact.length() - 1);
            							System.out.println("联系人" + contact);
            							
            							String mobile = strs[5].trim();
            							mobile = mobile.substring(1, 12);
            							System.out.println("手机" + mobile);
            						}
                				}
                			}
            				j++;
            			}
            			
            		}
            		i++;
            	}
    		} catch (Exception e) {
    			logger.error("抓取网页错误。", e);
    		}
        }
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
