package com.sunbeam.beans;

import com.sunbeam.daos.Customerdao;
import com.sunbeam.entities.Customer;

public class LoginBean {
   private String email;
   private String password;
   private Customer cust;
   
   
   public LoginBean() {
	   this.cust=null;
   }


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Customer getCust() {
	return cust;
}


public void setCust(Customer cust) {
	this.cust = cust;
}
   
public void authenticate() {
	try(Customerdao dao = new Customerdao()){
		Customer dbCust=dao.findByEmail(this.email);
		if(dbCust!=null && this.password.equals(dbCust.getPassword()))
			this.cust=dbCust;
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
