package com.sunbeam;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

@SpringBootApplication
public class AssignmentTweetsApplication  {

	public static void main(String[] args){
		SpringApplication.run(AssignmentTweetsApplication.class, args);
	}
	
}
