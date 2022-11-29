package com.basics.functionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class PredicateDemo {

	public static void main(String[] args) {

		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
		numberList.stream().filter((t) -> t % 2 == 0).forEach(num -> System.out.println("printing:" + num));
	}

}
