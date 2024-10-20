package com.sunbeam;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb07JdbcbookshopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb07JdbcbookshopApplication.class, args);
	}
    @Autowired
    private BookDao bookDao;// BookDaoImpl is only bean found of BookDao interface
    
    @Autowired
    private CustomerDao customerDao;
	@Override
	public void run(String... args) throws Exception {
//		Book bk1 = new Book(0,"Atlas shrugged","Ayn Rand","Novel",654.30);
//		int cnt=bookDao.save(bk1);
//		System.out.println("Book saved :"+cnt);
		
//		Book bk2= new Book(46,"C basics","Ashutosh","C book",767.9);
//		int cnt=bookDao.update(bk2);
//		System.out.println("update book :"+cnt);
		
//		int id=47;
//		int cnt=bookDao.deleteById(id);
//		System.out.println("delete book:"+cnt);
		
//		List<Book> l=bookDao.findBySubject("C");
//		for(Book b:l)
//			System.out.println(b);
			
//		List<Book> l=bookDao.findAll();
//		for(Book b:l)
//			System.out.println(b);
		
//		List<Book> l= bookDao.findById(48);
//		System.out.println(l);
		
		
//		List<String> l= bookDao.findAllSubjects();
//		for(String s: l)
//			System.out.println(s);
		
		
//		String name="ravi";
//		String password="ravi89";
//		String email="ravi@gmail.com";
//		String address="pune";
//		String mobile="9797868687";
//		String s="2002-06-03";
//		Date birth=Date.valueOf(s);
//		Customer c= new Customer(0,name,password,email,address,mobile,birth);
//		int cnt=customerDao.save(c);
//		System.out.println("Customer saved :"+cnt);
		
		String email="ravi@gmail.com";
		List<Customer> l=customerDao.findByEmail(email);
		for(Customer c:l)
			System.out.println(c);
	}

}
