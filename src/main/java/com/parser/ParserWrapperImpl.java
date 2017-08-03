package com.parser;

import is2.parser.Parser;
import is2.parser.*;
import is2.parser.Options;
import is2.util.*;
import is2.io.*;
import is2.data.*;
import is2.parser.ParametersFloat;
import java.io.*;

// This is stub for 'Turku' parser - however this is no longer continued
// To support one should implemente the tag.sh functionality as an input.
public class ParserWrapperImpl extends Parser implements ParserWrapper {

	// lets initialize the parser
	//  -model model/parser.model -test /dev/stdin -out $TMPDIR/input_parsed_raw.conll09
	public ParserWrapperImpl(String[] args) {
			super(new Options(args));
	}
	
	public void parsi(Reader in, Writer out) throws Exception {
		
		OmaConlReader reader = new OmaConlReader(in);
		CONLLWriter09 writer = new CONLLWriter09(out);
		
		omaOut(options, pipe, params, false, options.label,reader, writer);
	}
	
	/**
	 * Do the parsing job
	 * 
	 * @param options
	 * @param pipe
	 * @param params
	 * @throws IOException
	 */
	public void omaOut (OptionsSuper options, Pipe pipe, ParametersFloat params, boolean maxInfo, boolean labelOnly,OmaConlReader reader,
			CONLLWriter09 writer) 
			throws Exception {

		long start = System.currentTimeMillis();

		//CONLLReader09 depReader = new CONLLReader09(options.testfile, options.formatTask);
		OmaConlReader depReader =  reader;
		CONLLWriter09 depWriter =  writer;

		int cnt = 0;
		int del=0;
		long last = System.currentTimeMillis();

		if (maxInfo) System.out.println("\nParsing Information ");
		if (maxInfo) System.out.println("------------------- ");

		if (maxInfo && !options.decodeProjective) System.out.println(""+Decoder.getInfo());

		System.out.print("Processing Sentence: ");

		while(true) {

	//		Instances is = new Instances();
	//		is.init(1, new MFO(),options.formatTask);

			//					SentenceData09 instance = pipe.nextInstance(is, depReader);

			SentenceData09 instance = depReader.getNext();
			if (instance==null) break;
			cnt++;

			SentenceData09 i09 = super.parse(instance,params, labelOnly,options);

			depWriter.write(i09);
			del=PipeGen.outValue(cnt, del,last);

		}
		//pipe.close();
		depWriter.finishWriting();
		long end = System.currentTimeMillis();
		//		DB.println("errors "+error);
		if (maxInfo) System.out.println("Used time " + (end-start));
		if (maxInfo) System.out.println("forms count "+Instances.m_count+" unkown "+Instances.m_unkown);

	}

	
}
