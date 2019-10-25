package com.nlp.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "this is a fucking disturbing product";
		Pattern p = Pattern.compile(".*\\bfucking\\b.*");
		Matcher m = p.matcher(input);
		System.out.println(m.matches());
	}

}
