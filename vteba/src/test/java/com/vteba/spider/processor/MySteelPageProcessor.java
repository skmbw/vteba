package com.vteba.spider.processor;

import java.io.ByteArrayInputStream;
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
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 我的钢铁的基于webmagic的网页抓取器。
 * @author yinlei
 * 2014-3-5 上午11:01:56
 */
public class MySteelPageProcessor implements PageProcessor {
	//http://list.sososteel.com/res/p--------------------------------100.html
    private Site site = Site.me().setDomain("list.sososteel.com");
       //.addStartUrl("http://my.oschina.net/flashsword/blog");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://list\\.sososteel\\.com/res/p-+\\d+.html").all();
        page.addTargetRequests(links);
        //page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
        page.putField("content", page.getHtml().xpath("//tbody").all());
        //page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
        
    }

    @Override
    public Site getSite() {
        return site;

    }

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
    	
//    	String aaaString = "http://list.sososteel.com/res/p--------------------------------1221.html";
//    	boolean result = aaaString.matches("http://list\\.sososteel\\.com/res/p-+\\d+.html");
//    	if (result) {
//    		return;
//    	}
    	
        Spider spider = Spider.create(new MySteelPageProcessor());
        Pipeline filePipeline = new FilePipeline("c:\\cbc.txt");
        spider.addPipeline(filePipeline);
        ResultItems resultItems = spider.<ResultItems>get("http://list.sososteel.com/res/p--------------------------------1.html");
        
        List<String> bodyList = resultItems.get("content");
        
        System.out.println(bodyList.size());
        
        //testxml();
        int i = 0;
        for (String tbody : bodyList) {
        	if (i++ == 0) {
        		continue;
        	}
        	System.out.println(tbody);
        	//------------------------------
        	tbody = tbody.replace("&nbsp;", " ");
        	try {
        		SAXReader saxReader = new SAXReader();
        		ByteArrayInputStream inputStream = new ByteArrayInputStream(tbody.getBytes());
            	Document document = saxReader.read(inputStream);
            	Element rootElement = document.getRootElement();
            	List<Element> trList = rootElement.elements("tr");
            	
            	for (Element trElement : trList) {
            		//System.out.println(trElement.asXML());
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
            					
//            					Element aa = tdElement.element("a");
//            					System.out.println(aa.getTextTrim());
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
//                				Element href = (Element)tdElement.selectSingleNode("//a");
//            					System.out.println(href.getTextTrim());
                				System.out.println(tdElement.attributeValue("title"));
                			} else if (j == 8) {// 联系人，电话，手机
                				//List contents = tdElement.content();//hrefs.content();
                				List<Element> aaElements = tdElement.elements("a");
                				if (aaElements.size() > 2) {
                					for (Element aaElement : aaElements) {
                						String value = aaElement.attributeValue("onclick");
                						if (value != null && value.indexOf("showTel") > -1) {
                							//System.out.println(value);
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
                				} else {
                					System.err.println(tdElement.getTextTrim());
                					System.err.println(tdElement.asXML());
                				}
//                				for (Object ele : contents) {
//                					if (ele instanceof DefaultText) {
//                						continue;
//                					} else if (ele instanceof DefaultElement) {
//                						DefaultElement defaultElement = (DefaultElement)ele;
//                						String value = defaultElement.attributeValue("onclick");
//                						if (value != null && value.indexOf("showTel") > -1) {
//                							System.out.println(value);
//                							String[] strs = StringUtils.split(value, ",");
//                							System.out.println("电话" + strs[3]);
//                							System.out.println("联系人" + strs[4]);
//                							System.out.println("手机" + strs[5]);
//                						}
//                					}
//                				}
                				
                				
//                				if (hrefs != null) {
//                					System.out.println(hrefs.getTextTrim());
//                				} else {
//                					System.out.println(tdElement.getTextTrim());
//                				}
                				
//                				if (hrefs.size() > 2) {
//                					for (Element aa : hrefs) {
//                						System.out.println(aa.getTextTrim());
//                					}
//                				} else {
//                					System.out.println(tdElement.getTextTrim());
//                				}
                			}
            				j++;
            			}
            			
//            			String value = tdElement.getTextTrim();
//            			if (value == null || value.equals("")) {
//            				Element href = (Element)tdElement.selectSingleNode("//a");
//            				if (href == null) {
//            					Element div = tdElement.element("div");
//            					System.out.println(div.getTextTrim().trim());
//            				} else {
//            					System.out.println(href.getTextTrim());
//            				}
//            			} else {
//            				System.out.println(value);
//            			}
            		}
            		i++;
            	}
            	System.out.println(rootElement);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	//------------------------------
        	//Object object = xstream.fromXML(tbody);
        	//System.out.println(object);
        }
        
        //System.out.println(resultItems);
        //spider.run();
//        spider.test();
        //spider.stop();
        //spider.close();
    }
    
}