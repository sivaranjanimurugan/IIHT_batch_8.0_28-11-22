package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.entity.User;
import com.user.models.JwtRequest;
import com.user.models.JwtResponse;
import com.user.services.IUserService;
import com.user.services.UserDataService;
import com.user.utility.JWTUtility;

@RestController
@RequestMapping("/api/v1/digitalbooks")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JWTUtility jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDataService userDataService;

	// user sign-in and sign-up
	@PostMapping("/sign-up")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> login(@RequestBody JwtRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("INVALID CREDENTIALS", ex);
		}
		final UserDetails userDetails = userDataService.loadUserByUsername(request.getUsername());
		final String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<>( new JwtResponse(token), HttpStatus.OK);
	}

}
