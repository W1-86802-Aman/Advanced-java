package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sb01Assignment1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb01Assignment1Application.class, args);
	}
    @Autowired
    private ApplicationContext ctx;
	@Override
	public void run(String... args) throws Exception {
		

        Sender tcpSender = ctx.getBean(TcpSender.class);
        Sender httpSender = ctx.getBean(HttpSender.class);
        Sender udpSender = ctx.getBean(UdpSender.class);

        tcpSender.send(10.5);
        httpSender.send(20.5);
        udpSender.send(30.5);
		
	}

}
