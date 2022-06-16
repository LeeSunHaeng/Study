package main;

import java.awt.Shape;

import cls.Circle;
import cls.Rectangle;

public class MainClass {

	public static void main(String[] args) {
		
		Circle ci =  new Circle(5.5);
		System.out.println(ci.calcArea());
		
		Rectangle rc = new Rectangle(5.7, 9,8);
		System.out.println(rc.calcArea());


	}

}
