package com.basics.ref;

public class RefDemo {

	public static void main(String[] args) {
		System.out.println("Method reference demo");
		//provide the implementation of IWork
//		IWork work = ProjectDemo::projectInprogress;
//		work.doProject();
//		
//		Runnable run = ProjectDemo::threadTask;
//		Thread t1 = new Thread(run);
//		t1.start();
		
		Runnable run = ProjectDemo::oddTo100;
		Thread t1 = new Thread(run);
		t1.start();
	}

}
