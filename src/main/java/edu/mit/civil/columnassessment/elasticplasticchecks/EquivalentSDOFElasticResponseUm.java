/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFElasticResponseUm {

	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {

		graph.put((double) 0.02, (double) 0.07);
		graph.put((double) 0.03, (double) 0.1);
		graph.put((double) 0.04, (double) 0.125);
		graph.put((double) 0.05, (double) 0.15);
		graph.put((double) 0.06, (double) 0.175);
		graph.put((double) 0.07, (double) 0.19);
		graph.put((double) 0.08, (double) 0.2);
		graph.put((double) 0.09, (double) 0.25);
		graph.put((double) 0.1, (double) 0.275);
		graph.put((double) 0.11, (double) 0.307142857);
		graph.put((double) 0.12, (double) 0.339285714);
		graph.put((double) 0.13, (double) 0.371428571);
		graph.put((double) 0.14, (double) 0.403571429);
		graph.put((double) 0.15, (double) 0.435714286);
		graph.put((double) 0.16, (double) 0.467857143);
		graph.put((double) 0.17, (double) 0.5);
		graph.put((double) 0.18, (double) 0.533333333);
		graph.put((double) 0.19, (double) 0.566666667);
		graph.put((double) 0.2, (double) 0.6);
		graph.put((double) 0.21, (double) 0.625);
		graph.put((double) 0.22, (double) 0.65);
		graph.put((double) 0.23, (double) 0.675);
		graph.put((double) 0.24, (double) 0.7);
		graph.put((double) 0.25, (double) 0.725);
		graph.put((double) 0.26, (double) 0.75);
		graph.put((double) 0.27, (double) 0.775);
		graph.put((double) 0.28, (double) 0.8);
		graph.put((double) 0.29, (double) 0.825);
		graph.put((double) 0.3, (double) 0.85);
		graph.put((double) 0.31, (double) 0.87125);
		graph.put((double) 0.32, (double) 0.8925);
		graph.put((double) 0.33, (double) 0.91375);
		graph.put((double) 0.34, (double) 0.935);
		graph.put((double) 0.35, (double) 0.95625);
		graph.put((double) 0.36, (double) 0.9775);
		graph.put((double) 0.37, (double) 0.99875);
		graph.put((double) 0.38, (double) 1.02);
		graph.put((double) 0.39, (double) 1.04125);
		graph.put((double) 0.4, (double) 1.0625);
		graph.put((double) 0.5, (double) 1.1875);
		graph.put((double) 0.6, (double) 1.275);
		graph.put((double) 0.7, (double) 1.325);
		graph.put((double) 0.8, (double) 1.425);
		graph.put((double) 0.9, (double) 1.5);
		graph.put((double) 1, (double) 1.508);
		graph.put((double) 1.1, (double) 1.534888889);
		graph.put((double) 1.2, (double) 1.559088889);
		graph.put((double) 1.3, (double) 1.583288889);
		graph.put((double) 1.4, (double) 1.607488889);
		graph.put((double) 1.5, (double) 1.631688889);
		graph.put((double) 1.6, (double) 1.655888889);
		graph.put((double) 1.7, (double) 1.680088889);
		graph.put((double) 1.8, (double) 1.704288889);
		graph.put((double) 1.9, (double) 1.728488889);
		graph.put((double) 2, (double) 1.75);
		graph.put((double) 2.1, (double) 1.755);
		graph.put((double) 2.2, (double) 1.76);
		graph.put((double) 2.3, (double) 1.765);
		graph.put((double) 2.4, (double) 1.77);
		graph.put((double) 2.5, (double) 1.775);
		graph.put((double) 2.6, (double) 1.78);
		graph.put((double) 2.7, (double) 1.785);
		graph.put((double) 2.8, (double) 1.79);
		graph.put((double) 2.9, (double) 1.795);
		graph.put((double) 3, (double) 1.8);
		graph.put((double) 4, (double) 1.86);
		graph.put((double) 5, (double) 1.875);
		graph.put((double) 6, (double) 1.89);
		graph.put((double) 7, (double) 1.9);
		graph.put((double) 8, (double) 1.91);
		graph.put((double) 9, (double) 1.92);
		graph.put((double) 10, (double) 1.94);
	}

	public static double findPeakResponseParameter(final double x) {

		if ((x > 0) && (x <= 0.39)) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 100f;
			double nearestValue = (Math.round(x * coeff) / 100.0);
			return (graph.get(nearestValue));
		} else if ((x > 0.39) && (x <= 2.9)) {
			float coeff = 10f;
			double nearestValue = (Math.round(x * coeff) / 10.0);
			return (graph.get(nearestValue));
		} else if ((x > 3) && (x < 10.1)) {
			float coeff = 1f;
			double nearestValue = (Math.round(x * coeff) / 1.0);
			return (graph.get(nearestValue));
		}

		// TODO add logging here
		throw new RuntimeException("invalid T/Tn value. RANGE, 0.02 to 10");
	}

	public static double elasticResponseParameterCheck(final double x,
			final double us) {

		double A = findPeakResponseParameter(x);

		return A * us;
	}

}
