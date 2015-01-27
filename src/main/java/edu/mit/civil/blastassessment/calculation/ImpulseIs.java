/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

/**
 * @author koleary
 *
 */
public class ImpulseIs {

	public static double CONSTANT_A = 0.5;

	/**
	 * Return Impulse
	 * 
	 * @param pr
	 * @param ps
	 * @param tc
	 * @param to
	 * @return
	 */
	public static double calculateImpulseIsWithPrPsTcTo(final double pr,
			final double ps, final double tc, final double to) {

		return CONSTANT_A * (pr - ps) * tc + CONSTANT_A * ps * to;// psi - ms;

	}

}
