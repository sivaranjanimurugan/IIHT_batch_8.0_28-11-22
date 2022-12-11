package com.book.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "DB_BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESC")
	private String description;

	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "PUBLISHER")
	private String publisher;

	@Column(name = "PUBLISHED_DATE")
	private LocalDate publishedDate;
	
	@CreationTimestamp
	@Column(name = "CREATION_TIMESTAMP")
	private LocalDateTime createdTime;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
