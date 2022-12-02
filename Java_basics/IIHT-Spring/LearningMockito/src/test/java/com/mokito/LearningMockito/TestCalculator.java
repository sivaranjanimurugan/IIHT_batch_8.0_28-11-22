package com.mokito.LearningMockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TestCalculator {

	Calculator c = null;

//	CalcultorService service = new CalcultorService() {
//		public int add(int num1, int num2) {
//			return num1 + num2;
//		}
//	};

	CalculatorService service = Mockito.mock(CalculatorService.class);

	@Before
	public void configSetup() {
		c = new Calculator(service);
	}

	@Test
	public void testPerformAdd() {
		when(service.add(100, 50)).thenReturn(150);
		assertEquals(10, c.performAdd(5, 5));
	}

	@Test
	public void testPerformSub() {
		when(service.sub(100, 50)).thenReturn(50);
		assertEquals(50, c.performSub(100, 50));
	}

	@Test
	public void testPerformMultiply() {
		when(service.multiply(10, 50)).thenReturn(500);
		assertEquals(500, c.performMultiply(50, 10));
	}

}
