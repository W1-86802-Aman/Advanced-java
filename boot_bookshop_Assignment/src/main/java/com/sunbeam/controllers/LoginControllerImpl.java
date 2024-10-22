package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;
import com.sunbeam.services.CustomerService;

@Controller
public class LoginControllerImpl {
   @Autowired
   private CustomerService custService;
   
   @RequestMapping("/login")
   public String authenticate(Credentials cr,HttpSession session) {
	   Customer cust= custService.authenticate(cr);
	   if(cust==null)
		   return "failed";
	   
	   if(cust.getName().equals("admin"))
		   return "redirect:booklist";
	   
	   List<Book> cart=new ArrayList<Book>();
	   session.setAttribute("cart", cart);
	   session.setAttribute("username", cust.getName());
	   return "redirect:subjects";
   }
   
   @GetMapping("/register")
   public String newUser(Model model) {
	   Customer c=new Customer(0,"","","","","",null);
	   model.addAttribute("cust", c);
	   return "newuser";
   }
   
   @PostMapping("/register")
   public String registerUser(@ModelAttribute("cust") Customer cust,Model model) {
	   try {
		   int count=custService.saveUser(cust);
		   model.addAttribute("message","Customer Registered.");
		   
	   }catch(Exception e) {
		   e.printStackTrace();
		   model.addAttribute("message", "customer registration failed.");
	   }
	   return "newuser";
   }
}
