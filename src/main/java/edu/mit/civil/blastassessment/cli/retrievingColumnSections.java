/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.util.HashMap;
import java.util.Map;

import edu.mit.civil.memberdesign.calculation.externalColumnForcesandDesign;
import edu.mit.civil.memberdesign.calculation.internalColumnForcesAndDesign;

/**
 * @author koleary
 *
 */
public class retrievingColumnSections {

	private static Map<String, Double> graph = new HashMap<String, Double>();

	public static Double findColumn(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		graph.put((String) "W14x48", (double) 1);
		graph.put((String) "W14x53", (double) 2);
		graph.put((String) "W14x61", (double) 3);
		graph.put((String) "W14x68", (double) 4);
		graph.put((String) "W14x74", (double) 5);
		graph.put((String) "W14x82", (double) 6);
		graph.put((String) "W14x90", (double) 7);
		graph.put((String) "W14x99", (double) 8);
		graph.put((String) "W14x109", (double) 9);
		graph.put((String) "W14x120", (double) 10);
		graph.put((String) "W14x132", (double) 11);
		graph.put((String) "W14x145", (double) 12);
		graph.put((String) "W14x159", (double) 13);
		graph.put((String) "W14x176", (double) 14);
		graph.put((String) "W14x193", (double) 15);
		graph.put((String) "W14x211", (double) 16);
		graph.put((String) "W14x233", (double) 17);
		graph.put((String) "W14x257", (double) 18);
		graph.put((String) "W14x283", (double) 19);
		graph.put((String) "W14x311", (double) 20);
		graph.put((String) "W14x342", (double) 21);
		graph.put((String) "W14x370", (double) 22);
		graph.put((String) "W14x398", (double) 23);

		if (targetColumn == 1) {
			String Size = externalColumnForcesandDesign.columnSizing(span,
					trib, sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
					factorOfSafety, windspeed);
			return (graph.get(Size));
		}
		if (targetColumn > 1) {
			String Size = internalColumnForcesAndDesign.columnSizing(span,
					trib, sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
					factorOfSafety, windspeed);
			return (graph.get(Size));
		}

		return 0.0;

	}

	public static Double Ixx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		double sectionNumber = retrievingColumnSections.findColumn(span, trib,
				sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
				targetColumn, factorOfSafety, windspeed);

		if (sectionNumber == 1) {
			return 484.0;
		}
		if (sectionNumber == 2) {
			return 541.0;
		}
		if (sectionNumber == 3) {
			return 640.0;
		}
		if (sectionNumber == 4) {
			return 722.0;
		}
		if (sectionNumber == 5) {
			return 795.0;
		}
		if (sectionNumber == 6) {
			return 881.0;
		}
		if (sectionNumber == 7) {
			return 999.0;
		}
		if (sectionNumber == 8) {
			return 1110.0;
		}
		if (sectionNumber == 9) {
			return 1240.0;
		}
		if (sectionNumber == 10) {
			return 1380.0;
		}
		if (sectionNumber == 11) {
			return 1530.0;
		}
		if (sectionNumber == 12) {
			return 1710.0;
		}
		if (sectionNumber == 13) {
			return 1900.0;
		}
		if (sectionNumber == 14) {
			return 2140.0;
		}
		if (sectionNumber == 15) {
			return 2400.0;
		}
		if (sectionNumber == 16) {
			return 2660.0;
		}
		if (sectionNumber == 17) {
			return 3010.0;
		}
		if (sectionNumber == 18) {
			return 3400.0;
		}
		if (sectionNumber == 19) {
			return 3840.0;
		}
		if (sectionNumber == 20) {
			return 4330.0;
		}
		if (sectionNumber == 21) {
			return 4900.0;
		}
		if (sectionNumber == 22) {
			return 5440.0;
		}
		if (sectionNumber == 23) {
			return 6000.0;
		}

		return 0.0;

	}

	public static Double Sx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		double sectionNumber = retrievingColumnSections.findColumn(span, trib,
				sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
				targetColumn, factorOfSafety, windspeed);

		if (sectionNumber == 1) {
			return 70.2;
		}
		if (sectionNumber == 2) {
			return 77.8;
		}
		if (sectionNumber == 3) {
			return 92.1;
		}
		if (sectionNumber == 4) {
			return 103.0;
		}
		if (sectionNumber == 5) {
			return 112.0;
		}
		if (sectionNumber == 6) {
			return 123.0;
		}
		if (sectionNumber == 7) {
			return 143.0;
		}
		if (sectionNumber == 8) {
			return 157.0;
		}
		if (sectionNumber == 9) {
			return 173.0;
		}
		if (sectionNumber == 10) {
			return 190.0;
		}
		if (sectionNumber == 11) {
			return 209.0;
		}
		if (sectionNumber == 12) {
			return 232.0;
		}
		if (sectionNumber == 13) {
			return 254.0;
		}
		if (sectionNumber == 14) {
			return 281.0;
		}
		if (sectionNumber == 15) {
			return 310.0;
		}
		if (sectionNumber == 16) {
			return 338.0;
		}
		if (sectionNumber == 17) {
			return 375.0;
		}
		if (sectionNumber == 18) {
			return 415.0;
		}
		if (sectionNumber == 19) {
			return 459.0;
		}
		if (sectionNumber == 20) {
			return 506.0;
		}
		if (sectionNumber == 21) {
			return 558.0;
		}
		if (sectionNumber == 22) {
			return 607.0;
		}
		if (sectionNumber == 23) {
			return 656.0;
		}

		return 0.0;

	}

	public static Double Zx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		double sectionNumber = retrievingColumnSections.findColumn(span, trib,
				sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
				targetColumn, factorOfSafety, windspeed);

		if (sectionNumber == 1) {
			return 78.4;
		}
		if (sectionNumber == 2) {
			return 87.1;
		}
		if (sectionNumber == 3) {
			return 102.0;
		}
		if (sectionNumber == 4) {
			return 115.0;
		}
		if (sectionNumber == 5) {
			return 126.0;
		}
		if (sectionNumber == 6) {
			return 139.0;
		}
		if (sectionNumber == 7) {
			return 157.0;
		}
		if (sectionNumber == 8) {
			return 173.0;
		}
		if (sectionNumber == 9) {
			return 192.0;
		}
		if (sectionNumber == 10) {
			return 212.0;
		}
		if (sectionNumber == 11) {
			return 234.0;
		}
		if (sectionNumber == 12) {
			return 260.0;
		}
		if (sectionNumber == 13) {
			return 287.0;
		}
		if (sectionNumber == 14) {
			return 320.0;
		}
		if (sectionNumber == 15) {
			return 355.0;
		}
		if (sectionNumber == 16) {
			return 390.0;
		}
		if (sectionNumber == 17) {
			return 436.0;
		}
		if (sectionNumber == 18) {
			return 487.0;
		}
		if (sectionNumber == 19) {
			return 542.0;
		}
		if (sectionNumber == 20) {
			return 603.0;
		}
		if (sectionNumber == 21) {
			return 672.0;
		}
		if (sectionNumber == 22) {
			return 736.0;
		}
		if (sectionNumber == 23) {
			return 801.0;
		}

		return 0.0;

	}

	public static Double Wgt(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		double sectionNumber = retrievingColumnSections.findColumn(span, trib,
				sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
				targetColumn, factorOfSafety, windspeed);

		if (sectionNumber == 1) {
			return 48.0;
		}
		if (sectionNumber == 2) {
			return 53.0;
		}
		if (sectionNumber == 3) {
			return 61.0;
		}
		if (sectionNumber == 4) {
			return 68.0;
		}
		if (sectionNumber == 5) {
			return 74.0;
		}
		if (sectionNumber == 6) {
			return 82.0;
		}
		if (sectionNumber == 7) {
			return 90.0;
		}
		if (sectionNumber == 8) {
			return 99.0;
		}
		if (sectionNumber == 9) {
			return 109.0;
		}
		if (sectionNumber == 10) {
			return 120.0;
		}
		if (sectionNumber == 11) {
			return 132.0;
		}
		if (sectionNumber == 12) {
			return 145.0;
		}
		if (sectionNumber == 13) {
			return 159.0;
		}
		if (sectionNumber == 14) {
			return 176.0;
		}
		if (sectionNumber == 15) {
			return 193.0;
		}
		if (sectionNumber == 16) {
			return 211.0;
		}
		if (sectionNumber == 17) {
			return 233.0;
		}
		if (sectionNumber == 18) {
			return 257.0;
		}
		if (sectionNumber == 19) {
			return 283.0;
		}
		if (sectionNumber == 20) {
			return 311.0;
		}
		if (sectionNumber == 21) {
			return 342.0;
		}
		if (sectionNumber == 22) {
			return 370.0;
		}
		if (sectionNumber == 23) {
			return 398.0;
		}

		return 0.0;

	}

	public static Double Bf(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays,
			final double targetColumn, final double factorOfSafety,
			final double windspeed) {

		double sectionNumber = retrievingColumnSections.findColumn(span, trib,
				sdl, live, numstorys, colhgt, k, fy, factCOMP, bays,
				targetColumn, factorOfSafety, windspeed);

		if (sectionNumber == 1) {
			return 8.03;
		}
		if (sectionNumber == 2) {
			return 8.06;
		}
		if (sectionNumber == 3) {
			return 10.0;
		}
		if (sectionNumber == 4) {
			return 10.0;
		}
		if (sectionNumber == 5) {
			return 10.1;
		}
		if (sectionNumber == 6) {
			return 10.1;
		}
		if (sectionNumber == 7) {
			return 14.5;
		}
		if (sectionNumber == 8) {
			return 14.6;
		}
		if (sectionNumber == 9) {
			return 14.6;
		}
		if (sectionNumber == 10) {
			return 14.7;
		}
		if (sectionNumber == 11) {
			return 14.7;
		}
		if (sectionNumber == 12) {
			return 15.5;
		}
		if (sectionNumber == 13) {
			return 15.6;
		}
		if (sectionNumber == 14) {
			return 15.7;
		}
		if (sectionNumber == 15) {
			return 15.7;
		}
		if (sectionNumber == 16) {
			return 15.8;
		}
		if (sectionNumber == 17) {
			return 15.9;
		}
		if (sectionNumber == 18) {
			return 16.0;
		}
		if (sectionNumber == 19) {
			return 16.1;
		}
		if (sectionNumber == 20) {
			return 16.2;
		}
		if (sectionNumber == 21) {
			return 16.4;
		}
		if (sectionNumber == 22) {
			return 16.5;
		}
		if (sectionNumber == 23) {
			return 16.6;
		}

		return 0.0;

	}

}
