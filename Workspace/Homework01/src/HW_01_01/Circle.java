package HW_01_01;
import java.lang.Math;

public class Circle {
	private double radius;
	
	public Circle() {
	}

	public Circle(int radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double calculateCircumference() {
		return 2 * Math.PI * radius;
	}
	
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	

}
