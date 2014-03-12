package com.vteba.spider.processor;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 兰格网页抓取器。
 * @author yinlei
 * 2014-3-5 下午1:57:55
 */
public class LangePageProcessor implements PageProcessor {
	private Site site = Site.me().setDomain("www.lange360.com");
	private static final Logger logger = LoggerFactory.getLogger(LangePageProcessor.class);
	
	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().links().regex("http://www\\.lange360\\.com/search\\.do\\?baosteel_page_no\\=\\d+\\&baosteel_page_size\\=\\d+").all();
        page.addTargetRequests(links);
        page.putField("content", page.getHtml().xpath("//tbody").all());
	}

	@Override
	public Site getSite() {
		return site;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String html = "http://www.lange360.com/search.do?baosteel_page_no=1&baosteel_page_size=30";
//		boolean result = html.matches("http://www\\.lange360\\.com/search\\.do\\?baosteel_page_no\\=\\d+\\&baosteel_page_size\\=\\d+");
//		System.out.println(result);
		
		Spider spider = Spider.create(new LangePageProcessor());
		FilePipeline filePipeline = new FilePipeline("c:\\lange");
		spider.addPipeline(filePipeline);
		ResultItems resultItems = spider.<ResultItems>get(html);
		List<String> bodyList = resultItems.get("content");
		
		logger.info(bodyList.size() + "");
		
		String tbody = bodyList.get(0);//只有第一个是可用的
		tbody = tbody.replace("&nbsp;", " ");
		
    	try {
    		SAXReader saxReader = new SAXReader();
    		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
        	Document document = saxReader.read(inputStream);
        	Element rootElement = document.getRootElement();
        	List<Element> trList = rootElement.elements("tr");
        	
        	int i = 0;
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
        		for (Element tdElement : tdList) {
        			if (j == 1) {//品名
        				System.out.println(tdElement.getTextTrim());
        			} else if (j == 2) {//材质
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 3) {//规格
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 4) {//价格
        				String value = tdElement.elementText("strong");
        				System.out.println(value);
        			} else if (j == 5) {//数量
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 6) {//钢厂
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 7) {//仓库/交割库
        				String value = tdElement.getTextTrim();
        				System.out.println(value);
        			} else if (j == 8) {//计量方式
        				System.out.println(tdElement.getTextTrim());
        			} else if (j == 9) {//所属企业
        				System.out.println(tdElement.getTextTrim());
        			}
    				j++;
        			
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
