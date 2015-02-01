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
		graph.put((double) 0.25, (double) 5500);
		graph.put((double) 0.5, (double) 2600);
		graph.put((double) 0.75, (double) 1550);
		graph.put((double) 1, (double) 1000);
		graph.put((double) 1.25, (double) 750);
		graph.put((double) 1.5, (double) 550);
		graph.put((double) 1.75, (double) 400);
		graph.put((double) 2, (double) 300);
		graph.put((double) 2.25, (double) 260);
		graph.put((double) 2.5, (double) 220);
		graph.put((double) 2.75, (double) 180);
		graph.put((double) 3, (double) 140);
		graph.put((double) 3.25, (double) 120);
		graph.put((double) 3.5, (double) 100);
		graph.put((double) 3.75, (double) 85);
		graph.put((double) 4, (double) 70);
		graph.put((double) 4.25, (double) 62.5);
		graph.put((double) 4.5, (double) 55);
		graph.put((double) 4.75, (double) 50);
		graph.put((double) 5, (double) 44);
		graph.put((double) 5.25, (double) 37.5);
		graph.put((double) 5.5, (double) 35);
		graph.put((double) 5.75, (double) 32);
		graph.put((double) 6, (double) 28);
		graph.put((double) 6.25, (double) 26);
		graph.put((double) 6.5, (double) 24);
		graph.put((double) 6.75, (double) 22);
		graph.put((double) 7, (double) 20);
		graph.put((double) 7.25, (double) 19);
		graph.put((double) 7.5, (double) 18);
		graph.put((double) 7.75, (double) 17);
		graph.put((double) 8, (double) 16);
		graph.put((double) 8.25, (double) 15);
		graph.put((double) 8.5, (double) 14.5);
		graph.put((double) 8.75, (double) 14.35);
		graph.put((double) 9, (double) 12.5);
		graph.put((double) 9.25, (double) 11.75);
		graph.put((double) 9.5, (double) 11);
		graph.put((double) 9.75, (double) 10.25);
		graph.put((double) 10, (double) 9.5);
		graph.put((double) 10.25, (double) 9.3375);
		graph.put((double) 10.5, (double) 9.175);
		graph.put((double) 10.75, (double) 9.0125);
		graph.put((double) 11, (double) 8);
		graph.put((double) 11.25, (double) 7.75);
		graph.put((double) 11.5, (double) 7.5);
		graph.put((double) 11.75, (double) 7.25);
		graph.put((double) 12, (double) 7);
		graph.put((double) 12.25, (double) 6.75);
		graph.put((double) 12.5, (double) 6.5);
		graph.put((double) 12.75, (double) 6.25);
		graph.put((double) 13, (double) 6);
		graph.put((double) 13.25, (double) 5.875);
		graph.put((double) 13.5, (double) 5.75);
		graph.put((double) 13.75, (double) 5.625);
		graph.put((double) 14, (double) 5.5);
		graph.put((double) 14.25, (double) 5.375);
		graph.put((double) 14.5, (double) 5.25);
		graph.put((double) 14.75, (double) 5.125);
		graph.put((double) 15, (double) 5);
		graph.put((double) 15.25, (double) 4.875);
		graph.put((double) 15.5, (double) 4.75);
		graph.put((double) 15.75, (double) 4.625);
		graph.put((double) 16, (double) 4.5);
		graph.put((double) 16.25, (double) 4.375);
		graph.put((double) 16.5, (double) 4.25);
		graph.put((double) 16.75, (double) 4.125);
		graph.put((double) 17, (double) 4);
		graph.put((double) 17.25, (double) 3.9);
		graph.put((double) 17.5, (double) 3.8);
		graph.put((double) 17.75, (double) 3.7);
		graph.put((double) 18, (double) 3.6);
		graph.put((double) 18.25, (double) 3.5);
		graph.put((double) 18.5, (double) 3.4);
		graph.put((double) 18.75, (double) 3.3);
		graph.put((double) 19, (double) 3.2);
		graph.put((double) 19.25, (double) 3.15);
		graph.put((double) 19.5, (double) 3.1);
		graph.put((double) 19.75, (double) 3.05);
		graph.put((double) 20, (double) 3);
		graph.put((double) 20.25, (double) 2.958333333);
		graph.put((double) 20.5, (double) 2.916666667);
		graph.put((double) 20.75, (double) 2.875);
		graph.put((double) 21, (double) 2.833333333);
		graph.put((double) 21.25, (double) 2.791666667);
		graph.put((double) 21.5, (double) 2.75);
		graph.put((double) 21.75, (double) 2.708333333);
		graph.put((double) 22, (double) 2.666666667);
		graph.put((double) 22.25, (double) 2.625);
		graph.put((double) 22.5, (double) 2.583333333);
		graph.put((double) 22.75, (double) 2.541666667);
		graph.put((double) 23, (double) 2.5);
		graph.put((double) 23.25, (double) 2.458333333);
		graph.put((double) 23.5, (double) 2.416666667);
		graph.put((double) 23.75, (double) 2.375);
		graph.put((double) 24, (double) 2.333333333);
		graph.put((double) 24.25, (double) 2.291666667);
		graph.put((double) 24.5, (double) 2.25);
		graph.put((double) 24.75, (double) 2.208333333);
		graph.put((double) 25, (double) 2.166666667);
		graph.put((double) 25.25, (double) 2.125);
		graph.put((double) 25.5, (double) 2.083333333);
		graph.put((double) 25.75, (double) 2.041666667);
		graph.put((double) 26, (double) 2);
		graph.put((double) 26.25, (double) 1.9875);
		graph.put((double) 26.5, (double) 1.975);
		graph.put((double) 26.75, (double) 1.9625);
		graph.put((double) 27, (double) 1.95);
		graph.put((double) 27.25, (double) 1.9375);
		graph.put((double) 27.5, (double) 1.925);
		graph.put((double) 27.75, (double) 1.9125);
		graph.put((double) 28, (double) 1.9);
		graph.put((double) 28.25, (double) 1.8875);
		graph.put((double) 28.5, (double) 1.875);
		graph.put((double) 28.75, (double) 1.8625);
		graph.put((double) 29, (double) 1.85);
		graph.put((double) 29.25, (double) 1.8375);
		graph.put((double) 29.5, (double) 1.825);
		graph.put((double) 29.75, (double) 1.8125);
		graph.put((double) 30, (double) 1.8);
		graph.put((double) 30.25, (double) 1.78625);
		graph.put((double) 30.5, (double) 1.7725);
		graph.put((double) 30.75, (double) 1.75875);
		graph.put((double) 31, (double) 1.745);
		graph.put((double) 31.25, (double) 1.73125);
		graph.put((double) 31.5, (double) 1.7175);
		graph.put((double) 31.75, (double) 1.70375);
		graph.put((double) 32, (double) 1.69);
		graph.put((double) 32.25, (double) 1.67625);
		graph.put((double) 32.5, (double) 1.6625);
		graph.put((double) 32.75, (double) 1.64875);
		graph.put((double) 33, (double) 1.635);
		graph.put((double) 33.25, (double) 1.62125);
		graph.put((double) 33.5, (double) 1.6075);
		graph.put((double) 33.75, (double) 1.59375);
		graph.put((double) 34, (double) 1.58);
		graph.put((double) 34.25, (double) 1.56625);
		graph.put((double) 34.5, (double) 1.5525);
		graph.put((double) 34.75, (double) 1.53875);
		graph.put((double) 35, (double) 1.525);
		graph.put((double) 35.25, (double) 1.51125);
		graph.put((double) 35.5, (double) 1.4975);
		graph.put((double) 35.75, (double) 1.48375);
		graph.put((double) 36, (double) 1.47);
		graph.put((double) 36.25, (double) 1.45625);
		graph.put((double) 36.5, (double) 1.4425);
		graph.put((double) 36.75, (double) 1.42875);
		graph.put((double) 37, (double) 1.415);
		graph.put((double) 37.25, (double) 1.40125);
		graph.put((double) 37.5, (double) 1.3875);
		graph.put((double) 37.75, (double) 1.37375);
		graph.put((double) 38, (double) 1.36);
		graph.put((double) 38.25, (double) 1.34625);
		graph.put((double) 38.5, (double) 1.3325);
		graph.put((double) 38.75, (double) 1.31875);
		graph.put((double) 39, (double) 1.305);
		graph.put((double) 39.25, (double) 1.29125);
		graph.put((double) 39.5, (double) 1.2775);
		graph.put((double) 39.75, (double) 1.26375);
		graph.put((double) 40, (double) 1.25);
	}

	/**
	 * Return Peak Incident Over-Pressure Pso
	 * 
	 * @param z
	 * @return
	 */
	public static double findPeakIncidentOverPressureWith(final double z) {
		// Check that Z is greater than 0
		if (z > 0) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 4f;
			double nearestQuarterZ = Math.round(z * coeff) / coeff;
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