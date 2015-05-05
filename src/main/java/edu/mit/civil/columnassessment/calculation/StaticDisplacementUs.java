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

	public static double CalculateStaticDisplacementPIN_PIN(final double q,
			final double k) {

		double Q = calculateAppliedLoading(q);
		double K = calculateColumnActualStiffness(k);

		return (Q / K) * 12;

	}

	public static double CalculateStaticDisplacementPIN_FIXED(final double q,
			final double e, final double i, final double l) {

		double Q = calculateAppliedLoading(q);
		double K = ActualStiffnessK.stiffnessPIN_FIXED(e, i, l);

		return (Q / K) * 12;

	}

	public static double CalculateStaticDisplacementFIXED_FIXED(final double q,
			final double e, final double i, final double l) {

		double Q = calculateAppliedLoading(q);
		double K = ActualStiffnessK.stiffnessFIX(e, i, l);

		return (Q / K) * 12;

	}

}
