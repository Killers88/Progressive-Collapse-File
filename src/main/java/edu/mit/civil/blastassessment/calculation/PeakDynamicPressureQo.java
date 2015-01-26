package edu.mit.civil.blastassessment.calculation;

/**
 * 
 * @author koleary
 *
 */
public class PeakDynamicPressureQo {

	public static double CONSTANT_A = 0.022;

	/**
	 * Return Peak Dynamic Pressure 'qo' Could also use UFC 3-340 Fig 2.3 pg 155
	 * GRAPH
	 * 
	 * @param Pso
	 * @return
	 */
	public static double calculatQoWithPso(final double Pso) {

		return CONSTANT_A * Math.pow(Pso, 2);// psi;
	}

}
