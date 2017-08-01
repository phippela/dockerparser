package com.parser;

import java.util.*;
import java.io.*;

public class ConluParser implements com.parser.Parser {

	public static final boolean DEBUG = false;

  // This asssumes that in file is dot ''.'' exclamanation '! or question
  // marks separated '?''
  //
  // Each of the sentences are then put to own List.
  // As a result will be that each sentence is on list of its own.
  public List parse(String inFile) throws Exception {
		List returnList = new ArrayList();

		System.out.println("We"
				+ " are parsing...");

// LE dummy implementation a
				returnList.add(inFile);
				/*
		// this is for checking that all lines are of the same length
		int previousLength = -1;
		int currentLength = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(""+inFile), "ISO-8859-1"));

		String line = br.readLine();
		int lineNumber = 0;
		boolean previousWasToken = true;
		while(line!=null) {
			currentLength = 0;
			lineNumber++;

			if(DEBUG)
				System.out.println(""+line);

			StringTokenizer st = new StringTokenizer("start;"+line+";end",";",true);
			//String[] tokens = line.split(";");

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
				returnList.add(array);

				line = br.readLine();
		}
*/

		return returnList;
	}

}
