package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;

public interface CustomerService {
  Customer authenticate(Credentials cr);
  // int save(Customer c);

int saveUser(Customer cust);

List<Customer> getAllUser();

int delUser(int id);

Customer getByEmail(String email);
}
