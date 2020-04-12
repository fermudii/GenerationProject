package com.generationc20.bookfolks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.generationc20.bookfolks.model.Story;
import com.generationc20.bookfolks.model.User;
import com.generationc20.bookfolks.service.StoryService;
import com.generationc20.bookfolks.service.UserService;


@Controller
@RequestMapping("story")
public class StoryController {
	
	@Autowired
	UserService uService;
	
	@Autowired
	StoryService service; 
	
	@GetMapping("/new")
	public String loadNewStoryView(@SessionAttribute("user")User user, Model model) {
		model.addAttribute("user", uService.getById(user.getId()).get());
		return "/storyForm";
		
	}
	@PostMapping("/createStory")
	public String createStory(@SessionAttribute("user")User user,
			@RequestParam("txtTitle") String title,
			@RequestParam("txtSynopsis") String synopsis,
			@RequestParam("txtUrlImage") String urlImage,
			@RequestParam("txtGenre") int genre, RedirectAttributes redirectAttributes) {
		
		User userDB = uService.getById(user.getId()).get();
		//Model
		Story story = new Story();
		story.setTitle(title);
		story.setSynopsis(synopsis);
		story.setUrlImage(urlImage);
		story.setIdGenre(genre);
		story.setIdUser(user.getId());
		story.setAuthor(userDB.getUsername());
		
		service.save(story);
		redirectAttributes.addFlashAttribute("success","Your story was created");
	return "redirect:/user/main";
	}
	
	@GetMapping("/all")
	public String getAllMyStories(@SessionAttribute("user")User user, Model model,
			RedirectAttributes redirectAttributes) {
		
		List<Story> myStories = new ArrayList<>();
		
		List<Story> allStories = service.getAll();
		for(Story storyDB : allStories) {
			if(user.getId() == storyDB.getIdUser()) {
				myStories.add(storyDB);
			}
		}
		System.out.println(myStories.isEmpty());
			if(myStories.isEmpty()) {
				model.addAttribute("error","You don't have any stories yet!");
				return"/allMyStories";
			}else {
				model.addAttribute("myStories",myStories);
			}
		return"/allMyStories";
	}
}
