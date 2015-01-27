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
		graph.put((double) 0.75, (double) 0.55);
		graph.put((double) 1, (double) 0.5);
		graph.put((double) 1.25, (double) 0.5);
		graph.put((double) 1.5, (double) 0.475);
		graph.put((double) 1.75, (double) 0.425);
		graph.put((double) 2, (double) 0.435);
		graph.put((double) 2.25, (double) 0.45);
		graph.put((double) 2.5, (double) 0.5);
		graph.put((double) 2.75, (double) 0.575);
		graph.put((double) 3, (double) 0.66);
		graph.put((double) 3.25, (double) 0.75);
		graph.put((double) 3.5, (double) 0.85);
		graph.put((double) 3.75, (double) 1);
		graph.put((double) 4, (double) 1.1);
		graph.put((double) 4.25, (double) 1.2);
		graph.put((double) 4.5, (double) 1.25);
		graph.put((double) 4.75, (double) 1.3);
		graph.put((double) 5, (double) 1.35);
		graph.put((double) 5.25, (double) 1.4);
		graph.put((double) 5.5, (double) 1.5);
		graph.put((double) 5.75, (double) 1.55);
		graph.put((double) 6, (double) 1.625);
		graph.put((double) 6.25, (double) 1.65);
		graph.put((double) 6.5, (double) 1.675);
		graph.put((double) 6.75, (double) 1.68);
		graph.put((double) 7, (double) 1.8);
		graph.put((double) 7.25, (double) 1.85);
		graph.put((double) 7.5, (double) 1.9);
		graph.put((double) 7.75, (double) 1.95);
		graph.put((double) 8, (double) 2);
		graph.put((double) 8.25, (double) 2);
		graph.put((double) 8.5, (double) 2.05);
		graph.put((double) 8.75, (double) 2.1);
		graph.put((double) 9, (double) 2.15);
		graph.put((double) 9.25, (double) 2.175);
		graph.put((double) 9.5, (double) 2.2);
		graph.put((double) 9.75, (double) 2.25);
		graph.put((double) 10, (double) 2.3);
		graph.put((double) 10.25, (double) 2.32);
		graph.put((double) 10.5, (double) 2.34);
		graph.put((double) 10.75, (double) 2.36);
		graph.put((double) 11, (double) 2.38);
		graph.put((double) 11.25, (double) 2.4);
		graph.put((double) 11.5, (double) 2.42);
		graph.put((double) 11.75, (double) 2.44);
		graph.put((double) 12, (double) 2.46);
		graph.put((double) 12.25, (double) 2.48);
		graph.put((double) 12.5, (double) 2.5);
		graph.put((double) 12.75, (double) 2.52);
		graph.put((double) 13, (double) 2.54);
		graph.put((double) 13.25, (double) 2.56);
		graph.put((double) 13.5, (double) 2.58);
		graph.put((double) 13.75, (double) 2.6);
		graph.put((double) 14, (double) 2.62);
		graph.put((double) 14.25, (double) 2.64);
		graph.put((double) 14.5, (double) 2.66);
		graph.put((double) 14.75, (double) 2.68);
		graph.put((double) 15, (double) 2.7);
		graph.put((double) 15.25, (double) 2.72);
		graph.put((double) 15.5, (double) 2.74);
		graph.put((double) 15.75, (double) 2.76);
		graph.put((double) 16, (double) 2.78);
		graph.put((double) 16.25, (double) 2.8);
		graph.put((double) 16.5, (double) 2.82);
		graph.put((double) 16.75, (double) 2.84);
		graph.put((double) 17, (double) 2.86);
		graph.put((double) 17.25, (double) 2.88);
		graph.put((double) 17.5, (double) 2.9);
		graph.put((double) 17.75, (double) 2.92);
		graph.put((double) 18, (double) 2.94);
		graph.put((double) 18.25, (double) 2.96);
		graph.put((double) 18.5, (double) 2.98);
		graph.put((double) 18.75, (double) 3);
		graph.put((double) 19, (double) 3.02);
		graph.put((double) 19.25, (double) 3.04);
		graph.put((double) 19.5, (double) 3.06);
		graph.put((double) 19.75, (double) 3.08);
		graph.put((double) 20, (double) 3.1);

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
