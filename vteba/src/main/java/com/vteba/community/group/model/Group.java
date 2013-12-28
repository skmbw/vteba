package com.vteba.community.group.model;

// Generated 2013-10-7 22:12:46 by Hibernate Tools 4.0.0

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
 * 社区小组
 * @author yinlei
 * @date 2013年10月7日 下午10:13:05
 */
@Entity
@Table(name = "group", catalog = "skmbw")
public class Group implements java.io.Serializable {

	private static final long serialVersionUID = -9158945248760374368L;
	private Long groupId;
	private String groupName;
	private Integer groupTagId;
	private String tagName;
	private String targetUrl;
	private String groupDesc;
	private Integer loveNumber;
	private Integer favoriteNumber;
	private String coverImage;
	private Date createDate;
	private String createUser;
	private Integer state;
	private Integer category;

	public Group() {
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public Group(String groupName, Integer groupTagId, String tagName,
			String targetUrl, String groupDesc, Integer loveNumber,
			Integer favoriteNumber, String coverImage, Date createDate,
			String createUser, Integer state, Integer category) {
		this.groupName = groupName;
		this.groupTagId = groupTagId;
		this.tagName = tagName;
		this.targetUrl = targetUrl;
		this.groupDesc = groupDesc;
		this.loveNumber = loveNumber;
		this.favoriteNumber = favoriteNumber;
		this.coverImage = coverImage;
		this.createDate = createDate;
		this.createUser = createUser;
		this.state = state;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name", nullable = false, length = 200)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "group_tag_id")
	public Integer getGroupTagId() {
		return this.groupTagId;
	}

	public void setGroupTagId(Integer groupTagId) {
		this.groupTagId = groupTagId;
	}

	@Column(name = "tag_name", length = 100)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "target_url", length = 250)
	public String getTargetUrl() {
		return this.targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Column(name = "group_desc", length = 500)
	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	@Column(name = "love_number")
	public Integer getLoveNumber() {
		return this.loveNumber;
	}

	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}

	@Column(name = "favorite_number")
	public Integer getFavoriteNumber() {
		return this.favoriteNumber;
	}

	public void setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}

	@Column(name = "cover_image", length = 250)
	public String getCoverImage() {
		return this.coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
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

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "category")
	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

}
