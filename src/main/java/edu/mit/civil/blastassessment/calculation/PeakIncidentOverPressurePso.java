package edu.mit.civil.blastassessment.calculation;

import java.util.HashMap;
import java.util.Map;

public class PeakIncidentOverPressurePso {

	/**
	 * Data Representation for GRAPH UFC 3-340 Fig 2.15 pg 166. In Increments of
	 * 0.25
	 */
	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static {
		graph.put((double) 0.3, (double) 3700);
		graph.put((double) 0.4, (double) 3300);
		graph.put((double) 0.5, (double) 2700);
		graph.put((double) 0.6, (double) 2000);
		graph.put((double) 0.7, (double) 1750);
		graph.put((double) 0.8, (double) 1350);
		graph.put((double) 0.9, (double) 1250);
		graph.put((double) 1, (double) 1000);
		graph.put((double) 1.1, (double) 900);
		graph.put((double) 1.2, (double) 850);
		graph.put((double) 1.3, (double) 800);
		graph.put((double) 1.4, (double) 700);
		graph.put((double) 1.5, (double) 600);
		graph.put((double) 1.6, (double) 500);
		graph.put((double) 1.7, (double) 450);
		graph.put((double) 1.8, (double) 400);
		graph.put((double) 1.9, (double) 350);
		graph.put((double) 2, (double) 300);
		graph.put((double) 2.1, (double) 285.7142857);
		graph.put((double) 2.2, (double) 271.4285714);
		graph.put((double) 2.3, (double) 257.1428571);
		graph.put((double) 2.4, (double) 242.8571429);
		graph.put((double) 2.5, (double) 228.5714286);
		graph.put((double) 2.6, (double) 200);
		graph.put((double) 2.7, (double) 185);
		graph.put((double) 2.8, (double) 170);
		graph.put((double) 2.9, (double) 155);
		graph.put((double) 3, (double) 140);
		graph.put((double) 3.1, (double) 130);
		graph.put((double) 3.2, (double) 120);
		graph.put((double) 3.3, (double) 110);
		graph.put((double) 3.4, (double) 100);
		graph.put((double) 3.5, (double) 95);
		graph.put((double) 3.6, (double) 90);
		graph.put((double) 3.7, (double) 85);
		graph.put((double) 3.8, (double) 80);
		graph.put((double) 3.9, (double) 75);
		graph.put((double) 4, (double) 70);
		graph.put((double) 4.1, (double) 66.6);
		graph.put((double) 4.2, (double) 63.3);
		graph.put((double) 4.3, (double) 60);
		graph.put((double) 4.4, (double) 58);
		graph.put((double) 4.5, (double) 56);
		graph.put((double) 4.6, (double) 54);
		graph.put((double) 4.7, (double) 52);
		graph.put((double) 4.8, (double) 50);
		graph.put((double) 4.9, (double) 45);
		graph.put((double) 5, (double) 40);
		graph.put((double) 5.1, (double) 38.75);
		graph.put((double) 5.2, (double) 37.5);
		graph.put((double) 5.3, (double) 36.25);
		graph.put((double) 5.4, (double) 35);
		graph.put((double) 5.5, (double) 33.75);
		graph.put((double) 5.6, (double) 32.5);
		graph.put((double) 5.7, (double) 31.25);
		graph.put((double) 5.8, (double) 30);
		graph.put((double) 5.9, (double) 29.16666667);
		graph.put((double) 6, (double) 28.33333333);
		graph.put((double) 6.1, (double) 27.5);
		graph.put((double) 6.2, (double) 26.66666667);
		graph.put((double) 6.3, (double) 25.83333333);
		graph.put((double) 6.4, (double) 25);
		graph.put((double) 6.5, (double) 24.16666667);
		graph.put((double) 6.6, (double) 23.33333333);
		graph.put((double) 6.7, (double) 22.5);
		graph.put((double) 6.8, (double) 21.66666667);
		graph.put((double) 6.9, (double) 20.83333333);
		graph.put((double) 7, (double) 20);
		graph.put((double) 7.1, (double) 19.6);
		graph.put((double) 7.2, (double) 19.2);
		graph.put((double) 7.3, (double) 18.8);
		graph.put((double) 7.4, (double) 18.4);
		graph.put((double) 7.5, (double) 18);
		graph.put((double) 7.6, (double) 17.6);
		graph.put((double) 7.7, (double) 17.2);
		graph.put((double) 7.8, (double) 16.8);
		graph.put((double) 7.9, (double) 16.4);
		graph.put((double) 8, (double) 16);
		graph.put((double) 8.1, (double) 15.7);
		graph.put((double) 8.2, (double) 15.4);
		graph.put((double) 8.3, (double) 15.1);
		graph.put((double) 8.4, (double) 14.8);
		graph.put((double) 8.5, (double) 14.5);
		graph.put((double) 8.6, (double) 14.2);
		graph.put((double) 8.7, (double) 13.9);
		graph.put((double) 8.8, (double) 13.6);
		graph.put((double) 8.9, (double) 13.3);
		graph.put((double) 9, (double) 13);
		graph.put((double) 9.1, (double) 12.65);
		graph.put((double) 9.2, (double) 12.3);
		graph.put((double) 9.3, (double) 11.95);
		graph.put((double) 9.4, (double) 11.6);
		graph.put((double) 9.5, (double) 11.25);
		graph.put((double) 9.6, (double) 10.9);
		graph.put((double) 9.7, (double) 10.55);
		graph.put((double) 9.8, (double) 10.2);
		graph.put((double) 9.9, (double) 9.85);
		graph.put((double) 10, (double) 9.5);
	}

	/**
	 * Return Peak Incident Over-Pressure Pso
	 * 
	 * @param z
	 * @return
	 */
	public static double findPeakIncidentOverPressureWith(final double z) {
		// Check that Z is greater than 0
		if (z > 0) {
			// http://stackoverflow.com/questions/5419123/how-to-round-a-float-to-the-nearest-quarter
			float coeff = 10f;
			double nearestTenthZ = Math.round(z * coeff) / 10.0;
			return (graph.get(nearestTenthZ));
		}
		// TODO add logging here
		throw new RuntimeException("invalid Z value - Range 0.25 to 40");
	}
}
