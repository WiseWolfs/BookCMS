package com.njit.lib.domain;

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
 * 权限管理
 * @author Administrator
 *
 */
@Entity
public class Privilege {
	private Long id;
	private String name;
	private String url;
	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();
	
	public Privilege(){}
	
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	public Privilege(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	@ManyToOne
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
