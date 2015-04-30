/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class YieldDisplacementUy {

	public static double CONSTANT_A = 5;
	public static double CONSTANT_B = 48;
	public static double CONVERSION_A = 12; // inches - ft

	public static double calculateYieldDisplacementUy(final double colhgt,
			final double s, final double yield, final double e, final double i) {

		return ((5 * Math.pow(colhgt * 12, 2) * s * yield) / (48 * e * i));
	}

	public static double calculateYieldDisplacementUyFIXED(final double colhgt,
			final double s, final double yield, final double e, final double i) {

		return ((Math.pow(colhgt * 12, 2) * s * yield) / (32 * e * i));
	}

}
