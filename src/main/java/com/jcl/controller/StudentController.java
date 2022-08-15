package com.jcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcl.entity.Student;
import com.jcl.response.StudentResponse;
import com.jcl.service.StudentService;

@RestController // @Controller, @ResponseBody
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/getAll")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/get")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public StudentResponse getStudent() {
		StudentResponse sr = new StudentResponse(1, "John", "Jacob", "email");
		return sr;
	}

	@RequestMapping("/error")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public StudentResponse showError() {
		StudentResponse sr = new StudentResponse(1, "John", "Wick", "email");
		return sr;
	}
}
