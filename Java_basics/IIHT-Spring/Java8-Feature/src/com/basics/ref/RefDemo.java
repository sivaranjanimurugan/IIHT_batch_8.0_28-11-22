package com.basics.ref;

public class RefDemo {

	public static void main(String[] args) {
		System.out.println("Method reference demo");
		//provide the implementation of IWork
		IWork work = ProjectDemo::projectInprogress;
		work.doProject();
	}

}
