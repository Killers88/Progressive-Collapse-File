package edu.mit.civil.blastassessment.calculation;

public class SoundVelocityCr {

	public static double CONSTANT_A = -3;
	public static double CONSTANT_B = 0.0133;
	public static double CONSTANT_C = 1.1669;

	/**
	 * Return Sound Velocity 'Cr'
	 * 
	 * @param pso
	 *            (Peak incident over-pressure)
	 */
	public static double caculateCrWithPso(final double pso) {

		// Equation determine from plotting graph on excel, and retrieving the
		// polynomial equation
		return CONSTANT_A * Math.pow(10, -5) * (Math.pow(pso, 2)) + +CONSTANT_B
				* pso + CONSTANT_C;
	}

}
