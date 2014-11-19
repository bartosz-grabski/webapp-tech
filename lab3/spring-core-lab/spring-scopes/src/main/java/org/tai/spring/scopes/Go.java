package org.tai.spring.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tai.spring.scopes.objects.InPrototypeScope;
import org.tai.spring.scopes.objects.InSingletonScope;

import com.google.common.base.Preconditions;

public class Go {

	private static final Logger LOGGER = LoggerFactory.getLogger(Go.class);
	
	public static void main(String[] args)  {
		
		try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
			InSingletonScope first = context.getBean(InSingletonScope.class);
			InSingletonScope second = context.getBean(InSingletonScope.class);
			Preconditions.checkState(first == second, "Should return the same object");

			InPrototypeScope third = context.getBean(InPrototypeScope.class);
			InPrototypeScope forth = context.getBean(InPrototypeScope.class);
			Preconditions.checkState(third != forth, "Should return different Object");
			
			LOGGER.info("Greate Success!!");
		} catch (Exception e) {
			LOGGER.error("My application has miserably failed", e);
			System.exit(1);
		}

	}

}
