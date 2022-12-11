package com.library.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	@Override
	public Book updateBook(Long id, Book updateBook) {
		// throw exception if the resource not found
		Book existingBook = bookRepo.findById(id)
				.orElseThrow(() -> new com.library.exceptions.ResourceNotFoundExceptionHandler("Book", "id", id));
		// update existing object
		existingBook.setBookName(updateBook.getBookName());
		existingBook.setAuthorName(updateBook.getAuthorName());
		existingBook.setPrice(updateBook.getPrice());
		existingBook.setGenre(updateBook.getGenre());
		existingBook.setBorrowed(updateBook.getBorrowed());
		// return updated book object
		return bookRepo.save(existingBook);
	}

	@Override
	public void changeStatus(Long id, Boolean isBorrowed) {
		bookRepo.updateBorrowedById(isBorrowed, id);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
