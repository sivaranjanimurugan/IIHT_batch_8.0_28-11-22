package com.user.models;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BookContentDetails {

	private Long id;
	private String contentType;
	private String content;
	private LocalDateTime createdTime;
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
