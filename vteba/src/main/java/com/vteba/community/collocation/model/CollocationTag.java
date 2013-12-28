package com.vteba.community.collocation.model;

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
 * 搭配标签实体
 * @author yinlei
 * @date 2013年10月8日 下午4:57:52
 */
@Entity
@Table(name = "collocation_tag", catalog = "skmbw")
public class CollocationTag implements java.io.Serializable {

	private static final long serialVersionUID = -3072311364355139026L;
	private Integer tagId;
	private String tagName;
	private Integer state;
	private Date createDate;
	private String createUser;
	private Integer rank;
	private String targetUrl;
	private String tagDesc;
	private Integer tagType;

	public CollocationTag() {
	}

	public CollocationTag(String tagName, Integer state, Date createDate,
			String createUser, Integer rank, String targetUrl, String tagDesc,
			Integer tagType) {
		this.tagName = tagName;
		this.state = state;
		this.createDate = createDate;
		this.createUser = createUser;
		this.rank = rank;
		this.targetUrl = targetUrl;
		this.tagDesc = tagDesc;
		this.tagType = tagType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tag_name", length = 150)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
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

	@Column(name = "create_user", length = 100)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "target_url", length = 250)
	public String getTargetUrl() {
		return this.targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Column(name = "tag_desc", length = 250)
	public String getTagDesc() {
		return this.tagDesc;
	}

	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

	@Column(name = "tag_type")
	public Integer getTagType() {
		return this.tagType;
	}

	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}

}
