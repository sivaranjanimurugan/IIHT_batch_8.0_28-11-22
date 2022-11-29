package com.basics.functions;

public class BasicFunction {
	public static void main(String[] args) {
      System.out.println(add(10,5));
      System.out.println(sub(10,5));
      System.out.println(multiply(10,5));
      System.out.println(div(10,5));
      System.out.println(sq(10));
      System.out.println(cube(10));
	}

	static Integer add(Integer num1, Integer num2) {
		return num1 + num2;
	}
	
	static Integer sub(Integer num1, Integer num2) {
		return num1 - num2;
	}
	
	static Integer multiply(Integer num1, Integer num2) {
		return num1 * num2;
	}
	
	static Integer div(Integer num1, Integer num2) {
		return num1 / num2;
	}
	
	static Integer sq(Integer num) {
		return num * num;
	}
	
	static Integer cube(Integer num) {
		return num * num * num;
	}
}
