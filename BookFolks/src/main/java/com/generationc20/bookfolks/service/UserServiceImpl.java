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
	public Optional<User> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public User update(Integer id, User user) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
