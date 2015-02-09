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

	public static double maxBeamShear(final double spanlhs,
			final double spanrhs, final double trib, final double dl,
			final double ll, final double rdl, final double rll,
			final double daf, final double storys, final double dlfact,
			final double llfact) {

		double totptunfactdead = ((((spanlhs + spanrhs) / 2)
				* ((storys - 1) * dl) + rdl) * trib) / 1000;

		double totptcolfactlive = ((((spanlhs + spanrhs) / 2)
				* ((storys - 1) * ll) + rll) * trib) / 1000;

		double totfactloadwherecolremoved = totptunfactdead * dlfact
				+ totptcolfactlive * llfact;

		double firstdl = (dl * trib) / 1000;

		double firstll = (ll * trib) / 1000;

		double totfactudlfirstfloor = firstdl * dlfact + firstll * llfact;

		double maxshear = (totfactloadwherecolremoved + (totfactudlfirstfloor
				* (spanlhs + spanrhs) / 2))
				* daf / 2;

		return maxshear;

	}

	public static double maxBeamMoment(final double spanlhs,
			final double spanrhs, final double trib, final double dl,
			final double ll, final double rdl, final double rll,
			final double daf, final double storys, final double dlfact,
			final double llfact) {

		double totptunfactdead = ((((spanlhs + spanrhs) / 2)
				* ((storys - 1) * dl) + rdl) * trib) / 1000;

		double totptcolfactlive = ((((spanlhs + spanrhs) / 2)
				* ((storys - 1) * ll) + rll) * trib) / 1000;

		double totfactloadwherecolremoved = totptunfactdead * dlfact
				+ totptcolfactlive * llfact;

		double firstdl = (dl * trib) / 1000;

		double firstll = (ll * trib) / 1000;

		double totfactudlfirstfloor = firstdl * dlfact + firstll * llfact;

		double maxmoment = ((totfactudlfirstfloor
				* (Math.pow((spanlhs + spanrhs), 2)) / Fixed_Beam_Factor_Moment_UDL) + (totfactloadwherecolremoved * (spanlhs + spanrhs))
				/ Fixed_Beam_Factor_Moment_PT)
				* daf;

		return maxmoment;
	}
}
