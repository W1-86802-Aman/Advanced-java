package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao custDao;

	@Override
	public Customer authenticate(Credentials cr) {
		Customer dbCust=custDao.findByEmail(cr.getEmail());
		if(dbCust != null && dbCust.getPassword().equals(cr.getPassword()))
		return dbCust;
		
		return null;
	}

	@Override
	public int saveUser(Customer cust) {
		int count=custDao.save(cust);
		return count;
	}

	@Override
	public List<Customer> getAllUser() {
		List<Customer> list=custDao.findAll();
		return list;
	}

	@Override
	public int delUser(int id) {
		int count=custDao.deleteById(id);
		return count;
	}

	@Override
	public Customer getByEmail(String email) {
		Customer c=custDao.findByEmail(email);
		return c;
	}

}
