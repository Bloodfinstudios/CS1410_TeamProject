package biquadApp;

public class Coefficients{
	private double b0;
	private double b1;
	private double b2;
	private double a0;
	private double a1;
	private double a2;
	/**
	 * @param b0
	 * @param b1
	 * @param b2
	 * @param a0
	 * @param a1
	 * @param a2
	 */
	public Coefficients(double b0, double b1, double b2, double a0, double a1, double a2) {
		this.b0 = b0;
		this.b1 = b1;
		this.b2 = b2;
		this.a0 = a0;
		this.a1 = a1;
		this.a2 = a2;
	}
	/**
	 * @return the b0
	 */
	public double getB0() {
		return b0;
	}
	/**
	 * @return the b1
	 */
	public double getB1() {
		return b1;
	}
	/**
	 * @return the b2
	 */
	public double getB2() {
		return b2;
	}
	/**
	 * @return the a0
	 */
	public double getA0() {
		return a0;
	}
	/**
	 * @return the a1
	 */
	public double getA1() {
		return a1;
	}
	/**
	 * @return the a2
	 */
	public double getA2() {
		return a2;
	}
	
	
}
