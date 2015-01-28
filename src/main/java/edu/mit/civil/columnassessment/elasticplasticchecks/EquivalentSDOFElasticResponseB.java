/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFElasticResponseB {

	public static double CONSTANT_A = 0.7066;
	public static double CONSTANT_B = 3.0168;
	public static double CONSTANT_C = 0.0081;
	public static double CONSTANT_D = 1.8209;
	public static double CONSTANT_E = 3.2751;
	public static double CONSTANT_F = 0.0113;
	public static double CONSTANT_G = 0.0084;
	public static double CONSTANT_H = 0.1268;
	public static double CONSTANT_I = 1.4989;

	public static double determiningDynamicLoadFactor(final double a) {

		if (a < 0.1) {

			return -CONSTANT_A * Math.pow(a, 2) + CONSTANT_B * a + CONSTANT_C;

		} else if ((a > 0.1) && (a < 0.9)) {

			return -CONSTANT_D * Math.pow(a, 2) + CONSTANT_E * a + CONSTANT_F;

		} else if ((a > 0.9) && (a < 10)) {

			return -CONSTANT_G * Math.pow(a, 2) + CONSTANT_H * a + CONSTANT_I;

		}
		throw new RuntimeException("invalid Z value");

	}

	public static double elasticResponseParameterCheck(final double a,
			final double us) {

		double A = determiningDynamicLoadFactor(a);

		return A * us;
	}
}
