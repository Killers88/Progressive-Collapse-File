/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koleary
 *
 */
public class WaveLengthLw {

	/**
	 * Data Representation for GRAPH UFC 3-340 Fig 2.15 pg 166. In Increments of
	 * 0.25 Return Lw/W^1/3
	 */
	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {
		graph.put((double) 0.25, (double) 0.39);
		graph.put((double) 0.5, (double) 0.5);
		graph.put((double) 0.75, (double) 0.58);
		graph.put((double) 1, (double) 0.56);
		graph.put((double) 1.25, (double) 0.55);
		graph.put((double) 1.5, (double) 0.525);
		graph.put((double) 1.75, (double) 0.5);
		graph.put((double) 2, (double) 0.49);
		graph.put((double) 2.25, (double) 0.49);
		graph.put((double) 2.5, (double) 0.5);
		graph.put((double) 2.75, (double) 0.55);
		graph.put((double) 3, (double) 0.635);
		graph.put((double) 3.25, (double) 0.7);
		graph.put((double) 3.5, (double) 0.8);
		graph.put((double) 3.75, (double) 0.9);
		graph.put((double) 4, (double) 1);
		graph.put((double) 4.25, (double) 1.1);
		graph.put((double) 4.5, (double) 1.2);
		graph.put((double) 4.75, (double) 1.3);
		graph.put((double) 5, (double) 1.4);
		graph.put((double) 5.25, (double) 1.45);
		graph.put((double) 5.5, (double) 1.5);
		graph.put((double) 5.75, (double) 1.55);
		graph.put((double) 6, (double) 1.6);
		graph.put((double) 6.25, (double) 1.65);
		graph.put((double) 6.5, (double) 1.7);
		graph.put((double) 6.75, (double) 1.75);
		graph.put((double) 7, (double) 1.8);
		graph.put((double) 7.25, (double) 1.85);
		graph.put((double) 7.5, (double) 1.9);
		graph.put((double) 7.75, (double) 1.95);
		graph.put((double) 8, (double) 2);
		graph.put((double) 8.25, (double) 2.05);
		graph.put((double) 8.5, (double) 2.1);
		graph.put((double) 8.75, (double) 2.15);
		graph.put((double) 9, (double) 2.2);
		graph.put((double) 9.25, (double) 2.25);
		graph.put((double) 9.5, (double) 2.3);
		graph.put((double) 9.75, (double) 2.35);
		graph.put((double) 10, (double) 2.4);
		graph.put((double) 10.25, (double) 2.43);
		graph.put((double) 10.5, (double) 2.46);
		graph.put((double) 10.75, (double) 2.49);
		graph.put((double) 11, (double) 2.52);
		graph.put((double) 11.25, (double) 2.55);
		graph.put((double) 11.5, (double) 2.58);
		graph.put((double) 11.75, (double) 2.61);
		graph.put((double) 12, (double) 2.64);
		graph.put((double) 12.25, (double) 2.67);
		graph.put((double) 12.5, (double) 2.7);
		graph.put((double) 12.75, (double) 2.73);
		graph.put((double) 13, (double) 2.76);
		graph.put((double) 13.25, (double) 2.79);
		graph.put((double) 13.5, (double) 2.82);
		graph.put((double) 13.75, (double) 2.85);
		graph.put((double) 14, (double) 2.88);
		graph.put((double) 14.25, (double) 2.91);
		graph.put((double) 14.5, (double) 2.94);
		graph.put((double) 14.75, (double) 2.97);
		graph.put((double) 15, (double) 3);
		graph.put((double) 15.25, (double) 3.02);
		graph.put((double) 15.5, (double) 3.04);
		graph.put((double) 15.75, (double) 3.06);
		graph.put((double) 16, (double) 3.08);
		graph.put((double) 16.25, (double) 3.1);
		graph.put((double) 16.5, (double) 3.12);
		graph.put((double) 16.75, (double) 3.14);
		graph.put((double) 17, (double) 3.16);
		graph.put((double) 17.25, (double) 3.18);
		graph.put((double) 17.5, (double) 3.2);
		graph.put((double) 17.75, (double) 3.22);
		graph.put((double) 18, (double) 3.24);
		graph.put((double) 18.25, (double) 3.26);
		graph.put((double) 18.5, (double) 3.28);
		graph.put((double) 18.75, (double) 3.3);
		graph.put((double) 19, (double) 3.32);
		graph.put((double) 19.25, (double) 3.34);
		graph.put((double) 19.5, (double) 3.36);
		graph.put((double) 19.75, (double) 3.38);
		graph.put((double) 20, (double) 3.4);
		graph.put((double) 20.25, (double) 3.41375);
		graph.put((double) 20.5, (double) 3.4275);
		graph.put((double) 20.75, (double) 3.44125);
		graph.put((double) 21, (double) 3.455);
		graph.put((double) 21.25, (double) 3.46875);
		graph.put((double) 21.5, (double) 3.4825);
		graph.put((double) 21.75, (double) 3.49625);
		graph.put((double) 22, (double) 3.51);
		graph.put((double) 22.25, (double) 3.52375);
		graph.put((double) 22.5, (double) 3.5375);
		graph.put((double) 22.75, (double) 3.55125);
		graph.put((double) 23, (double) 3.565);
		graph.put((double) 23.25, (double) 3.57875);
		graph.put((double) 23.5, (double) 3.5925);
		graph.put((double) 23.75, (double) 3.60625);
		graph.put((double) 24, (double) 3.62);
		graph.put((double) 24.25, (double) 3.63375);
		graph.put((double) 24.5, (double) 3.6475);
		graph.put((double) 24.75, (double) 3.66125);
		graph.put((double) 25, (double) 3.675);
		graph.put((double) 25.25, (double) 3.68875);
		graph.put((double) 25.5, (double) 3.7025);
		graph.put((double) 25.75, (double) 3.71625);
		graph.put((double) 26, (double) 3.73);
		graph.put((double) 26.25, (double) 3.74375);
		graph.put((double) 26.5, (double) 3.7575);
		graph.put((double) 26.75, (double) 3.77125);
		graph.put((double) 27, (double) 3.785);
		graph.put((double) 27.25, (double) 3.79875);
		graph.put((double) 27.5, (double) 3.8125);
		graph.put((double) 27.75, (double) 3.82625);
		graph.put((double) 28, (double) 3.84);
		graph.put((double) 28.25, (double) 3.85375);
		graph.put((double) 28.5, (double) 3.8675);
		graph.put((double) 28.75, (double) 3.88125);
		graph.put((double) 29, (double) 3.895);
		graph.put((double) 29.25, (double) 3.90875);
		graph.put((double) 29.5, (double) 3.9225);
		graph.put((double) 29.75, (double) 3.93625);
		graph.put((double) 30, (double) 3.95);
		graph.put((double) 30.25, (double) 3.95625);
		graph.put((double) 30.5, (double) 3.9625);
		graph.put((double) 30.75, (double) 3.96875);
		graph.put((double) 31, (double) 3.975);
		graph.put((double) 31.25, (double) 3.98125);
		graph.put((double) 31.5, (double) 3.9875);
		graph.put((double) 31.75, (double) 3.99375);
		graph.put((double) 32, (double) 4);
		graph.put((double) 32.25, (double) 4.00625);
		graph.put((double) 32.5, (double) 4.0125);
		graph.put((double) 32.75, (double) 4.01875);
		graph.put((double) 33, (double) 4.025);
		graph.put((double) 33.25, (double) 4.03125);
		graph.put((double) 33.5, (double) 4.0375);
		graph.put((double) 33.75, (double) 4.04375);
		graph.put((double) 34, (double) 4.05);
		graph.put((double) 34.25, (double) 4.05625);
		graph.put((double) 34.5, (double) 4.0625);
		graph.put((double) 34.75, (double) 4.06875);
		graph.put((double) 35, (double) 4.075);
		graph.put((double) 35.25, (double) 4.08125);
		graph.put((double) 35.5, (double) 4.0875);
		graph.put((double) 35.75, (double) 4.09375);
		graph.put((double) 36, (double) 4.1);
		graph.put((double) 36.25, (double) 4.10625);
		graph.put((double) 36.5, (double) 4.1125);
		graph.put((double) 36.75, (double) 4.11875);
		graph.put((double) 37, (double) 4.125);
		graph.put((double) 37.25, (double) 4.13125);
		graph.put((double) 37.5, (double) 4.1375);
		graph.put((double) 37.75, (double) 4.14375);
		graph.put((double) 38, (double) 4.15);
		graph.put((double) 38.25, (double) 4.15625);
		graph.put((double) 38.5, (double) 4.1625);
		graph.put((double) 38.75, (double) 4.16875);
		graph.put((double) 39, (double) 4.175);
		graph.put((double) 39.25, (double) 4.18125);
		graph.put((double) 39.5, (double) 4.1875);
		graph.put((double) 39.75, (double) 4.19375);
		graph.put((double) 40, (double) 4.2);

	}

	/**
	 * 
	 * @param z
	 * @param w
	 *            (Weight in TNT)
	 * @return
	 */
	public static double findWaveLengthWithZ(final double z, final double w) {
		// Check that Z is greater than 0
		if (z > 0) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 4f;
			double nearestQuarterZ = Math.round(z * coeff) / coeff;
			return (graph.get(nearestQuarterZ)) * Math.pow(w, 0.3333);
		}

		// TODO add logging here
		throw new RuntimeException("invalid Z value");
	}

}
