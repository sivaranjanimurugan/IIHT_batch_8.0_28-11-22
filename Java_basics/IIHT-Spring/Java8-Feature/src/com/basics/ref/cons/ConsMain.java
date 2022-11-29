package com.basics.ref.cons;

public class ConsMain {

	public static void main(String[] args) {
		IStudent stu = () -> new Student();
		Student student = stu.getStudent();
		student.display("Siva", 23);
	}

}
