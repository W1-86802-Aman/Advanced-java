package com.sunbeam.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookService;

@Controller
public class BookShopController {
 @Autowired
 private BookService bookService;
 
 @RequestMapping("/subjects")
 public String showSubjects(HttpServletRequest request) {
		List<String> list = bookService.getAllSubjects();
		request.setAttribute("subjectList", list);
		return "subjects"; // prefix="/", suffix=".jsp" ==> /subjects.jsp 
	}
 
 @RequestMapping("/books")
	public String showBooks(@RequestParam("subject") String subject, Model model) {
		List<Book> list = bookService.getBooksOfSubject(subject);
		model.addAttribute("bookList", list);
		return "books";
 }
 
 @RequestMapping("/addcart")
	public String addToCart(HttpSession session, 
			@RequestParam("book") String[] bookIds) {
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		for (String bookId : bookIds) {
			int id = Integer.parseInt(bookId);
			Book b = bookService.getBookById(id);
			cart.add(b);
		}
		return "forward:subjects";
	}
 
 @RequestMapping("/showcart")
 public String showCart() {
	 return "showcart";
 }
 
 @RequestMapping("/logout")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "logout"; // --> /logout.jsp
	}
 
 @RequestMapping("/index")
	public String showLogin() {
		return "index"; // --> /index.jsp
	}
 
 @RequestMapping("/booklist")
 public String showBookList(Model model) {
	 List<Book> list=bookService.getAllBookList();
	 model.addAttribute("bookList", list);
	 return "booklist";
 }
 
 @GetMapping("/editbook")
 public String editBook(@RequestParam("id") int id,Model model) {
	 Book b=bookService.getBookById(id);
	 model.addAttribute("bk", b);
	 return "editbook";
 }
 
 @PostMapping("/editbook")
 public String updateBook(Book b) {
	 int count=bookService.updateBook(b);
	 return "redirect:booklist";
 }
 
 @GetMapping("/delbook")
 public String delBook(@RequestParam("id") int id) {
	 int count=bookService.delBook(id);
	 return "redirect:booklist";
 }
 
 @GetMapping("/newbook")
 public String addBook() {
	 return "newbook";
 }
 @PostMapping("/newbook")
 public String newBook(Book b) {
	 int count=bookService.saveBook(b);
	 return "redirect:booklist";
 }
}
