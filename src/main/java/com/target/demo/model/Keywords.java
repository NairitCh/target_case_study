package com.target.demo.model;

import java.util.HashSet;

public class Keywords {
	
	private static HashSet<String> keywordSet = new HashSet<String>();
	
	public static HashSet<String> getInstance(){
		return keywordSet;
	}

}
