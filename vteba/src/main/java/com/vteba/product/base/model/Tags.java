package com.vteba.product.base.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品标签实体
 * @author yinlei
 * @date 2013年10月4日 下午5:52:29
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "parentTags" })
@Entity
@Table(name = "tags", catalog = "skmbw", uniqueConstraints = @UniqueConstraint(columnNames = "tags_name"))
public class Tags implements java.io.Serializable {
	private static final long serialVersionUID = -8036318257520195773L;
	private Integer tagsId;
	private String tagsName;
	private String parentName;
	private Integer tagsType;
	private Integer state;
	private String tagsUrl;

	/**一对多自关联**/
    private List<Tags> childTags = new ArrayList<Tags>();
    private Tags parentTags;
	
	public Tags() {
	}

	public Tags(String tagsName) {
		this.tagsName = tagsName;
	}

	public Tags(String tagsName, Tags parentTags, String parentName,
			Integer tagsType, Integer state, String tagsUrl, List<Tags> childTags) {
		this.tagsName = tagsName;
		this.parentTags = parentTags;
		this.parentName = parentName;
		this.tagsType = tagsType;
		this.state = state;
		this.tagsUrl = tagsUrl;
		this.childTags = childTags;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tags_id", unique = true, nullable = false)
	public Integer getTagsId() {
		return this.tagsId;
	}

	public void setTagsId(Integer tagsId) {
		this.tagsId = tagsId;
	}

	@Column(name = "tags_name", unique = true, nullable = false, length = 100)
	public String getTagsName() {
		return this.tagsName;
	}

	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}

//	@Column(name = "parent_tags")
//	public Integer getParentTags() {
//		return this.parentTags;
//	}
//
//	public void setParentTags(Integer parentTags) {
//		this.parentTags = parentTags;
//	}

	@Column(name = "parent_name", length = 100)
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "tags_type")
	public Integer getTagsType() {
		return this.tagsType;
	}

	public void setTagsType(Integer tagsType) {
		this.tagsType = tagsType;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "tags_url", length = 250)
	public String getTagsUrl() {
		return this.tagsUrl;
	}

	public void setTagsUrl(String tagsUrl) {
		this.tagsUrl = tagsUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentTags")
    @BatchSize(size = 10)
    @Fetch(value = FetchMode.SUBSELECT)
    @Cascade({CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.EXTRA)
	public List<Tags> getChildTags() {
		return childTags;
	}

	public void setChildTags(List<Tags> childTags) {
		this.childTags = childTags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_tags", nullable = true)
    @LazyToOne(LazyToOneOption.PROXY)
	public Tags getParentTags() {
		return parentTags;
	}

	public void setParentTags(Tags parentTags) {
		this.parentTags = parentTags;
	}

}
