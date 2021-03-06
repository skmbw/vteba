package com.skmbw.user.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_account
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String userAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.register_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Date registerDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.last_login_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Date lastLoginDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.address
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.zipcode
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Integer zipcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.province
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.city
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.district
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String district;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.street
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String street;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.mobile_phone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String mobilePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.telphone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private String telphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.level
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.enable
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Integer enable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    private Integer gender;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nickName the value for user.nick_name
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_account
     *
     * @return the value of user.user_account
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_account
     *
     * @param userAccount the value for user.user_account
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.register_date
     *
     * @return the value of user.register_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.register_date
     *
     * @param registerDate the value for user.register_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.last_login_date
     *
     * @return the value of user.last_login_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.last_login_date
     *
     * @param lastLoginDate the value for user.last_login_date
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.address
     *
     * @return the value of user.address
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.address
     *
     * @param address the value for user.address
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.zipcode
     *
     * @return the value of user.zipcode
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Integer getZipcode() {
        return zipcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.zipcode
     *
     * @param zipcode the value for user.zipcode
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.province
     *
     * @return the value of user.province
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.province
     *
     * @param province the value for user.province
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.city
     *
     * @return the value of user.city
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.city
     *
     * @param city the value for user.city
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.district
     *
     * @return the value of user.district
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getDistrict() {
        return district;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.district
     *
     * @param district the value for user.district
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.street
     *
     * @return the value of user.street
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getStreet() {
        return street;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.street
     *
     * @param street the value for user.street
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.mobile_phone
     *
     * @return the value of user.mobile_phone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.mobile_phone
     *
     * @param mobilePhone the value for user.mobile_phone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.telphone
     *
     * @return the value of user.telphone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.telphone
     *
     * @param telphone the value for user.telphone
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.level
     *
     * @return the value of user.level
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.level
     *
     * @param level the value for user.level
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.enable
     *
     * @return the value of user.enable
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.enable
     *
     * @param enable the value for user.enable
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbggenerated Fri Nov 15 22:31:12 CST 2013
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
}