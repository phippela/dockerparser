package com.parser;

import java.util.List;
import java.util.Set;

public interface ParserCache {
	public void add(String key, String object);
	public String get(String key);
	public Set<String> allKeys();
}
