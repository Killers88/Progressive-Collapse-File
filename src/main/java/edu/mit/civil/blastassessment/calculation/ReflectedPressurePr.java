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
		} else if ((z > 1.35) && (z < 2.45)) {
			return findingPrWithZ19Angle(angle);
		} else if ((z > 2.45) && (z < 4.15)) {
			return findingPrWithZ30Angle(angle);
		} else if ((z > 4.15) && (z < 6.25)) {
			return findingPrWithZ53Angle(angle);
		} else if ((z > 6.25) && (z < 8.05)) {
			return findingPrWithZ72Angle(angle);
		} else if ((z > 8.05) && (z < 10.4)) {
			return findingPrWithZ89Angle(angle);
		} else if ((z > 10.4) && (z < 13.1)) {
			return findingPrWithZ119Angle(angle);
		} else if (z > 13.1) {
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
	 * Z = 3.0
	 * 
	 * @param angle
	 * @return
	 */
	private static double findingPrWithZ30Angle(int angle) {

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

// else if ((z > 0.45) && (z < 0.7)) {
//
// graph.put((double) 0, (double) 19500);
// graph.put((double) 5, (double) 19000);
// graph.put((double) 10, (double) 18900);
// graph.put((double) 15, (double) 18000);
// graph.put((double) 20, (double) 18000);
// graph.put((double) 25, (double) 16500);
// graph.put((double) 30, (double) 14500);
// graph.put((double) 35, (double) 12000);
// graph.put((double) 40, (double) 10000);
// graph.put((double) 45, (double) 8000);
// graph.put((double) 50, (double) 6000);
// graph.put((double) 55, (double) 4250);
// graph.put((double) 60, (double) 3000);
// graph.put((double) 65, (double) 1750);
// graph.put((double) 70, (double) 850);
// graph.put((double) 75, (double) 375);
// graph.put((double) 80, (double) 120);
//
// return (newPr);
//
// }
//
// else if ((z > 0.7) && (z < 1.35)) {
//
// graph.put((double) 0, (double) 10000);
// graph.put((double) 5, (double) 10000);
// graph.put((double) 10, (double) 10000);
// graph.put((double) 15, (double) 10000);
// graph.put((double) 20, (double) 9000);
// graph.put((double) 25, (double) 8000);
// graph.put((double) 30, (double) 7000);
// graph.put((double) 35, (double) 6000);
// graph.put((double) 40, (double) 4750);
// graph.put((double) 45, (double) 3600);
// graph.put((double) 50, (double) 2600);
// graph.put((double) 55, (double) 1900);
// graph.put((double) 60, (double) 1250);
// graph.put((double) 65, (double) 800);
// graph.put((double) 70, (double) 400);
// graph.put((double) 75, (double) 175);
// graph.put((double) 80, (double) 55);
//
// return (newPr);
//
// }
//
// else if ((z > 1.35) && (z < 2.45)) {
//
// graph.put((double) 0, (double) 1700);
// graph.put((double) 5, (double) 1700);
// graph.put((double) 10, (double) 1650);
// graph.put((double) 15, (double) 1500);
// graph.put((double) 20, (double) 1350);
// graph.put((double) 25, (double) 1200);
// graph.put((double) 30, (double) 1000);
// graph.put((double) 35, (double) 875);
// graph.put((double) 40, (double) 725);
// graph.put((double) 45, (double) 575);
// graph.put((double) 50, (double) 435);
// graph.put((double) 55, (double) 300);
// graph.put((double) 60, (double) 200);
// graph.put((double) 65, (double) 130);
// graph.put((double) 70, (double) 65);
// graph.put((double) 75, (double) 28);
// graph.put((double) 80, (double) 10);
//
// return (newPr);
//
// }
//
// else if ((z > 2.45) && (z < 4.15)) {
//
// graph.put((double) 0, (double) 460);
// graph.put((double) 5, (double) 440);
// graph.put((double) 10, (double) 400);
// graph.put((double) 15, (double) 350);
// graph.put((double) 20, (double) 300);
// graph.put((double) 25, (double) 250);
// graph.put((double) 30, (double) 200);
// graph.put((double) 35, (double) 175);
// graph.put((double) 40, (double) 135);
// graph.put((double) 45, (double) 100);
// graph.put((double) 50, (double) 80);
// graph.put((double) 55, (double) 60);
// graph.put((double) 60, (double) 42.5);
// graph.put((double) 65, (double) 28);
// graph.put((double) 70, (double) 17.5);
// graph.put((double) 75, (double) 9);
// graph.put((double) 80, (double) 3.7);
//
// return (newPr);
//
// }
//
// else if ((z > 4.15) && (z < 6.25)) {
//
// graph.put((double) 0, (double) 75);
// graph.put((double) 5, (double) 77.5);
// graph.put((double) 10, (double) 77.5);
// graph.put((double) 15, (double) 75);
// graph.put((double) 20, (double) 72.5);
// graph.put((double) 25, (double) 70);
// graph.put((double) 30, (double) 65);
// graph.put((double) 35, (double) 57.5);
// graph.put((double) 40, (double) 52.5);
// graph.put((double) 45, (double) 45);
// graph.put((double) 50, (double) 37.5);
// graph.put((double) 55, (double) 29);
// graph.put((double) 60, (double) 21.5);
// graph.put((double) 65, (double) 15.5);
// graph.put((double) 70, (double) 9);
// graph.put((double) 75, (double) 4.5);
// graph.put((double) 80, (double) 2);
//
// return (newPr);
//
// }
//
// else if ((z > 6.25) && (z < 8.05)) {
//
// graph.put((double) 0, (double) 32);
// graph.put((double) 5, (double) 35);
// graph.put((double) 10, (double) 35);
// graph.put((double) 15, (double) 35);
// graph.put((double) 20, (double) 32.5);
// graph.put((double) 25, (double) 30);
// graph.put((double) 30, (double) 30);
// graph.put((double) 35, (double) 28);
// graph.put((double) 40, (double) 26);
// graph.put((double) 45, (double) 23);
// graph.put((double) 50, (double) 20);
// graph.put((double) 55, (double) 16);
// graph.put((double) 60, (double) 13);
// graph.put((double) 65, (double) 8.5);
// graph.put((double) 70, (double) 5.5);
// graph.put((double) 75, (double) 3);
// graph.put((double) 80, (double) 1.5);
//
// return (newPr);
//
// }
//
// else if ((z > 8.05) && (z < 10.4)) {
//
// graph.put((double) 0, (double) 20);
// graph.put((double) 5, (double) 20);
// graph.put((double) 10, (double) 20);
// graph.put((double) 15, (double) 20);
// graph.put((double) 20, (double) 20);
// graph.put((double) 25, (double) 20);
// graph.put((double) 30, (double) 18.5);
// graph.put((double) 35, (double) 17.5);
// graph.put((double) 40, (double) 16);
// graph.put((double) 45, (double) 15);
// graph.put((double) 50, (double) 13);
// graph.put((double) 55, (double) 10);
// graph.put((double) 60, (double) 8);
// graph.put((double) 65, (double) 5.7);
// graph.put((double) 70, (double) 4);
// graph.put((double) 75, (double) 2);
// graph.put((double) 80, (double) 1);
//
// return (newPr);
//
// }
//
// else if ((z > 10.4) && (z < 13.1)) {
//
// graph.put((double) 0, (double) 10);
// graph.put((double) 5, (double) 10);
// graph.put((double) 10, (double) 10);
// graph.put((double) 15, (double) 10);
// graph.put((double) 20, (double) 10);
// graph.put((double) 25, (double) 10);
// graph.put((double) 30, (double) 10);
// graph.put((double) 35, (double) 9);
// graph.put((double) 40, (double) 9);
// graph.put((double) 45, (double) 8);
// graph.put((double) 50, (double) 7);
// graph.put((double) 55, (double) 6);
// graph.put((double) 60, (double) 5);
// graph.put((double) 65, (double) 4);
// graph.put((double) 70, (double) 3.8);
// graph.put((double) 75, (double) 1.7);
// graph.put((double) 80, (double) 1);
//
// return (newPr);
//
// }
//
// else if (z > 13.1) {
//
// graph.put((double) 0, (double) 8);
// graph.put((double) 5, (double) 8);
// graph.put((double) 10, (double) 8);
// graph.put((double) 15, (double) 8);
// graph.put((double) 20, (double) 8);
// graph.put((double) 25, (double) 8);
// graph.put((double) 30, (double) 7);
// graph.put((double) 35, (double) 6);
// graph.put((double) 40, (double) 5.5);
// graph.put((double) 45, (double) 5);
// graph.put((double) 50, (double) 4.5);
// graph.put((double) 55, (double) 4);
// graph.put((double) 60, (double) 3.3);
// graph.put((double) 65, (double) 2.6);
// graph.put((double) 70, (double) 2);
// graph.put((double) 75, (double) 1.5);
// graph.put((double) 80, (double) 1);
//
// return (newPr);
//
// }
// return newPr;
// }