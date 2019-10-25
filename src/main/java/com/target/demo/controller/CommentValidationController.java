package com.target.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.demo.model.Comments;
import com.target.demo.model.ValidationResponse;
import com.target.demo.service.CommentValidation;

@RestController
public class CommentValidationController {
	@Autowired
	private CommentValidation commentValidation;
	
	@CrossOrigin
	@PostMapping(path = "/postComment", produces = "application/json")
	public ResponseEntity<?> postComment(@RequestBody Comments comments){
		String inputComment = comments.getComment();
		ValidationResponse response = new ValidationResponse();
		if (commentValidation.validateComment(inputComment)) {
			response.setErrorCode("200");
			response.setErrorMessage("comment is successfully validated");
			return ResponseEntity.ok(response);
		} else {
			response.setErrorCode("400");
			response.setErrorMessage("comments got offensive & abusive remarks");
			return ResponseEntity.ok(response);
		}
	}
}
