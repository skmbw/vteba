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
 * 钢之家网页抓取器。
 * @author yinlei
 * 2014-3-5 下午4:27:51
 */
public class SteelHomePageProcessor implements PageProcessor {
	private Site site = Site.me().setDomain("www.steelhome.cn").setCharset("gb2312");
	
	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().links().regex("http://www\\.steelhome\\.cn/biz/biz_search\\.php\\?view\\=search_xh\\&page\\=\\d+").all();
        page.addTargetRequests(links);
        page.putField("content", page.getHtml().xpath("//tbody").all());
	}

	@Override
	public Site getSite() {
		return site;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		String str = "<a href=\"\" tjminghao')\"=\"\"><img class=\"img_164453\"";
//		//String pattern = "w+'\\)\"=\"\"";
//		String pattern = "[A-Za-z0-9]+'\\)\"=\"\"";
//		System.out.println(pattern);
//		boolean result = str.matches(pattern);
//		System.out.println(result);
//		
//		str = str.replaceAll(pattern, "");
//		System.out.println(str);
//		
//		Pattern regex = Pattern.compile("[A-Za-z0-9]+'\\)\"=\"\"");
//		
//		Matcher matcher = regex.matcher(str);
//		
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
		String html = "http://www.steelhome.cn/biz/biz_search.php?view=search_xh&page=1";
//		boolean result = html.matches("http://www\\.steelhome\\.cn/biz/biz_search\\.php\\?view\\=search_xh\\&page\\=\\d+");
//		System.out.println(result);
		
		Spider spider = Spider.create(new SteelHomePageProcessor());
		
		FilePipeline filePipeline = new FilePipeline("c:\\steelhome");
		spider.addPipeline(filePipeline);
		ResultItems resultItems = spider.get(html);
		List<String> bodyList = resultItems.get("content");
		
		System.out.println(bodyList.size());
		
		String tbody = bodyList.get(12);
		System.out.println(tbody);
		
		
		tbody = tbody.replace("&nbsp;", " ").replaceAll("[A-Za-z0-9]+'\\)\"=\"\"", "");//这个是因为，页面中有一些错误，通过正则表达式将其删去
		
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
        				String value = tdElement.elementTextTrim("a");//公司简称
        				System.out.println(value);
        				Element tbodyElement = (Element)tdElement.element("div").element("table").element("tbody");
        				List<Element> elements = tbodyElement.elements("tr");
        				
        				if (elements.size() == 2) {
        					Element company = elements.get(0).element("td").element("strong");//公司
        					System.out.println(company.getTextTrim());
        					
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
        				System.out.println(value);
        			} else if (j == 5) {//材质
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 6) {//规格
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 7) {//价格
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 8) {//数量
        				System.out.println(tdElement.getTextTrim());
        			} else if (j == 9) {//钢厂
        				System.out.println(tdElement.getTextTrim());
        			} else if (j == 10) {//地址/交货点
        				System.out.println(tdElement.getTextTrim());
        			} 
        			j++;
        		}
        		
//        		if (tdList.size() == 9) {
//        			
//        		} else if (tdList.size() == 1) {
//        			List<Element> elements = tdList.get(0).element("div").elements("span");
//        			String contact = elements.get(1).getTextTrim().substring(4).trim();
//        			inventory.setContact(contact);
//        			System.out.println(contact);
//        			
//        			String tele = elements.get(2).getTextTrim().substring(5).trim();
//        			String[] phones = StringUtils.split(tele, " ");
//        			if (phones.length == 2) {
//        				inventory.setMobilephone(phones[0]);
//        				inventory.setTelephone(phones[1]);
//        			} else {
//        				inventory.setMobilephone(tele);
//        			}
//        			
//        			String address = elements.get(3).getTextTrim().substring(5).trim();
//        			inventory.setAddress(address);
//        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
