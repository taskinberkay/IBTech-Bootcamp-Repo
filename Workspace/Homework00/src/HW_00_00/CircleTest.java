package HW_00_00;

public class CircleTest {
	public static void main(String[] args) {
		Circle myCircle = new Circle(3);
		System.out.println(
			"Circumference: " + myCircle.calculateCircumference() + "\n" +
			"Area: " + myCircle.calculateArea()
		);
	}
	
}
