package com.sunbeam;

import java.util.List;

public class Bookshopmain {

	public static void main(String[] args) {
//		Book b = new Book(43, "UNIX INTERNALS V2", "URESH", "UNIX", 544.20);
//		try(Bookdao bookDao = new Bookdao()) {
//			int cnt = bookDao.update(b);
//			System.out.println("Updated Books: " + cnt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try(Bookdao bookDao = new Bookdao()) {
//			List<Book> list = bookDao.findAll();
//			for (Book bk : list)
//				System.out.println(bk);
//		} // bookDao.close();
//		catch (Exception e) {
//			e.printStackTrace();
//		}
        
//		Book b = new Book(43, "UNIX INTERNALS V2", "URESH", "UNIX", 544.20);
//		try(Bookdao bookDao = new Bookdao()){
//			int d=bookDao.deleteById(b);
//			System.out.println("deleted:"+d);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		Book b = new Book(43, "UNIX INTERNALS V2", "URESH", "UNIX", 544.20);
//		try(Bookdao bookDao = new Bookdao()){
//			Book i=bookDao.findById(b);
//			System.out.println("saved:"+i);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		Book b = new Book(43, "UNIX INTERNALS V2", "URESH", "UNIX", 544.20);
		try(Bookdao bookDao = new Bookdao()){
			Book d=bookDao.findById(b);
			System.out.println("Book:"+d);
		}catch(Exception e) {
			e.printStackTrace();
		}
//		Book b = new Book(43, "UNIX INTERNALS V2", "URESH", "UNIX", 544.20);
//		try(Bookdao bookDao=new Bookdao()){
//			List<Book> list =bookDao.findBySubject(b);
//			for(Book bk :list)
//				System.out.println(bk);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
