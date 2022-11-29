package com.basics.interfaces;

interface Square {
	void square();

	static Integer sq(Integer x) {return x*x;};
}

public class Calculate {

	public static void main(String[] args) {
          Square sq = new SquareOf10();
          sq.square();
          System.out.println(Square.sq(10));
	}

}

class SquareOf10 implements Square {

	@Override
	public void square() {
        System.out.println("Square of the number is:");
	}
	
}
