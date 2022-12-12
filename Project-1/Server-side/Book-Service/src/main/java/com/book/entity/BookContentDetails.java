package com.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "DB_BOOK_CONTENT_DETAILS")
public class BookContentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CONTENT_TYPE")
	private String contentType;
	
	@Column(name = "CONTENT")
	private String content;

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