package com.parser;

import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParserServlet extends HttpServlet {

	public static final boolean DEBUG = false;

	// Add here all the dependencies used
	private com.parser.Parser parser = null;
	private com.parser.Filter filter = null;
	private com.parser.ParserLog log = null;
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    System.out.println("Init called");
	    this.log = new com.parser.ParserLogImpl();
	    this.parser = new ConluParser(log);    
	    this.filter = new com.parser.FilterImpl(log);  	   
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>K‰yt‰ post meotodia v‰litt‰‰ksesi parsittavan dokumentin.</h1>");
		out.println("</body>");
		out.println("</html>");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		long start = System.currentTimeMillis();
		
		log.info("Starting to process new request");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			// This will read sentences to own list
			// Sentence is ended by ? ! or .
			String body = filter.getBody(request);
		
			List in = parser.parse(body);
			// step 1
			// luokka2.tee(in)
			// step 2
			// luokka2.tee(in)

			log.info("...writing parsing result to output stream");
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello Servlet Post</h1>");
			for (int i = 0; i < in.size(); i++) {
				out.println((i + 1) + ":" + in.get(i));
				log.debug(""+in.get(i));
			}
			out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
			long end = System.currentTimeMillis();
			
			log.info("Request processing complete. (in "+ (end-start)+" ms)");
		} catch (Exception e) {
			log.error("Error caught in the servlet",e);			
		}
	}

}
