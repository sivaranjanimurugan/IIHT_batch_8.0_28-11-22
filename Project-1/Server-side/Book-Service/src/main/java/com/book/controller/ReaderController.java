package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.models.SubscribeDetails;
import com.book.services.IBookService;

@RestController
public class ReaderController {

	@Autowired
	private IBookService bookService;

	@PutMapping("/update/is-subscribe/{book-id}")
	public ResponseEntity<?> subcribeBook(@PathVariable("book-id") Long bookId,
			@RequestBody SubscribeDetails subDetails) {
		return new ResponseEntity<>(bookService.subscribeBook(bookId, subDetails), HttpStatus.OK);
	}

	@PutMapping("/update/cancel-subscription/{sub-id}")
	public ResponseEntity<?> unsubcribeBook(@PathVariable("sub-id") Long subId,
			@RequestBody SubscribeDetails subDetails) {
		Integer result = bookService.unsubscribeBook(subId, subDetails);
		if(result == 0) {
			return new ResponseEntity<>("You can't unsubscribe this book due to time limit exceed for this action!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Book unsubscribed successfully!", HttpStatus.OK);
		}
		
	}

	@GetMapping("/getall/by-user/{subName}")
	public ResponseEntity<?> getAllByUser(@PathVariable String subName) {
		return new ResponseEntity<>(bookService.getAllSubscribedBooks(subName), HttpStatus.OK);
	}

	@GetMapping("/get/{subId}/by-user/{subName}")
	public ResponseEntity<?> getBookByUserAndSubId(@PathVariable String subName, @PathVariable Long subId) {
		return new ResponseEntity<>(bookService.getBookBySubscribedId(subName, subId), HttpStatus.OK);
	}
	
	@GetMapping("/getall/note/by-user/{subName}")
	public ResponseEntity<?> getAllNotificationByUser(@PathVariable String subName) {
		return new ResponseEntity<>(bookService.getAllNoteByuser(subName), HttpStatus.OK);
	}

}
