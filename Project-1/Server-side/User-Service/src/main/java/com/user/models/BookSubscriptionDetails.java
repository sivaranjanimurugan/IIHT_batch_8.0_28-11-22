package com.user.models;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BookSubscriptionDetails {

	private Long id;
	private String subName;
	private Role subRole;
	private Boolean isSubscribed;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	// Mapping the column of this table
    @ManyToOne
  //Adding the name
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "id")
	private Book book;

	public BookSubscriptionDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookSubscriptionDetails [id=" + id + ", subName=" + subName + ", subRole=" + subRole + ", isSubscribed="
				+ isSubscribed + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", book=" + book
				+ "]";
	}
	
}
