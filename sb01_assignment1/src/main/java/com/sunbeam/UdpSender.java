package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class UdpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("hello udp:"+value);
		
	}

}
