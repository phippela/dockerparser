package com.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class FilterImpl implements Filter {

	

	private com.parser.ParserLog log = null;
	
	public FilterImpl(ParserLog logComponent) {
		this.log = logComponent;
	}
		
	// This is responsible for getting in bound post file
	// and parsing it to sentences to the List.
	
	public String getBody(HttpServletRequest request) throws Exception {
	
		log.info("filtering...");
		
			BufferedReader bufferedReader = null;
			StringBuffer stringBuilder = new StringBuffer();

			try {
				InputStream inputStream = request.getInputStream();
				if (inputStream != null) {
					bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
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
	}

