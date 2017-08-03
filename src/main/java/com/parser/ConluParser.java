package com.parser;

import java.util.*;
import java.io.*;


public class ConluParser implements com.parser.Parser {

	private com.parser.ParserLog log = null;
	private com.parser.ParserWrapper parserWrapper = null;
	
	public ConluParser(ParserLog logComponent, ParserWrapper inWrapper) {
		this.log = logComponent;
		this.parserWrapper = inWrapper;
	}

	// This will creat list of lists. Each sub list contains words for the corresponding clause.
	public List convertInputToList(String inFile) throws Exception  {

		List returnList = new ArrayList();
		
		// dummy implementation
		// returnList.add(inFile);

		int lineNumber = 0;
		boolean previousWasToken = true;
		// in here we eat delimiters, and plan to add "." after each clause
		// one could add here checking for the type of the token, and
		// then use this to add correct punctuation mark. TODO
		StringTokenizer st = new StringTokenizer(inFile,"?!.",false);

		while(st.hasMoreTokens()) {
			lineNumber++;
			String lause = st.nextToken().trim();
			log.debug(lineNumber+":"+lause);

			// then we want to split this lause into words
			StringTokenizer wordt = new StringTokenizer(lause,", ",false);
			List list = new ArrayList();
			while(wordt.hasMoreTokens()) {
				String word = wordt.nextToken().trim();		
				log.debug("lause"+lineNumber+": "+word);
				list.add(word);
			}
			returnList.add(list);		
		}

		return returnList;
	}

	// This asssumes that in file is dot ''.'' exclamanation '! or question
	// marks separated '?''
	//
	// Each of the sentences are then put to own List.
	// As a result will be that each sentence is on list of its own.
	public List parse(String inFile) throws Exception {
		log.info("We" 
				+ " are parsing...");

		List returnList = new ArrayList();
		
		// Splitting input file to clauses. These in the end do not have correct punctuation mark ? . or !
		List lauseetList = convertInputToList(inFile);

		
		// Lets go through each of the clauses, and parse them in own method
		for(int i = 0 ; i < lauseetList.size(); i ++) {
			List lause = (List) lauseetList.get(i);
			processClause(lause,returnList);
		}
		
		return returnList;
	}
	
	// This method is reponsible for parsing and using cache if we know the word already
	public void processClause(List lause, List returnList) throws Exception {
		
		// Lets add punctuation to the end 
		lause.add(".");
		// TODO add cache
		// TODO add parsing call
		StringBuffer sb = new StringBuffer();

		for(int i = 0 ; i < lause.size() ; i ++) {
				sb.append((i+1)+"\t"+lause.get(i));
			for(int j = 0 ; j <12 ; j++) {
				sb.append("\t-");
			}
			// Lets not add \n to the last line
			sb.append("\n");
			if(i== (lause.size()-1))
				sb.append("\n");
			
		}	
		
		long start = System.currentTimeMillis();
		StringWriter sw = new StringWriter();
		String input = sb.toString();
		log.debug("input:\n"+input);
		StringReader sr = new StringReader(input);
		log.debug("Calling parser wrapper");
		parserWrapper.parsi(sr,sw);
		log.debug("...parsing complete (in "+(System.currentTimeMillis() - start)+"ms)");
		String output = sw.toString();
		returnList.add(output); 


	}

}
