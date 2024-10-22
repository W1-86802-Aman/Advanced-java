package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookService {
  List<String> getAllSubjects();

  List<Book> getBooksOfSubject(String subject);

  Book getBookById(int id);

List<Book> getAllBookList();

int updateBook(Book b);

int delBook(int id);

int saveBook(Book b);
}
