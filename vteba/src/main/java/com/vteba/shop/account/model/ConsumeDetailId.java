package com.vteba.shop.account.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 用户账户消费明细主键，用户ID + 订单ID
 * @author yinlei
 * date 2013-8-31 下午9:10:31
 */
@Embeddable
public class ConsumeDetailId implements java.io.Serializable {

	private static final long serialVersionUID = 8242782846694185493L;
	private int userId;
	private long orderId;

	public ConsumeDetailId() {
	}

	public ConsumeDetailId(int userId, long orderId) {
		this.userId = userId;
		this.orderId = orderId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConsumeDetailId))
			return false;
		ConsumeDetailId castOther = (ConsumeDetailId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getOrderId() == castOther.getOrderId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + (int) this.getOrderId();
		return result;
	}

}
