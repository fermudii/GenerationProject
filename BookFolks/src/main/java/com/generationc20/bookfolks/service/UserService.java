package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.User;

public interface UserService {

	User save(User user);
	Optional<User> getById(String username);
	User update(String username, User user);
	void remove(String username);
}
