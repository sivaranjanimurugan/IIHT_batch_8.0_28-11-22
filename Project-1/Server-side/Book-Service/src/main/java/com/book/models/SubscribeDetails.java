package com.book.models;

public class SubscribeDetails {
	
	private String subName;
	private Role subRole;
	private Boolean isSubscribed;
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Role getSubRole() {
		return subRole;
	}
	public void setSubRole(Role subRole) {
		this.subRole = subRole;
	}
	public Boolean getIsSubscribed() {
		return isSubscribed;
	}
	public void setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}
	
	

}
