/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

/**
 * @author koleary
 *
 */
public class windForces {

	public static Double designWindPressure(final double colhgt,
			final double numstorys, final double loadwidth,
			final double windspeed) {

		double designPressure = 0;
		double z = 0;

		while (z <= numstorys) {

			double floorHgt = z * colhgt;

			double floorLoad = 0.0000037614 * Math.pow(windspeed, 2)
					* Math.pow((floorHgt / 1200), 0.2857);

			designPressure = floorLoad + designPressure;

			if (z == numstorys) {
				return (designPressure / numstorys) * 1000;
			}
			z++;
		}
		return 0.0;
	}

	public static Double windPressure(final double colhgt,
			final double numstorys, final double loadwidth,
			final double windspeed) {

		double designPressure = 0;
		double z = 1;

		while (z <= numstorys) {

			double floorHgt = z * colhgt;

			double floorLoad = 0.0000037614 * Math.pow(windspeed, 2)
					* Math.pow((floorHgt / 1200), 0.2857) * colhgt * loadwidth;

			designPressure = floorLoad + designPressure;

			if (z == numstorys) {
				return designPressure;
			}
			z++;
		}
		return 0.0;
	}

	public static Double roofDisplacement(final double colhgt,
			final double numstorys, final double loadwidth,
			final double windspeed, final double e, final double intIx,
			final double extIx, final double numberOfBays,
			final double windDispFact) {

		double storystiffnessFIXED = ((12 * e * extIx) * 2)
				/ (Math.pow((colhgt * 12), 3))
				+ ((12 * e * intIx) * (numberOfBays - 1) / (Math.pow(
						(colhgt * 12), 3)));// kip/in

		double storystiffnessPIN = ((3 * e * extIx) * 2)
				/ (Math.pow((colhgt * 12), 3))
				+ ((3 * e * intIx) * (numberOfBays - 1) / (Math.pow(
						(colhgt * 12), 3)));// kip/in

		double storyShear = 0;
		double storyDisplacement = 0;
		double z = 0;

		while (z <= (numstorys + 1)) {

			z++;

			double floorHgt = z * colhgt;

			double floorLoad = windDispFact * 0.0000037614
					* Math.pow(windspeed, 2)
					* Math.pow((floorHgt / 1200), 0.2857) * colhgt * loadwidth;

			storyShear = floorLoad + storyShear;

			storyDisplacement = storyShear / storystiffnessFIXED
					+ storyDisplacement;

			if (z == numstorys + 1) {
				return storyDisplacement;
			}

		}

		return storystiffnessFIXED;

	}

	public static Double intMoment(final double colhgt, final double numstorys,
			final double loadwidth, final double bays, final double windspeed) {

		double baseShear = windForces.windPressure(colhgt, numstorys,
				loadwidth, windspeed);

		/**
		 * Pin Bases
		 */

		double shearRatioExtToInt = 0.89;

		double intshear = baseShear
				* (1 / (2 * shearRatioExtToInt + (bays - 1)));

		return colhgt * intshear;
	}

	public static Double extMoment(final double colhgt, final double numstorys,
			final double loadwidth, final double bays, final double windspeed) {

		double baseShear = windForces.windPressure(colhgt, numstorys,
				loadwidth, windspeed);

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

		double ultUdl = trib * ((sdl * 1.2 + live) / 1000);

		return span * numstorys * ultUdl;

	}

	public static Double axialExt(final double span, final double trib,
			final double sdl, final double live, final double numstorys) {

		double ultUdl = trib * ((sdl * 1.2 + live) / 1000);

		return span * numstorys * ultUdl * 0.5;

	}

	public static Double beamAxialForce(final double colhgt,
			final double numstorys, final double loadwidth,
			final double windspeed) {

		return 0.0000037614 * Math.pow(windspeed, 2)
				* Math.pow((colhgt / 1200), 0.2857) * colhgt * loadwidth;

	}
}
