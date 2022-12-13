package com.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.book.models.Role;

@Entity
@Table(name = "DB_BOOK_SUBSCRIPTION_DETAILS")
public class BookSubscriptionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "SUB_NAME")
	private String subName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SUB_ROLE")
	private Role subRole;
	
	@Column(name = "IS_SUBSCRIBED")
	private Boolean isSubscribed;
	
	@CreationTimestamp
	@Column(name = "CREATION_TIMESTAMP")
	private LocalDateTime createdTime;
	
	@UpdateTimestamp
	@Column(name = "UPDATION_TIMESTAMP")
	private LocalDateTime updatedTime;
	
	// Mapping the column of this table
    @ManyToOne
    //Adding the name
    @JoinColumn(name = "BOOK_ID")
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
