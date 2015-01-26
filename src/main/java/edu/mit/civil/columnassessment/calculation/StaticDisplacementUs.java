/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class StaticDisplacementUs {

	public static double calculateAppliedLoading(final double Q) {
		return Q;
	}

	public static double calculateColumnActualStiffness(final double K) {
		return K;
	}

	public static double CalculateStaticDisplacement(final double Q,
			final double K) {

		double q = calculateAppliedLoading(Q);
		double k = calculateColumnActualStiffness(K);

		return q / k;

	}

}
