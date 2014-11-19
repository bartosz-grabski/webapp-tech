package org.tai.spring.scopes.objects;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class InSingletonScope implements ApplicationContextAware {
	
	public void afterCreation() {
		System.out.println("Created singleton");
	}
	
	public void beforeDestroy() {
		System.out.println("Destroying singleton");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		for (String bean : applicationContext.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
		
	}
	
	
	

}
