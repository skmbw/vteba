package com.vteba.service.xml.jibx;

import java.util.List;
import java.util.Map;

public class Customer {
	public Person person;
	public String street;
	public String city;
	public String state;
	public Integer zip;
	public String phone;
	public List<String> nameList;
	public List<Person> personList;
	
	private Map<String, Person> personMap;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the personList
	 */
	public List<Person> getPersonList() {
		return personList;
	}

	/**
	 * @param personList the personList to set
	 */
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	/**
	 * @return the nameList
	 */
	public List<String> getNameList() {
		return nameList;
	}

	/**
	 * @param nameList the nameList to set
	 */
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	/**
	 * @return the personMap
	 */
	public Map<String, Person> getPersonMap() {
		return personMap;
	}

	/**
	 * @param personMap the personMap to set
	 */
	public void setPersonMap(Map<String, Person> personMap) {
		this.personMap = personMap;
	}

	

}
