package com.jcl.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jcl.clirunner.CliRunner;

@SpringBootApplication	// @Configuration, @EnableAutoConfiguration, @ComponentScan
//@ComponentScan("com.jcl.*")
@ComponentScan({"com.jcl.controller", "com.jcl.service", "com.jcl.clirunner"})
public class UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
		
//		Calendar cal = Calendar.getInstance();
//		Date newTime = cal.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
//		String dtg = dateFormat.format(newTime);
//		System.out.println(dtg + "  INFO 00000 --- [\t    >>> TEST SAT <<<");
		
		CliRunner.loggit("THIS IS ALSO, VERY MUCH SO, THE MESSAGE");
	}

}
