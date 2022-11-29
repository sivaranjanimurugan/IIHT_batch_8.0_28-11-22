package com.basics.functionalInterfaces;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String>{

	@Override
	public String get() {
		return "Hello world!!";
	}
	
	public static void main(String[] args) {
		Supplier<String> sub = new SupplierDemo();
		System.out.println(sub.get());
	}

}
