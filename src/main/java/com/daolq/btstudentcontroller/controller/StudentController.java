package com.daolq.btstudentcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daolq.btstudentcontroller.pojo.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private List<Student> list = new ArrayList<Student>();
	
//	Map, Object
	@PostMapping("/create")
	public ResponseEntity<List<Student>> createStudentParam(
			@RequestParam("name") String name, 
			@RequestParam("age") int age
			) {
		
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		
		list.add(student);
		
		
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/create/{name}/{age}")
	public ResponseEntity<List<Student>> createStudentPathVariable(
			@PathVariable("name") String name,
			@PathVariable("age") int age
			) {
		
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		
		list.add(student);
		
		
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@PostMapping( value = "/create", consumes = "application/json")
	public ResponseEntity<List<Student>> createStudentRequestBody(
			@RequestBody Student student
			) {
		
		
		list.add(student);
		
		
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
}
