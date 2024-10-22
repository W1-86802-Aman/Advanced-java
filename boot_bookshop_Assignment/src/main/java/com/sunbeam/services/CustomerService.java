package com.sunbeam.services;

import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;

public interface CustomerService {
  Customer authenticate(Credentials cr);
  // int save(Customer c);

int saveUser(Customer cust);
}
