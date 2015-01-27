/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class StaticDisplacementUs {

	public static double calculateAppliedLoading(final double q) {
		return q;
	}

	public static double calculateColumnActualStiffness(final double k) {
		return k;
	}

	public static double CalculateStaticDisplacement(final double q,
			final double k) {

		double Q = calculateAppliedLoading(q);
		double K = calculateColumnActualStiffness(k);

		return Q / K;

	}

}
