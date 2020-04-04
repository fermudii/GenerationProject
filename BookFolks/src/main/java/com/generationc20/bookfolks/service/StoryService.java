package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Story;

public interface StoryService {

	Story save(Story story);
	Optional<Story> getById(Integer id);
	Story update(Integer id, Story story);
	void remove(Integer id);
}
