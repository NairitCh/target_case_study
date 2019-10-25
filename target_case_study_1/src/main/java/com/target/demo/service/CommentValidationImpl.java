package com.target.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class CommentValidationImpl implements CommentValidation {

	@Override
	public boolean validateComment(String input) {
		List<String> keywordList = new ArrayList<String>();
		keywordList.add("fuck");
		for (String key : keywordList) {
	        Pattern p = Pattern.compile(".*\\b"+key+"\\b.*");
	        Matcher m = p.matcher(input);
	        if (m.matches()) {
	        	return false;
	        }
		}
		return true;
	}

}
