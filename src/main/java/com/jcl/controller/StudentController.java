package com.jcl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcl.response.StudentResponse;

@RestController // @Controller, @ResponseBody
@RequestMapping("/api/student")
public class StudentController {
	
	@Value("${app.name:Default Demo App}")
	private String appName;

	@GetMapping("/get")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public StudentResponse getStudent() {
		StudentResponse sr = new StudentResponse(1, "John", "Jacob");
		return sr;
	}

	@RequestMapping("/error")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public StudentResponse showError() {
		StudentResponse sr = new StudentResponse(1, "John", "Wick");
		return sr;
	}
}
