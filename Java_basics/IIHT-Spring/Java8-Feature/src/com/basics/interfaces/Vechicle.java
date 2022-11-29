package com.basics.interfaces;

//using the interface by third user
public class Vechicle {
 
	public static void main(String[] args) {
		Drivable car = new Car();
		car.driven();
		Drivable truck = new Truck();
		truck.driven();
		Drivable bike = new Bike();
		bike.driven();
	}
	
}

//implementation done by second user
class Car implements Drivable{

	@Override
	public void driven() {
		System.out.println("the car can be driven");
	}
	
}

class Truck implements Drivable{

	@Override
	public void driven() {
		System.out.println("the truck can be driven");
	}
}

class Bike implements Drivable{

	@Override
	public void driven() {
		System.out.println("the bike can be driven");
	}
}
