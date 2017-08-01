package com.parser;

import java.util.*;
import java.io.*;
import java.text.*;

public interface Parser {
    public List parse(String inFile) throws Exception;
}
