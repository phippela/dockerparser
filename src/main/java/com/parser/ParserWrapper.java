package com.parser;

import java.io.Reader;
import java.io.Writer;

public interface ParserWrapper {

	public void parsi(Reader reader, Writer writer) throws Exception;
}
