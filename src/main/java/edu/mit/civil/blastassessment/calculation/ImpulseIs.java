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
public class ImpulseIs {

	/**
	 * Data Representation for GRAPH UFC 3-340 Fig 2.15 pg 166. In Increments of
	 * 0.25
	 */
	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {
		graph.put((double) 0.2, (double) 250);
		graph.put((double) 0.3, (double) 105);
		graph.put((double) 0.4, (double) 60);
		graph.put((double) 0.5, (double) 40);
		graph.put((double) 0.6, (double) 32);
		graph.put((double) 0.7, (double) 26);
		graph.put((double) 0.8, (double) 23.5);
		graph.put((double) 0.9, (double) 21);
		graph.put((double) 1, (double) 20);
		graph.put((double) 1.1, (double) 19.75);
		graph.put((double) 1.2, (double) 19.5);
		graph.put((double) 1.3, (double) 19.5);
		graph.put((double) 1.4, (double) 19.5);
		graph.put((double) 1.5, (double) 19.75);
		graph.put((double) 1.6, (double) 19.75);
		graph.put((double) 1.7, (double) 20);
		graph.put((double) 1.8, (double) 20.5);
		graph.put((double) 1.9, (double) 21.5);
		graph.put((double) 2, (double) 22.5);
		graph.put((double) 2.1, (double) 23.625);
		graph.put((double) 2.2, (double) 24.75);
		graph.put((double) 2.3, (double) 25.875);
		graph.put((double) 2.4, (double) 27);
		graph.put((double) 2.5, (double) 26.58333333);
		graph.put((double) 2.6, (double) 26.16666667);
		graph.put((double) 2.7, (double) 25.75);
		graph.put((double) 2.8, (double) 25.33333333);
		graph.put((double) 2.9, (double) 24.91666667);
		graph.put((double) 3, (double) 24.5);
		graph.put((double) 3.1, (double) 23.85714286);
		graph.put((double) 3.2, (double) 23.21428571);
		graph.put((double) 3.3, (double) 22.57142857);
		graph.put((double) 3.4, (double) 21.92857143);
		graph.put((double) 3.5, (double) 21.28571429);
		graph.put((double) 3.6, (double) 20.64285714);
		graph.put((double) 3.7, (double) 20);
		graph.put((double) 3.8, (double) 19.66);
		graph.put((double) 3.9, (double) 19.33);
		graph.put((double) 4, (double) 19);
		graph.put((double) 4.1, (double) 18.7);
		graph.put((double) 4.2, (double) 18.4);
		graph.put((double) 4.3, (double) 18.1);
		graph.put((double) 4.4, (double) 17.8);
		graph.put((double) 4.5, (double) 17.5);
		graph.put((double) 4.6, (double) 17.2);
		graph.put((double) 4.7, (double) 16.9);
		graph.put((double) 4.8, (double) 16.6);
		graph.put((double) 4.9, (double) 16.3);
		graph.put((double) 5, (double) 16);
		graph.put((double) 5.1, (double) 15.7);
		graph.put((double) 5.2, (double) 15.4);
		graph.put((double) 5.3, (double) 15.1);
		graph.put((double) 5.4, (double) 14.8);
		graph.put((double) 5.5, (double) 14.5);
		graph.put((double) 5.6, (double) 14.2);
		graph.put((double) 5.7, (double) 13.9);
		graph.put((double) 5.8, (double) 13.6);
		graph.put((double) 5.9, (double) 13.3);
		graph.put((double) 6, (double) 13);
		graph.put((double) 6.1, (double) 12.8);
		graph.put((double) 6.2, (double) 12.6);
		graph.put((double) 6.3, (double) 12.4);
		graph.put((double) 6.4, (double) 12.2);
		graph.put((double) 6.5, (double) 12);
		graph.put((double) 6.6, (double) 11.8);
		graph.put((double) 6.7, (double) 11.6);
		graph.put((double) 6.8, (double) 11.4);
		graph.put((double) 6.9, (double) 11.2);
		graph.put((double) 7, (double) 11);
		graph.put((double) 7.1, (double) 10.9);
		graph.put((double) 7.2, (double) 10.8);
		graph.put((double) 7.3, (double) 10.7);
		graph.put((double) 7.4, (double) 10.6);
		graph.put((double) 7.5, (double) 10.5);
		graph.put((double) 7.6, (double) 10.4);
		graph.put((double) 7.7, (double) 10.3);
		graph.put((double) 7.8, (double) 10.2);
		graph.put((double) 7.9, (double) 10.1);
		graph.put((double) 8, (double) 10);
		graph.put((double) 8.1, (double) 9.88);
		graph.put((double) 8.2, (double) 9.76);
		graph.put((double) 8.3, (double) 9.64);
		graph.put((double) 8.4, (double) 9.52);
		graph.put((double) 8.5, (double) 9.4);
		graph.put((double) 8.6, (double) 9.28);
		graph.put((double) 8.7, (double) 9.16);
		graph.put((double) 8.8, (double) 9.04);
		graph.put((double) 8.9, (double) 8.92);
		graph.put((double) 9, (double) 8.8);
		graph.put((double) 9.1, (double) 8.72);
		graph.put((double) 9.2, (double) 8.64);
		graph.put((double) 9.3, (double) 8.56);
		graph.put((double) 9.4, (double) 8.48);
		graph.put((double) 9.5, (double) 8.4);
		graph.put((double) 9.6, (double) 8.32);
		graph.put((double) 9.7, (double) 8.24);
		graph.put((double) 9.8, (double) 8.16);
		graph.put((double) 9.9, (double) 8.08);
		graph.put((double) 10, (double) 8);
	}

	/**
	 * Return Peak Incident Over-Pressure Pso
	 * 
	 * @param z
	 * @return
	 */
	public static double findPeakImpulseIsWith(final double z, final double w) {
		// Check that Z is greater than 0
		if (z > 0) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 10f;
			double nearestTenthZ = Math.round(z * coeff) / 10.0;
			return (graph.get(nearestTenthZ) * Math.pow(w, 0.3333));
		}
		// TODO add logging here
		throw new RuntimeException("invalid Z value - Range 0.25 to 40");
	}

}
