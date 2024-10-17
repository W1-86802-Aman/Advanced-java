package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

public class BooksBean {
  private String subject;
  private List<Book> books;
  
  public BooksBean() {
	  this.books=new ArrayList<Book>();
  }
  public List<Book> getBooks(){
	  return books;
  }
  public void setBooks(List<Book> books) {
	  this.books=books;
  }
  public String getSubject() {
	  return subject;
	  
  }
  public void setSubject(String subject) {
	  this.subject=subject;
  }
  
  public void fetchBooks() {
	  try(Bookdao bookDao = new Bookdao()){
		  this.books=bookDao.findBySubject(this.subject);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
