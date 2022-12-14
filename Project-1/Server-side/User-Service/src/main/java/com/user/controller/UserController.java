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

import com.user.entity.User;
import com.user.models.BookFilter;
import com.user.models.JwtRequest;
import com.user.services.IUserService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private RestTemplate restTemplate;

	// user sign-in and sign-up
	@PostMapping("/sign-up")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> createBook(@RequestBody JwtRequest request) {
		return new ResponseEntity<>(userService.signin(request), HttpStatus.OK);
	}

	@PostMapping("/search/by-filter")
	public ResponseEntity<?> searchBooks(@RequestBody BookFilter filter) {
		List result = restTemplate.postForObject("http://BOOK-SERVICE/search", filter, List.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
