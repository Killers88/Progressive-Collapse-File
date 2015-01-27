/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

/**
 * @author koleary
 *
 */
public class StagnationPressurePs {

	/**
	 * Return Stagnation Pressure
	 * 
	 * @param pso
	 * @param qo
	 * @return
	 */
	public static double calculateStagnationPressureWithPsoandqo(
			final double pso, final double qo) {

		return pso + qo;// psi;

	}

}
