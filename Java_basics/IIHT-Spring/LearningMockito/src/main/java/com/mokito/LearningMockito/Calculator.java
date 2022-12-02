package com.mokito.LearningMockito;

public class Calculator {

	CalculatorService calService;

	public Calculator(CalculatorService service) {
		this.calService = service;
	}

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	public int multiply(int num1, int num2) {
		return num1 * num2;
	}

	public int performAdd(int i, int j) {
		// TODO Auto-generated method stub
//		return calService.add(i, j);
		return i + j;
	}

	public int performSub(int i, int j) {
		// TODO Auto-generated method stub
//		return calService.sub(i, j);
		return i - j;
	}

	public int performMultiply(int i, int j) {
		// TODO Auto-generated method stub
//		return calService.multiply(i, j);
		return i * j;
	}

}
