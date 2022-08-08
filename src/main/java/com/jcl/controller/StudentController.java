package com.jcl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller, @ResponseBody
@RequestMapping("/api/student")
public class StudentController {

	@GetMapping("/get")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getStudent() {
		return "Hello Student";
	}
}
