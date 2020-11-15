package com.sotnikov.memstorage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sotnikov.memstorage.models.Tag;
import com.sotnikov.memstorage.repositories.TagRepository;




@RestController
public class HomeController {

	@Autowired
	TagRepository tagRepository;
	
	 @PostMapping("/add_tag")
	 public Tag newTag(Tag newTag) {
		 
	    return tagRepository.save(newTag);
	    
	  }
	 
	 @GetMapping("/tags") 
	 public List<Tag> showAllTags() {
		 
		 return (List<Tag>) tagRepository.findAll();
		 
	 }
	 
	 @PostMapping("/update/{id}")
		public String updateTag(@PathVariable("id") long id, Tag tag, 
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        tag.setId(id);
		        return "update-user";
		    }
		        
		    tagRepository.save(tag);
		    return "Updated tag for " + id + " ID";
		}
		    
		@GetMapping("/delete/{id}")
		public String deleteUser(@PathVariable("id") long id, Model model) {
		    Tag tag = tagRepository.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		    tagRepository.delete(tag);
		    model.addAttribute("users", tagRepository.findAll());
		    return "Deleted tag for " + id + " ID";
		}
	
}
