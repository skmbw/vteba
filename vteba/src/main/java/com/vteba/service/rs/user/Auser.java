package com.vteba.service.rs.user;

import com.vteba.user.model.User;

public class Auser {
	private Long userId;
	private String userName;
	private String tagsName;
	private User user;
	
	public Auser() {
		super();
	}
	
	public Auser(Long userId, String tagsName, User user) {
		super();
		this.userId = userId;
		this.tagsName = tagsName;
		this.user = user;
	}

	public Auser(Long userId, String userName, String tagsName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.tagsName = tagsName;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTagsName() {
		return tagsName;
	}
	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}
	
}
