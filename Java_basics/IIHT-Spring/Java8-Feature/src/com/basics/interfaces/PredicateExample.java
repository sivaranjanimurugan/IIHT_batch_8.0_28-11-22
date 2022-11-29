package com.basics.interfaces;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> condition1 = num -> (num > 20);// calling the predicate
		System.out.println(condition1.test(100)); // calling the predicate method
	}

}
