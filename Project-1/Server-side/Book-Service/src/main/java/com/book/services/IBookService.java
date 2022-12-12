package com.book.services;

import com.book.entity.Book;

public interface IBookService {
	
	public Book createBook(Book newBook);

	public Book updateBook(Long id, Book updateBook);

	public void changeStatus(Long id, Boolean isBlock);
	
	public Book getBookById(Long id);
	
}
