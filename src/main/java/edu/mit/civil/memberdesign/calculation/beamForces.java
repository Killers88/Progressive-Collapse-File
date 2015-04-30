/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

/**
 * @author koleary
 *
 */
public class beamForces {

	public static Double maxMoment(final double span, final double trib,
			final double sdl, final double live) {

		double ultUdl = trib * ((sdl * 1.2 + live * 1.6) / 1000);

		double mMax = ultUdl * Math.pow(span, 2) * 0.08333;

		return mMax;

	}

	public static Double serviceIReq(final double span, final double trib,
			final double sdl, final double live) {

		double servUdl = trib * ((sdl + live) / 1000);

		double defA = (span * 8) / 250;

		double defB = 0.8;

		if (defA <= defB) {

			return (servUdl / 12) * Math.pow(span * 12, 4) * 5
					/ (384 * 29000 * defA);

		} else if (defA > defB) {

			return (servUdl / 12) * Math.pow(span * 12, 4) * 5
					/ (384 * 29000 * defB);
		}
		throw new RuntimeException("THIS SHOULD NOT APPEAR");

	}
}
