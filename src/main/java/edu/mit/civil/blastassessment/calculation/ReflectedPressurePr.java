package edu.mit.civil.blastassessment.calculation;

public class ReflectedPressurePr {

	// TODO Increase accuracy by interpolating between graph lines for different
	// z values
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

	public static double findingPrWithZAndAngle(final double z, final int angle) {

		/**
		 * Determine which curve to use for calculating 'Pr'
		 */
		if (z < 0.45) {
			return findingPrWithZ03Angle(angle);
		} else if ((z > 0.45) && (z < 0.7)) {
			return findingPrWithZ06Angle(angle);
		} else if ((z > 0.7) && (z < 1.35)) {
			return findingPrWithZ08Angle(angle);
		} else if ((z > 1.35) && (z < 2.0375)) {
			return findingPrWithZ19Angle(angle);
		} else if ((z > 2.0375) && (z < 2.3125)) {
			return findingPrWithZ2175Angle(angle);
		} else if ((z > 2.3125) && (z < 2.5875)) {
			return findingPrWithZ245Angle(angle);
		} else if ((z > 2.5875) && (z < 2.8625)) {
			return findingPrWithZ2725Angle(angle);
		} else if ((z > 2.8625) && (z < 3.2875)) {
			return findingPrWithZ3Angle(angle);
		} else if ((z > 3.2875) && (z < 3.8625)) {
			return findingPrWithZ3575Angle(angle);
		} else if ((z > 3.8625) && (z < 4.6375)) {
			return findingPrWithZ415Angle(angle);
		} else if ((z > 4.6375) && (z < 5.2125)) {
			return findingPrWithZ5125Angle(angle);
		} else if ((z > 5.2125) && (z < 6.25)) {
			return findingPrWithZ53Angle(angle);
		} else if ((z > 6.25) && (z < 8.05)) {
			return findingPrWithZ72Angle(angle);
		} else if ((z > 8.05) && (z < 10.4)) {
			return findingPrWithZ89Angle(angle);
		} else if ((z > 10.4) && (z < 12.5)) {
			return findingPrWithZ119Angle(angle);
		} else if (z > 12.5) {
			return findingPrWithZ143Angle(angle);
		}
		return angle;

	}

	/**
	 * Z = 0.3
	 * 
	 * @param angle
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ03Angle(int angle) {

		switch (angle) {
		case ZERO:
		case FIVE:
			return 40000;
		case TEN:
			return 42000;
		case FIFTEEN:
			return 41000;
		case TWENTY:
			return 40000;
		case TWENTY_FIVE:
			return 40000;
		case THIRTY:
			return 36000;
		case THIRTY_FIVE:
			return 32000;
		case FORTY:
			return 30000;
		case FORTY_FIVE:
			return 22000;
		case FIFTY:
			return 18000;
		case FIFTY_FIVE:
			return 12000;
		case SIXTY:
			return 7500;
		case SIXTY_FIVE:
			return 4800;
		case SEVENTY:
			return 3000;
		case SEVENTY_FIVE:
			return 1600;
		case EIGHTY:
			return 600;
		}
		return 0;
	}

	/**
	 * Z = 0.6
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ06Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 19500;
		case FIVE:
			return 19000;
		case TEN:
			return 18900;
		case FIFTEEN:
			return 18000;
		case TWENTY:
			return 18000;
		case TWENTY_FIVE:
			return 16500;
		case THIRTY:
			return 14500;
		case THIRTY_FIVE:
			return 12000;
		case FORTY:
			return 10000;
		case FORTY_FIVE:
			return 8000;
		case FIFTY:
			return 6000;
		case FIFTY_FIVE:
			return 4250;
		case SIXTY:
			return 3000;
		case SIXTY_FIVE:
			return 1750;
		case SEVENTY:
			return 850;
		case SEVENTY_FIVE:
			return 375;
		case EIGHTY:
			return 120;
		}
		return 0;
	}

	/**
	 * Z = 0.8
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ08Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 10000;
		case FIVE:
			return 10000;
		case TEN:
			return 10000;
		case FIFTEEN:
			return 10000;
		case TWENTY:
			return 9000;
		case TWENTY_FIVE:
			return 8000;
		case THIRTY:
			return 7000;
		case THIRTY_FIVE:
			return 6000;
		case FORTY:
			return 4750;
		case FORTY_FIVE:
			return 3600;
		case FIFTY:
			return 2600;
		case FIFTY_FIVE:
			return 1900;
		case SIXTY:
			return 1250;
		case SIXTY_FIVE:
			return 800;
		case SEVENTY:
			return 400;
		case SEVENTY_FIVE:
			return 175;
		case EIGHTY:
			return 55;
		}
		return 0;
	}

	/**
	 * Z = 1.9
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ19Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 1700;
		case FIVE:
			return 1700;
		case TEN:
			return 1650;
		case FIFTEEN:
			return 1500;
		case TWENTY:
			return 1350;
		case TWENTY_FIVE:
			return 1200;
		case THIRTY:
			return 1000;
		case THIRTY_FIVE:
			return 875;
		case FORTY:
			return 725;
		case FORTY_FIVE:
			return 575;
		case FIFTY:
			return 435;
		case FIFTY_FIVE:
			return 300;
		case SIXTY:
			return 200;
		case SIXTY_FIVE:
			return 130;
		case SEVENTY:
			return 65;
		case SEVENTY_FIVE:
			return 28;
		case EIGHTY:
			return 10;
		}
		return 0;
	}

	/**
	 * Z = 2.175
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ2175Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 1100;
		case FIVE:
			return 1100;
		case TEN:
			return 1100;
		case FIFTEEN:
			return 1100;
		case TWENTY:
			return 900;
		case TWENTY_FIVE:
			return 800;
		case THIRTY:
			return 700;
		case THIRTY_FIVE:
			return 600;
		case FORTY:
			return 500;
		case FORTY_FIVE:
			return 400;
		case FIFTY:
			return 300;
		case FIFTY_FIVE:
			return 200;
		case SIXTY:
			return 150;
		case SIXTY_FIVE:
			return 85;
		case SEVENTY:
			return 45;
		case SEVENTY_FIVE:
			return 25;
		case EIGHTY:
			return 8;
		}
		return 0;
	}

	/**
	 * Z = 2.245
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ245Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 800;
		case FIVE:
			return 800;
		case TEN:
			return 750;
		case FIFTEEN:
			return 700;
		case TWENTY:
			return 600;
		case TWENTY_FIVE:
			return 500;
		case THIRTY:
			return 450;
		case THIRTY_FIVE:
			return 400;
		case FORTY:
			return 350;
		case FORTY_FIVE:
			return 250;
		case FIFTY:
			return 190;
		case FIFTY_FIVE:
			return 150;
		case SIXTY:
			return 85;
		case SIXTY_FIVE:
			return 60;
		case SEVENTY:
			return 35;
		case SEVENTY_FIVE:
			return 15;
		case EIGHTY:
			return 6;
		}
		return 0;
	}

	/**
	 * Z = 2.735
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ2725Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 600;
		case FIVE:
			return 600;
		case TEN:
			return 550;
		case FIFTEEN:
			return 500;
		case TWENTY:
			return 425;
		case TWENTY_FIVE:
			return 350;
		case THIRTY:
			return 300;
		case THIRTY_FIVE:
			return 250;
		case FORTY:
			return 190;
		case FORTY_FIVE:
			return 150;
		case FIFTY:
			return 125;
		case FIFTY_FIVE:
			return 80;
		case SIXTY:
			return 60;
		case SIXTY_FIVE:
			return 40;
		case SEVENTY:
			return 22.5;
		case SEVENTY_FIVE:
			return 12;
		case EIGHTY:
			return 4.5;
		}
		return 0;
	}

	/**
	 * Z = 3.0
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ3Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 460;
		case FIVE:
			return 440;
		case TEN:
			return 400;
		case FIFTEEN:
			return 350;
		case TWENTY:
			return 300;
		case TWENTY_FIVE:
			return 250;
		case THIRTY:
			return 200;
		case THIRTY_FIVE:
			return 175;
		case FORTY:
			return 135;
		case FORTY_FIVE:
			return 100;
		case FIFTY:
			return 80;
		case FIFTY_FIVE:
			return 60;
		case SIXTY:
			return 43;
		case SIXTY_FIVE:
			return 28;
		case SEVENTY:
			return 18;
		case SEVENTY_FIVE:
			return 9;
		case EIGHTY:
			return 4;
		}
		return 0;
	}

	/**
	 * Z = 3.575
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ3575Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 300;
		case FIVE:
			return 300;
		case TEN:
			return 275;
		case FIFTEEN:
			return 250;
		case TWENTY:
			return 200;
		case TWENTY_FIVE:
			return 175;
		case THIRTY:
			return 160;
		case THIRTY_FIVE:
			return 135;
		case FORTY:
			return 100;
		case FORTY_FIVE:
			return 85;
		case FIFTY:
			return 63;
		case FIFTY_FIVE:
			return 50;
		case SIXTY:
			return 38;
		case SIXTY_FIVE:
			return 25;
		case SEVENTY:
			return 16;
		case SEVENTY_FIVE:
			return 8;
		case EIGHTY:
			return 3;
		}
		return 0;
	}

	/**
	 * Z = 4.15
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ415Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 185;
		case FIVE:
			return 185;
		case TEN:
			return 175;
		case FIFTEEN:
			return 155;
		case TWENTY:
			return 145;
		case TWENTY_FIVE:
			return 135;
		case THIRTY:
			return 110;
		case THIRTY_FIVE:
			return 95;
		case FORTY:
			return 80;
		case FORTY_FIVE:
			return 70;
		case FIFTY:
			return 55;
		case FIFTY_FIVE:
			return 45;
		case SIXTY:
			return 30;
		case SIXTY_FIVE:
			return 20;
		case SEVENTY:
			return 14;
		case SEVENTY_FIVE:
			return 7;
		case EIGHTY:
			return 3;
		}
		return 0;
	}

	/**
	 * Z = 5.125
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ5125Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 125;
		case FIVE:
			return 125;
		case TEN:
			return 110;
		case FIFTEEN:
			return 100;
		case TWENTY:
			return 95;
		case TWENTY_FIVE:
			return 90;
		case THIRTY:
			return 85;
		case THIRTY_FIVE:
			return 75;
		case FORTY:
			return 65;
		case FORTY_FIVE:
			return 55;
		case FIFTY:
			return 45;
		case FIFTY_FIVE:
			return 33;
		case SIXTY:
			return 25;
		case SIXTY_FIVE:
			return 18;
		case SEVENTY:
			return 11;
		case SEVENTY_FIVE:
			return 6;
		case EIGHTY:
			return 2;
		}
		return 0;
	}

	/**
	 * Z = 5.3
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ53Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 75;
		case FIVE:
			return 77.5;
		case TEN:
			return 77.5;
		case FIFTEEN:
			return 75;
		case TWENTY:
			return 72.5;
		case TWENTY_FIVE:
			return 70;
		case THIRTY:
			return 60;
		case THIRTY_FIVE:
			return 57.5;
		case FORTY:
			return 52.5;
		case FORTY_FIVE:
			return 45;
		case FIFTY:
			return 37.5;
		case FIFTY_FIVE:
			return 29;
		case SIXTY:
			return 21.5;
		case SIXTY_FIVE:
			return 15.5;
		case SEVENTY:
			return 9;
		case SEVENTY_FIVE:
			return 4.5;
		case EIGHTY:
			return 2;
		}
		return 0;
	}

	/**
	 * Z = 7.2
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ72Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 32;
		case FIVE:
			return 35;
		case TEN:
			return 35;
		case FIFTEEN:
			return 35;
		case TWENTY:
			return 32.5;
		case TWENTY_FIVE:
			return 30;
		case THIRTY:
			return 30;
		case THIRTY_FIVE:
			return 28;
		case FORTY:
			return 26;
		case FORTY_FIVE:
			return 23;
		case FIFTY:
			return 20;
		case FIFTY_FIVE:
			return 16;
		case SIXTY:
			return 13;
		case SIXTY_FIVE:
			return 8.5;
		case SEVENTY:
			return 5.5;
		case SEVENTY_FIVE:
			return 3;
		case EIGHTY:
			return 1.5;
		}
		return 0;
	}

	/**
	 * Z = 8.9
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ89Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 20;
		case FIVE:
			return 20;
		case TEN:
			return 20;
		case FIFTEEN:
			return 20;
		case TWENTY:
			return 20;
		case TWENTY_FIVE:
			return 20;
		case THIRTY:
			return 18.5;
		case THIRTY_FIVE:
			return 17.5;
		case FORTY:
			return 16;
		case FORTY_FIVE:
			return 15;
		case FIFTY:
			return 13;
		case FIFTY_FIVE:
			return 10;
		case SIXTY:
			return 8;
		case SIXTY_FIVE:
			return 5.7;
		case SEVENTY:
			return 4;
		case SEVENTY_FIVE:
			return 2;
		case EIGHTY:
			return 1;
		}
		return 0;
	}

	/**
	 * Z = 11.9
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ119Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 10;
		case FIVE:
			return 10;
		case TEN:
			return 10;
		case FIFTEEN:
			return 10;
		case TWENTY:
			return 10;
		case TWENTY_FIVE:
			return 10;
		case THIRTY:
			return 10;
		case THIRTY_FIVE:
			return 9;
		case FORTY:
			return 9;
		case FORTY_FIVE:
			return 8;
		case FIFTY:
			return 7;
		case FIFTY_FIVE:
			return 6;
		case SIXTY:
			return 5;
		case SIXTY_FIVE:
			return 4;
		case SEVENTY:
			return 3.8;
		case SEVENTY_FIVE:
			return 1.7;
		case EIGHTY:
			return 1;
		}
		return 0;
	}

	/**
	 * Z = 14.3
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ143Angle(int angle) {

		switch (angle) {
		case ZERO:
			return 8;
		case FIVE:
			return 8;
		case TEN:
			return 8;
		case FIFTEEN:
			return 8;
		case TWENTY:
			return 8;
		case TWENTY_FIVE:
			return 8;
		case THIRTY:
			return 7;
		case THIRTY_FIVE:
			return 6;
		case FORTY:
			return 5.5;
		case FORTY_FIVE:
			return 5;
		case FIFTY:
			return 4.5;
		case FIFTY_FIVE:
			return 4;
		case SIXTY:
			return 3.3;
		case SIXTY_FIVE:
			return 2.6;
		case SEVENTY:
			return 2;
		case SEVENTY_FIVE:
			return 1.5;
		case EIGHTY:
			return 1;
		}

		return angle;

	}

}
