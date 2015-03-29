/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.util.HashMap;
import java.util.Map;

import edu.mit.civil.memberdesign.calculation.beamDesign;

/**
 * @author koleary
 *
 */
public class retrievingBeamSections {

	private static Map<String, Double> graph = new HashMap<String, Double>();

	public static Double findBeam(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		graph.put((String) "W12x45", (double) 1);
		graph.put((String) "W12x58", (double) 2);
		graph.put((String) "W12x65", (double) 3);
		graph.put((String) "W12x72", (double) 4);
		graph.put((String) "W12x79", (double) 5);
		graph.put((String) "W12x87", (double) 6);
		graph.put((String) "W12x96", (double) 7);

		String Size = beamDesign.sectionDesign(span, trib, sdl, live,
				numstorys, colhgt, beamFoS);

		return (graph.get(Size));
	}

	public static Double bf(final double span, final double trib,
			final double sdl, final double live, final double steelYield,
			final double beamaxial, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, steelYield, beamaxial, beamFoS);

		if (sectionNumber == 1) {
			return 8.05;
		}
		if (sectionNumber == 2) {
			return 10.0;
		}
		if (sectionNumber == 3) {
			return 12.0;
		}
		if (sectionNumber == 4) {
			return 12.0;
		}
		if (sectionNumber == 5) {
			return 12.1;
		}
		if (sectionNumber == 6) {
			return 12.1;
		}
		if (sectionNumber == 7) {
			return 12.2;
		}
		return 0.0;

	}

	public static Double tf(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 0.575;
		}
		if (sectionNumber == 2) {
			return 0.64;
		}
		if (sectionNumber == 3) {
			return 0.605;
		}
		if (sectionNumber == 4) {
			return 0.67;
		}
		if (sectionNumber == 5) {
			return 0.735;
		}
		if (sectionNumber == 6) {
			return 0.81;
		}
		if (sectionNumber == 7) {
			return 0.9;
		}
		return 0.0;

	}

	public static Double tw(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 0.335;
		}
		if (sectionNumber == 2) {
			return 0.36;
		}
		if (sectionNumber == 3) {
			return 0.39;
		}
		if (sectionNumber == 4) {
			return 0.43;
		}
		if (sectionNumber == 5) {
			return 0.47;
		}
		if (sectionNumber == 6) {
			return 0.515;
		}
		if (sectionNumber == 7) {
			return 0.55;
		}
		return 0.0;

	}

	public static Double d(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 12.1;
		}
		if (sectionNumber == 2) {
			return 12.2;
		}
		if (sectionNumber == 3) {
			return 12.1;
		}
		if (sectionNumber == 4) {
			return 12.3;
		}
		if (sectionNumber == 5) {
			return 12.4;
		}
		if (sectionNumber == 6) {
			return 12.5;
		}
		if (sectionNumber == 7) {
			return 12.7;
		}
		return 0.0;

	}

	public static Double zx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 64.2;
		}
		if (sectionNumber == 2) {
			return 86.4;
		}
		if (sectionNumber == 3) {
			return 96.8;
		}
		if (sectionNumber == 4) {
			return 108.0;
		}
		if (sectionNumber == 5) {
			return 119.0;
		}
		if (sectionNumber == 6) {
			return 132.0;
		}
		if (sectionNumber == 7) {
			return 147.0;
		}
		return 0.0;

	}

	public static Double rx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 5.15;
		}
		if (sectionNumber == 2) {
			return 5.28;
		}
		if (sectionNumber == 3) {
			return 5.28;
		}
		if (sectionNumber == 4) {
			return 5.31;
		}
		if (sectionNumber == 5) {
			return 5.34;
		}
		if (sectionNumber == 6) {
			return 5.38;
		}
		if (sectionNumber == 7) {
			return 5.44;
		}
		return 0.0;

	}

	public static Double ry(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 1.95;
		}
		if (sectionNumber == 2) {
			return 2.51;
		}
		if (sectionNumber == 3) {
			return 3.02;
		}
		if (sectionNumber == 4) {
			return 3.04;
		}
		if (sectionNumber == 5) {
			return 3.05;
		}
		if (sectionNumber == 6) {
			return 3.07;
		}
		if (sectionNumber == 7) {
			return 3.09;
		}
		return 0.0;

	}

	public static Double a(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double beamFoS) {

		double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, numstorys, colhgt, beamFoS);

		if (sectionNumber == 1) {
			return 13.1;
		}
		if (sectionNumber == 2) {
			return 17.0;
		}
		if (sectionNumber == 3) {
			return 19.1;
		}
		if (sectionNumber == 4) {
			return 21.1;
		}
		if (sectionNumber == 5) {
			return 32.2;
		}
		if (sectionNumber == 6) {
			return 25.6;
		}
		if (sectionNumber == 7) {
			return 28.2;
		}
		return 0.0;

	}

}
