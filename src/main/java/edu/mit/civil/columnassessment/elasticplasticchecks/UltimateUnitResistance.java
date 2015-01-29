/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class UltimateUnitResistance {

	public static double CONSTANT_A = 8;
	public static double Dynamic_Increase_Factor = 1.29;
	public static double Strength_Increase_Factor = 1.1;

	public static double calculatingPlasticMoment(final double fyi,
			final double z, final double colheight) {

		return (CONSTANT_A * ((Dynamic_Increase_Factor
				* Strength_Increase_Factor * fyi) * z))
				/ (Math.pow(colheight, 2));

	}
}
