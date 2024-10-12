package com.sunbeam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customerdao implements AutoCloseable{
   private Connection con;
   
   public Customerdao() throws Exception {
	   con=DB_Util.getConnection();
   }

@Override
  public void close() throws Exception {
	con.close();
	
  }

public int save(Customer c) throws Exception {
	String sql = "INSERT INTO customers (name, address, mobile, email, password, birth) VALUES (?, ?, ?, ?, ?, ?)";
	try(PreparedStatement stmt = con.prepareStatement(sql)) {
		stmt.setString(1, c.getName());
		stmt.setString(2, c.getAddress());
		stmt.setString(3, c.getMobile());
		stmt.setString(4, c.getEmail());
		stmt.setString(5, c.getPassword());
		stmt.setDate(6, c.getBirth());
		int count = stmt.executeUpdate();
		return count;
	} // stmt.close();
}

  public Customer findByEmail(String email) throws Exception {
	  String sql="select * from customers where email=?";
	  try(PreparedStatement stmt = con.prepareStatement(sql)){
		  stmt.setString(1, email);
		  try(ResultSet rs=stmt.executeQuery()){
			  if(rs.next()) {
				  int id=rs.getInt("id");
				  String name=rs.getString("name");
				  String mobile = rs.getString("mobile");
				  String address = rs.getString("address");
				  String password = rs.getString("password");
				  email = rs.getString("email");
				  Date birth= rs.getDate("birth");
				  Customer c=new Customer(id,name,mobile,address,password,email,birth);
				  return c;
			  }
		  }
	  }
	  return null;
  }
  
   
}
