package com.jcl.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jcl.clirunner.CliRunner;

@SpringBootApplication
@ComponentScan({ "com.jcl.controller", "com.jcl.service", "com.jcl.clirunner" })
@EntityScan("com.jcl.entity")
@EnableJpaRepositories("com.jcl.repository")
public class UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);

		CliRunner.loggit("Started.", "*");
	}

}
