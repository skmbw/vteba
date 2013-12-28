package com.vteba.shop.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户账户信息。
 * @author yinlei
 * date 2013-8-27 下午11:17:45
 */
@Entity
@Table(name = "account", catalog = "skmbw")
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = -2480266543539730057L;
	private Long userId;
	private String payPassword;
	private Double consumeTotal;
	private Double accountBalance;
	private Double freezeBalance;
	private Integer state;
	private String remark;

	public Account() {
	}

	public Account(Long userId) {
		this.userId = userId;
	}

	public Account(Long userId, String payPassword, Double consumeTotal,
			Double accountBalance, Double freezeBalance, Integer state,
			String remark) {
		this.userId = userId;
		this.payPassword = payPassword;
		this.consumeTotal = consumeTotal;
		this.accountBalance = accountBalance;
		this.freezeBalance = freezeBalance;
		this.state = state;
		this.remark = remark;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "pay_password", length = 30)
	public String getPayPassword() {
		return this.payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	@Column(name = "consume_total", precision = 16)
	public Double getConsumeTotal() {
		return this.consumeTotal;
	}

	public void setConsumeTotal(Double consumeTotal) {
		this.consumeTotal = consumeTotal;
	}

	@Column(name = "account_balance", precision = 16)
	public Double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Column(name = "freeze_balance", precision = 16)
	public Double getFreezeBalance() {
		return this.freezeBalance;
	}

	public void setFreezeBalance(Double freezeBalance) {
		this.freezeBalance = freezeBalance;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
