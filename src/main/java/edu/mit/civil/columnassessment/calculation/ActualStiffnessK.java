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
	public static double CONSTANT_C = 185;
	public static double UNIT_CONVERSIONA = 0.00694444;
	public static double UNIT_CONVERSIONB = 0.0000481;

	public static double calculateColumnActualStiffness(final double e,
			final double i, final double l) {

		return (CONSTANT_A * (e / UNIT_CONVERSIONA) * (i * UNIT_CONVERSIONB))
				/ (5 * (Math.pow(l, 3)));
	}

	public static double stiffnessFIX(final double e, final double i,
			final double l) {

		return (CONSTANT_A * (e / UNIT_CONVERSIONA) * (i * UNIT_CONVERSIONB))
				/ ((Math.pow(l, 3)));

	}

	public static double stiffnessPIN_FIXED(final double e, final double i,
			final double l) {

		return (CONSTANT_C * (e / UNIT_CONVERSIONA) * (i * UNIT_CONVERSIONB))
				/ ((Math.pow(l, 3)));

	}

}
