package com.vteba.test;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * 网站用户信息
 * @author yinlei
 * date 2013-8-27 下午10:42:20
 */
@Entity
@Table(name = "user", catalog = "skmbw")
@XmlRootElement
public class UserCopy implements java.io.Serializable {

	private static final long serialVersionUID = 9127067637357153383L;
	private Long userId;
	private String userName;
	private String nickName;
	private String email;
	private String password;
	private String userAccount;
	private Date registerDate;
	private Date lastLoginDate;
	private String address;
	private Integer zipcode;
	private String province;
	private String city;
	private String district;
	private String street;
	private String mobilePhone;
	private String telphone;
	private Integer level;
	private Integer enable;
	private Integer gender;//性别，1男，2女
	
	private String authCode;
	private boolean rememberMe;

	public UserCopy() {
	}

	public UserCopy(Long userId) {
		this.userId = userId;
	}

	public UserCopy(Long userId, String userName, String nickName, String email,
			String password, String userAccount, Date registerDate,
			Date lastLoginDate, String address, Integer zipcode,
			String province, String city, String district, String street,
			String mobilePhone, String telphone, Integer level, Integer enable) {
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.userAccount = userAccount;
		this.registerDate = registerDate;
		this.lastLoginDate = lastLoginDate;
		this.address = address;
		this.zipcode = zipcode;
		this.province = province;
		this.city = city;
		this.district = district;
		this.street = street;
		this.mobilePhone = mobilePhone;
		this.telphone = telphone;
		this.level = level;
		this.enable = enable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "nick_name", length = 50)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Email
	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(min = 6, max = 16)
	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_account", length = 50)
	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", length = 19)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date", length = 19)
	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "address", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode")
	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "province", length = 50)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "district", length = 50)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "street", length = 250)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "mobile_phone", length = 15)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "telphone", length = 15)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "enable")
	public Integer getEnable() {
		return this.enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	@Column(name = "gender")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	/**
	 * @return 验证码
	 */
	@Transient
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode 验证码
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return 是否记住我
	 */
	@Transient
	public boolean isRememberMe() {
		return rememberMe;
	}

	/**
	 * @param rememberMe 是否记住我
	 */
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}
