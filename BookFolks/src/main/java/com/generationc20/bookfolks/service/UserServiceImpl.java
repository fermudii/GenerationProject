package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.UserRepository;
import com.generationc20.bookfolks.model.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(User user) {
		return repository.save(user);
	}
	
	@Override
	public Optional<User> getById(String username) {
		return repository.findById(username);
	}
	
	@Override
	public User update(String username, User user) {
		User userDB = getById(username).get();
		userDB.setUsername(user.getUsername());
		userDB.setName(user.getName());
		userDB.setLastName(user.getLastName());
		userDB.setAge(user.getAge());
		userDB.setGender(user.getGender());
		userDB.setDescription(user.getDescription());
		userDB.setPassword(user.getPassword());
		userDB.setEmail(user.getEmail());
		userDB.setUrlImage(user.getUrlImage());
		return repository.save(userDB);
		
	}
	
	@Override
	public void remove(String username) {
		repository.deleteById(username);
		
	}
}
