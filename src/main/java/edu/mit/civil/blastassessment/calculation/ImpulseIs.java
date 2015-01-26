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
	 * @param Pr
	 * @param Ps
	 * @param tc
	 * @param to
	 * @return
	 */
	public static double calculateImpulseIsWithPrPsTcTo(final double Pr,
			final double Ps, final double tc, final double to) {

		return CONSTANT_A * (Pr - Ps) * tc + CONSTANT_A * Ps * to;// psi - ms;

	}

}
