package com.parser;

import java.io.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get 2</h1>");
		out.println("</body>");
		out.println("</html>");
	}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
ServletException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Post</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
