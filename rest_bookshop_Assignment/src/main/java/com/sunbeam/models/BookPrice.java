package com.sunbeam.models;

public class BookPrice {
  private double price;
  public BookPrice() {
	  
  }
public BookPrice(double price) {
	
	this.price = price;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "BookPrice [price=" + price + "]";
}
  
}
