package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.models.JwtRequest;
import com.user.models.JwtResponse;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User signup(User newUser) {
		return userRepo.save(newUser);
	}

	@Override
	public JwtResponse signin(JwtRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
