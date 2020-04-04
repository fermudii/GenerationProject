package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.StoryRepository;
import com.generationc20.bookfolks.model.Story;

@Service
public class StoryServiceImpl implements StoryService{

	@Autowired
	private StoryRepository repository;
	
	@Override
	public Story save(Story story) {
		return repository.save(story);
		}
	
	@Override
	public Optional<Story> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Story update(Integer id, Story story) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
