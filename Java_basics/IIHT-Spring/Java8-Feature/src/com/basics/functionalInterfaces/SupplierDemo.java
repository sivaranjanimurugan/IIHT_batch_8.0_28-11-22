package com.basics.functionalInterfaces;

import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<String> sub = () -> {
			return "Hello";
		};
		System.out.println(sub.get());
	}

}
