package com.vteba.service.rs.user;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vteba.product.clothing.model.Clothing;
import com.vteba.service.xml.XmlServiceImpl;
import com.vteba.service.xml.jibx.Customer;
import com.vteba.service.xml.jibx.Person;
import com.vteba.user.model.User;
import com.vteba.user.service.spi.UserService;
import com.vteba.utils.json.JacksonUtils;
import com.vteba.utils.reflection.BeanCopyUtils;

@Path("/restUser")
@Named
public class RestUserService {
	@Inject
	private UserService userServiceImpl;
	@Inject
	private XmlServiceImpl xmlServiceImpl;
//	@Inject
//	private MongoUserDao mongoUserDaoImpl;
	
	@GET
	@Path("/list")
	@Produces(value = {MediaType.APPLICATION_JSON})
	public Customer list() {
		String hql = "select u from User u";
		userServiceImpl.getListByHql(hql, User.class);
		
		hql = "select u,t from User u,Tags t where u.userId = t.tagsId";
		List<User> list = userServiceImpl.getListByHql(hql);
		System.out.println(list);
		
		hql = "select u.userId,u.userName,t.tagsName from User u,Tags t where u.userId = t.tagsId";
		List<User> list2 = userServiceImpl.getListByHql(hql);
		System.out.println(list2);
		
		hql = "select new com.vteba.service.rs.user.Auser(u.userId,t.tagsName,u) from User u,Tags t where u.userId = t.tagsId";
		List<Auser> list3 = userServiceImpl.getListByHql(hql);
		System.out.println(list3);
		
		hql = "select u.userId,t.tagsName,u as user from User u,Tags t where u.userId = t.tagsId";
		List<Auser> list4 = userServiceImpl.getListByHql(hql);
		System.out.println(list4);
		
		//String sql = "select * from user";
//		List list5 = userServiceImpl.getListBySql(sql, User.class);
		
//		sql = "select user_id userId,user_name userName,user_account userAccount from user";
//		List<User> list6 = userServiceImpl.getListBySql(sql, User.class);
//		System.out.println(list6);
		
		User user = userServiceImpl.get(4L);
		//user = mongoUserDaoImpl.findOne(user.getUserId());
		JacksonUtils.get().toJson(user);
		
		Customer customer = new Customer();
		customer.setCity("ghj");
		customer.setPhone("123456789");
		customer.setStreet("中国浙江杭州");
		customer.setState("中国");
		
		Person person = new Person();
		person.setCustomerNumber(23);
		person.setFirstName("yinlei");
		person.setLastName("尹雷");
		
		customer.setPerson(person);
		
		List<String> nameList = Lists.newArrayList();
		for (int i = 0; i < 11; i++) {
			nameList.add("asdfasd" + i);
		}
		customer.setNameList(nameList);
		
		List<Person> personList = Lists.newArrayList();
		for (int i = 0; i < 1; i++) {
			Person p = new Person();
			p.setCustomerNumber(23);
			p.setFirstName("yinlei");
			p.setLastName("尹雷");
			personList.add(p);
		}
		customer.setPersonList(personList);
		
		Map<String, Person> personMap = Maps.newHashMap();
		Person person2 = new Person();
		person2.setCustomerNumber(34);
		person2.setFirstName("毕子利");
		person2.setLastName("千寻");
		personMap.put("qianxun", person2);
		
		customer.setPersonMap(personMap);
		
		long d = System.nanoTime();
		String result = xmlServiceImpl.objectToXml(customer);
		xmlServiceImpl.xmlToObject(result, Customer.class);
		System.out.println(System.nanoTime() - d);
		
		long d1 = System.nanoTime();
		String json = JacksonUtils.get().toJson(customer);
		JacksonUtils.get().fromJson(json, Customer.class);
		System.out.println(System.nanoTime() - d1);
		
		long d2 = System.nanoTime();
		String json2 = JSON.toJSONString(customer);
		JSON.parseObject(json2, Customer.class);
		System.out.println(System.nanoTime() - d2);
		
		/****************************************************/
//		System.out.print("fastjson toMap : ");
//		long ad0 = System.nanoTime();
//		BeanCopyUtils.get().toMap(customer);
//		System.out.println(System.nanoTime() - ad0);
//		
//		System.out.print("fastjson 去null toMaps : ");
//		long ad = System.nanoTime();
//		BeanCopyUtils.get().toMaps(customer);
//		System.out.println(System.nanoTime() - ad);
		
		System.out.print("CGLIB BeanMap beanToMap : ");
		long ad2 = System.nanoTime();
		BeanCopyUtils.get().beanToMap(customer);
		System.out.println(System.nanoTime() - ad2);
		
		System.out.print("MethodAccess beanToMap : ");
		Map<String, Object> maps = Maps.newHashMap();
		long ad3 = System.nanoTime();
		BeanCopyUtils.get().beanToMap(customer, maps);
		System.out.println(System.nanoTime() - ad3);
		
		System.out.print("CGLIB BeanCopier BeanCopy : ");
		Customer c = new Customer();
		long ad4 = System.nanoTime();
		BeanCopyUtils.get().beanCopy(customer, c);
		System.out.println(System.nanoTime() - ad4);
		
		System.out.print("MethodAccess MapToBean : ");
		Customer c2 = new Customer();
		long ad5 = System.nanoTime();
		BeanCopyUtils.get().mapToBean(c2, maps);
		System.out.println(System.nanoTime() - ad5);
		
		/****************************************************/
		
		return customer;
	}
	
	@POST
	@Path("/json")
	@Produces(value = { MediaType.APPLICATION_JSON })
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Customer json(Clothing list) {
		User user = userServiceImpl.get(4L);
		JacksonUtils.get().toJson(user);
		
		Customer customer = new Customer();
		customer.setCity("ghj");
		customer.setPhone("123456789");
		customer.setStreet("中国浙江杭州");
		customer.setState("中国");
		
		Person person = new Person();
		person.setCustomerNumber(23);
		person.setFirstName("yinlei");
		person.setLastName("尹雷");
		
		customer.setPerson(person);
		
		List<String> nameList = Lists.newArrayList();
		for (int i = 0; i < 11; i++) {
			nameList.add("asdfasd" + i);
		}
		customer.setNameList(nameList);
		
		List<Person> personList = Lists.newArrayList();
		for (int i = 0; i < 1; i++) {
			Person p = new Person();
			p.setCustomerNumber(23);
			p.setFirstName("yinlei");
			p.setLastName("尹雷");
			personList.add(p);
		}
		customer.setPersonList(personList);
		
		Map<String, Person> personMap = Maps.newHashMap();
		Person person2 = new Person();
		person2.setCustomerNumber(34);
		person2.setFirstName("毕子利");
		person2.setLastName("千寻");
		personMap.put("qianxun", person2);
		
		customer.setPersonMap(personMap);
		
		long d = System.nanoTime();
		String result = xmlServiceImpl.objectToXml(customer);
		xmlServiceImpl.xmlToObject(result, Customer.class);
		System.out.println(System.nanoTime() - d);
		
		//***************************************
//		List<Customer> cusList = Lists.newArrayList();
//		cusList.add(customer);
//		String xmlList = xmlServiceImpl.objectToXml(cusList, Customer.class);
//		xmlServiceImpl.xmlToObject(xmlList, Customer.class);
		//***************************************
		
		long d1 = System.nanoTime();
		String json = JacksonUtils.get().toJson(customer);
		JacksonUtils.get().fromJson(json, Customer.class);
		System.out.println(System.nanoTime() - d1);
		
		long d2 = System.nanoTime();
		String json2 = JSON.toJSONString(customer);
		JSON.parseObject(json2, Customer.class);
		System.out.println(System.nanoTime() - d2);
		
		return customer;
	}
}
