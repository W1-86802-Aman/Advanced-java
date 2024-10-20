package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AccountImpl implements Account {
 private int accId;
 private String type;
 private double balance;
 @Autowired
// @Value("#{fileLoggerImpl}")
 private Logger logger;
 
 public AccountImpl() {
	 this.logger=null;
 }
 

public AccountImpl(int accId, String type, double balance) {
	
	this.accId = accId;
	this.type = type;
	this.balance = balance;
	this.logger = null;
}


public int getAccId() {
	return accId;
}

public void setAccId(int accId) {
	this.accId = accId;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public Logger getLogger() {
	return logger;
}

public void setLogger(Logger logger) {
	this.logger = logger;
}

@Override
public String toString() {
	return "AccountImpl [accId=" + accId + ", type=" + type + ", balance=" + balance + ", logger=" + logger + "]";
}

@Override
public void deposit(double amount) {
	if(logger != null)
		logger.log("deposite rs:"+amount +"/- in acocunt"+this.accId);
	   this.balance=this.balance+amount;
	
}

@Override
public void withdraw(double amount) {
	if(logger!=null)
		logger.log("Withdraw Rs." + amount + "/- from Account" + this.accId);
	this.balance=this.balance-amount;
}
 
}
