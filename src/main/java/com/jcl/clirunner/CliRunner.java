package com.jcl.clirunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// https://zetcode.com/springboot/commandlinerunner/
@Component // Autodetect and register by Spring
public class CliRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CliRunner.class);
	
	private static String message;
	private static String borderString;
	private static String dtg;
	private static String topBottomBorder;
	private static int padMessageLength;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Started CLI Runner.");
	}

	public static void loggit(String msg, String borderStr) {
		message = msg;
		dtg = getDTG();
		borderString = createBookEnd(borderStr);
		padMessageLength = getPadMessageLength();
		topBottomBorder = createTopBottomBorder(borderStr);
		
		showMessage();
	}
	
	public static int getPadMessageLength() {
		int dtgLength = dtg.length();
		if (message.length() < dtgLength) {
			padMessageLength = dtgLength;
		} else {
			padMessageLength = message.length();
		}
		
		return padMessageLength + borderString.length() * 2;
	}
	
	public static String createBookEnd(String borderStr) {		
		borderString = borderStr.repeat(5);
		return borderString;
	}
	
	public static String createTopBottomBorder(String borderString) {
		topBottomBorder = borderString.repeat(padMessageLength);
		
		return topBottomBorder;
	}
	
	public static String getDTG() {
		Calendar cal = Calendar.getInstance();
		Date newTime = cal.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
		dtg = dateFormat.format(newTime);
		
		return dtg;
	}
	
	public static String createMessage() {
		//message = borderString + " " + message + " " + borderString;
		message = borderString + " " + message;
		return message;
	}
	
	public static void showMessage() {

		logger.info(topBottomBorder);
		logger.info(createMessage());
		message = dtg;
		logger.info(createMessage());
		logger.info(topBottomBorder);
	}
}
