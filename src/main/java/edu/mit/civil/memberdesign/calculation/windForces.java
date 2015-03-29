/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

/**
 * @author koleary
 *
 */
public class windForces {

	public static Double windPressure(final double colhgt,
			final double numstorys, final double loadwidth) {

		double designPressure = 0;
		double z = 0;

		while (z <= numstorys) {

			double floorHgt = z * colhgt;

			double floorLoad = 0.067 * Math.pow((floorHgt / 1200), 0.2857)
					* colhgt * loadwidth;

			designPressure = floorLoad + designPressure;

			if (z == numstorys) {
				return designPressure;
			}
			z++;
		}
		return 0.0;
	}

	public static Double intMoment(final double colhgt, final double numstorys,
			final double loadwidth, final double bays) {

		double baseShear = windForces
				.windPressure(colhgt, numstorys, loadwidth);

		/**
		 * Pin Bases
		 */

		double shearRatioExtToInt = 0.89;

		double intshear = baseShear
				* (1 / (2 * shearRatioExtToInt + (bays - 1)));

		return colhgt * intshear;
	}

	public static Double extMoment(final double colhgt, final double numstorys,
			final double loadwidth, final double bays) {

		double baseShear = windForces
				.windPressure(colhgt, numstorys, loadwidth);

		/**
		 * Pin Bases
		 */

		double shearRatioExtToInt = 0.89;

		double extshear = baseShear
				* (1 / (2 + (bays - 1) * (1 / shearRatioExtToInt)));

		return colhgt * extshear;
	}

	public static Double axialInt(final double span, final double trib,
			final double sdl, final double live, final double numstorys) {

		double ultUdl = trib * ((sdl * 1.0) / 1000);

		return span * numstorys * ultUdl;

	}

	public static Double axialExt(final double span, final double trib,
			final double sdl, final double live, final double numstorys) {

		double ultUdl = trib * ((sdl * 1.0) / 1000);

		return span * numstorys * ultUdl * 0.5;

	}

	public static Double beamAxialForce(final double colhgt,
			final double numstorys, final double loadwidth) {

		return 0.067 * Math.pow((colhgt / 1200), 0.2857) * colhgt * loadwidth;

	}
}
