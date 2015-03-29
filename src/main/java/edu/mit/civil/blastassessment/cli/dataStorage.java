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
		return 2000;
	}

	public static double blastFactor() {
		return 1;
	}

	public static double standoffDist() {
		return 30;
	}

	public static int blastAngle() {
		return 30;
	}

	/**
	 * Building Geometry
	 */
	public static int numbStorys() {
		return 14;
	}

	public static int numbBays() {
		return 8;
	}

	public static double floorHeight() {
		return 14;
	}

	public static double bayWidth() {
		return 25;
	}

	public static double tribWidth() {
		return 10;
	}

	public static int targetColumn() {
		return 3;
	}

	/**
	 * Loading
	 */
	public static double deadLoad() {
		return 120;
	}

	public static double liveLoad() {
		return 90;
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
		return 3;
	}

	public static double kFactor() {
		return 1;
	}

	public static double compressionFactor() {
		return 1.7;
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
