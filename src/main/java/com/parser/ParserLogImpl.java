package com.parser;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ParserLogImpl implements ParserLog {

	public void debug(String message) {
		System.out.println("Debug: "+message);

	}

	public void info(String message) {
		System.out.println("Info: "+message);

	}

	public void error(String message) {
		System.out.println("Info: "+message);
	}

	public void error(String message, Exception e) {
		this.error(message + "\n" + exceptionToString(e) );
		
	}

	public String exceptionToString(Exception e) {
		new StringBuffer();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.flush();
		pw.close();
		return e+"\n"+sw.toString();		
	}
}
