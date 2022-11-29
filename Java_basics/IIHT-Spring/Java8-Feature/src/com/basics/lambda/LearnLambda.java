package com.basics.lambda;

public class LearnLambda {

	public static void main(String[] args) {

		LearnLambda lambda = new LearnLambda();

		MethOperation add = (num1, num2) -> num1 + num2;

		MethOperation sub = (num1, num2) -> num1 - num2;

		MethOperation div = (num1, num2) -> num1 / num2;
		
		MethOperation multiply = (num1, num2) -> num1 * num2;
		
		System.out.println("Add two values = "+ lambda.operate(100, 50, add));
		System.out.println("Sub two values = "+ lambda.operate(100, 50, sub));
		System.out.println("Div two values = "+ lambda.operate(100, 50, div));
		System.out.println("Multiply two values = "+ lambda.operate(100, 50, multiply));
	}
	
	private Integer operate(Integer num1, Integer num2, MethOperation operation) {
		return operation.operation(num1, num2);
	}

}
