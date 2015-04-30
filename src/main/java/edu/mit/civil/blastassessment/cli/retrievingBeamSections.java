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
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		graph.put((String) "W21x50", (double) 8);
		graph.put((String) "W21x57", (double) 9);
		graph.put((String) "W21x62", (double) 10);
		graph.put((String) "W21x68", (double) 1);
		graph.put((String) "W21x73", (double) 2);
		graph.put((String) "W21x83", (double) 3);
		graph.put((String) "W21x93", (double) 4);
		graph.put((String) "W21x101", (double) 5);
		graph.put((String) "W21x111", (double) 6);
		graph.put((String) "W21x122", (double) 7);

		String Size = beamDesign.sectionDesign(span, trib, sdl, live, fy, pr,
				beamFoS, colhgt, numstorys, bays, windspeed);

		return (graph.get(Size));
	}

	public static Double bf(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 8.27;
		}
		if (sectionNumber == 2) {
			return 8.3;
		}
		if (sectionNumber == 3) {
			return 8.36;
		}
		if (sectionNumber == 4) {
			return 8.42;
		}
		if (sectionNumber == 5) {
			return 12.3;
		}
		if (sectionNumber == 6) {
			return 12.3;
		}
		if (sectionNumber == 7) {
			return 12.4;
		}
		if (sectionNumber == 8) {
			return 6.53;
		}
		if (sectionNumber == 9) {
			return 6.56;
		}
		if (sectionNumber == 10) {
			return 8.24;
		}
		return 0.0;

	}

	public static Double tf(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 0.685;
		}
		if (sectionNumber == 2) {
			return 0.74;
		}
		if (sectionNumber == 3) {
			return 0.835;
		}
		if (sectionNumber == 4) {
			return 0.93;
		}
		if (sectionNumber == 5) {
			return 0.8;
		}
		if (sectionNumber == 6) {
			return 0.875;
		}
		if (sectionNumber == 7) {
			return 0.96;
		}
		if (sectionNumber == 8) {
			return 0.535;
		}

		if (sectionNumber == 9) {
			return 0.65;
		}

		if (sectionNumber == 10) {
			return 0.615;
		}
		return 0.0;

	}

	public static Double tw(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 0.43;
		}
		if (sectionNumber == 2) {
			return 0.455;
		}
		if (sectionNumber == 3) {
			return 0.515;
		}
		if (sectionNumber == 4) {
			return 0.58;
		}
		if (sectionNumber == 5) {
			return 0.5;
		}
		if (sectionNumber == 6) {
			return 0.55;
		}
		if (sectionNumber == 7) {
			return 0.6;
		}
		if (sectionNumber == 8) {
			return 0.38;
		}
		if (sectionNumber == 9) {
			return 0.405;
		}
		if (sectionNumber == 10) {
			return 0.4;
		}
		return 0.0;

	}

	public static Double d(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 21.1;
		}
		if (sectionNumber == 2) {
			return 21.2;
		}
		if (sectionNumber == 3) {
			return 21.4;
		}
		if (sectionNumber == 4) {
			return 21.6;
		}
		if (sectionNumber == 5) {
			return 21.4;
		}
		if (sectionNumber == 6) {
			return 21.6;
		}
		if (sectionNumber == 7) {
			return 21.4;
		}
		if (sectionNumber == 8) {
			return 20.8;
		}
		if (sectionNumber == 9) {
			return 21.1;
		}
		if (sectionNumber == 10) {
			return 21.0;
		}
		return 0.0;

	}

	public static Double zx(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 160.0;
		}
		if (sectionNumber == 2) {
			return 172.0;
		}
		if (sectionNumber == 3) {
			return 196.0;
		}
		if (sectionNumber == 4) {
			return 221.0;
		}
		if (sectionNumber == 5) {
			return 253.0;
		}
		if (sectionNumber == 6) {
			return 279.0;
		}
		if (sectionNumber == 7) {
			return 307.0;
		}
		if (sectionNumber == 8) {
			return 110.0;
		}
		if (sectionNumber == 9) {
			return 129.0;
		}
		if (sectionNumber == 10) {
			return 144.0;
		}
		return 0.0;

	}

	public static Double rx(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 8.6;
		}
		if (sectionNumber == 2) {
			return 8.64;
		}
		if (sectionNumber == 3) {
			return 8.67;
		}
		if (sectionNumber == 4) {
			return 9.02;
		}
		if (sectionNumber == 5) {
			return 9.05;
		}
		if (sectionNumber == 6) {
			return 9.09;
		}
		if (sectionNumber == 7) {
			return 9.12;
		}
		if (sectionNumber == 8) {
			return 8.18;
		}
		if (sectionNumber == 9) {
			return 8.36;
		}
		if (sectionNumber == 10) {
			return 8.54;
		}
		return 0.0;

	}

	public static Double ry(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 1.8;
		}
		if (sectionNumber == 2) {
			return 1.81;
		}
		if (sectionNumber == 3) {
			return 1.83;
		}
		if (sectionNumber == 4) {
			return 1.84;
		}
		if (sectionNumber == 5) {
			return 2.89;
		}
		if (sectionNumber == 6) {
			return 2.9;
		}
		if (sectionNumber == 7) {
			return 2.92;
		}
		if (sectionNumber == 8) {
			return 1.3;
		}
		if (sectionNumber == 9) {
			return 1.35;
		}
		if (sectionNumber == 10) {
			return 1.77;
		}
		return 0.0;

	}

	public static Double a(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		Double sectionNumber = retrievingBeamSections.findBeam(span, trib, sdl,
				live, fy, pr, beamFoS, colhgt, numstorys, bays, windspeed);

		if (sectionNumber == 1) {
			return 20.0;
		}
		if (sectionNumber == 2) {
			return 21.5;
		}
		if (sectionNumber == 3) {
			return 24.3;
		}
		if (sectionNumber == 4) {
			return 27.3;
		}
		if (sectionNumber == 5) {
			return 29.8;
		}
		if (sectionNumber == 6) {
			return 32.7;
		}
		if (sectionNumber == 7) {
			return 35.9;
		}
		if (sectionNumber == 8) {
			return 14.7;
		}
		if (sectionNumber == 9) {
			return 16.7;
		}
		if (sectionNumber == 10) {
			return 18.3;
		}
		return 0.0;

	}

}
