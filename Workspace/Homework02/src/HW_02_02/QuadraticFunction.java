package HW_02_02;

public class QuadraticFunction implements MathFunction {
	// ax2+bx+c
	private double a, b, c;

	public QuadraticFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double evaluate(double x) {
		return a * Math.pow(x, 2) + b * x + c;
	}
}
