package com.vteba.shop.account.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户账户消费明细
 * @author yinlei
 * date 2013-8-31 下午9:06:01
 */
@Entity
@Table(name = "consume_detail", catalog = "skmbw")
public class ConsumeDetail implements java.io.Serializable {

	private static final long serialVersionUID = -3884994300223671126L;
	private ConsumeDetailId id;
	private Long orderDetailId;
	private Long itemId;
	private BigDecimal consumeSum;
	private Date consumeDate;
	private String remark;

	public ConsumeDetail() {
	}

	public ConsumeDetail(ConsumeDetailId id) {
		this.id = id;
	}

	public ConsumeDetail(ConsumeDetailId id, Long orderDetailId, Long itemId,
			BigDecimal consumeSum, Date consumeDate, String remark) {
		this.id = id;
		this.orderDetailId = orderDetailId;
		this.itemId = itemId;
		this.consumeSum = consumeSum;
		this.consumeDate = consumeDate;
		this.remark = remark;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)) })
	public ConsumeDetailId getId() {
		return this.id;
	}

	public void setId(ConsumeDetailId id) {
		this.id = id;
	}

	@Column(name = "order_detail_id")
	public Long getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	@Column(name = "item_id")
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "consume_sum", precision = 16)
	public BigDecimal getConsumeSum() {
		return this.consumeSum;
	}

	public void setConsumeSum(BigDecimal consumeSum) {
		this.consumeSum = consumeSum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consume_date", length = 19)
	public Date getConsumeDate() {
		return this.consumeDate;
	}

	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
