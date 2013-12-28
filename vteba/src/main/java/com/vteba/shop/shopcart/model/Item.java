package com.vteba.shop.shopcart.model;

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
 * 
 * @author yinlei
 * date 2013-8-27 下午11:01:03
 */
@Entity
@Table(name = "item", catalog = "skmbw")
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = -2964443114829111194L;
	private Long itemId;
	private String itemName;
	private Double itemPrice;
	private Double discountPrice;
	private Double discount;
	private Integer categoryId;
	private String categoryName;
	private String promotion;
	private String brand;
	private Integer state;
	private Date createDate;
	private String createUser;
	private String itemDesc;
	private Date updateDate;
	private Long userId;
	private Integer itemNumber;
	private String itemImagePath;
	private String targetUrl;

	public Item() {
	}

	public Item(Long itemId) {
		this.itemId = itemId;
	}

	public Item(Long itemId, String itemName, Double itemPrice,
			Double discountPrice, Double discount, Integer categoryId,
			String categoryName, String promotion, String brand, Integer state,
			Date createDate, String createUser, String itemDesc,
			Date updateDate, Long userId, Integer itemNumber,
			String itemImagePath, String targetUrl) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
		this.discount = discount;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.promotion = promotion;
		this.brand = brand;
		this.state = state;
		this.createDate = createDate;
		this.createUser = createUser;
		this.itemDesc = itemDesc;
		this.updateDate = updateDate;
		this.userId = userId;
		this.itemNumber = itemNumber;
		this.itemImagePath = itemImagePath;
		this.targetUrl = targetUrl;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "item_name", length = 250)
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

	@Column(name = "discount_price", precision = 16)
	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "discount", precision = 10, scale = 1)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", length = 250)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "promotion", length = 250)
	public String getPromotion() {
		return this.promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@Column(name = "brand", length = 250)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
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

	@Column(name = "create_user", length = 30)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "item_desc", length = 250)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "item_number")
	public Integer getItemNumber() {
		return this.itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	@Column(name = "item_image_path", length = 250)
	public String getItemImagePath() {
		return this.itemImagePath;
	}

	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}

	@Column(name = "target_url", length = 250)
	public String getTargetUrl() {
		return this.targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

}
