package com.sunbeam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bookdao implements AutoCloseable{
	private Connection con;
	
	public Bookdao() throws Exception {
		con=DB_Util.getConnection();
	}
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
   
   public int save(Book b) throws Exception {
	   String sql="insert into Books values(?,?,?,?,?)";
	   try(PreparedStatement stmt =con.prepareStatement(sql)){
		   stmt.setInt(1, b.getId());
		   stmt.setString(1, b.getName());
		   stmt.setString(2, b.getAuthor());
		   stmt.setString(3, b.getSubject());
		   stmt.setDouble(4,b.getPrice());
		   int i =stmt.executeUpdate();
		   return i;
	   }
	   
   }
   public int update(Book b) throws Exception {
	   String sql="UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
	   try(PreparedStatement stmt =con.prepareStatement(sql)){
		   stmt.setString(1, b.getName());
		   stmt.setString(2, b.getAuthor());
		   stmt.setString(3, b.getSubject());
		   stmt.setDouble(4,b.getPrice());
		   stmt.setInt(5, b.getId());
		   int count =stmt.executeUpdate();
		   return count;
	   }
   }
   public int deleteById(Book b) throws Exception {
	   String sql="delete from books where id=?";
	   try(PreparedStatement stmt = con.prepareStatement(sql)){
		   stmt.setInt(1,b.getId());
		   int d =stmt.executeUpdate();
		   return d;
	   }
   }
   public List<Book> findAll() throws Exception{
	   List<Book> l =new ArrayList();
	   String sql="Select * from books";
	   try (PreparedStatement stmt = con.prepareStatement(sql)){
		   try(ResultSet rs = stmt.executeQuery()){
			   while(rs.next()) {
				   int id=rs.getInt("id");
				   String name=rs.getString("name");
				   String author=rs.getString("author");
				   String subject =rs.getString("subject");
				   double price=rs.getDouble("price");
				   Book b=new Book(id,name,author,subject,price);
				   l.add(b);
			   }
		   }
	   }
	   return l;
   }
   public Book findById(Book b)throws Exception {
	   String sql="Select name from books where id=?";
	   try(PreparedStatement stmt = con.prepareStatement(sql)){
		   stmt.setInt(1, b.getId());
		   try (ResultSet rs = stmt.executeQuery()) {
			  int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				double price = rs.getDouble("price");
				return new Book(id, name, author, subject, price);
		   }
	   }
   }
   public List<Book> findBySubject(Book b) throws Exception{
	   List<Book> l= new ArrayList();
	   String sql ="Select * from books where subject=?";
	   try(PreparedStatement stmt = con.prepareStatement(sql)){
		   stmt.setString(1, b.getSubject());
		   try(ResultSet rs =stmt.executeQuery()){
			   while(rs.next()) {
				   int id=rs.getInt("id");
				   String name=rs.getString("name");
				   String author=rs.getString("author");
				   String subject =rs.getString("subject");
				   double price=rs.getDouble("price");
				   Book b1=new Book(id,name,author,subject,price);
				   l.add(b);
			   }
		   }
	   }
	   return l;
   }
   public String findAllSubject() {
	   return null;
   }

}