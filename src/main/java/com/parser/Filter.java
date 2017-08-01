package com.parser;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.text.*;

public interface Filter {
	
	public String getBody(HttpServletRequest request) throws Exception;
	
}
