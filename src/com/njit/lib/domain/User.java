package com.njit.lib.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.opensymphony.xwork2.ActionContext;
@Entity
public class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4385577944822696195L;
	//>-----一般属性
	private Long id;
	private String name;//昵称
	private String loginName;
	private String password;
	private String email;
	private String phone;
	private Long qq;
	private String profile;
	private String picUrl;
	private String imageName;//图像的名字
	private Date birthday;
	private String ipAddr;
	private int donateCount;
	
	//>------关联属性
	private Address address;
	private Role role=new Role();
	private Set<Paper> papers= new HashSet<Paper>();
	private Set<ElecBook> elecBooks = new HashSet<ElecBook>();
	private Set<DonateOrder> donateOrders = new HashSet<DonateOrder>();
	private Set<Message> messages = new HashSet<Message>();
	private Set<Book> books = new HashSet<Book>();
	
	@OneToMany(mappedBy="user")
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	@OneToMany(mappedBy="user")
	public Set<DonateOrder> getDonateOrders() {
		return donateOrders;
	}
	public void setDonateOrders(Set<DonateOrder> donateOrders) {
		this.donateOrders = donateOrders;
	}
	@OneToMany(mappedBy="user")
	public Set<Paper> getPapers() {
		return papers;
	}
	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}
	@OneToMany(mappedBy="user")
	public Set<ElecBook> getElecBooks() {
		return elecBooks;
	}
	public void setElecBooks(Set<ElecBook> elecBooks) {
		this.elecBooks = elecBooks;
	}
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getQq() {
		return qq;
	}
	public void setQq(Long qq) {
		this.qq = qq;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public int getDonateCount() {
		return donateCount;
	}
	public void setDonateCount(int donateCount) {
		this.donateCount = donateCount;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean hasPrivilegeByUrl(String privUrl) {
		//privUrl类似 user_addUI?name=1
		//1，对URL进行处理
		int pos = privUrl.indexOf("?");
		if(pos>-1){
			privUrl = privUrl.substring(0,pos);
		}
		//去掉UI后缀(因为保存在数据库中都没有加UI）
		if(privUrl.endsWith("UI")){
			privUrl = privUrl.substring(0,privUrl.length()-2);
		}
		//若本URL在我们的系统中根本就不存在，那么就可以放过它
		Collection<String> allPrivilegeUrls= (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if(!allPrivilegeUrls.contains(privUrl)){
			return true;
		}else{
			for(Privilege priv:role.getPrivileges()){
				if(privUrl.equals((priv.getUrl()))){
					return true;
				}
			}
			return false;
		}
		
	}
	

}
