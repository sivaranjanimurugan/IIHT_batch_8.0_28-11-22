package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.services.IBookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@PostMapping("/author/books")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.createBook(book), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book updateBook) {
		return new ResponseEntity<>(bookService.updateBook(id, updateBook), HttpStatus.OK);
	}

	@PutMapping("/update/is-borrowed/{id}")
	public ResponseEntity<?> updateBorrowed(@PathVariable("id") Long id, @RequestBody Boolean isBorrowed) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return new ResponseEntity<>("No such book available !", HttpStatus.NOT_FOUND);
		} else {
			bookService.changeStatus(id, isBorrowed);
			return new ResponseEntity<>("Book status updated successfully !", HttpStatus.OK);
		}
	}

}
