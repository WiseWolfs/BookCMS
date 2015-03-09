package com.njit.lib.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class District {
	private Long id;
	private String name;
	private Set<Dormitory> dormitories = new HashSet<Dormitory>();
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
	
	@OneToMany
	@JoinColumn(name="districtId")
	public Set<Dormitory> getDormitories() {
		return dormitories;
	}
	public void setDormitories(Set<Dormitory> dormitories) {
		this.dormitories = dormitories;
	}
	
	

}
