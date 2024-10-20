package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private BookRowMapper bookRowMapper;
	@Override
	public int save(Book b) {
		String sql="insert into books(name,author,subject,price)values(?,?,?,?)";
		int count=jdbcTemplate.update(sql,b.getName(),b.getAuthor(),b.getPrice(),b.getPrice());
		return count;
	}

	@Override
	public int update(Book b) {
		String sql="update books set name=?,author=?,subject=?,price=? where id=?";
		int count=jdbcTemplate.update(sql,b.getName(),b.getAuthor(),b.getSubject(),b.getPrice(),b.getId());
		return count;
	}

	@Override
	public int deleteById(int id) {
		String sql="delete from books where id=?";
		int count=jdbcTemplate.update(sql,id);
		return count;
	}

	@Override
	public List<Book> findAll() {
		String sql="select * from books";
		List<Book> list=jdbcTemplate.query(sql,bookRowMapper);
		return list;
	}

	@Override
	public List<Book> findBySubject(String subject) {
		String sql="select * from books where subject=?";
		List<Book> list=jdbcTemplate.query(sql,bookRowMapper,subject);
		return list;
	}

	
	@Override
	public List<Book> findById(int id) {
			String sql="select * from books where id=?";
			List<Book> b= jdbcTemplate.query(sql, bookRowMapper,id);
			return b;
		
	}
	@Override
	public List<String> findAllSubjects() {
		String sql="select Distinct subject from books";
		List<String> s=jdbcTemplate.queryForList(sql,String.class);
		return s;
	}

	

	

}
