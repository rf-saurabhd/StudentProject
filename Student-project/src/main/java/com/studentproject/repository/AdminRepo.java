package com.studentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentproject.model.Admin;

public interface AdminRepo  extends JpaRepository<Admin, String>{

	public Admin findByAdminName(String adminName);
}
