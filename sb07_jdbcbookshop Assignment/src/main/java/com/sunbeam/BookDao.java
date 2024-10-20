package com.sunbeam;

import java.util.List;

public interface BookDao {
  int save(Book b);
  int update(Book b);
  int deleteById(int id);
  List<Book> findAll();
  List<Book> findBySubject(String subject);
  List<Book> findById(int id);
  List<String> findAllSubjects();
  
}
