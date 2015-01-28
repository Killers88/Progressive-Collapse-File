package edu.mit.civil.blastassessment.calculation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koleary
 *
 */
public class PositivePhaseDurationTo {

	/**
	 * Data Representation for GRAPH UFC 3-340 Fig 2.15 pg 166. In Increments of
	 * 0.25 Return to/W^1/3
	 */
	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {

		graph.put((double) 0.25, (double) 0.175);
		graph.put((double) 0.5, (double) 0.15);
		graph.put((double) 0.75, (double) 0.15);
		graph.put((double) 1, (double) 0.185);
		graph.put((double) 1.25, (double) 0.2);
		graph.put((double) 1.5, (double) 0.3);
		graph.put((double) 1.75, (double) 0.6);
		graph.put((double) 2, (double) 0.97);
		graph.put((double) 2.25, (double) 1.3);
		graph.put((double) 2.5, (double) 1.45);
		graph.put((double) 2.75, (double) 1.45);
		graph.put((double) 3, (double) 1.4);
		graph.put((double) 3.25, (double) 1.375);
		graph.put((double) 3.5, (double) 1.3);
		graph.put((double) 3.75, (double) 1.3);
		graph.put((double) 4, (double) 1.3);
		graph.put((double) 4.25, (double) 1.3);
		graph.put((double) 4.5, (double) 1.325);
		graph.put((double) 4.75, (double) 1.35);
		graph.put((double) 5, (double) 1.4);
		graph.put((double) 5.25, (double) 1.5);
		graph.put((double) 5.5, (double) 1.6);
		graph.put((double) 5.75, (double) 1.65);
		graph.put((double) 6, (double) 1.75);
		graph.put((double) 6.25, (double) 1.8);
		graph.put((double) 6.5, (double) 1.9);
		graph.put((double) 6.75, (double) 1.95);
		graph.put((double) 7, (double) 2);
		graph.put((double) 7.25, (double) 2);
		graph.put((double) 7.5, (double) 2.1);
		graph.put((double) 7.75, (double) 2.15);
		graph.put((double) 8, (double) 2.175);
		graph.put((double) 8.25, (double) 2.19);
		graph.put((double) 8.5, (double) 2.2);
		graph.put((double) 8.75, (double) 2.25);
		graph.put((double) 9, (double) 2.28);
		graph.put((double) 9.25, (double) 2.3);
		graph.put((double) 9.5, (double) 2.325);
		graph.put((double) 9.75, (double) 2.35);
		graph.put((double) 10, (double) 2.375);
		graph.put((double) 10.25, (double) 2.390625);
		graph.put((double) 10.5, (double) 2.40625);
		graph.put((double) 10.75, (double) 2.421875);
		graph.put((double) 11, (double) 2.4375);
		graph.put((double) 11.25, (double) 2.453125);
		graph.put((double) 11.5, (double) 2.46875);
		graph.put((double) 11.75, (double) 2.484375);
		graph.put((double) 12, (double) 2.5);
		graph.put((double) 12.25, (double) 2.515625);
		graph.put((double) 12.5, (double) 2.53125);
		graph.put((double) 12.75, (double) 2.546875);
		graph.put((double) 13, (double) 2.5625);
		graph.put((double) 13.25, (double) 2.578125);
		graph.put((double) 13.5, (double) 2.59375);
		graph.put((double) 13.75, (double) 2.609375);
		graph.put((double) 14, (double) 2.625);
		graph.put((double) 14.25, (double) 2.640625);
		graph.put((double) 14.5, (double) 2.65625);
		graph.put((double) 14.75, (double) 2.671875);
		graph.put((double) 15, (double) 2.6875);
		graph.put((double) 15.25, (double) 2.703125);
		graph.put((double) 15.5, (double) 2.71875);
		graph.put((double) 15.75, (double) 2.734375);
		graph.put((double) 16, (double) 2.75);
		graph.put((double) 16.25, (double) 2.765625);
		graph.put((double) 16.5, (double) 2.78125);
		graph.put((double) 16.75, (double) 2.796875);
		graph.put((double) 17, (double) 2.8125);
		graph.put((double) 17.25, (double) 2.828125);
		graph.put((double) 17.5, (double) 2.84375);
		graph.put((double) 17.75, (double) 2.859375);
		graph.put((double) 18, (double) 2.875);
		graph.put((double) 18.25, (double) 2.890625);
		graph.put((double) 18.5, (double) 2.90625);
		graph.put((double) 18.75, (double) 2.921875);
		graph.put((double) 19, (double) 2.9375);
		graph.put((double) 19.25, (double) 2.953125);
		graph.put((double) 19.5, (double) 2.96875);
		graph.put((double) 19.75, (double) 2.984375);
		graph.put((double) 20, (double) 3);

	}

	/**
	 * Return Positive Phase Duration to
	 * 
	 * @param z
	 * @param w
	 *            (Weight of TNT)
	 * @return
	 */
	public static double findPositivePhaseDurationForZ(final double z,
			final double w) {
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
