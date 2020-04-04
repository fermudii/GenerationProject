package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.User;

public interface UserService {

	User save(User user);
	Optional<User> getById(Integer id);
	User update(Integer id, User user);
	void remove(Integer id);
}
