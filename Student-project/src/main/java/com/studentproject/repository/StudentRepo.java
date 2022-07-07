package com.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentproject.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
