package com.vteba.community.base.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 各种社区达人实体
 * @author yinlei
 * @date 2013年10月7日 下午3:13:42
 */
@Entity
@Table(name = "daren", catalog = "skmbw")
public class Daren implements java.io.Serializable {

	private static final long serialVersionUID = 3295414420630103461L;
	private Long darenId;
	private long userId;
	private String userName;
	private String nickName;
	private String email;
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
	private Integer gender;
	private String headImage;
	private String targetUrl;
	private Integer darenType;

	public Daren() {
	}

	public Daren(long userId) {
		this.userId = userId;
	}

	public Daren(long userId, String userName, String nickName, String email,
			String userAccount, Date registerDate, Date lastLoginDate,
			String address, Integer zipcode, String province, String city,
			String district, String street, String mobilePhone,
			String telphone, Integer level, Integer enable, Integer gender,
			String headImage, String targetUrl, Integer darenType) {
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
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
		this.gender = gender;
		this.headImage = headImage;
		this.targetUrl = targetUrl;
		this.darenType = darenType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "daren_id", unique = true, nullable = false)
	public Long getDarenId() {
		return this.darenId;
	}

	public void setDarenId(Long darenId) {
		this.darenId = darenId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
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

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "head_image", length = 250)
	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@Column(name = "target_url", length = 250)
	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Column(name = "daren_type")
	public Integer getDarenType() {
		return darenType;
	}

	public void setDarenType(Integer darenType) {
		this.darenType = darenType;
	}

}
