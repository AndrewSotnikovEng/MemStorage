package com.sotnikov.memstorage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
    @GetMapping(value="/")
    public String getIndex() {

        return "index";
    }
    
    @GetMapping(value="/login")
    public String showLogin() {

        return "login";
    }

    
    
    @ResponseBody
    @GetMapping(value="/admin")
    public String showAdmin() {

        return "Hello from admin page";
    }
    
//    @PostMapping(value = "/login")
//    public String loginPage(@RequestParam(value = "error", required = false) String error, 
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessge", errorMessge);
//        return "login";
//    }

}
