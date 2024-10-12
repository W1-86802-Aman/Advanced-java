package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Subjectlist")
public class SubjectsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  resp.setContentType("text/html");
	  PrintWriter out = resp.getWriter();
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<title>Book List</title>");
	  out.println("<body>");
	  out.println("<h1>LIST OF SUBJECTS</h1>");
	  out.println("<table border='1'>");
		out.println("<thead>");
		out.printf("<th>subject</th>");
		out.println("</thead>");
		try(Bookdao bookDao = new Bookdao()){
			List<Book> l=bookDao.findAll();
			for(Book b:l) {
				out.println("<tr>");
				out.printf("<td><input type=radio name=html>%s</td>", b.getSubject());
				out.println("</tr>");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</body");
		out.println("</html>");
	}
	
   
}
