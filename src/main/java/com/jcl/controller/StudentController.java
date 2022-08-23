package com.jcl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcl.entity.Student;
import com.jcl.request.CreateStudentRequest;
import com.jcl.request.UpdateStudentRequest;
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

	@PostMapping("/create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = studentService.createStudent(createStudentRequest);

		return new StudentResponse(student);
	}
	
	@PutMapping("/update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = studentService.updateStudent(updateStudentRequest);
		
		return new StudentResponse(student);
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
	
	// Delete using Param - /delete/id={id}
//	@DeleteMapping("/delete")
//	public String deleteStudent(@RequestParam long id) {
//		return studentService.deleteStudent(id);
//	}
	
	// Delete using Path
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
}
