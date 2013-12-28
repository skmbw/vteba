package com.vteba.shop.order.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 订单信息
 * @author yinlei
 * date 2013-8-27 下午10:46:25
 */
@Entity
@Table(name = "order", catalog = "skmbw")
public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 5714903192425511855L;
	private Long orderId;
	private int userId;
	private Long contractId;
	private String remark;
	private int state;
	private double orderSum;
	private Date createDate;
	private Date updateDate;

	public Order() {
	}

	public Order(int userId, int state, double orderSum, Date updateDate) {
		this.userId = userId;
		this.state = state;
		this.orderSum = orderSum;
		this.updateDate = updateDate;
	}

	public Order(int userId, Long contractId, String remark, int state,
			double orderSum, Date createDate, Date updateDate) {
		this.userId = userId;
		this.contractId = contractId;
		this.remark = remark;
		this.state = state;
		this.orderSum = orderSum;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "contract_id")
	public Long getContractId() {
		return this.contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "order_sum", nullable = false, precision = 16)
	public double getOrderSum() {
		return this.orderSum;
	}

	public void setOrderSum(double orderSum) {
		this.orderSum = orderSum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false, length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
