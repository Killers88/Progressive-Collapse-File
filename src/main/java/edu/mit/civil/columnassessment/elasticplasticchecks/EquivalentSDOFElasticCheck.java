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

			return "'um' <= 'uy', therefore Column PASSES for specified blast parameters";

		}

		else {

			return "'um' > 'uy', therefore EXCEEDS Elastic limits, a Plastic check is required. % utilisation "
					+ ((um - uy) / uy) * 100;

		}
	}

	// public static String programFinish(final double um, final double uy) {
	//
	// if ((um < uy)) {
	//
	// System.exit(0);
	//
	// }
	// return "COLUMN - PLASTIC ASSESSMENT:";
	// }
}
