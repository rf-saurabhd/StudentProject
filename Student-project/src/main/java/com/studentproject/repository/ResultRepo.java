package com.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentproject.model.Result;

public interface ResultRepo extends JpaRepository<Result,Long> {

	Result findByStudentId(long id);
	
}
