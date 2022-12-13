package com.book.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.entity.Book;
import com.book.entity.BookSubscriptionDetails;
import com.book.exceptions.ResourceNotFoundExceptionHandler;
import com.book.models.BookFilter;
import com.book.models.SubscribeDetails;
import com.book.repository.BookRepository;
import com.book.repository.BookSubcribeRepository;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookSubcribeRepository subscribeRepo;

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
		existingBook.setLogo(updateBook.getLogo());
		existingBook.setTitle(updateBook.getTitle());
		existingBook.setDescription(updateBook.getDescription());
		existingBook.setCategory(updateBook.getCategory());
		existingBook.setPrice(updateBook.getPrice());
		existingBook.setAuthor(updateBook.getAuthor());
		existingBook.setPublisher(updateBook.getPublisher());
		existingBook.setPublishedDate(updateBook.getPublishedDate());
		existingBook.setIsActive(updateBook.getIsActive());
		// return updated book object
		return bookRepo.save(existingBook);
	}

	@Override
	public void changeBookStatus(Long id, Boolean isBlock) {
		bookRepo.updateActiveById(isBlock, id);
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	@Override
	public List<Book> searchBook(BookFilter filter) {
		return bookRepo.searchBooks(filter.getTitle(), filter.getCategory(), filter.getAuthor(), filter.getPrice());
	}

	@Override
	public Long subscribeBook(Long bookId, SubscribeDetails subDetails) {
		Book existingBook = bookRepo.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandler("Book", "id", bookId));
		//subscribe
		BookSubscriptionDetails subscribe = new BookSubscriptionDetails();
		subscribe.setSubName(subDetails.getSubName());
		subscribe.setSubRole(subDetails.getSubRole());
		subscribe.setIsSubscribed(subDetails.getIsSubscribed());
		subscribe.setBook(existingBook);	
		//todo unsubscribe
		return subscribeRepo.save(subscribe).getId();
	}

	@Override
	public List<Book> getAllSubscribedBooks(String subName) {
		return subscribeRepo.findAllbooksBySubscription(subName);
	}

	@Override
	public Book getBookBySubscribedId(String subName, Long subscribedId) {
		return subscribeRepo.findbookBySubscriptionIdandUsername(subName, subscribedId);
	}
}
