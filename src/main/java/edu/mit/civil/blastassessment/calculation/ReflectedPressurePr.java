package edu.mit.civil.blastassessment.calculation;

import java.util.HashMap;
import java.util.Map;

public class ReflectedPressurePr {
	/**
	 * Pr(alpha) calculated Reflected Pressure Coefficient - GRAPH UFC 3-340 Fig
	 * 2.193 pg 268
	 * 
	 * Angle in increments of 5 degrees
	 */

	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	public static double findReflectedPressureWith(final double angle,
			final double pso) {
		if (pso < 25) {
			graph.put((double) 0, (double) 2.85);
			graph.put((double) 5, (double) 2.85);
			graph.put((double) 10, (double) 2.85);
			graph.put((double) 15, (double) 2.8);
			graph.put((double) 20, (double) 2.75);
			graph.put((double) 25, (double) 2.7);
			graph.put((double) 30, (double) 2.7);
			graph.put((double) 35, (double) 2.75);
			graph.put((double) 40, (double) 3);
			graph.put((double) 45, (double) 2.9);
			graph.put((double) 50, (double) 2.3);
			graph.put((double) 55, (double) 2);
			graph.put((double) 60, (double) 1.75);
			graph.put((double) 65, (double) 1.5);
			graph.put((double) 70, (double) 1.3);
			graph.put((double) 75, (double) 1.25);
			graph.put((double) 80, (double) 1.2);

			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 25) && (pso < 40)) {
			graph.put((double) 0, (double) 3.2);
			graph.put((double) 5, (double) 3.15);
			graph.put((double) 10, (double) 3.1);
			graph.put((double) 15, (double) 3.05);
			graph.put((double) 20, (double) 3);
			graph.put((double) 25, (double) 3);
			graph.put((double) 30, (double) 3);
			graph.put((double) 35, (double) 3);
			graph.put((double) 40, (double) 3.5);
			graph.put((double) 45, (double) 2.6);
			graph.put((double) 50, (double) 2.25);
			graph.put((double) 55, (double) 1.9);
			graph.put((double) 60, (double) 1.6);
			graph.put((double) 65, (double) 1.4);
			graph.put((double) 70, (double) 1.3);
			graph.put((double) 75, (double) 1.25);
			graph.put((double) 80, (double) 1.2);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 40) && (pso < 60)) {
			graph.put((double) 0, (double) 4.4);
			graph.put((double) 5, (double) 4.35);
			graph.put((double) 10, (double) 4.3);
			graph.put((double) 15, (double) 4.25);
			graph.put((double) 20, (double) 4.1);
			graph.put((double) 25, (double) 4.05);
			graph.put((double) 30, (double) 4);
			graph.put((double) 35, (double) 3.8);
			graph.put((double) 40, (double) 4.3);
			graph.put((double) 45, (double) 3.3);
			graph.put((double) 50, (double) 2.6);
			graph.put((double) 55, (double) 2.25);
			graph.put((double) 60, (double) 1.95);
			graph.put((double) 65, (double) 1.7);
			graph.put((double) 70, (double) 1.5);
			graph.put((double) 75, (double) 1.3);
			graph.put((double) 80, (double) 1.1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 60) && (pso < 78.75)) {
			graph.put((double) 0, (double) 4.4);
			graph.put((double) 5, (double) 4.35);
			graph.put((double) 10, (double) 4.3);
			graph.put((double) 15, (double) 4.25);
			graph.put((double) 20, (double) 4.1);
			graph.put((double) 25, (double) 4.05);
			graph.put((double) 30, (double) 4);
			graph.put((double) 35, (double) 3.8);
			graph.put((double) 40, (double) 4.3);
			graph.put((double) 45, (double) 3.3);
			graph.put((double) 50, (double) 2.6);
			graph.put((double) 55, (double) 2.25);
			graph.put((double) 60, (double) 1.95);
			graph.put((double) 65, (double) 1.7);
			graph.put((double) 70, (double) 1.5);
			graph.put((double) 75, (double) 1.3);
			graph.put((double) 80, (double) 1.1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 78.75) && (pso < 93.75)) {
			graph.put((double) 0, (double) 4.65);
			graph.put((double) 5, (double) 4.6);
			graph.put((double) 10, (double) 4.575);
			graph.put((double) 15, (double) 4.475);
			graph.put((double) 20, (double) 4.35);
			graph.put((double) 25, (double) 4.275);
			graph.put((double) 30, (double) 4.175);
			graph.put((double) 35, (double) 4.025);
			graph.put((double) 40, (double) 4.45);
			graph.put((double) 45, (double) 3.65);
			graph.put((double) 50, (double) 2.9);
			graph.put((double) 55, (double) 2.875);
			graph.put((double) 60, (double) 2.075);
			graph.put((double) 65, (double) 1.75);
			graph.put((double) 70, (double) 1.55);
			graph.put((double) 75, (double) 1.4);
			graph.put((double) 80, (double) 1.15);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 93.75) && (pso < 112.5)) {
			graph.put((double) 0, (double) 4.9);
			graph.put((double) 5, (double) 4.85);
			graph.put((double) 10, (double) 4.85);
			graph.put((double) 15, (double) 4.7);
			graph.put((double) 20, (double) 4.6);
			graph.put((double) 25, (double) 4.5);
			graph.put((double) 30, (double) 4.35);
			graph.put((double) 35, (double) 4.25);
			graph.put((double) 40, (double) 4.6);
			graph.put((double) 45, (double) 4);
			graph.put((double) 50, (double) 3.2);
			graph.put((double) 55, (double) 3.5);
			graph.put((double) 60, (double) 2.2);
			graph.put((double) 65, (double) 1.8);
			graph.put((double) 70, (double) 1.6);
			graph.put((double) 75, (double) 1.5);
			graph.put((double) 80, (double) 1.2);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 112.5) && (pso < 137.5)) {
			graph.put((double) 0, (double) 5.2);
			graph.put((double) 5, (double) 5.15);
			graph.put((double) 10, (double) 5.1);
			graph.put((double) 15, (double) 5.025);
			graph.put((double) 20, (double) 4.85);
			graph.put((double) 25, (double) 4.75);
			graph.put((double) 30, (double) 4.525);
			graph.put((double) 35, (double) 4.425);
			graph.put((double) 40, (double) 4.7);
			graph.put((double) 45, (double) 4.35);
			graph.put((double) 50, (double) 3.6);
			graph.put((double) 55, (double) 3.375);
			graph.put((double) 60, (double) 2.35);
			graph.put((double) 65, (double) 1.9);
			graph.put((double) 70, (double) 1.7);
			graph.put((double) 75, (double) 1.5);
			graph.put((double) 80, (double) 1.2);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 137.5) && (pso < 162.5)) {
			graph.put((double) 0, (double) 5.5);
			graph.put((double) 5, (double) 5.45);
			graph.put((double) 10, (double) 5.35);
			graph.put((double) 15, (double) 5.35);
			graph.put((double) 20, (double) 5.1);
			graph.put((double) 25, (double) 5);
			graph.put((double) 30, (double) 4.7);
			graph.put((double) 35, (double) 4.6);
			graph.put((double) 40, (double) 4.8);
			graph.put((double) 45, (double) 4.7);
			graph.put((double) 50, (double) 4);
			graph.put((double) 55, (double) 3.25);
			graph.put((double) 60, (double) 2.5);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.8);
			graph.put((double) 75, (double) 1.5);
			graph.put((double) 80, (double) 1.2);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 162.5) && (pso < 187.5)) {
			graph.put((double) 0, (double) 5.75);
			graph.put((double) 5, (double) 5.675);
			graph.put((double) 10, (double) 5.575);
			graph.put((double) 15, (double) 5.525);
			graph.put((double) 20, (double) 5.35);
			graph.put((double) 25, (double) 5.2);
			graph.put((double) 30, (double) 4.9);
			graph.put((double) 35, (double) 4.7);
			graph.put((double) 40, (double) 4.9);
			graph.put((double) 45, (double) 4.85);
			graph.put((double) 50, (double) 4.25);
			graph.put((double) 55, (double) 3.425);
			graph.put((double) 60, (double) 3.125);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.8);
			graph.put((double) 75, (double) 1.4);
			graph.put((double) 80, (double) 1.15);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 187.5) && (pso < 225)) {
			graph.put((double) 0, (double) 6);
			graph.put((double) 5, (double) 5.9);
			graph.put((double) 10, (double) 5.8);
			graph.put((double) 15, (double) 5.7);
			graph.put((double) 20, (double) 5.6);
			graph.put((double) 25, (double) 5.4);
			graph.put((double) 30, (double) 5.1);
			graph.put((double) 35, (double) 4.8);
			graph.put((double) 40, (double) 5);
			graph.put((double) 45, (double) 5);
			graph.put((double) 50, (double) 4.5);
			graph.put((double) 55, (double) 3.6);
			graph.put((double) 60, (double) 3.75);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.8);
			graph.put((double) 75, (double) 1.3);
			graph.put((double) 80, (double) 1.1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 225) && (pso < 275)) {
			graph.put((double) 0, (double) 6.325);
			graph.put((double) 5, (double) 6.225);
			graph.put((double) 10, (double) 6.1);
			graph.put((double) 15, (double) 6);
			graph.put((double) 20, (double) 5.875);
			graph.put((double) 25, (double) 5.65);
			graph.put((double) 30, (double) 5.35);
			graph.put((double) 35, (double) 5.025);
			graph.put((double) 40, (double) 5.125);
			graph.put((double) 45, (double) 5.45);
			graph.put((double) 50, (double) 4.75);
			graph.put((double) 55, (double) 3.8);
			graph.put((double) 60, (double) 3.375);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.55);
			graph.put((double) 75, (double) 1.2);
			graph.put((double) 80, (double) 1.05);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 275) && (pso < 325)) {
			graph.put((double) 0, (double) 6.65);
			graph.put((double) 5, (double) 6.55);
			graph.put((double) 10, (double) 6.4);
			graph.put((double) 15, (double) 6.3);
			graph.put((double) 20, (double) 6.15);
			graph.put((double) 25, (double) 5.9);
			graph.put((double) 30, (double) 5.6);
			graph.put((double) 35, (double) 5.25);
			graph.put((double) 40, (double) 5.25);
			graph.put((double) 45, (double) 5.9);
			graph.put((double) 50, (double) 5);
			graph.put((double) 55, (double) 4);
			graph.put((double) 60, (double) 3);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.3);
			graph.put((double) 75, (double) 1.1);
			graph.put((double) 80, (double) 1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 325) && (pso < 375)) {
			graph.put((double) 0, (double) 6.825);
			graph.put((double) 5, (double) 6.725);
			graph.put((double) 10, (double) 6.6);
			graph.put((double) 15, (double) 6.5);
			graph.put((double) 20, (double) 6.35);
			graph.put((double) 25, (double) 6.1);
			graph.put((double) 30, (double) 5.8);
			graph.put((double) 35, (double) 5.45);
			graph.put((double) 40, (double) 5.325);
			graph.put((double) 45, (double) 6.2);
			graph.put((double) 50, (double) 5.3);
			graph.put((double) 55, (double) 4.1);
			graph.put((double) 60, (double) 3);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.3);
			graph.put((double) 75, (double) 1.1);
			graph.put((double) 80, (double) 1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		} else if ((pso >= 375) && (pso < 450)) {
			graph.put((double) 0, (double) 7);
			graph.put((double) 5, (double) 6.9);
			graph.put((double) 10, (double) 6.8);
			graph.put((double) 15, (double) 6.7);
			graph.put((double) 20, (double) 6.55);
			graph.put((double) 25, (double) 6.3);
			graph.put((double) 30, (double) 6);
			graph.put((double) 35, (double) 5.65);
			graph.put((double) 40, (double) 5.4);
			graph.put((double) 45, (double) 6.5);
			graph.put((double) 50, (double) 5.6);
			graph.put((double) 55, (double) 4.2);
			graph.put((double) 60, (double) 3);
			graph.put((double) 65, (double) 2);
			graph.put((double) 70, (double) 1.3);
			graph.put((double) 75, (double) 1.1);
			graph.put((double) 80, (double) 1);
			if (angle > 0) {
				double cr = (graph.get(angle));
				return cr * pso;
			}
			// TODO add logging here
			throw new RuntimeException(
					"invalid ANGLE (must be increments of 5deg). Range of Pso 25 to 450");
		}
		return pso;
	}

}
