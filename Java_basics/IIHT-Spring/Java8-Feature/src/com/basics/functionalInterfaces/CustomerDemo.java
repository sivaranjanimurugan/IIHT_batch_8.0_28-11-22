package com.basics.functionalInterfaces;

import java.util.function.Consumer;

public class CustomerDemo {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (t) -> 
			System.out.println("Printing..."+t);
			consumer.accept(8000);
	}

}
