/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFElasticResponseA {

	public static double CONSTANT_A = 0.4562;
	public static double CONSTANT_B = 0.4517;

	public static double determiningDynamicLoadFactor(final double a) {

		if ((a > 0.06) && (a < 1)) {

			return CONSTANT_A * Math.pow(a, -0.8);

		} else if ((a > 0.9) && (a < 10)) {

			return CONSTANT_B * Math.pow(a, -0.975);

		}

		throw new RuntimeException("invalid Z value");

	}

	public static double elasticResponseParameterCheck(final double a,
			final double t) {

		double A = determiningDynamicLoadFactor(a);

		return A * t;
	}

}
