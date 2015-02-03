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
	 * @param ir
	 *            (alpha)
	 * @param pr
	 *            (alpha)
	 * @return
	 */
	public static double calculateEquivalentDurationWithIsAndPr(
			final double is, final double pr) {

		return (CONSTANT_A * is) / pr;
	}

}
