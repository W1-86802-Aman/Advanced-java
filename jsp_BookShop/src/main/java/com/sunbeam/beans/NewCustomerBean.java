package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.Customerdao;
import com.sunbeam.entities.Customer;

public class NewCustomerBean {
  private String name;
  private String password;
  private String mobile;
  private String address;
  private String email;
  private String birth;
  private Customer cust;
  public NewCustomerBean() {
	  cust=null;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getBirth() {
	return birth;
}

public void setBirth(String birth) {
	this.birth = birth;
}
  public boolean saveCustomer() {
	  Date date= Date.valueOf(birth);
	  cust=new Customer(0, name, password, mobile, address, email, date);
	  try(Customerdao custDao=new Customerdao()){
		  custDao.save(cust);
		  return true;
	  }catch(Exception e) {
		  e.printStackTrace();
		  return false;
	  }
  }
}
