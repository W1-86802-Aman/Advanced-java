package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

@WebServlet("/editbook")

public class EditBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId=req.getParameter("id");
		System.out.println(bookId);
		int id=Integer.parseInt(bookId);
		try(Bookdao bookDao=new Bookdao()){
			Book b=bookDao.findById(id);
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.printf("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>New Book</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h3>New Book</h3>\r\n"
					+ "	<form method=\"post\" action=\"editbook\">\r\n"
					+ "		Id: <input type=\"text\" name=\"id\" value='%d' readonly/> <br/><br/>\r\n"
					+ "		Name: <input type=\"text\" name=\"name\" value='%s'/> <br/><br/>\r\n"
					+ "		Author: <input type=\"text\" name=\"author\" value='%s'/> <br/><br/>\r\n"
					+ "		Subject: <input type=\"text\" name=\"subject\" value='%s'/> <br/><br/>\r\n"
					+ "		Price: <input type=\"text\" name=\"price\" value='%f'/> <br/><br/>\r\n"
					+ "		<input type=\"submit\" value=\"Update Book\"/>\r\n"
					+ "		<a href='booklist'>Go Back</a>"
					+ "	</form>\r\n"
					+ "</body>\r\n"
					+ "</html>",
					b.getId(), b.getName(), b.getAuthor(), b.getSubject(), b.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id =Integer.parseInt(req.getParameter("id"));
    	String name =req.getParameter("name");
    	String author=req.getParameter("author");
    	String subject=req.getParameter("subject");
    	double price=Double.parseDouble(req.getParameter("price"));
    	
    	Book b= new Book(id,name,author,subject,price);
    	try(Bookdao bookDao= new Bookdao()){
    		int count=bookDao.update(b);
    		String message="Book updated:"+count;
    		System.out.println(message);
    		req.setAttribute("msg", message);
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new ServletException(e);
    	}
    	// works for post request
    	RequestDispatcher rd= req.getRequestDispatcher("booklist");
    	rd.forward(req, resp);
    	
    }
   
}
