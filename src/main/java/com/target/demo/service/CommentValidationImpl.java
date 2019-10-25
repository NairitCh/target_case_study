package com.target.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.target.demo.model.Keywords;

@Service
public class CommentValidationImpl implements CommentValidation {

	@Override
	public boolean validateComment(String input) {
		HashSet<String> keywordSet = Keywords.getInstance();
		keywordSet.add("fuck");
		for (String key : keywordSet) {
	        Pattern p = Pattern.compile(".*\\b"+key+"\\b.*");
	        Matcher m = p.matcher(input);
	        if (m.matches()) {
	        	return false;
	        }
		}
		return true;
	}

}
