/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CustomerRowMapper custRowMapper;
	@Override
	public Customer findByEmail(String email) {
		String sql = "SELECT * FROM customers WHERE email = ?";
		List<Customer> list = jdbcTemplate.query(sql, custRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}
	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO customers(name, address, email, mobile, password, birth) VALUES(?, ?, ?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, c.getName(), c.getAddress(), c.getEmail(), c.getMobile(), c.getPassword(), c.getBirth());
		return count;
	}
	@Override
	public List<Customer> findAll() {
		String sql="select * from customers";
		List<Customer> c=jdbcTemplate.query(sql, custRowMapper);
		return c;
	}
	@Override
	public int update(Customer c) {
		String sql="update customers set name=?,address=?,email=?,mobile=?,password=?,birth=? where id=?";
		int count=jdbcTemplate.update(sql,c.getName(),c.getAddress(),c.getEmail(),c.getMobile(),c.getPassword(),c.getBirth(),c.getId());
		return count;
	}
	@Override
	public int deleteById(int id) {
		String sql="delete from customers where id=?";
		int count=jdbcTemplate.update(sql,id);
		return count;
	}
}



