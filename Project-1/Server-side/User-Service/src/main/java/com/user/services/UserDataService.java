package com.user.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements UserDetailsService {
	
	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// logic to get the user_name and password from database can be written here
		com.user.entity.User user = userService.getUserByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username not present !!!");
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
