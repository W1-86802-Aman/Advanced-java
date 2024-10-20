package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private CustomerRowMapper customerRowMapper;
    
	@Override
	public int save(Customer c) {
		String sql="Insert into customers(name,password,email,address,mobile,birth) values(?,?,?,?,?,?)";
		int count=jdbcTemplate.update(sql,c.getName(),c.getPassword(),c.getEmail(),c.getAddress(),c.getMobile(),c.getBirth());
		return count;
	}

	@Override
	public List<Customer> findByEmail(String email) {
		String sql="select * from customers where email=?";
		List<Customer> l=jdbcTemplate.query(sql,customerRowMapper,email);
		return l;
	}

	
  
}
