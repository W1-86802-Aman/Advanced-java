package com.sunbeam;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
public class Bookshopmain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id;
		String name;
		String cname;
		String author;
		String subject;
		double price;
		String email;
		while(true) {
		System.out.println("Enter the choice in number\n"
				+ "press 1 to save book\n"
				+ "press 2 to update book\n"
				+ "press 3 to delete book\n"
				+ "press 4 to findAll book\n"
				+ "press 5 to find by id book\n"
				+ "press 6 to find by subject\n"
				+ "press 7 to save customers\n"
				+ "press 8 to find customer by email");
		
		int option=sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("enter id:");
			 id=sc.nextInt();
			System.out.println("enter name:");
			 name=sc.next();
			System.out.println("enter author:");
			 author=sc.next();
			System.out.println("enter subject:");
			subject=sc.next();
			System.out.println("enter price");
			 price=sc.nextDouble();
			
			Book b = new Book(0, name, author,subject, price);
			try(Bookdao bookDao = new Bookdao()){
				int i=bookDao.save(b);
				System.out.println("saved:"+i);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("enter id:");
			 id=sc.nextInt();
			System.out.println("enter name:");
			 name=sc.next();
			System.out.println("enter author:");
			 author=sc.next();
			System.out.println("enter subject:");
			subject=sc.next();
			System.out.println("enter price");
			price=sc.nextDouble();
			Book c = new Book(id, name, author, subject,price);
			try(Bookdao bookDao = new Bookdao()) {
				int cnt = bookDao.update(c);
				System.out.println("Updated Books: " + cnt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("enter id:");
			 id=sc.nextInt();
			Book e = new Book(id);
			try(Bookdao bookDao = new Bookdao()){
				int d=bookDao.deleteById(e);
				System.out.println("deleted:"+d);
			}catch(Exception r) {
				r.printStackTrace();
			}
		case 4:
			try(Bookdao bookDao = new Bookdao()) {
				List<Book> list = bookDao.findAll();
				for (Book bk : list)
					System.out.println(bk);
			} // bookDao.close();
			catch (Exception r) {
				r.printStackTrace();
			}
			break;
		case 5:
			
			System.out.println("enter the id:");
			int i=sc.nextInt();
			try(Bookdao bookDao = new Bookdao()){
				Book d=bookDao.findById(i);
				System.out.println("Book:"+d);
			}catch(Exception r) {
				r.printStackTrace();
			}
		case 6:
			System.out.println("enter subject");
			subject=sc.nextLine();
	       try(Bookdao bookDao=new Bookdao()){
	    	   List<Book> a=bookDao.findBySubject(subject);
	    	   for(Book bk:a)
	    		   
	    	   System.out.println("Book"+bk);
	       }catch(Exception r) {
	    	   r.printStackTrace();
	       }
		case 7:
			System.out.print("Name: ");
			 cname = sc.next();
			System.out.print("Address: ");
			String address = sc.next();
			System.out.print("Email: ");
		    email = sc.next();
			System.out.print("Mobile: ");
			String mobile = sc.next();
			System.out.print("Password: ");
			String password = sc.next();
			System.out.print("Birth (yyyy-MM-dd): ");
			String birth = sc.next();
			Date birthDate = Date.valueOf(birth);
			Customer newCust = new Customer(0, cname, password, email, address, mobile, birthDate);
			try(Customerdao custDao = new Customerdao()) {
				int count = custDao.save(newCust);
				System.out.println("Customers Saved: " + count);
			} 
			catch (Exception r) {
				r.printStackTrace();
			}
			
		    break;
		case 8:
	         System.out.println("enter email:");
	         email=sc.next();
	         try(Customerdao custDao = new Customerdao()) {
	 			Customer cd = custDao.findByEmail(email);
	 			if(cd != null)
	 				System.out.println("Found " + cd);
	 			else
	 				System.out.println("Customer Not Found.");
	 		} catch (Exception r) {
	 			r.printStackTrace();
	 		}
			
			break;
			default:
				System.out.println("invalid number");
		

		}
	}

	}
}
