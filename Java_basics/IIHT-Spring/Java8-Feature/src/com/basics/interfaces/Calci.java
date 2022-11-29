package com.basics.interfaces;

interface Calculator {

	void doOperations();

	static Integer add(Integer a, Integer b) {
		return a + b;
	};

	static Integer sub(Integer a, Integer b) {
		return a - b;
	};

	static Integer div(Integer a, Integer b) {
		return a / b;
	};

	static Integer multi(Integer a, Integer b) {
		return a * b;
	};
}

public class Calci {

	public static void main(String[] args) {
		Calculator cal = new SimpleCal();
		cal.doOperations();
		System.out.println(Calculator.add(10,5));
		System.out.println(Calculator.sub(10,5));
		System.out.println(Calculator.div(10,5));
		System.out.println(Calculator.multi(10,5));
	}

}

class SimpleCal implements Calculator {

	@Override
	public void doOperations() {
		System.out.println("results:");
	}

}