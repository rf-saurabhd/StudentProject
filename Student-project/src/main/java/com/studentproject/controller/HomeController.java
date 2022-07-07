package com.studentproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	public ResponseEntity<String> getlogin(){
		
		String msg="Welcome to Login Page";
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}
}
