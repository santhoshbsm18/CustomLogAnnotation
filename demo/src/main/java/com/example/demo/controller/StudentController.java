package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.LogRequest;
import com.example.demo.entity.Student;

@RestController
public class StudentController {

	@PostMapping("/save1")
	@LogRequest(true)
	public ResponseEntity<?> saveStudent1(@RequestBody Student student){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/save2")
	@LogRequest
	public ResponseEntity<?> saveStudent2(@RequestBody Student student){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
