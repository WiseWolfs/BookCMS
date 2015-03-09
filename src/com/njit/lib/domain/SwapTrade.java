package com.njit.lib.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * 交换记录
 * @author Administrator
 *
 */
@Entity
public class SwapTrade {
	private Long id;
	private Date createTime;
	private int status;
	
	//关联属性,因为交易的双方有先后顺序
	private List<Book> books = new ArrayList<Book>();
	private List<User> users = new ArrayList<User>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@OneToMany
	@JoinColumn(name="swapTradeId")
	@OrderBy
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@OneToMany
	@JoinColumn(name="swapTradeId")
	@OrderBy
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
