package com.studentproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentproject.exception.StudentNotFoundException;
import com.studentproject.model.Result;
import com.studentproject.model.Student;
import com.studentproject.repository.ResultRepo;
import com.studentproject.serviceimpl.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static final Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentServiceImpl serviceImpl;
	
	@Autowired
	private ResultRepo resultRepo;

	@PostMapping("/")
	public ResponseEntity<Student> createStudentResource(@RequestBody Student student, @RequestBody Result result) {

		logger.info("Insider Student controller :- createStudentResource() method invoked");
		student.setResult(result);
		Student stud = serviceImpl.createStudent(student);

		return new ResponseEntity<Student>(stud, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Student>> getStudents() {

		logger.info("Insider Student controller :- getStudents() method invoked");
		List<Student> students = serviceImpl.getStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentResource(@PathVariable("id") long  id){

		logger.info("Insider Student controller :- getStudentResource() method invoked");
		Student student=null;
		try {
		 student=serviceImpl.getStudent(id);
		}catch(StudentNotFoundException e) {
			e.getMessage();
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentResource(@PathVariable("id") long id, Student student){

		logger.info("Insider Student controller :- updateStudentResource() method invoked");
		Student existingStudent=null;
		try {
			existingStudent=serviceImpl.getStudent(id);
		}catch(StudentNotFoundException e) {
			e.getMessage();
		}
		
		existingStudent.setAge(student.getAge());
		existingStudent.setEmailId(student.getEmailId());
		existingStudent.setLastName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setPhoneNumber(student.getPhoneNumber());
		
		return new ResponseEntity<Student>(serviceImpl.createStudent(existingStudent), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudentResource(@PathVariable("id") long id){

		logger.info("Insider Student controller :- deleteStudentResource() method invoked");
		Student student=null;
		try {
			student=serviceImpl.getStudent(id);
		}catch(StudentNotFoundException e) {
			e.getMessage();
		}
		
		serviceImpl.deleteStudent(student);
		return new ResponseEntity<String>("Student with Id "+id+" is deleted", HttpStatus.OK);
	}
	
	@GetMapping("/{id}/marks")
	public ResponseEntity<Result> getStudentMarks(@PathVariable("id") long id){

		logger.info("Insider Student controller :- getStudentMarks() method invoked");
		try {
			serviceImpl.getStudent(id);
		}catch(StudentNotFoundException e) {
			e.getMessage();
		}
		
		Result result=resultRepo.findByStudentId(id);
		return new ResponseEntity<Result>(result, HttpStatus.OK);
		
	}
	
	@GetMapping("/marks")
	public ResponseEntity<List<Result>> getAllStudentsMarks(){

		logger.info("Insider Student controller :- getAllStudentsMarks() method invoked");
		List<Result> results=resultRepo.findAll();
		
		return new ResponseEntity<List<Result>>(results, HttpStatus.OK);
	}
	
}
