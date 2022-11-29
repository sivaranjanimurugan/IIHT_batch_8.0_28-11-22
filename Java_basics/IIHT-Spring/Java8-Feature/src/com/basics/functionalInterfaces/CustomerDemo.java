package com.basics.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class CustomerDemo {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (t) -> 
			System.out.println("Printing:"+t);
			consumer.accept(8000);
			
			List<Integer> numberList = Arrays.asList(1,2);
//			numberList.stream().forEach(consumer);
			numberList.stream().forEach(num -> System.out.println("printing:"+ num));
	}

}
