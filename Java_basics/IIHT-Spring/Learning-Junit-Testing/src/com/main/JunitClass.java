package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JunitClass {
	
	String username = "Sivaranjani";
	
	@Test
	public void testUsername() {
		System.out.println("Testing username if matches..");
		assertEquals("Sivaranjani",username);
	}
	
	@Test
	public void JunitMethod() {
		System.out.println("Test file executed..");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JunitClass junit = new JunitClass();
        junit.testUsername();
	}

}
