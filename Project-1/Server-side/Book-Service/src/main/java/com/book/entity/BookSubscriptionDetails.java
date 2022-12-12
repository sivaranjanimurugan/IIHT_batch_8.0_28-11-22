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

import lombok.Data;

@Entity
@Data
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

}
