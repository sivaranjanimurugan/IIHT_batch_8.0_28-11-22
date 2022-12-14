package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.models.BookFilter;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class UserBookController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/search/by-filter")
	public ResponseEntity<?> searchBooks(@RequestBody BookFilter filter) {
		List<?> result = restTemplate.postForObject("http://BOOK-SERVICE/search", filter, List.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
