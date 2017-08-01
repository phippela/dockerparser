package com.parser;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ParserLogImpl implements ParserLog {

	public void debug(String message) {
		printWithAakkoset("Debug: "+message);

	}

	public void info(String message) {
		printWithAakkoset("Info: "+message);

	}

	public void error(String message) {
		printWithAakkoset("Info: "+message);
	}

	public void error(String message, Exception e) {
		this.error(message + "\n" + exceptionToString(e) );
		
	}

	// TODO consider removing will create extra objects just...
	public void printWithAakkoset(String s) {
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(s);
		pw.flush();
		pw.close();
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
