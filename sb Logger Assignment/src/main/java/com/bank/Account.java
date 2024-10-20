package com.bank;

public interface Account {
	void setAccId(int id);
	void setType(String type);
	void setBalance(double balance);
	void setLogger(Logger logger);
	int getAccId();
	String getType();
	double getBalance();
	Logger getLogger();
	void deposit(double amount);
	void withdraw(double amount);
}
