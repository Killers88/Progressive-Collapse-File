/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

/**
 * @author koleary
 *
 */
public class ImpulseIralpha {

	private static final int ZERO = 0;
	private static final int FIVE = 5;
	private static final int TEN = 10;
	private static final int FIFTEEN = 15;
	private static final int TWENTY = 20;
	private static final int TWENTY_FIVE = 25;
	private static final int THIRTY = 30;
	private static final int THIRTY_FIVE = 35;
	private static final int FORTY = 40;
	private static final int FORTY_FIVE = 45;
	private static final int FIFTY = 50;
	private static final int FIFTY_FIVE = 55;
	private static final int SIXTY = 60;
	private static final int SIXTY_FIVE = 65;
	private static final int SEVENTY = 70;
	private static final int SEVENTY_FIVE = 75;
	private static final int EIGHTY = 80;

	public static double calculateImpulseIsUFCGraph(final double pso,
			final int angle, final double w) {

		/**
		 * Determine which curve to use for calculating 'Pr'
		 */
		if (pso < 56.25) {
			return (findingImpulsePsoEquals50(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 56.25) && (pso < 68.75)) {
			return (findingImpulsePsoEquals625(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 68.75) && (pso < 81.25)) {
			return (findingImpulsePsoEquals75(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 81.25) && (pso < 93.75)) {
			return (findingImpulsePsoEquals875(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 93.75) && (pso < 112.5)) {
			return (findingImpulsePsoEquals100(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 112.5) && (pso < 137.5)) {
			return (findingImpulsePsoEquals125(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 137.5) && (pso < 162.5)) {
			return (findingImpulsePsoEquals150(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 162.5) && (pso < 187.5)) {
			return (findingImpulsePsoEquals175(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 187.5) && (pso < 225)) {
			return (findingImpulsePsoEquals200(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 225) && (pso < 275)) {
			return (findingImpulsePsoEquals250(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 275) && (pso < 325)) {
			return (findingImpulsePsoEquals300(angle) * Math.pow(w, 0.3333));
		} else if ((pso > 325) && (pso < 275)) {
			return (findingImpulsePsoEquals350(angle) * Math.pow(w, 0.3333));
		} else if (pso > 275) {
			return (findingImpulsePsoEquals400(angle) * Math.pow(w, 0.3333));
		}
		throw new RuntimeException("invalid Pso value");

	}

	/**
	 * Z = 0.3
	 * 
	 * @param angle
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals50(int angle) {

		switch (angle) {
		case ZERO:
			return 36;
		case FIVE:
			return 36;
		case TEN:
			return 35.5;
		case FIFTEEN:
			return 35;
		case TWENTY:
			return 34;
		case TWENTY_FIVE:
			return 33;
		case THIRTY:
			return 31.5;
		case THIRTY_FIVE:
			return 30;
		case FORTY:
			return 29;
		case FORTY_FIVE:
			return 28;
		case FIFTY:
			return 26;
		case FIFTY_FIVE:
			return 24;
		case SIXTY:
			return 22.5;
		case SIXTY_FIVE:
			return 20;
		case SEVENTY:
			return 18;
		case SEVENTY_FIVE:
			return 17;
		case EIGHTY:
			return 16;
		}
		return 0;
	}

	/**
	 * Z = 0.6
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals625(int angle) {

		switch (angle) {
		case ZERO:
			return 39;
		case FIVE:
			return 39;
		case TEN:
			return 39;
		case FIFTEEN:
			return 38.5;
		case TWENTY:
			return 38;
		case TWENTY_FIVE:
			return 37;
		case THIRTY:
			return 35;
		case THIRTY_FIVE:
			return 32.5;
		case FORTY:
			return 31;
		case FORTY_FIVE:
			return 29;
		case FIFTY:
			return 28;
		case FIFTY_FIVE:
			return 26;
		case SIXTY:
			return 24;
		case SIXTY_FIVE:
			return 21;
		case SEVENTY:
			return 20;
		case SEVENTY_FIVE:
			return 18;
		case EIGHTY:
			return 17;
		}
		return 0;
	}

	/**
	 * Z = 0.8
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals75(int angle) {

		switch (angle) {
		case ZERO:
			return 43;
		case FIVE:
			return 43;
		case TEN:
			return 41.5;
		case FIFTEEN:
			return 41;
		case TWENTY:
			return 40.5;
		case TWENTY_FIVE:
			return 40;
		case THIRTY:
			return 37.5;
		case THIRTY_FIVE:
			return 36;
		case FORTY:
			return 34;
		case FORTY_FIVE:
			return 32;
		case FIFTY:
			return 30;
		case FIFTY_FIVE:
			return 28;
		case SIXTY:
			return 26;
		case SIXTY_FIVE:
			return 24;
		case SEVENTY:
			return 22;
		case SEVENTY_FIVE:
			return 20;
		case EIGHTY:
			return 18;
		}
		return 0;
	}

	/**
	 * Z = 1.9
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals875(int angle) {

		switch (angle) {
		case ZERO:
			return 48;
		case FIVE:
			return 48;
		case TEN:
			return 48;
		case FIFTEEN:
			return 46;
		case TWENTY:
			return 45;
		case TWENTY_FIVE:
			return 44;
		case THIRTY:
			return 42;
		case THIRTY_FIVE:
			return 40;
		case FORTY:
			return 37;
		case FORTY_FIVE:
			return 36;
		case FIFTY:
			return 32.5;
		case FIFTY_FIVE:
			return 30;
		case SIXTY:
			return 28;
		case SIXTY_FIVE:
			return 26;
		case SEVENTY:
			return 24;
		case SEVENTY_FIVE:
			return 21.5;
		case EIGHTY:
			return 19.5;
		}
		return 0;
	}

	/**
	 * Z = 2.175
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals100(int angle) {

		switch (angle) {
		case ZERO:
			return 52;
		case FIVE:
			return 52;
		case TEN:
			return 51;
		case FIFTEEN:
			return 50;
		case TWENTY:
			return 49.5;
		case TWENTY_FIVE:
			return 47.5;
		case THIRTY:
			return 46;
		case THIRTY_FIVE:
			return 43.5;
		case FORTY:
			return 41;
		case FORTY_FIVE:
			return 38;
		case FIFTY:
			return 35.5;
		case FIFTY_FIVE:
			return 34;
		case SIXTY:
			return 30;
		case SIXTY_FIVE:
			return 28;
		case SEVENTY:
			return 26;
		case SEVENTY_FIVE:
			return 23.5;
		case EIGHTY:
			return 21;
		}
		return 0;
	}

	/**
	 * Z = 2.245
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals125(int angle) {

		switch (angle) {
		case ZERO:
			return 58;
		case FIVE:
			return 58;
		case TEN:
			return 57;
		case FIFTEEN:
			return 56;
		case TWENTY:
			return 55;
		case TWENTY_FIVE:
			return 52;
		case THIRTY:
			return 50;
		case THIRTY_FIVE:
			return 47.5;
		case FORTY:
			return 45;
		case FORTY_FIVE:
			return 42.5;
		case FIFTY:
			return 39;
		case FIFTY_FIVE:
			return 36;
		case SIXTY:
			return 32.5;
		case SIXTY_FIVE:
			return 30;
		case SEVENTY:
			return 27.5;
		case SEVENTY_FIVE:
			return 25;
		case EIGHTY:
			return 23;
		}
		return 0;
	}

	/**
	 * Z = 2.735
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals150(int angle) {

		switch (angle) {
		case ZERO:
			return 64;
		case FIVE:
			return 64;
		case TEN:
			return 62;
		case FIFTEEN:
			return 61;
		case TWENTY:
			return 59;
		case TWENTY_FIVE:
			return 58;
		case THIRTY:
			return 55;
		case THIRTY_FIVE:
			return 52.5;
		case FORTY:
			return 48;
		case FORTY_FIVE:
			return 45;
		case FIFTY:
			return 41;
		case FIFTY_FIVE:
			return 39;
		case SIXTY:
			return 35;
		case SIXTY_FIVE:
			return 32.5;
		case SEVENTY:
			return 29;
		case SEVENTY_FIVE:
			return 27;
		case EIGHTY:
			return 25;
		}
		return 0;
	}

	/**
	 * Z = 3.0
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals175(int angle) {

		switch (angle) {
		case ZERO:
			return 70;
		case FIVE:
			return 70;
		case TEN:
			return 69;
		case FIFTEEN:
			return 67.5;
		case TWENTY:
			return 64;
		case TWENTY_FIVE:
			return 63;
		case THIRTY:
			return 60;
		case THIRTY_FIVE:
			return 58;
		case FORTY:
			return 54;
		case FORTY_FIVE:
			return 50;
		case FIFTY:
			return 46;
		case FIFTY_FIVE:
			return 42;
		case SIXTY:
			return 38;
		case SIXTY_FIVE:
			return 35;
		case SEVENTY:
			return 31;
		case SEVENTY_FIVE:
			return 28;
		case EIGHTY:
			return 26;
		}
		return 0;
	}

	/**
	 * Z = 3.575
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals200(int angle) {

		switch (angle) {
		case ZERO:
			return 80;
		case FIVE:
			return 78;
		case TEN:
			return 77;
		case FIFTEEN:
			return 76;
		case TWENTY:
			return 72.5;
		case TWENTY_FIVE:
			return 70;
		case THIRTY:
			return 67;
		case THIRTY_FIVE:
			return 63;
		case FORTY:
			return 60;
		case FORTY_FIVE:
			return 55;
		case FIFTY:
			return 50;
		case FIFTY_FIVE:
			return 46;
		case SIXTY:
			return 42;
		case SIXTY_FIVE:
			return 38;
		case SEVENTY:
			return 33;
		case SEVENTY_FIVE:
			return 30;
		case EIGHTY:
			return 26.5;
		}
		return 0;
	}

	/**
	 * Z = 4.15
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals250(int angle) {

		switch (angle) {
		case ZERO:
			return 87.5;
		case FIVE:
			return 87.5;
		case TEN:
			return 86;
		case FIFTEEN:
			return 84;
		case TWENTY:
			return 82;
		case TWENTY_FIVE:
			return 78;
		case THIRTY:
			return 72;
		case THIRTY_FIVE:
			return 69;
		case FORTY:
			return 63;
		case FORTY_FIVE:
			return 59;
		case FIFTY:
			return 52.5;
		case FIFTY_FIVE:
			return 48;
		case SIXTY:
			return 43;
		case SIXTY_FIVE:
			return 37.5;
		case SEVENTY:
			return 33;
		case SEVENTY_FIVE:
			return 28.5;
		case EIGHTY:
			return 24;
		}
		return 0;
	}

	/**
	 * Z = 5.125
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals300(int angle) {

		switch (angle) {
		case ZERO:
			return 97;
		case FIVE:
			return 97;
		case TEN:
			return 96.5;
		case FIFTEEN:
			return 95;
		case TWENTY:
			return 90;
		case TWENTY_FIVE:
			return 87;
		case THIRTY:
			return 82.5;
		case THIRTY_FIVE:
			return 76;
		case FORTY:
			return 68;
		case FORTY_FIVE:
			return 64;
		case FIFTY:
			return 57;
		case FIFTY_FIVE:
			return 50;
		case SIXTY:
			return 45;
		case SIXTY_FIVE:
			return 39;
		case SEVENTY:
			return 33;
		case SEVENTY_FIVE:
			return 29;
		case EIGHTY:
			return 25;
		}
		return 0;
	}

	/**
	 * Z = 5.3
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals350(int angle) {

		switch (angle) {
		case ZERO:
			return 115;
		case FIVE:
			return 115;
		case TEN:
			return 110;
		case FIFTEEN:
			return 103;
		case TWENTY:
			return 100;
		case TWENTY_FIVE:
			return 98;
		case THIRTY:
			return 90;
		case THIRTY_FIVE:
			return 85;
		case FORTY:
			return 75;
		case FORTY_FIVE:
			return 68;
		case FIFTY:
			return 60;
		case FIFTY_FIVE:
			return 53;
		case SIXTY:
			return 47;
		case SIXTY_FIVE:
			return 40;
		case SEVENTY:
			return 33;
		case SEVENTY_FIVE:
			return 29;
		case EIGHTY:
			return 27;
		}
		return 0;
	}

	/**
	 * Z = 7.2
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingImpulsePsoEquals400(int angle) {

		switch (angle) {
		case ZERO:
			return 135;
		case FIVE:
			return 135;
		case TEN:
			return 130;
		case FIFTEEN:
			return 125;
		case TWENTY:
			return 120;
		case TWENTY_FIVE:
			return 110;
		case THIRTY:
			return 100;
		case THIRTY_FIVE:
			return 92;
		case FORTY:
			return 83;
		case FORTY_FIVE:
			return 75;
		case FIFTY:
			return 66;
		case FIFTY_FIVE:
			return 57.5;
		case SIXTY:
			return 48;
		case SIXTY_FIVE:
			return 40;
		case SEVENTY:
			return 34;
		case SEVENTY_FIVE:
			return 28;
		case EIGHTY:
			return 23;
		}
		return 0;
	}

}

//
// public static double CONSTANT_A = 0.5;
//
// /**
// * Return Impulse
// *
// * @param pr
// * @param ps
// * @param tc
// * @param to
// * @return
// */
// public static double calculateImpulseIsWithPrPsTcTo(final double pr,
// final double ps, final double tc, final double to) {
//
// return 285;
// return CONSTANT_A * (pr - ps) * tc + CONSTANT_A * ps * to;// psi -
// ms;

