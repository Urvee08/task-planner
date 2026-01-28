package com.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User getUserByName(String username){
		return userRepo.findByUsername(username);
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}

	public User editUser(User user) {
		return userRepo.findById(user.getUser_id()).map(u->{
			u.setUsername(user.getUsername());
			u.setEmail(user.getEmail());
			return userRepo.save(u);
		}) .orElseGet(()->{
			return userRepo.save(user);
		});
	}
	
	public void deleteUser(UUID user_id) {
		userRepo.deleteById(user_id);
	}
	
}
