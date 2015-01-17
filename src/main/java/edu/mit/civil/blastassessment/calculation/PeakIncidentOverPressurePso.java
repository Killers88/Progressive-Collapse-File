package edu.mit.civil.blastassessment.calculation;

public class PeakIncidentOverPressurePso {

	public static double CONSTANT_808 = 808;
	public static double IMPERIAL_CONVERSION = 2.5208;
	public static double CONSTANT_A = 4.5;
	public static double CONSTANT_B = 0.048;
	public static double CONSTANT_C = 0.32;
	public static double CONSTANT_D = 1.35;
	// psi Po (Ambient Pressure @ sea level)
	public static double AMBIENT_PRESSURE = 14.696;

	/**
	 * Return value for ambient pressure 'Po'
	 * 
	 * @param Z
	 * @param Po
	 * @return
	 */
	public static double calculatePsoWithPressure(final double Z,
			final double Po) {

		// Parameter checking to ensure parameters Z and constantVariation are
		// greater than 0
		if (Z > 0 && Po > 0) {
			double top = 808 * subCalcPso(Z, CONSTANT_A);
			double bottom = subCalcPso(Z, CONSTANT_B)
					* subCalcPso(Z, CONSTANT_C) * subCalcPso(Z, CONSTANT_D);
			bottom = Math.sqrt(bottom);
			return Po * (top / bottom);
		}
		// Handle invalid parameter
		throw new RuntimeException("invalid parameters passed in subCalc");
	}

	/**
	 * Return value for ambient pressure @ sea level
	 * 
	 * @param Z
	 * @return
	 */
	public static double calculatePso(final double Z) {

		return calculatePsoWithPressure(Z, AMBIENT_PRESSURE);

	}

	/**
	 * This represents a sub-calculation for the overall calculation of 'Pso'
	 * 
	 * @param Z
	 * @param constantVariation
	 * @return
	 */
	private static double subCalcPso(final double Z,
			final double constantVariation) {

		// Parameter checking to ensure parameters Z and constantVariation are
		// greater than 0
		if (Z > 0 && constantVariation > 0) {
			return (1 + Math.pow(
					((Z / IMPERIAL_CONVERSION) / constantVariation), 2));
		}
		// Handle invalid parameter
		throw new RuntimeException("invalid parameters passed in subCalc");
	}
}
