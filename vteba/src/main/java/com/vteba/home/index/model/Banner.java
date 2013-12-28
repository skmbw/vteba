package com.vteba.home.index.model;

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
 * 
 * @author yinlei
 * date 2013-8-27 下午10:38:07
 */
@Entity
@Table(name = "banner", catalog = "skmbw")
public class Banner implements java.io.Serializable {

	private static final long serialVersionUID = 2024950905251304026L;
	private Integer bannerId;
	private String bannerName;
	private String bigPath;
	private String smallPath;
	private String targetUrl;
	private String bannerDesc;
	private int bannerType;
	private String typeName;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String remark;
	private Integer state;
	private Integer position;

	public Banner() {
	}

	public Banner(String bannerName, String bigPath, int bannerType) {
		this.bannerName = bannerName;
		this.bigPath = bigPath;
		this.bannerType = bannerType;
	}

	public Banner(String bannerName, String bigPath, String targetUrl,
			String bannerDesc, int bannerType, String typeName,
			Date createDate, String createUser, Date updateDate,
			String updateUser, String remark, Integer state, String smallPath,
			Integer position) {
		this.bannerName = bannerName;
		this.bigPath = bigPath;
		this.targetUrl = targetUrl;
		this.bannerDesc = bannerDesc;
		this.bannerType = bannerType;
		this.typeName = typeName;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
		this.state = state;
		this.smallPath = smallPath;
		this.position = position;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "banner_id", unique = true, nullable = false)
	public Integer getBannerId() {
		return this.bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	@Column(name = "banner_name", nullable = false, length = 100)
	public String getBannerName() {
		return this.bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	@Column(name = "big_path", nullable = false, length = 250)
	public String getBigPath() {
		return this.bigPath;
	}

	public void setBigPath(String bigPath) {
		this.bigPath = bigPath;
	}

	@Column(name = "target_url", length = 250)
	public String getTargetUrl() {
		return this.targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Column(name = "banner_desc", length = 250)
	public String getBannerDesc() {
		return this.bannerDesc;
	}

	public void setBannerDesc(String bannerDesc) {
		this.bannerDesc = bannerDesc;
	}

	@Column(name = "banner_type", nullable = false)
	public int getBannerType() {
		return this.bannerType;
	}

	public void setBannerType(int bannerType) {
		this.bannerType = bannerType;
	}

	@Column(name = "type_name", length = 100)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "update_user", length = 30)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "small_path", nullable = false, length = 250)
	public String getSmallPath() {
		return smallPath;
	}

	public void setSmallPath(String smallPath) {
		this.smallPath = smallPath;
	}

	@Column(name = "position")
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
