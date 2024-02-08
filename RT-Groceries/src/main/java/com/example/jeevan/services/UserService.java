package com.example.jeevan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jeevan.dao.UserRepo;
import com.example.jeevan.entity.User;

@Service
public class UserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User addUser(User user) {
		// Perform any additional business logic if needed
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

	public Optional<User> updateUser(User user) {
		// Check if the user with the given ID exists
		return userRepo.existsById(user.getId()) ? Optional.of(userRepo.save(user)) : Optional.empty();
	}

	public boolean deleteUser(Long id) {
		// Check if the user with the given ID exists
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
