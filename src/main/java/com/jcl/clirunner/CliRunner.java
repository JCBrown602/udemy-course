package com.jcl.clirunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://zetcode.com/springboot/commandlinerunner/
@Component	// Autodetect and register by Spring
public class CliRunner implements CommandLineRunner {
	private static final Logger logger = 
			LoggerFactory.getLogger(CliRunner.class);
	
	@Override
    public void run(String... args) throws Exception {
		Calendar cal = Calendar.getInstance();
		Date newTime = cal.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
		String dtg = dateFormat.format(newTime);

		logger.info(dtg);
		logger.info("test");
	}
}
