package com.njit.lib.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 电子书//TODO 不知道为什么我使用继承，但是出错
 * @author Administrator
 *
 */
@Entity
public class ElecBook{
	//>>一般属性
	private Long id;
	private String name;
	private String downUrl;//网盘的下载地址
	private int downCount;//下载量
	
	
	//>>关联属性
	private User user;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDownUrl() {
		return downUrl;
	}


	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}


	public int getDownCount() {
		return downCount;
	}


	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

}
