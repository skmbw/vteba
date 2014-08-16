package com.vteba.user.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.vteba.service.generic.BaseService;
import com.vteba.service.xml.XmlServiceImpl;
import com.vteba.service.xml.jibx.Customer;
import com.vteba.service.xml.jibx.Person;
import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.user.model.User;
import com.vteba.user.service.spi.UserService;
import com.vteba.web.action.BasicAction;

/**
 * 用户登录控制器。
 * @author yinlei
 * date 2013-8-23 6:44:19
 */
@Controller
@RequestMapping("/user")
public class LoginAction extends BasicAction<User> {
	public static final String VTEBA_PASS_SALT_VALUE = "vteba_V_pass_salt_Fn_skmbw";
	
//	private JedisTemplate jedisTemplate;
//	private Memcache memcacheImpl;
	
	@Inject
	private CookieService cookieServiceImpl;
	
	@Inject
	private UserService userServiceImpl;
	
	@Inject
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Inject
	private XmlServiceImpl xmlServiceImpl;
	
	/**
	 * 去登录。
	 * @return 登录页面
	 * @author yinlei
	 * date 2013-8-23 11:01:08
	 */
	@RequestMapping("/login")
	public String login() {
		long ad = System.currentTimeMillis();
		User cacheUser = userServiceImpl.get(4L);
		System.out.println(cacheUser.getUserName() + " : " + (System.currentTimeMillis() - ad));
		
		//***************Redis*********************//
//		long da2 = System.currentTimeMillis();
//		jedisTemplate.set("keys", "尹雷");
//		String keys = jedisTemplate.get("keys");
//		System.out.println(keys + " : " + (System.currentTimeMillis() - da2));
//		
//		long da3 = System.currentTimeMillis();
//		memcacheImpl.add(keys, 0, keys);
//		String memKey = memcacheImpl.get(keys);
//		System.out.println(memKey + " : " + (System.currentTimeMillis() - da3));
		
//		String path = "\\WEB-INF\\classes\\com\\vteba\\service\\xml\\jibx\\data.xml";
//		path = RequestContextHolder.getSession().getServletContext().getRealPath(path);
//		File file = new File(path);
//		FileInputStream stream = null;
//		try {
//			stream = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			
//		}
//		StreamSource source = new StreamSource(stream);
		
		Customer custom = new Customer();//xmlServiceImpl.xmlToObject(source, Customer.class);
		Person person = new Person();
		person.setCustomerNumber(22);
		person.setFirstName("yin");
		person.setLastName("lei");
		
		List<Person> personList = new ArrayList<Person>();
		Person person2 = new Person();
		person2.setCustomerNumber(22);
		person2.setFirstName("yin");
		person2.setLastName("尹雷");
		personList.add(person2);
		
		custom.setPersonList(personList);
		
		custom.setPerson(person);
		custom.setCity("杭州");
		custom.setPhone("123123");
		custom.setState("ZJ");
		custom.setStreet("xx");
		custom.setZip(212121);
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("yinlei");
		nameList.add("尹雷");
		custom.setNameList(nameList);
		
		//***************Jedis*********************//
//		long da4 = System.currentTimeMillis();
//		jedisTemplate.set("customer", custom);
//		
//		jedisTemplate.get("customer", Customer.class);
//		System.out.println(System.currentTimeMillis() - da4);
		
		//***************Jedis*********************//
//		long da5 = System.currentTimeMillis();
//		memcacheImpl.put("customer", 0, custom);
//		
//		memcacheImpl.get("customer");
//		System.out.println(System.currentTimeMillis() - da5);
		//*****************Memcache***********************//
		
//		String[] names = new String[2];
//		names[0] = "yinlei";
//		names[1] = "";
//		custom.setNameList(names);
		long d = System.currentTimeMillis();
		//Customer c = null;
		String customerXml = null;
		for (int i = 0; i < 1000; i++) {
			customerXml = xmlServiceImpl.objectToXml(custom);
			xmlServiceImpl.xmlToObject(customerXml, Customer.class);
		}
		
		System.out.println("JIBX " + (System.currentTimeMillis() - d));
		//System.out.println(customerXml);
//		File outFile = new File("e:\\ddd.xml");
//		FileOutputStream outputStream = null;
//		try {
//			outputStream = new FileOutputStream(outFile);
//		} catch (FileNotFoundException e) {
//			
//		}
//		StreamResult result = new StreamResult(outputStream);
//		xmlServiceImpl.objectToXml(c, result);
//		IOUtils.closeQuietly(outputStream);
		
		//---------------XStream----------------------//
		Map<String, Person> maps = Maps.newHashMap();
		custom.setPersonMap(maps);
		long d2 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			String xml = xmlServiceImpl.toXml(custom);
			xmlServiceImpl.fromXml(xml);
		}
		System.out.println("XStream " + (System.currentTimeMillis() - d2));
		
		return "user/login";
	}
	
	/**
     * 用户登录逻辑，登录成功后跳转到，登录前的页面。
     * @param user 用户信息
     * @return 首页视图
     * @author yinlei
     * date 2013-8-23 下午6:47:31
     */
    @RequestMapping("/doLogin")
    public String doLogin(User user) {
		// 检查当前是否有登录用户
		if (cookieServiceImpl.isUserLogin()) {
			// 如果有，和用户填写的登录信息进行比较
			User curUser = cookieServiceImpl.getCurrentUser();

			boolean passEqual = passEqual(curUser.getPassword(), user.getPassword());
			if (passEqual && user.getUserAccount().equals(curUser.getUserAccount())) {
				// 如果成功，直接跳转
				return "index";
			} else {
				return checkUserLogin(user);
			}
		} else {// 没有登录直接查询数据库，获取用户信息
			return checkUserLogin(user);
		}
    }
    
    /**
     * 用户登出。登出后跳转到首页。
     * @return
     * @author yinlei
     * date 2013-8-23 下午6:47:43
     */
    @RequestMapping("/logout")
	public String logout() {
		cookieServiceImpl.logout();
		return "index";
	}
    
    /**
     * 验证用户登录。
     * @param user 用户信息
     * @return 返回的视图
     */
    protected String checkUserLogin(User user) {
//		String hql = "select u from User u where u.userAccount = ?1";
		// 不成功，查询数据库，获取用户信息
		User aUser = userServiceImpl.uniqueResult("userAccount", user.getUserAccount());
		// 和用户填写的登录信息进行比较
		if (aUser != null && passEqual(aUser.getPassword(), user.getPassword())) {
			
			// 如果成功，将信息保存到cookie中，跳转
			cookieServiceImpl.addUserToCookie(aUser);

			return "index";
		} else {
			// 不成功，返回登录页面，显示错误
			return "user/login";
		}
    }

    /**
     * 比较密码是否相等
     * @param encodePass 加密密码
     * @param rawPass 原密码
     * @return true相等，false不等
     */
    private boolean passEqual(String encodePass, String rawPass) {
    	boolean passEqual = shaPasswordEncoder.isPasswordValid(encodePass, rawPass, VTEBA_PASS_SALT_VALUE);
    	return passEqual;
    }

	@Override
	public void setBaseServiceImpl(
			BaseService<User, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
    
//    @Inject
//	public void setJedisTemplate(JedisTemplate jedisTemplate) {
//		this.jedisTemplate = jedisTemplate;
//	}
//
//    @Inject
//	public void setMemcacheImpl(Memcache memcacheImpl) {
//		this.memcacheImpl = memcacheImpl;
//	}
    
}
