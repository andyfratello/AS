package src.com.junit.demo;


public class Calculator {
		  
	public double multiply(double a, double b) {
		  return a * b;
		 }
		 
    public double divide(double a, double b) { 
	  if(b == 0) {
	   throw new ArithmeticException();
	  }
	  return a / b;
	 }
	 
	 public double suma(double a, double b) {
		return a + b;
	 }

	public double resta(double a, double b) {
		if (b > a) {
			throw new ArithmeticException();
		}
		return a - b;
	}

	public int factorial(int n) {
		int p = 1;
		if (n == 0) return 1;
		else if (n < 0) throw new ArithmeticException();
		else {
			while (n != 0) {
				p *= n;
				--n;
			}
		}
		return p;
	}
}
