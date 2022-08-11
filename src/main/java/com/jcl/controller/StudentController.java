package com.jcl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller, @ResponseBody
@RequestMapping("/api/student")
public class StudentController {
	
	@Value("${app.name:Default Demo App}")
	private String appName;

	@GetMapping("/get")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getStudent() {
		return "<h2>Hello " + appName + "</h2>";
	}
}
