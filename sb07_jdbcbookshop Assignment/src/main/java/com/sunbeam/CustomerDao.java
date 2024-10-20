package com.sunbeam;

import java.util.List;

public interface CustomerDao {
  int save(Customer c);
  List<Customer> findByEmail(String email);
}
