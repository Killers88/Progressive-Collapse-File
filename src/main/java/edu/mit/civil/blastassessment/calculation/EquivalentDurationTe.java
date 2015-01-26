/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

/**
 * @author koleary
 *
 */
public class EquivalentDurationTe {

	public static double CONSTANT_A = 2;

	/**
	 * Return Equivalent Time Duration
	 * 
	 * @param Is
	 * @param Pr
	 * @return
	 */
	public static double calculateEquivalentDurationWithIsAndPr(
			final double Is, final double Pr) {

		return (CONSTANT_A * Is) / Pr;
	}

}
