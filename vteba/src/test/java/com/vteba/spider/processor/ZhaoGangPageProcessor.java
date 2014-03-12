package com.vteba.spider.processor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import com.vteba.spider.model.Inventory;

/**
 * 找钢网网页抓取器。
 * @author yinlei
 * 2014-3-5 下午2:02:52
 */
public class ZhaoGangPageProcessor implements PageProcessor {
	private Site site = Site.me().setDomain("www.zhaogang.com");
	
	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().links().regex("http://www\\.zhaogang\\.com/spot/\\?page\\=\\d+").all();
        page.addTargetRequests(links);
        page.putField("content", page.getHtml().xpath("//tbody").all());
	}

	@Override
	public Site getSite() {
		return site;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String html = "http://www.zhaogang.com/spot/?page=1";
//		boolean result = html.matches("http://www\\.zhaogang\\.com/spot/\\?page\\=\\d+");
//		System.out.println(result);
		
		Spider spider = Spider.create(new ZhaoGangPageProcessor());
		
		FilePipeline filePipeline = new FilePipeline("c:\\zhaogang");
		spider.addPipeline(filePipeline);
		ResultItems resultItems = spider.get(html);
		List<String> bodyList = resultItems.get("content");
		
		System.out.println(bodyList.size());
		
		String tbody = bodyList.get(0);
		//tbody = tbody.replace("&nbsp;", " ");
		
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
            				System.out.println(pm);
            			} else if (j == 2) {//规格
            				String value = tdElement.elementTextTrim("a");
            				System.out.println(value);
            			} else if (j == 3) {//材质
            				String value = tdElement.elementTextTrim("a");
            				System.out.println(value);
            			} else if (j == 4) {//钢厂
            				String value = tdElement.elementTextTrim("a");
            				System.out.println(value);
            			} else if (j == 5) {//仓库
            				String value = tdElement.getTextTrim();
            				System.out.println(value);
            			} else if (j == 6) {//数量
            				String value = tdElement.getTextTrim();
            				System.out.println(value);
            			} else if (j == 7) {//价格
            				String value = tdElement.getTextTrim();
            				System.out.println(value);
            			} else if (j == 8) {//公司
            				System.out.println(tdElement.getTextTrim());
            			}
        				j++;
            			
            		}
        		} else if (tdList.size() == 1) {
        			List<Element> elements = tdList.get(0).element("div").elements("span");
        			String contact = elements.get(1).getTextTrim().substring(4).trim();
        			inventory.setContact(contact);
        			System.out.println(contact);
        			
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
