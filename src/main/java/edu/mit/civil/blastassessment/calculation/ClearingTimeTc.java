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
	 * @param h
	 * @param w
	 * @param Cr
	 */
	public static double parameterS(final double w, final double h) {

		if (h > (w / 2)) {
			return (w / 2);
		} else {
			return h;
		}
	}

	public static double parameterG(final double w, final double h) {
		if (h < (w / 2)) {
			return (w / 2);
		} else {
			return h;
		}
	}

	public static double calculateclearingTimeTc(final double w,
			final double h, final double cr) {

		double S = parameterS(h, w);
		double G = parameterG(h, w);

		return (CONSTANT_A * S) / ((CONSTANT_B + (S / G)) * cr);

	}

}
