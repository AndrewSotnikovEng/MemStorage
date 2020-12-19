package com.sotnikov.memstorage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping(value="/")
    public String getIndex() {

        return "index";
    }
    
//    @GetMapping(value="/login")
//    public String showLogin() {
//
//        return "login";
//    }

}
