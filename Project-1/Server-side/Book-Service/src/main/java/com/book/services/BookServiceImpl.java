package com.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.exceptions.ResourceNotFoundExceptionHandler;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}

	@Override
	public Book updateBook(Long id, Book updateBook) {
		// throw exception if the resource not found
		Book existingBook = bookRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandler("Book", "id", id));
		// update existing object
		// return updated book object
		return bookRepo.save(existingBook);
	}

	@Override
	public void changeStatus(Long id, Boolean isBlock) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

}
