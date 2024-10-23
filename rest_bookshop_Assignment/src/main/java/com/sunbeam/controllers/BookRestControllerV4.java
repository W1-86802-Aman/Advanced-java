package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Book;
import com.sunbeam.models.Result;
import com.sunbeam.services.BookService;

@RequestMapping("/v4")
@RestController
public class BookRestControllerV4 {
  
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public Result getAllBooks() {
		List<Book> list=bookService.getAllBookList();
		return Result.success(list);
	}
	
	@GetMapping("/books/{id}")
	public Result getBookOfId(@PathVariable("id") int id) {
		Book b=bookService.getBookById(id);
		return Result.success(b);
	}
	
	@PostMapping("/books")
	public Result addBook(@RequestBody Book bk) {
		int count=bookService.saveBook(bk);
		return Result.success("Book added:"+count);
	}
	
	@DeleteMapping("/books/{id}")
	public Result deleteBook(@PathVariable("id") int id) {
		int count=bookService.delBook(id);
		return Result.success("Books deleted:"+count);
	}
	
	@PutMapping("/books/{id}")
	public Result updateBook(@PathVariable("id") int id,@RequestBody Book bk) {
		bk.setId(id);
		int count=bookService.updateBook(bk);
		return Result.success("Books updated:"+count);
	}
	
	
	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		return Result.error(e.getMessage());
	}
}
