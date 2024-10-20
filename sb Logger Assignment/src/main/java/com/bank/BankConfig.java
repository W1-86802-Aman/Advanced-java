package com.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan("com.bank")//main in another package would find it
@Configuration
public class BankConfig {
@Bean
public Account acc() {
	Account a= new AccountImpl(101,"svings", 5000.0);
	return a;
	
}
}
