package com.vteba.community.album.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 专辑类型
 * @author yinlei
 * @date 2013年10月7日 下午5:37:36
 */
@Entity
@Table(name = "album_type", catalog = "skmbw")
public class AlbumType implements java.io.Serializable {

	private static final long serialVersionUID = 71940104738311046L;
	private int albumTypeId;
	private String albumTypeName;
	private Integer state;
	private Date createDate;
	private String createUser;
	private Integer rank;
	private String targetUrl;
	private String albumDesc;

	public AlbumType() {
	}

	public AlbumType(int albumTypeId, String albumTypeName) {
		this.albumTypeId = albumTypeId;
		this.albumTypeName = albumTypeName;
	}

	public AlbumType(int albumTypeId, String albumTypeName, Integer state,
			Date createDate, String createUser, Integer rank, String targetUrl,
			String albumDesc) {
		this.albumTypeId = albumTypeId;
		this.albumTypeName = albumTypeName;
		this.state = state;
		this.createDate = createDate;
		this.createUser = createUser;
		this.rank = rank;
		this.targetUrl = targetUrl;
		this.albumDesc = albumDesc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_type_id", unique = true, nullable = false)
	public int getAlbumTypeId() {
		return this.albumTypeId;
	}

	public void setAlbumTypeId(int albumTypeId) {
		this.albumTypeId = albumTypeId;
	}

	@Column(name = "album_type_name", nullable = false, length = 100)
	public String getAlbumTypeName() {
		return this.albumTypeName;
	}

	public void setAlbumTypeName(String albumTypeName) {
		this.albumTypeName = albumTypeName;
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
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Column(name = "album_desc", length = 250)
	public String getAlbumDesc() {
		return albumDesc;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

}
