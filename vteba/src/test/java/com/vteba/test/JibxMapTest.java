package com.vteba.test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;

public class JibxMapTest {
	private IBindingFactory factory = null;
    
    private StringWriter writer = null;
    private StringReader reader = null;
    
    private Account bean = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void mapBean2XML() {
	    try {
	    	bean = new Account();
	        bean.setAddress("北京");
	        bean.setEmail("email");
	        bean.setId(1);
	        bean.setName("jack");
	    	
	        MapBean mapBean = new MapBean();
	        HashMap<String, Account> map = new HashMap<String, Account>();
	        map.put("No1", bean);
	        
	        bean = new Account();
	        bean.setAddress("china");
	        bean.setEmail("tom@125.com");
	        bean.setId(2);
	        bean.setName("tom");
	        
	        map.put("No2", bean);
	        mapBean.setMap(map);
	        
	        factory = BindingDirectory.getFactory(MapBean.class);
	        writer = new StringWriter();
	        // marshal 编组
	        IMarshallingContext mctx = factory.createMarshallingContext();
	        mctx.setIndent(2);
	        mctx.marshalDocument(mapBean, "UTF-8", null, writer);
	        
	        reader = new StringReader(writer.toString());
	        //unmarshal 解组
	        IUnmarshallingContext uctx = factory.createUnmarshallingContext();
	        mapBean = (MapBean) uctx.unmarshalDocument(reader, null);
	        
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
