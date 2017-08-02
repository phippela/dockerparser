package com.parser;

import java.util.*;
import java.io.*;

public class ConluParser implements com.parser.Parser {


	private com.parser.ParserLog log = null;
	
	public ConluParser(ParserLog logComponent) {
		this.log = logComponent;
	}
	
	// TODO clean extra comments
	public List convertInputToList(String inFile) throws Exception  {

		List returnList = new ArrayList();
		

// dummy implementation
// returnList.add(inFile);

/*
// this is for checking that all lines are of the same length
int previousLength = -1;
int currentLength = 0;
BufferedReader br = new BufferedReader(new InputStreamReader(
	    new FileInputStream(""+inFile), "ISO-8859-1"));

String line = br.readLine();
*/

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
	
	/*
	List tempList = new ArrayList();

	while(st.hasMoreTokens()) {
			String token = (""+st.nextToken()).trim();
			if(";".equals(token)) {
				if(!previousWasToken) {
					token = null;
				} else {
					token = "";
				}
				previousWasToken = true;
			}
			else
				previousWasToken = false;
			if(DEBUG)
				if(token!=null)
					System.out.println(""+token);

			if(token!=null)
			tempList.add(token);
		}

		String[] array = new String[tempList.size()];
		for(int i = 0; i < tempList.size(); i++) {
			array[i] = ""+tempList.get(i);
		}

		if(previousLength >0) {
			if(previousLength != tempList.size())  {

				System.out.println("line="+lineNumber + " previous length="+previousLength+" currentLength="+tempList.size());

				throw new Exception("Not all lines of equal length!");
			}
		}

		previousLength = tempList.size();
		*/
		returnList.add(lause);

		//line = br.readLine();
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

				// Splitting input file to clauses. These in the end do not have correct punctuation mark ? . or !
				List returnList = convertInputToList(inFile);

				return returnList;

	}

}
