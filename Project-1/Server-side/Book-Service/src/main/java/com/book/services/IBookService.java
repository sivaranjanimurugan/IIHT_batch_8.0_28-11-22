package com.book.services;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.Notification;
import com.book.models.BookFilter;
import com.book.models.SubscribeDetails;

public interface IBookService {
	
	//author
	public Book createBook(Book newBook);

	public Book updateBook(Long id, Book updateBook);

	public void changeBookStatus(Long id, Boolean isActive);
	
	public Book getBookById(Long id);
	
	public List<Book> searchBook(BookFilter filter);
	
	public List<Book> getAllBooks(String author);
	
	public void deleteBook(Long id);
	
	//reader
	public Long subscribeBook(Long bookId, SubscribeDetails subDetails);
	
	public Integer unsubscribeBook(Long subId, SubscribeDetails subDetails);
	
	public List<Book> getAllSubscribedBooks(String subName);
	
	public Book getBookBySubscribedId(String subName, Long subscribedId);
	
	//notification
	public List<Notification> getAllNoteByuser(String username);
	
}
