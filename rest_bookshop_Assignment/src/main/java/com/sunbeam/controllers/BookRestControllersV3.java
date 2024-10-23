package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Book;
import com.sunbeam.models.BookPrice;
import com.sunbeam.models.Result;
import com.sunbeam.services.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/v3")
@RestController
public class BookRestControllersV3 {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public Result getAllBooks() {
		List<Book> list=bookService.getAllBookList();
		return Result.success(list);
	}
	
	@GetMapping("/books/{id}")
	public Result getBookOfId(@PathVariable("id") int id) {
		try {
			Book bk=bookService.getBookById(id);
			return Result.success(bk);
					
		}catch(Exception e) {
			e.printStackTrace();
			return Result.error("Book not found");
		}
	}
	
	@PostMapping("/books")
	public Result saveBook(@RequestBody Book bk) {
		try {
			int count=bookService.saveBook(bk);
			String message="Books added:"+ count;
			return Result.success(message);
		}catch(Exception e) {
			e.printStackTrace();
			return Result.error("no book added");
		}
	}
	
	@DeleteMapping("/books/{id}")
	public Result deleteBook(@PathVariable("id") int id) {
		String message="";
		try {
			int count=bookService.delBook(id);
			message="Book deleted:"+count;
			return Result.success(message);
		}
		catch(Exception e) {
			e.printStackTrace();
			message = "Book Delete Failed.";
			return Result.error(message);
		}
	}
	
	@PutMapping("/books/{id}")
	
	public Result updateBook(@PathVariable("id") int id,@RequestBody Book bk) {
		String message;
		bk.setId(id);
		try {
			int count=bookService.updateBook(bk);
			message="Books updated:"+count;
			return Result.success(message);
		}catch(Exception e) {
			e.printStackTrace();
			message = "Book Update Failed.";
			return Result.error(message);
		}
	}
	
	@PatchMapping("/books/{id}/updateprice")
	public Result updateBookPrice(@PathVariable("id") int id,@RequestBody BookPrice bp) {
	String message="";
	try {
		int count=bookService.updateBookPrice(id,bp.getPrice());
		message="Books Price Updated:"+count;
		return Result.success(message);
	}catch(Exception e) {
		e.printStackTrace();
		message="book price update failed";
		return Result.error(message);
	}
}
}
