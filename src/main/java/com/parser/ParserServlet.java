package com.parser;

import java.io.*;
import java.util.*;
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
		out.println("<h1>Hello Servlet Get 3</h1>");
		out.println("</body>");
		out.println("</html>");
	}

public String getBody(HttpServletRequest request) throws Exception {

  BufferedReader bufferedReader = null;
  StringBuffer stringBuilder = new StringBuffer();

  try {
      InputStream inputStream = request.getInputStream();
      if (inputStream != null) {
          bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"ISO-8859-1"));
          char[] charBuffer = new char[128];
          int bytesRead = -1;
          while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
              stringBuilder.append(charBuffer, 0, bytesRead);
          }
      } else {
          stringBuilder.append("");
      }
  } catch (IOException ex) {
      throw ex;
  } finally {
      if (bufferedReader != null) {
          try {
              bufferedReader.close();
          } catch (IOException ex) {
              throw ex;
          }
      }
  }

  return stringBuilder.toString();
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
ServletException {

  PrintWriter out  = null;
  try {
		out = response.getWriter();

    com.parser.Parser parser = new ConluParser();

    String body = getBody(request);


    // This will read sentences to own list
    // Sentence is endedn by ? ! or .
    List in = parser.parse(body);
    // step 1
    //luokka2.tee(in)
    // step 2
    //luokka2.tee(in)

  	out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Post</h1>");
    for(int i = 0; i< in.size(); i++) {
      out.println((i+1)+":"+in.get(i));
    }
    out.println("</body>");
		out.println("</html>");
  } catch (Exception e) {
    e.printStackTrace(out);
  }
}

}
