package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.models.JwtRequest;
import com.user.services.IUserService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
	}
	
	@PostMapping("/sign-in")
	public ResponseEntity<?> createBook(@RequestBody JwtRequest request) {
		return new ResponseEntity<>(userService.signin(request), HttpStatus.OK);
	}

}
