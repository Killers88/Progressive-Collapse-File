/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class TotalActalMassM {

	public static double CONVERSION_A = 32; // ft/s^2
	public static double CONVERSION_B = 1000; // lbs - kips

	public static double calculatingTotalActualMass(final double colweight,
			final double colhgt) {

		return ((colweight / CONVERSION_A) * colhgt) / CONVERSION_B;
	}
}
