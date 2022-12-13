package com.user.services;

import com.user.entity.User;
import com.user.models.JwtRequest;
import com.user.models.JwtResponse;

public interface IUserService {

	public User signup(User newUser);

	public JwtResponse signin(JwtRequest request);

}
