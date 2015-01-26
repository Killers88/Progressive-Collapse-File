package edu.mit.civil.blastassessment.calculation;

import java.util.HashMap;
import java.util.Map;

public class PeakIncidentOverPressurePso {

	/**
	 * Data Representation for GRAPH UFC 3-340 Fig 2.15 pg 166. In Increments of
	 * 0.25
	 */
	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {
		graph.put(0.25, (double) 4500);
		graph.put(0.5, (double) 2200);
		graph.put(0.75, (double) 1450);
		graph.put(1.0, (double) 850);
		graph.put(1.25, (double) 600);
		graph.put(1.5, (double) 450);
		graph.put(1.75, (double) 325);
		graph.put(2.0, (double) 225);
		graph.put(2.25, (double) 200);
		graph.put(2.5, (double) 160);
		graph.put(2.75, (double) 125);
		graph.put(3.0, (double) 90);
		graph.put(3.25, (double) 77.5);
		graph.put(3.5, (double) 65);
		graph.put(3.75, (double) 55);
		graph.put(4.0, (double) 45);
		graph.put(4.25, (double) 40);
		graph.put(4.5, (double) 35);
		graph.put(4.75, (double) 33);
		graph.put(5.0, (double) 28);
		graph.put(5.25, (double) 27.5);
		graph.put(5.5, (double) 25);
		graph.put(5.75, (double) 22.5);
		graph.put(6.0, (double) 19);
		graph.put(6.25, (double) 18);
		graph.put(6.5, (double) 17);
		graph.put(6.75, (double) 16);
		graph.put(7.0, (double) 14.5);
		graph.put(7.25, (double) 13.5);
		graph.put(7.5, (double) 12.5);
		graph.put(7.75, (double) 11.5);
		graph.put(8.0, (double) 10.5);
		graph.put(8.25, (double) 9.5);
		graph.put(8.5, (double) 9.25);
		graph.put(8.75, (double) 9);
		graph.put(9.0, (double) 8.25);
		graph.put(9.25, (double) 8);
		graph.put(9.5, (double) 7.5);
		graph.put(9.75, (double) 7.25);
		graph.put(10.0, (double) 6.9);
		graph.put(10.25, (double) 6.735);
		graph.put(10.5, (double) 6.57);
		graph.put(10.75, (double) 6.405);
		graph.put(11.0, (double) 6.24);
		graph.put(11.25, (double) 6.075);
		graph.put(11.5, (double) 5.91);
		graph.put(11.75, (double) 5.745);
		graph.put(12.0, (double) 5.58);
		graph.put(12.25, (double) 5.415);
		graph.put(12.5, (double) 5.25);
		graph.put(12.75, (double) 5.085);
		graph.put(13.0, (double) 4.92);
		graph.put(13.25, (double) 4.755);
		graph.put(13.5, (double) 4.59);
		graph.put(13.75, (double) 4.425);
		graph.put(14.0, (double) 4.26);
		graph.put(14.25, (double) 4.095);
		graph.put(14.5, (double) 3.93);
		graph.put(14.75, (double) 3.765);
		graph.put(15.0, (double) 3.6);
		graph.put(15.25, (double) 4.4325);
		graph.put(15.5, (double) 4.315);
		graph.put(15.75, (double) 4.1975);
		graph.put((double) 16, (double) 4.08);
		graph.put(16.25, (double) 3.9625);
		graph.put(16.5, (double) 3.845);
		graph.put(16.75, (double) 3.7275);
		graph.put((double) 17, (double) 3.61);
		graph.put(17.25, (double) 3.4925);
		graph.put(17.5, (double) 3.375);
		graph.put(17.75, (double) 3.2575);
		graph.put((double) 18, (double) 3.14);
		graph.put(18.25, (double) 3.0225);
		graph.put(18.5, (double) 2.905);
		graph.put(18.75, (double) 2.7875);
		graph.put((double) 19, (double) 2.67);
		graph.put(19.25, (double) 2.5525);
		graph.put(19.5, (double) 2.435);
		graph.put(19.75, (double) 2.3175);
		graph.put((double) 20, (double) 2.2);
	}

	/**
	 * Return Peak Incident Over-Pressure Pso
	 * 
	 * @param Z
	 * @return
	 */
	public static double findPeakIncidentOverPressureWith(final double Z) {
		// Check that Z is greater than 0
		if (Z > 0) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 4f;
			double nearestQuarterZ = Math.round(Z * coeff) / coeff;
			return (graph.get(nearestQuarterZ));
		}
		// TODO add logging here
		throw new RuntimeException("invalid Z value");
	}
}

/*
 * Equation used to calculate Pso - Not being used. Calculating via graph
 * interpolation instead as per above
 */
// public static double CONSTANT_808 = 808;
// public static double IMPERIAL_CONVERSION = 2.5208;
// public static double CONSTANT_A = 4.5;
// public static double CONSTANT_B = 0.048;
// public static double CONSTANT_C = 0.32;
// public static double CONSTANT_D = 1.35;
// // psi Po (Ambient Pressure @ sea level)
// public static double AMBIENT_PRESSURE = 14.696;
//
// /**
// * Return value for ambient pressure 'Po'
// *
// * @param Z
// * @param Po
// * @return
// */
// public static double calculatePsoWithPressure(final double Z,
// final double Po) {
//
// // Parameter checking to ensure parameters Z and constantVariation are
// // greater than 0
// if (Z > 0 && Po > 0) {
// double top = CONSTANT_808 * subCalcPso(Z, CONSTANT_A);
// double bottom = subCalcPso(Z, CONSTANT_B)
// * subCalcPso(Z, CONSTANT_C) * subCalcPso(Z, CONSTANT_D);
// bottom = Math.sqrt(bottom);
// return Po * (top / bottom);
// }
// // Handle invalid parameter
// throw new RuntimeException("invalid parameters passed in subCalc");
// }
//
// /**
// * Return value for ambient pressure @ sea level
// *
// * @param Z
// * @return
// */
// public static double calculatePso(final double Z) {
//
// return calculatePsoWithPressure(Z, AMBIENT_PRESSURE);
//
// }
//
// /**
// * This represents a sub-calculation for the overall calculation of 'Pso'
// *
// * @param Z
// * @param constantVariation
// * @return
// */
// private static double subCalcPso(final double Z,
// final double constantVariation) {
//
// // Parameter checking to ensure parameters Z and constantVariation are
// // greater than 0
// if (Z > 0 && constantVariation > 0) {
// return (1 + Math.pow(
// ((Z / IMPERIAL_CONVERSION) / constantVariation), 2));
// }
// // Handle invalid parameter
// throw new RuntimeException("invalid parameters passed in subCalc");
// }