package com.jcl.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication	// @Configuration, @EnableAutoConfiguration, @ComponentScan
//@ComponentScan("com.jcl.*")
@ComponentScan({"com.jcl.controller", "com.jcl.service"})
public class UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

}
