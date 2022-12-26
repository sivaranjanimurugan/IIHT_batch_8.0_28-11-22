package com.user.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {

	private Long id;
	private String logo;
	private String title;
	private String description;
	private String category;
	private Float price;
	private String author;
	private String publisher;
	private LocalDate publishedDate;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	private Boolean isActive;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BookContentDetails> bookContentDetails;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BookSubscriptionDetails> bookSubDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<BookContentDetails> getBookContentDetails() {
		return bookContentDetails;
	}

	public void setBookContentDetails(Set<BookContentDetails> bookContentDetails) {
		this.bookContentDetails = bookContentDetails;
	}

	public Set<BookSubscriptionDetails> getBookSubDetails() {
		return bookSubDetails;
	}

	public void setBookSubDetails(Set<BookSubscriptionDetails> bookSubDetails) {
		this.bookSubDetails = bookSubDetails;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", logo=" + logo + ", title=" + title + ", description=" + description + ", category="
				+ category + ", price=" + price + ", author=" + author + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", isActive="
				+ isActive + ", bookContentDetails=" + bookContentDetails + ", bookSubDetails=" + bookSubDetails + "]";
	}

}
