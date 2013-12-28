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
 * 订单明细信息
 * @author yinlei
 * date 2013-8-27 下午10:46:44
 */
@Entity
@Table(name = "order_detail", catalog = "skmbw")
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -8365910421518011584L;
	private Long orderDetailId;
	private long orderId;
	private Integer userId;
	private Long itemId;
	private String itemName;
	private Double itemPrice;
	private String remark;
	private int state;
	private Date createDate;
	private Date updateDate;

	public OrderDetail() {
	}

	public OrderDetail(long orderId, String remark, int state) {
		this.orderId = orderId;
		this.remark = remark;
		this.state = state;
	}

	public OrderDetail(long orderId, Integer userId, Long itemId,
			String itemName, Double itemPrice, String remark, int state,
			Date createDate, Date updateDate) {
		this.orderId = orderId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.remark = remark;
		this.state = state;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_detail_id", unique = true, nullable = false)
	public Long getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "item_id")
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "item_name", length = 100)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_price", precision = 16)
	public Double getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Column(name = "remark", nullable = false, length = 100)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
