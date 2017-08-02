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
	}
}