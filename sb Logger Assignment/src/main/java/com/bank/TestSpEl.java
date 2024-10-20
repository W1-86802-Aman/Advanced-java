package com.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestSpEl {
 @Value("#{acc.accId}")
 private int accId;
 
 @Value("#{acc.balance}")
private double accBalance;
 
	@Value("#{acc}")
	private Account acc;
	
	public void printInfo() {
		System.out.println("Acc Id: " + this.accId);
		System.out.println("Acc Balance: " + this.accBalance);
		System.out.println("Account: " + acc);
	}
}
