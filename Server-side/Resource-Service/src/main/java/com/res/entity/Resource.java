package com.res.entity;

public class Resource {

	private Long rId;
	private String email;
	private String resourceName;
	private String domain;

	private Long userId;

	public Resource(Long rId, String email, String resourceName, String domain, Long userId) {
		super();
		this.rId = rId;
		this.email = email;
		this.resourceName = resourceName;
		this.domain = domain;
		this.userId = userId;
	}

	public Resource() {
		super();
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
