package org.tai.spring.scopes.objects;

public class InPrototypeScope {
	
	public void afterCreation() {
		System.out.println("Created prototype");
	}
	
	public void beforeDestroy() {
		System.out.println("Destroying prototype");
	}
	
	
}
