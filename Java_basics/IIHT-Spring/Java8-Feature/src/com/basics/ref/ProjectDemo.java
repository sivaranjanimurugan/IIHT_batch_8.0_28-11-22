package com.basics.ref;

import java.time.LocalDate;

public class ProjectDemo {

	public static void projectInprogress() {
		System.out.println("Project is making progress");
		System.out.println("Project is Approved by client");
		System.out.println("on " + LocalDate.now());
	}

	public static void threadTask() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i * 2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void oddTo100() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
