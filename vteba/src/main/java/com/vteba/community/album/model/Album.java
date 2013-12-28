package com.vteba.community.album.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.vteba.community.base.model.Images;

/**
 * 专辑实体
 * @author yinlei
 * @date 2013年10月7日 下午4:39:20
 */
@Entity
@Table(name = "album", catalog = "skmbw")
public class Album implements java.io.Serializable {

	private static final long serialVersionUID = 4909595177574037989L;
	private Long albumId;
	private String albumName;
	private Integer albumTypeId;
	private String albumTypeName;
	private Long userId;
	private String albumUser;
	private Date createDate;
	private String createUser;
	private Integer state;
	private Integer position;
	private Integer hotLevel;
	
	private List<Images> imagesList;

	public Album() {
	}

	public Album(String albumName) {
		this.albumName = albumName;
	}

	public Album(String albumName, String albumTypeName, Long userId,
			String albumUser, Date createDate, String createUser,
			Integer state, Integer position, Integer hotLevel, List<Images> imagesList,
			Integer albumTypeId) {
		this.albumName = albumName;
		this.albumTypeName = albumTypeName;
		this.userId = userId;
		this.albumUser = albumUser;
		this.createDate = createDate;
		this.createUser = createUser;
		this.state = state;
		this.position = position;
		this.hotLevel = hotLevel;
		this.imagesList = imagesList;
		this.albumTypeId = albumTypeId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "album_id", unique = true, nullable = false)
	public Long getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	@Column(name = "album_name", nullable = false, length = 100)
	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	@Column(name = "album_type_id")
	public Integer getAlbumTypeId() {
		return albumTypeId;
	}

	public void setAlbumTypeId(Integer albumTypeId) {
		this.albumTypeId = albumTypeId;
	}

	@Column(name = "album_type_name", length = 100)
	public String getAlbumTypeName() {
		return this.albumTypeName;
	}

	public void setAlbumTypeName(String albumTypeName) {
		this.albumTypeName = albumTypeName;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "album_user", length = 100)
	public String getAlbumUser() {
		return this.albumUser;
	}

	public void setAlbumUser(String albumUser) {
		this.albumUser = albumUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "create_user", length = 50)
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

	@Column(name = "position")
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Column(name = "hot_level")
	public Integer getHotLevel() {
		return this.hotLevel;
	}

	public void setHotLevel(Integer hotLevel) {
		this.hotLevel = hotLevel;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
    @BatchSize(size = 5)
    @Fetch(value = FetchMode.SUBSELECT)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE})
	public List<Images> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<Images> imagesList) {
		this.imagesList = imagesList;
	}

}
