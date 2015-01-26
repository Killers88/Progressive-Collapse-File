/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

/**
 * @author koleary
 *
 */

public class ClearingTimeTc {

	public static double CONSTANT_A = 4;
	public static double CONSTANT_B = 1;

	/**
	 * Return min(S) and max(G) of building dimensions
	 * 
	 * @param H
	 * @param W
	 * @param Cr
	 */
	public static double parameterS(final double W, final double H) {

		if (H > (W / 2)) {
			return (W / 2);
		} else {
			return H;
		}
	}

	public static double parameterG(final double W, final double H) {
		if (H < (W / 2)) {
			return (W / 2);
		} else {
			return H;
		}
	}

	public static double calculateclearingTimeTc(final double W,
			final double H, final double Cr) {

		double S = parameterS(H, W);
		double G = parameterG(H, W);

		return (CONSTANT_A * S) / ((CONSTANT_B + (S / G)) * Cr);

	}

}
