/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

/**
 * @author koleary
 *
 */
public class dataStorage {

	/**
	 * Blast Input Details
	 */
	public static double weightTNT() {
		return 1000;
	}

	public static double blastFactor() {
		return 1;
	}

	public static double standoffDist() {
		return 32.5;
	}

	public static int blastAngle() {
		return 30;
	}

	/**
	 * Building Geometry
	 */
	public static int numbStorys() {
		return 12;
	}

	public static int numbBays() {
		return 6;
	}

	public static double floorHeight() {
		return 12.5;
	}

	public static double bayWidth() {
		return 25;
	}

	public static String heading() {
		return "Standard";
	}

	public static double tribWidth() {
		return 12.5;
	}

	public static int targetColumn() {
		return 1;
	}

	/**
	 * Loading
	 */
	public static double deadLoad() {
		return 120 * 1.1 + 10;// 10% Cladding, 11lbs/ft2 beam s/w
	}

	public static double liveLoad() {
		return 90;
	}

	/**
	 * Wind Speed
	 */
	public static double windspeed() {
		return 150;
	}

	/**
	 * Progressive Collapse Load Case
	 */
	public static double dlCombPC() {
		return 1.1;
	}

	public static double llCombPC() {
		return 0.25;
	}

	public static double beamLy() {
		return 5;
	}

	/**
	 * Factors
	 */
	public static double columnSafetyFactor() {
		return 1;
	}

	public static double beamSafetyFactor() {
		return 1;
	}

	public static double dynamicAmpFactor() {
		return 2;
	}

	public static double ductilityLimit() {
		return 3.75;
	}

	public static double kFactor() {
		return 1;
	}

	public static double compressionFactor() {
		return 1.7;
	}

	public static double noOfFloorsBeamSupports() {
		return 1;
	}

	public static double windDisplacementFactor() {
		return 0.2;
	}

	/**
	 * Steel Input Details
	 */
	public static double steelE() {
		return 29000;
	}

	public static double steelYield() {
		return 50;
	}
}
