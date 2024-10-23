package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Customer;
import com.sunbeam.models.Result;
import com.sunbeam.models.UserResult;
import com.sunbeam.services.BookService;
import com.sunbeam.services.CustomerService;
@RequestMapping("/v1")
@RestController
public class UserRestcontrollerV1 {
  @Autowired
  private CustomerService custService;
  
  @GetMapping("/users")
  public UserResult getAllUser() {
	  List<Customer> c=custService.getAllUser();
	  return UserResult.success(c);
  }
  
  @DeleteMapping("/user/{id}")
  public UserResult deleteById(@PathVariable("id") int id) {
	  int count =custService.delUser(id);
	  return UserResult.success("deleted customer:"+count);
	  
  }
  
  @GetMapping("/user/{email}")
  public UserResult getByEmail(@PathVariable("email") String email) {
	  Customer c= custService.getByEmail(email);
	  return UserResult.success(c);
  }
  
  @PostMapping("/users")
  public UserResult addUser(@RequestBody Customer cu) {
	  int count= custService.saveUser(cu);
	  return UserResult.success("Customer added:"+count);
  }
  
  @ExceptionHandler(Exception.class)
	public UserResult handleException(Exception e) {
		return UserResult.error(e.getMessage());
	}
}
