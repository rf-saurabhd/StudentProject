package com.studentproject.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentproject.exception.StudentNotFoundException;
import com.studentproject.model.Student;
import com.studentproject.repository.StudentRepo;
import com.studentproject.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger logger=LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {

		logger.info("Inside StudentServiceImpl :- createStudent() method invoked");
		return studentRepo.save(student);
	}

	@Override
	public Student getStudent(long id) {

		logger.info("Inside StudentServiceImpl :- getStudent() method invoked");
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException("Student with Student Id " + id + " is not found");
		}
	}

	@Override
	public List<Student> getStudents() {

		logger.info("Inside StudentServiceImpl :- getStudents() method invoked");
		return studentRepo.findAll();
	}

	@Override
	public void deleteStudent(Student student) {

		logger.info("Inside StudentServiceImpl :- deleteStudent() method invoked");
		studentRepo.delete(student);
	}

	@Override
	public Student updateStudent(Student Student) {
		logger.info("Inside StudentServiceImpl :- updateStudent() method invoked");
		return studentRepo.save(Student);
	}

}
