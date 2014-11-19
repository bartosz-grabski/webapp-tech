package org.tai.spring.wiring;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tai.spring.wiring.application.ReportGenerator;

public class Go {

	private static final Logger LOGGER = LoggerFactory.getLogger(Go.class);
	
	public static void main(String[] args) throws IOException {
		
		try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {

			final ReportGenerator generator = context.getBean(ReportGenerator.class);
			generator.generate();

		} catch (Exception e) {
			LOGGER.error("My application has miserably failed", e);
			System.exit(1);
		}

	}

}
