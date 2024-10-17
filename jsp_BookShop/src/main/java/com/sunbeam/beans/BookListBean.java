package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

public class BookListBean {
	private List<Book> books;

	public BookListBean() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public boolean fetchBooks() {
	  try(Bookdao bookDao = new Bookdao()){
		  List<Book> list = bookDao.findAll();
		  for (Book bk : list) {
			  books.add(bk);
		}
		  return true;
	  }catch(Exception e) {
		  e.printStackTrace();
		  return false;
	  }
  }
}
