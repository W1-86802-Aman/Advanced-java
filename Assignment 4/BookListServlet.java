package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  processResult(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResult(req, resp);
			}
protected void processResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>\n"
				+ "<head>\n"
				+ "<title>Book list</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>LIST OF BOOKS</h1>\n"
				+ "<table border=1>\n"
				+ "<thead>\n"
				+ "<th>ID</th>\n"
				+ "<th>NAME</th>\n"
				+ "<th>AUTHOR</th>\n"
				+ "<th>SUBJECT</th>\n"
				+ "<th>PRICE</th>\n"
				+ "<th>ACTION</th>\n"
				+ "</thead>");
		      try(Bookdao bookDao = new Bookdao()){
		    	  List<Book> list=bookDao.findAll();
		    	  for(Book b:list) {
		    		  out.println("<tr>");
		    		  out.printf("<td>%s</td>",b.getId());
		    		  out.printf("<td>%s</td>",b.getName());
		    		  out.printf("<td>%s</td>",b.getAuthor());
		    		  out.printf("<td>%s</td>",b.getSubject());
		    		  out.printf("<td>%s</td>",b.getPrice());
		    		  out.printf("<td><a href='editbook?id=%d'><img src='edit.png' alt='edit' width='24' height='24'></a> <a href='delbook?id=%d'><img src='delete.png' alt='delete' width='24' height='24'></a></td>",b.getId(),b.getId());
		    		  out.println("</tr>");
		    	  }
		      }catch(Exception e) {
		    	  e.printStackTrace();
		    	  throw new ServletException(e);
		      }
		      out.println("</table>");
		      String message=(String)req.getAttribute("msg");
		      if(message!=null) {
		    	  out.println("<p>"+message+"</p>");
		      }
		      out.println("<p><a href='logout'>Sign OUT..</a></p>");
		      
		      out.println("</body");
		      out.println("</html>");
		      
		      
	}

}
