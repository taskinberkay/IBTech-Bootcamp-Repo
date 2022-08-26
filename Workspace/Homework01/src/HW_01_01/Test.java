package HW_01_01;

public class Test {
	public static void main(String[] args) {
		MathFunction function = new QuadraticFunction(3, 2, 6);
		FunctionDrawer drawer = new FunctionDrawer();
		drawer.draw(function, -5, 5, 5);
	}

}
