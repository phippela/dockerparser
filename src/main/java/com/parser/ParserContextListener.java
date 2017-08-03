package com.parser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// When ever context (i.e. app server / application is started)
// Tomcat send context initialized, and similarly context destroyed signals
// This class is used to initialize the cache - and check that chache disk is offloaded too

public class ParserContextListener
               implements ServletContextListener{

	ParserLog log = null;
	
	public ParserLog getLog() {
		if(log  == null )
			log = new ParserLogImpl();
		
		return log;
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO add here cache flush to disk
		getLog().info("ParserContextListener destroyed");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		// TODO add here cache initialization
		getLog().info("ParserContextListener started");
		com.parser.ParserWrapperImpl parserWrapper= null;
		String[] args = new String[6];
		args[0] = "-model";
		args[1] = "/usr/local/tomcat/parser.model";
		args[2] = "-test";
		args[3] = "/usr/local/tomcat/int.txt";
		args[4] = "-out";
		args[5] = "/usr/local/tomcat/out.txt";
		getLog().info("Starting to initialize parser wrapper");
	    parserWrapper = new ParserWrapperImpl(args);
	    getLog().info("Parser wrapper initialized (model read)");
	    arg0.getServletContext().setAttribute("parserwrapper", parserWrapper);
	}
}