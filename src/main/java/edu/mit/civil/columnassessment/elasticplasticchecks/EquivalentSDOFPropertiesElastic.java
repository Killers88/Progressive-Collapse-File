/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */

public class EquivalentSDOFPropertiesElastic {

	public static double Load_Factor_ELASTIC = 0.64;
	public static double Mass_Factor_ELASTIC = 0.5;
	public static double CONSTANT_A = 2;

	public static double stiffnessOfEquivSDOF(final double k) {

		return Load_Factor_ELASTIC * k;
	}

	public static double massOfEquivSDOF(final double m) {

		return Mass_Factor_ELASTIC * m;
	}

	public static double naturalPeriodSDOF(final double m, final double k) {

		double K = stiffnessOfEquivSDOF(k);
		double M = massOfEquivSDOF(m);

		return CONSTANT_A * Math.PI * (Math.sqrt(M / K));
	}

	public static double stiffnessOfEquivSDOFFIX(final double k) {

		return Load_Factor_ELASTIC * k;
	}

	public static double massOfEquivSDOFFIX(final double m) {

		return Mass_Factor_ELASTIC * m;
	}

	public static double naturalPeriodSDOFFIX(final double m, final double k) {

		double K = stiffnessOfEquivSDOF(k);
		double M = massOfEquivSDOF(m);

		return CONSTANT_A * Math.PI * (Math.sqrt(M / K));
	}

}
