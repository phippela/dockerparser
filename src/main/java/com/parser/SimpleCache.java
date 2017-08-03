package com.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SimpleCache implements ParserCache {

	HashMap<String,String> map = null;
	public SimpleCache() {
		this.map = new HashMap<String,String>(); 
	}
	public void add(String key, String object) {
		map.put(""+key,""+object);
	}

	public String get(String key) {
		
		return map.get(""+key);
	}

	public Set<String> allKeys() {
		
		return map.keySet();
	}

}
