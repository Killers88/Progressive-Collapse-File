/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class ActualStiffnessK {

	public static double CONSTANT_A = 384;
	public static double CONSTANT_B = 5;
	public static double UNIT_CONVERSIONA = 0.00694444;
	public static double UNIT_CONVERSIONB = 0.0000481;

	public static double calculateColumnActualStiffness(final double e,
			final double i, final double l) {

		return (CONSTANT_A * (e / UNIT_CONVERSIONA) * (i * UNIT_CONVERSIONB))
				/ (5 * (Math.pow(l, 3)));
	}
}
