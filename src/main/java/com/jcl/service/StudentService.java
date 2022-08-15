package com.jcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.entity.Student;
import com.jcl.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		// findAll() is provided by JpaRepository() super
		return studentRepository.findAll();
	}

}
