package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.bank.Logger;
import com.bank.TestSpEl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.bank.Account;
import com.bank.BankConfig;
import com.bank.ConsoleLoggerImpl;
import com.bank.FIleLoggerImpl;
@PropertySource("classpath:dmc.properties")
@Import(BankConfig.class)
@SpringBootApplication
public class Sb04StereoannApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb04StereoannApplication.class, args);
	}
    @Autowired
    private ApplicationContext ctx;
    
    
    @Value("${title}")
    private String title;
	@Override
	public void run(String... args) throws Exception {
		ConsoleLoggerImpl consoleLoggerImpl =ctx.getBean(ConsoleLoggerImpl.class);
		FIleLoggerImpl fIleLoggerImpl =ctx.getBean(FIleLoggerImpl.class);
		
		Account acc= ctx.getBean(Account.class);
		acc.setLogger(fIleLoggerImpl);
		System.out.println("acc:"+acc);
		acc.deposit(4000);
		System.out.println("acc:"+acc);
		acc.withdraw(3000);
		System.out.println("acc:"+acc);
		
		Logger logger =ctx.getBean(Logger.class);
		logger.log("Hello Logger");
		
		System.out.println("Title:"+title);
		
//		TestSpEl obj = ctx.getBean(TestSpEL.class);
//		obj.printInfo();
		
	}

}
