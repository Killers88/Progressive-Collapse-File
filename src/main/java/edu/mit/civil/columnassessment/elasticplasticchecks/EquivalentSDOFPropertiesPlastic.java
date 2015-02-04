/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFPropertiesPlastic {

	public static double Load_Factor_PLASTIC = 0.5;
	public static double Mass_Factor_PLASTIC = 0.33;
	public static double CONSTANT_A = 2;

	public static double stiffnessOfEquivSDOF(final double k) {

		return Load_Factor_PLASTIC * k;
	}

	public static double massOfEquivSDOF(final double m) {

		return Mass_Factor_PLASTIC * m;
	}

	public static double naturalPeriodSDOF(final double m, final double k) {

		return CONSTANT_A * Math.PI * (Math.sqrt(m / k));
	}

}
