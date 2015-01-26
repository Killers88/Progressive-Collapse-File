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
	 * @param Pso
	 * @param qo
	 * @return
	 */
	public static double calculateStagnationPressureWithPsoandqo(
			final double Pso, final double qo) {

		return Pso + qo;// psi;

	}

}
