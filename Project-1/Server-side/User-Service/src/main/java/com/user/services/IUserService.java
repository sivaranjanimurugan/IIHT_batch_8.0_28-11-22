package com.user.services;

import com.user.entity.User;

public interface IUserService {

	public User signup(User newUser);
	
	public User getUserByName(String username);

}
