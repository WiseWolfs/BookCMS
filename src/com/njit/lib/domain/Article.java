package com.njit.lib.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article {
	//>>一般属性
	private Long id;
	private String title;
	private String content;
	private int viewCount;
	private Date publishTime;
	private int remarkCount;
	//>>关联属性
	private User user;
	private Set<Remark> remarks = new HashSet<Remark>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public int getRemarkCount() {
		return remarkCount;
	}
	public void setRemarkCount(int remarkCount) {
		this.remarkCount = remarkCount;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="article")
	public Set<Remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}
	

}
