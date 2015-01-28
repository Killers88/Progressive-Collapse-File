/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFElasticCheck {

	public static String determiningDynamicLoadFactor(final double um,
			final double uy) {

		if ((um <= uy)) {

			return "Column PASSES for specified blast parameters";

		} else {

			return "Exceeds Elastic limits, a Plastic check is required";

		}

	}
}
