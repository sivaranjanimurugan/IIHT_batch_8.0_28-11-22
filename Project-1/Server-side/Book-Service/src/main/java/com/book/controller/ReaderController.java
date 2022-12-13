package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.models.SubscribeDetails;
import com.book.services.IBookService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	private IBookService bookService;

	@PutMapping("/update/is-subscribe/{book-id}")
	public ResponseEntity<?> updateBorrowed(@PathVariable("book-id") Long bookId,
			@RequestBody SubscribeDetails subDetails) {
		return new ResponseEntity<>(bookService.subscribeBook(bookId, subDetails), HttpStatus.OK);
	}
	
	@GetMapping("/getall/by-user")
	public ResponseEntity<?> getAllByUser(@RequestParam String subName) {
		return new ResponseEntity<>(bookService.getAllSubscribedBooks(subName), HttpStatus.OK);
	}
	
	@GetMapping("/getall/by-user")
	public ResponseEntity<?> getBookByUserAndSubId(@RequestParam String subName,
			@RequestParam Long subId) {
		return new ResponseEntity<>(bookService.getBookBySubscribedId(subName, subId), HttpStatus.OK);
	}

}
