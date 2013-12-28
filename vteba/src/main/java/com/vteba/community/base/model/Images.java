package com.vteba.community.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专辑等的图片实体
 * @author yinlei
 * @date 2013年10月7日 下午4:38:25
 */
@Entity
@Table(name = "images", catalog = "skmbw")
public class Images implements java.io.Serializable {
	private static final long serialVersionUID = -7705365857108388091L;
	private long imageId;
	private Integer imageType;
	private String imageUrl;
	private Integer state;
	private String size;
	private String module;
	private Long albumId;
	
	public Images() {
	}

	public Images(long imageId) {
		this.imageId = imageId;
	}

	public Images(long imageId, Integer imageType, String imageUrl,
			Integer state, String size, String module) {
		this.imageId = imageId;
		this.imageType = imageType;
		this.imageUrl = imageUrl;
		this.state = state;
		this.size = size;
		this.module = module;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id", unique = true, nullable = false)
	public long getImageId() {
		return this.imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	@Column(name = "image_type")
	public Integer getImageType() {
		return this.imageType;
	}

	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}

	@Column(name = "image_url", length = 250)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "size")
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "module", length = 100)
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "album_id", insertable = false, updatable = false)
	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

}
