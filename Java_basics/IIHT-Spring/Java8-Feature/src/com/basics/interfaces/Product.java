package com.basics.interfaces;

interface Manufacturing{
	void made();
}

interface Sales{
	void sold();
}

public class Product implements Manufacturing, Sales{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Product soap = new Product();
       soap.made();
       soap.sold();
       
	}

	@Override
	public void sold() {
		System.out.println("the product has been made");
	}

	@Override
	public void made() {
		System.out.println("the product can be sold");	
	}

}
