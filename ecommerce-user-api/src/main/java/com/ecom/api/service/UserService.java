package com.ecom.api.service;

import java.util.List;
import java.util.Optional;

import com.ecom.api.model.User;

public interface UserService {

	public User save(User User) ;
	
	public Optional<User> getUser(Long userId);
	
	public List<User> getAllUser();
	
	public void deleteUser(Long userId);
	
	
}
