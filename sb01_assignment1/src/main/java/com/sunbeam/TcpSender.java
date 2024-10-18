package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class TcpSender implements Sender {

	
	public void send(double value) {
		System.out.println("hello tcp"+value);
		
	}

}
