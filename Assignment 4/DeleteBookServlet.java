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

@WebServlet("/delbook")
public class DeleteBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResult(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResult(req, resp);
	}
protected void processResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String bookId=req.getParameter("id");
	    int id=Integer.parseInt(bookId);
		try(Bookdao bookDao = new Bookdao()){
			int count=bookDao.deleteById(id);
			String message="Book deleted:"+count;
			
			System.out.println(message);
			req.setAttribute("msg",message);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher rd=req.getRequestDispatcher("booklist");
		rd.forward(req, resp);
	}

}
