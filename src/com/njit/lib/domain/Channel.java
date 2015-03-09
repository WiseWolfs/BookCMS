package com.njit.lib.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Channel {
	private Long id;
	private String profile;
	private String picUrl;
	private int type;
	private String imageName;
	/**
	 * 购买专区
	 */
	public static final int AREA_SELL =0;
	/**
	 * 交换专区
	 */
	public static final int AREA_TRADE=1;
	/**
	 * 捐赠专区
	 */
	public static final int AREA_CONTRIBUTE=2;
	
	/**
	 * 电子专区
	 */
	public static final int AREA_ELEC=3;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	

}
