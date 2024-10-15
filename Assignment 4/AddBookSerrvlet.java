package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

@WebServlet("/newbook")
public class AddBookSerrvlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	processResult(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	processResult(req,resp);
    }
 protected void processResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=Integer.parseInt(req.getParameter("id"));
    	String name=req.getParameter("name");
    	String author=req.getParameter("author");
    	String subject=req.getParameter("subject");
    	double price=Double.parseDouble(req.getParameter("price"));
    	
    	Book b=new Book(id,name,author,subject,price);
    	try(Bookdao bookDao=new Bookdao()){
    		int count=bookDao.save(b);
    		String message="book saved:"+count;
    		req.setAttribute("msg",message);
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new ServletException(e);
    	}
    	RequestDispatcher rd=req.getRequestDispatcher("booklist");
    	rd.forward(req, resp);
    }
}
