package com.hr.entity;

import java.util.ArrayList;
import java.util.List;

public class HR {
	
	private Long userId;
	private String name;
	private String phone;
	
	List<Resource> resoures = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Resource> getResoures() {
		return resoures;
	}

	public void setResoures(List<Resource> resoures) {
		this.resoures = resoures;
	}

	public HR(Long userId, String name, String phone, List<Resource> resoures) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.resoures = resoures;
	}

	public HR(Long userId, String name, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

	public HR() {
		super();
	}

}
