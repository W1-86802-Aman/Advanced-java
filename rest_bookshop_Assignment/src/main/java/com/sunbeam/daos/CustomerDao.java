/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;

public interface CustomerDao {
	Customer findByEmail(String email);
	int save(Customer c);
	List<Customer> findAll();
	int update(Customer c);
	int deleteById(int id);
}
