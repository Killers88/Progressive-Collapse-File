/**
 * 
 */
package edu.mit.civil.beamassessment.calculation;

/**
 * @author koleary
 *
 */
public class beamDesignForces {

	public static double Weight_Of_Steel = 2;
	public static double In_Squared_To_Feet = 0.00694444;
	public static double Fixed_Beam_Factor_Moment_UDL = 12;
	public static double Fixed_Beam_Factor_Moment_PT = 8;

	public static double maxBeamShear(final double span, final double trib,
			final double dead, final double live, final double daf,
			final double numstorys, final double dlfact, final double llfact) {

		double totptunfactdead = span * numstorys * dead * trib / 1000;

		double totptcolfactlive = span * numstorys * live * trib / 1000;

		double totfactloadwherecolremoved = totptunfactdead * dlfact
				+ totptcolfactlive * llfact;

		double firstdl = (dead * trib) / 1000;

		double firstll = (live * trib) / 1000;

		double totfactudlfirstfloor = firstdl * dlfact + firstll * llfact;

		double maxshear = (totfactloadwherecolremoved + (totfactudlfirstfloor * 2 * span))
				* daf / 2;

		return maxshear;

	}

	public static double maxBeamMoment(final double span, final double trib,
			final double dead, final double live, final double daf,
			final double numstorys, final double dlfact, final double llfact) {

		double totptunfactdead = span * numstorys * dead * trib / 1000;

		double totptcolfactlive = span * numstorys * live * trib / 1000;

		double totfactloadwherecolremoved = totptunfactdead * dlfact
				+ totptcolfactlive * llfact;

		double firstdl = (dead * trib) / 1000;

		double firstll = (live * trib) / 1000;

		double totfactudlfirstfloor = firstdl * dlfact + firstll * llfact;

		double maxmoment = ((totfactudlfirstfloor * (Math.pow(2 * span, 2)) / Fixed_Beam_Factor_Moment_UDL) + (totfactloadwherecolremoved * (2 * span))
				/ Fixed_Beam_Factor_Moment_PT)
				* daf;

		return maxmoment;
	}
}
