package com.njit.lib.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 留言
 * @author Administrator
 *
 */
@Entity
public class Message {
	//>一般属性
	private Long id;
	private String content;
	private Date publishTime;
	private int agreeCount;//赞同数
	private int disagreeCount;//不赞同的数量
	private boolean isAgree;//是否赞成，用来保存一个用户的评论
	
	//>关联属性
	private User user;
	private Set<Remark> remarks  = new HashSet<Remark>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public int getAgreeCount() {
		return agreeCount;
	}
	public void setAgreeCount(int agreeCount) {
		this.agreeCount = agreeCount;
	}
	public int getDisagreeCount() {
		return disagreeCount;
	}
	public void setDisagreeCount(int disagreeCount) {
		this.disagreeCount = disagreeCount;
	}
	public boolean isAgree() {
		return isAgree;
	}
	public void setAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="message",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public Set<Remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}
	
}
