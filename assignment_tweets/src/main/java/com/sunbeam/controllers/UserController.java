package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.User;
import com.sunbeam.services.UserService;

@Controller
public class UserController {
  @Autowired
  private UserService userService;
  
  @RequestMapping("/login")
  public String authenticate(@RequestParam String email,@RequestParam String password,Model model) {
	  User user=userService.findByEmail(email);
	  if(user!=null && user.getPassword().equals(password)) {
		  System.out.println(user.getPassword());
		  model.addAttribute("user", user);
		  return "redirect:tweets";
	  }
	  return "failed";
  }
}
