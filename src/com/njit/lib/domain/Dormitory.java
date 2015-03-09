package com.njit.lib.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Dormitory {
	private Long id;
	private String name;
	private Set<Area> areas = new HashSet<Area>();
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
	@JoinColumn(name="dormitoryId")
	public Set<Area> getAreas() {
		return areas;
	}
	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
	

}
