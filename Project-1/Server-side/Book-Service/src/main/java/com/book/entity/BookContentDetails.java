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

@Entity
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
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "id")
	private Book book;

	public BookContentDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "BookContentDetails [id=" + id + ", contentType=" + contentType + ", content=" + content
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", book=" + book + "]";
	}
    
}
