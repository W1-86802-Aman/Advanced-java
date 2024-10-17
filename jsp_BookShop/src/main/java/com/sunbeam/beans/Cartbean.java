package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

public class Cartbean {
	private String[] bookIds;
	private List<Book> booklist;

	public Cartbean() {
		booklist = new ArrayList<Book>();
	}

	public String[] getBookIds() {
		return bookIds;
	}

	public void setBookIds(String[] bookIds) {
		this.bookIds = bookIds;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public void addToCart() {
		try (Bookdao bookDao = new Bookdao()) {
			for (String bookId : bookIds) {
				int id = Integer.parseInt(bookId);
				Book b = bookDao.findById(id);
				this.booklist.add(b);
			}
			for (Book book : booklist) {
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
