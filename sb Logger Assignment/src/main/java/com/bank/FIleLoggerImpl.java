package com.bank;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("logger")
//@Primary
public class FIleLoggerImpl implements Logger {
	private String logFilePath;
	
	public FIleLoggerImpl() {
		this.logFilePath="applog.txt";
	}
    
	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	@Override
	public void log(String message) {
		System.out.println("file :" +message);
		try(FileOutputStream fout=new FileOutputStream(this.logFilePath,true)){
			try(PrintStream out=new PrintStream(fout)){
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
