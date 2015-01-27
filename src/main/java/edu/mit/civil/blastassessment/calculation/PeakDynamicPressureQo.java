package edu.mit.civil.blastassessment.calculation;

/**
 * 
 * @author koleary
 *
 */
public class PeakDynamicPressureQo {

	public static double CONSTANT_A = 0.0099;
	public static double CONSTANT_B = 0.319;
	public static double CONSTANT_C = 1.2759;
	public static double CONSTANT_D = 7e-15;
	public static double CONSTANT_E = 25;
	public static double CONSTANT_F = 2400;

	/**
	 * Return Peak Dynamic Pressure 'qo' Could also use UFC 3-340 Fig 2.3 pg 155
	 * GRAPH
	 * 
	 * @param pso
	 * @return
	 */
	public static double calculatQoWithPso(final double pso) {

		if (pso < 100) {

			return CONSTANT_A * Math.pow(pso, 2) + CONSTANT_B * pso
					+ CONSTANT_C;// psi;

		} else if ((pso > 100) && (pso < 130)) {

			return CONSTANT_D * Math.pow(pso, 2) + CONSTANT_E * pso
					- CONSTANT_F;// psi;
		}
		return 0;
	}

}
