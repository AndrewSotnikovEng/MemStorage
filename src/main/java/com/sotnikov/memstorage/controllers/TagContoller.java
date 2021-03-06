package com.sotnikov.memstorage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class TagContoller {

	@Autowired
	TagRepository tagRepository;
	
	 @GetMapping("/admin/tag/add")
	 public String showNewTag(Tag newTag) {
		 
	    return "add_tag";
	    
	  }
	
	
	 @PostMapping("/admin/tag/add")
	 public String sendNewTag(Tag newTag) {
		 
		 tagRepository.save(newTag);
	    return "redirect:/tags";
	    
	  }
	 
	 @GetMapping("/admin") 
	 public String showAdminPanel(Model model) {
		 
		 
		 return "admin";
		 
	 }
	 
	 
	 @GetMapping("/tags") 
	 public String showAllTags(Model model) {
		 
		 model.addAttribute("tags", tagRepository.findAll());
		 
		 return "all_tags";
		 
	 }
	 
	 @GetMapping("/admin/edit/tag/{id}")
	 public String showUpdateForm(@PathVariable("id") long id, Model model) {
	     Tag tag = tagRepository.findById(id)
	       .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	     model.addAttribute("tag", tag);
	     return "update_tag";
	 }
	 
	 @PostMapping("/admin/update/tag/{id}")
		public String updateTag(@PathVariable("id") long id, Tag tag, 
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        tag.setId(id);
		        return "update_tag";
		    }

		    tagRepository.save(tag);
		    return "redirect:/tags";
		}
		    
		@GetMapping("/admin/delete/{id}")
		public String deleteUser(@PathVariable("id") long id, Model model) {
		    Tag tag = tagRepository.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		    tagRepository.delete(tag);
		    model.addAttribute("users", tagRepository.findAll());
		    return "redirect:/tags";
		}
	
}
