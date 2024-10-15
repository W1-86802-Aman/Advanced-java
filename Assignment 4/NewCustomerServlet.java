package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.Customerdao;
import com.sunbeam.entities.Customer;

@WebServlet("/registercustomer")

public class NewCustomerServlet extends HttpServlet {
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
		String name=req.getParameter("name");//request inserting
         String password=req.getParameter("password");
         String mobile=req.getParameter("mobile");
         String address=req.getParameter("address");
         String email=req.getParameter("email");
         String birthString = req.getParameter("birth");
         Date birth= Date.valueOf(birthString);

         Customer c=new Customer(0,name,password,mobile,address,email,birth);
		try(Customerdao cd = new Customerdao()){
		int count=cd.save(c);
		if(count ==1) {
		  out.println("<h3>Customer inserted sucessfully..!</h3>");
		}
		}catch(Exception e) {
			out.println("<h4>Customer entry failed..!</h4>");
			e.printStackTrace();
			throw new ServletException(e);
			
		}
	}
	
}



