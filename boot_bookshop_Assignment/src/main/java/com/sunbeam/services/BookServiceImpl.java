package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;
@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookDao bookDao;
  
	@Override
	public List<String> getAllSubjects() {
		return bookDao.findAllSubjects();
		
	}
   @Override
	public List<Book> getBooksOfSubject(String subject) {
		List<Book> l=bookDao.findBySubject(subject);
		return l;
	}
   @Override
	public Book getBookById(int id) {
		Book book = bookDao.findById(id);
		return book;
	}
@Override
public List<Book> getAllBookList() {
	List<Book> list=bookDao.findAll();
	return list;
}
@Override
public int updateBook(Book b) {
	int count=bookDao.update(b);
	return count;
}
@Override
public int delBook(int id) {
	int count=bookDao.deleteById(id);
	return count;
}
@Override
public int saveBook(Book b) {
	int count=bookDao.save(b);
	return count;
}

}
