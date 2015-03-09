package com.njit.lib.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 试题
 * @author Administrator
 *
 */
@Entity
public class Paper {
	//>>一般属性
	private Long id;
	private String name;//试卷的名称
	private int downCount;//下载量
	private String paperName;//存放在硬盘上的名字
	
	
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
	

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	

}
