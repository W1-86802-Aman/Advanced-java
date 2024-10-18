package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class HttpSender implements Sender {

	
	public void send(double value) {
		System.out.println("hello http:"+value);
		
	}

}
