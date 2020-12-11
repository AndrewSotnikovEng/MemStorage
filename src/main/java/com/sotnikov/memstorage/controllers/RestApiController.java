package com.sotnikov.memstorage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sotnikov.memstorage.models.Tag;
import com.sotnikov.memstorage.repositories.TagRepository;




@Controller
public class RestApiController {

	@Autowired
	TagRepository tagRepository;
	
	 @PostMapping("/tag/add")
	 public String sendNewTag(Tag newTag) {
		 
		 tagRepository.save(newTag);
	    return "add_tag";
	    
	  }
	 
	 @GetMapping("/tag/add")
	 public String swowForm(Tag newTag) {
		 
	    return "add_tag";
	    
	  }
	 
	 @GetMapping("/tags") 
	 public String showAllTags(Model model) {
		 
		 model.addAttribute("tags", tagRepository.findAll());
		 
		 return "all_tags";
		 
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
