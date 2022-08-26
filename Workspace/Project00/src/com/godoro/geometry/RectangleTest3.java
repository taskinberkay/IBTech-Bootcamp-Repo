package com.godoro.geometry;

public class RectangleTest3 {
	
	public static void main(String[] args) {
		Rect myRectangle = new Rect();
		myRectangle.setHeight(3);
		myRectangle.setWidth(4);
		System.out.println("Alan: " + myRectangle.getArea());
		System.out.println("Çevre " + myRectangle.getCircumference());
	}
}