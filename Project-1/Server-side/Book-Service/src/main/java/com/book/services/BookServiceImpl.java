package com.book.services;

import java.time.LocalDateTime;
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
//		Set<BookContentDetails> bookContent = newBook.getBookContentDetails();
//		for(BookContentDetails book:bookContent) {
//			
//		}
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
		existingBook.setBookContentDetails(updateBook.getBookContentDetails());
		// return updated book object
		return bookRepo.save(existingBook);
	}

	@Override
	public void changeBookStatus(Long id, Boolean isActive) {
		bookRepo.updateActiveById(isActive, id);
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
		// subscribe
		BookSubscriptionDetails subscribe = new BookSubscriptionDetails();
		subscribe.setSubName(subDetails.getSubName());
		subscribe.setSubRole(subDetails.getSubRole());
		subscribe.setIsSubscribed(subDetails.getIsSubscribed());
		subscribe.setBook(existingBook);
		return subscribeRepo.save(subscribe).getId();
	}

	@Override
	public Integer unsubscribeBook(Long subId, SubscribeDetails subDetails) {
		BookSubscriptionDetails existingSub = subscribeRepo.findBookByusernameandbookId(subDetails.getSubName(), subId);
//				.orElseThrow(() -> new ResourceNotFoundExceptionHandler("Subscription", "id", subId));
		LocalDateTime startTime = existingSub.getCreatedTime();
		LocalDateTime endTime = existingSub.getCreatedTime().plusDays(1);
		LocalDateTime now = LocalDateTime.now();
		if (!now.isBefore(startTime) && !now.isAfter(endTime)) {
			// un-subscribe
			existingSub.setIsSubscribed(subDetails.getIsSubscribed());
			subscribeRepo.save(existingSub);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Book> getAllSubscribedBooks(String subName) {
		return subscribeRepo.findAllbooksBySubscription(subName);
	}

	@Override
	public Book getBookBySubscribedId(String subName, Long subscribedId) {
		return subscribeRepo.findbookBySubscriptionIdandUsername(subName, subscribedId);
	}

	@Override
	public List<Book> getAllBooks(String author) {
		return bookRepo.findAllbooksByAuthor(author);
	}

	@Override
	public void deleteBook(Long id) {
//		Book book = getBookById(id);
//		book.getBookContentDetails().
		bookRepo.deleteById(id);
	}
}
