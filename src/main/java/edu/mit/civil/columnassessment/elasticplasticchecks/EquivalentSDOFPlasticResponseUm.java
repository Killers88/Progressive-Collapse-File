/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFPlasticResponseUm {

	public static double maxDeflectionPlasticInputsTeDivideTn(final double te,
			final double tn) {

		return (te / 1000) / tn;

	}

	public static double maxDeflectionPlasticInputsRuDivideP(final double ru,
			final double q) {

		return (ru) / (q / 6.944);

	}

	private static Map<Double, Double> graph = new HashMap<Double, Double>();

	static double retrievingGraphData(final double te, final double tn,
			final double ru, final double uy, final double pr) {

		double graphinput = (ru) / (pr / 6.944);

		double tDivideTn = (te / 1000) / tn;

		if (graphinput < 0.15) {
			graph.put((double) 0.1, (double) 5.5);
			graph.put((double) 0.15, (double) 10);
			graph.put((double) 0.2, (double) 19);
			graph.put((double) 0.25, (double) 28);
			graph.put((double) 0.3, (double) 40);
			graph.put((double) 0.35, (double) 56);
			graph.put((double) 0.4, (double) 70);
			graph.put((double) 0.45, (double) 90);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException(
					"Review T/Tn & ru/P. Review Values Above");
		} else if ((graphinput > 0.15) && (graphinput <= 0.25)) {
			graph.put((double) 0.1, (double) 1.75);
			graph.put((double) 0.15, (double) 3);
			graph.put((double) 0.2, (double) 5);
			graph.put((double) 0.25, (double) 7.25);
			graph.put((double) 0.3, (double) 10);
			graph.put((double) 0.35, (double) 14);
			graph.put((double) 0.4, (double) 17);
			graph.put((double) 0.45, (double) 22.5);
			graph.put((double) 0.5, (double) 26);
			graph.put((double) 0.55, (double) 33);
			graph.put((double) 0.6, (double) 37);
			graph.put((double) 0.65, (double) 44);
			graph.put((double) 0.7, (double) 48);
			graph.put((double) 0.75, (double) 56);
			graph.put((double) 0.8, (double) 64);
			graph.put((double) 0.85, (double) 73);
			graph.put((double) 0.9, (double) 80);
			graph.put((double) 0.95, (double) 87);
			graph.put((double) 1, (double) 100);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.25) && (graphinput < 0.35)) {
			graph.put((double) 0.1, (double) 1.1);
			graph.put((double) 0.15, (double) 1.65);
			graph.put((double) 0.2, (double) 2.55);
			graph.put((double) 0.25, (double) 3.6);
			graph.put((double) 0.3, (double) 4.7);
			graph.put((double) 0.35, (double) 6);
			graph.put((double) 0.4, (double) 7.5);
			graph.put((double) 0.45, (double) 9.2);
			graph.put((double) 0.5, (double) 11);
			graph.put((double) 0.55, (double) 13.5);
			graph.put((double) 0.6, (double) 16);
			graph.put((double) 0.65, (double) 18);
			graph.put((double) 0.7, (double) 20);
			graph.put((double) 0.75, (double) 23);
			graph.put((double) 0.8, (double) 26);
			graph.put((double) 0.85, (double) 28);
			graph.put((double) 0.9, (double) 32);
			graph.put((double) 0.95, (double) 35);
			graph.put((double) 1, (double) 38);
			graph.put((double) 1.1, (double) 43);
			graph.put((double) 1.2, (double) 47);
			graph.put((double) 1.3, (double) 54);
			graph.put((double) 1.4, (double) 63);
			graph.put((double) 1.5, (double) 75);
			graph.put((double) 1.6, (double) 85);
			graph.put((double) 1.7, (double) 100);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.35) && (graphinput <= 0.45)) {
			graph.put((double) 0.1, (double) 0.79);
			graph.put((double) 0.15, (double) 1.15);
			graph.put((double) 0.2, (double) 1.65);
			graph.put((double) 0.25, (double) 2.2);
			graph.put((double) 0.3, (double) 2.8);
			graph.put((double) 0.35, (double) 3.5);
			graph.put((double) 0.4, (double) 4.25);
			graph.put((double) 0.45, (double) 5);
			graph.put((double) 0.5, (double) 6);
			graph.put((double) 0.55, (double) 7);
			graph.put((double) 0.6, (double) 8);
			graph.put((double) 0.65, (double) 9);
			graph.put((double) 0.7, (double) 10);
			graph.put((double) 0.75, (double) 12.5);
			graph.put((double) 0.8, (double) 14);
			graph.put((double) 0.85, (double) 15);
			graph.put((double) 0.9, (double) 16.5);
			graph.put((double) 0.95, (double) 18);
			graph.put((double) 1, (double) 19.5);
			graph.put((double) 1.1, (double) 21);
			graph.put((double) 1.2, (double) 23);
			graph.put((double) 1.3, (double) 27);
			graph.put((double) 1.4, (double) 31);
			graph.put((double) 1.5, (double) 36);
			graph.put((double) 1.6, (double) 40);
			graph.put((double) 1.7, (double) 47.5);
			graph.put((double) 1.8, (double) 53);
			graph.put((double) 1.9, (double) 60);
			graph.put((double) 2, (double) 67);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.45) && (graphinput <= 0.55)) {
			graph.put((double) 0.1, (double) 0.63);
			graph.put((double) 0.15, (double) 0.88);
			graph.put((double) 0.2, (double) 1.3);
			graph.put((double) 0.25, (double) 1.6);
			graph.put((double) 0.3, (double) 1.95);
			graph.put((double) 0.35, (double) 2.4);
			graph.put((double) 0.4, (double) 2.8);
			graph.put((double) 0.45, (double) 3.3);
			graph.put((double) 0.5, (double) 3.8);
			graph.put((double) 0.55, (double) 4.5);
			graph.put((double) 0.6, (double) 5);
			graph.put((double) 0.65, (double) 5.5);
			graph.put((double) 0.7, (double) 6.25);
			graph.put((double) 0.75, (double) 7);
			graph.put((double) 0.8, (double) 7.75);
			graph.put((double) 0.85, (double) 8.5);
			graph.put((double) 0.9, (double) 9.25);
			graph.put((double) 0.95, (double) 10);
			graph.put((double) 1, (double) 11);
			graph.put((double) 1.1, (double) 12.5);
			graph.put((double) 1.2, (double) 14);
			graph.put((double) 1.3, (double) 15.5);
			graph.put((double) 1.4, (double) 17.5);
			graph.put((double) 1.5, (double) 20);
			graph.put((double) 1.6, (double) 22);
			graph.put((double) 1.7, (double) 26);
			graph.put((double) 1.8, (double) 28);
			graph.put((double) 1.9, (double) 31.5);
			graph.put((double) 2, (double) 35);
			graph.put((double) 2.1, (double) 37.5);
			graph.put((double) 2.2, (double) 40);
			graph.put((double) 2.3, (double) 43);
			graph.put((double) 2.4, (double) 46);
			graph.put((double) 2.5, (double) 48);
			graph.put((double) 2.6, (double) 53);
			graph.put((double) 2.7, (double) 56);
			graph.put((double) 2.8, (double) 60);
			graph.put((double) 2.9, (double) 65);
			graph.put((double) 3, (double) 70);
			graph.put((double) 3.5, (double) 90);
			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.55) && (graphinput <= 0.65)) {
			graph.put((double) 0.1, (double) 0.525);
			graph.put((double) 0.15, (double) 0.6);
			graph.put((double) 0.2, (double) 0.73);
			graph.put((double) 0.25, (double) 1);
			graph.put((double) 0.3, (double) 1.3);
			graph.put((double) 0.35, (double) 1.6);
			graph.put((double) 0.4, (double) 1.75);
			graph.put((double) 0.45, (double) 2.05);
			graph.put((double) 0.5, (double) 2.8);
			graph.put((double) 0.55, (double) 3.1);
			graph.put((double) 0.6, (double) 3.5);
			graph.put((double) 0.65, (double) 3.75);
			graph.put((double) 0.7, (double) 4.2);
			graph.put((double) 0.75, (double) 4.6);
			graph.put((double) 0.8, (double) 5);
			graph.put((double) 0.85, (double) 5.5);
			graph.put((double) 0.9, (double) 5.8);
			graph.put((double) 0.95, (double) 6.25);
			graph.put((double) 1, (double) 6.75);
			graph.put((double) 1.1, (double) 7.4);
			graph.put((double) 1.2, (double) 8);
			graph.put((double) 1.3, (double) 9);
			graph.put((double) 1.4, (double) 10);
			graph.put((double) 1.5, (double) 11.42857143);
			graph.put((double) 1.6, (double) 12.85714286);
			graph.put((double) 1.7, (double) 14.28571429);
			graph.put((double) 1.8, (double) 15.71428571);
			graph.put((double) 1.9, (double) 17.14285714);
			graph.put((double) 2, (double) 18.57142857);
			graph.put((double) 2.1, (double) 20);
			graph.put((double) 2.2, (double) 21.66666667);
			graph.put((double) 2.3, (double) 23.33333333);
			graph.put((double) 2.4, (double) 25);
			graph.put((double) 2.5, (double) 26.66666667);
			graph.put((double) 2.6, (double) 28.33333333);
			graph.put((double) 2.7, (double) 30);
			graph.put((double) 2.8, (double) 32);
			graph.put((double) 2.9, (double) 34);
			graph.put((double) 3, (double) 36.5);
			graph.put((double) 3.5, (double) 47);
			graph.put((double) 4, (double) 60);
			graph.put((double) 4.5, (double) 72.5);
			graph.put((double) 5, (double) 87);
			graph.put((double) 5.5, (double) 100);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.65) && (graphinput <= 0.725)) {
			graph.put((double) 0.1, (double) 0.45);
			graph.put((double) 0.15, (double) 0.625);
			graph.put((double) 0.2, (double) 0.85);
			graph.put((double) 0.25, (double) 1.05);
			graph.put((double) 0.3, (double) 1.3);
			graph.put((double) 0.35, (double) 1.55);
			graph.put((double) 0.4, (double) 1.7);
			graph.put((double) 0.45, (double) 1.85);
			graph.put((double) 0.5, (double) 2);
			graph.put((double) 0.55, (double) 2.3);
			graph.put((double) 0.6, (double) 2.55);
			graph.put((double) 0.65, (double) 2.8);
			graph.put((double) 0.7, (double) 2.95);
			graph.put((double) 0.75, (double) 3.25);
			graph.put((double) 0.8, (double) 3.5);
			graph.put((double) 0.85, (double) 3.75);
			graph.put((double) 0.9, (double) 4);
			graph.put((double) 0.95, (double) 4.25);
			graph.put((double) 1, (double) 4.5);
			graph.put((double) 1.1, (double) 4.75);
			graph.put((double) 1.2, (double) 5.1);
			graph.put((double) 1.3, (double) 5.75);
			graph.put((double) 1.4, (double) 6.2);
			graph.put((double) 1.5, (double) 6.8);
			graph.put((double) 1.6, (double) 7.5);
			graph.put((double) 1.7, (double) 8);
			graph.put((double) 1.8, (double) 9);
			graph.put((double) 1.9, (double) 10);
			graph.put((double) 2, (double) 11);
			graph.put((double) 2.1, (double) 11.8);
			graph.put((double) 2.2, (double) 12.6);
			graph.put((double) 2.3, (double) 13.4);
			graph.put((double) 2.4, (double) 14.2);
			graph.put((double) 2.5, (double) 15);
			graph.put((double) 2.6, (double) 15.8);
			graph.put((double) 2.7, (double) 16.6);
			graph.put((double) 2.8, (double) 17.4);
			graph.put((double) 2.9, (double) 18.2);
			graph.put((double) 3, (double) 19);
			graph.put((double) 3.5, (double) 23);
			graph.put((double) 4, (double) 29);
			graph.put((double) 4.5, (double) 34.5);
			graph.put((double) 5, (double) 41);
			graph.put((double) 5.5, (double) 48);
			graph.put((double) 6, (double) 55);
			graph.put((double) 6.5, (double) 64);
			graph.put((double) 7, (double) 70);
			graph.put((double) 8, (double) 90);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.725) && (graphinput <= 0.775)) {
			graph.put((double) 0.1, (double) 0.425);
			graph.put((double) 0.15, (double) 0.5875);
			graph.put((double) 0.2, (double) 0.8);
			graph.put((double) 0.25, (double) 0.975);
			graph.put((double) 0.3, (double) 1.2);
			graph.put((double) 0.35, (double) 1.425);
			graph.put((double) 0.4, (double) 1.575);
			graph.put((double) 0.45, (double) 1.75);
			graph.put((double) 0.5, (double) 1.875);
			graph.put((double) 0.55, (double) 2);
			graph.put((double) 0.6, (double) 2.2);
			graph.put((double) 0.65, (double) 2.35);
			graph.put((double) 0.7, (double) 2.5);
			graph.put((double) 0.75, (double) 2.75);
			graph.put((double) 0.8, (double) 3);
			graph.put((double) 0.85, (double) 3.25);
			graph.put((double) 0.9, (double) 3.4);
			graph.put((double) 0.95, (double) 3.6);
			graph.put((double) 1, (double) 3.75);
			graph.put((double) 1.1, (double) 4);
			graph.put((double) 1.2, (double) 4.25);
			graph.put((double) 1.3, (double) 4.6);
			graph.put((double) 1.4, (double) 4.9);
			graph.put((double) 1.5, (double) 5.4);
			graph.put((double) 1.6, (double) 5.8);
			graph.put((double) 1.7, (double) 6.3);
			graph.put((double) 1.8, (double) 7);
			graph.put((double) 1.9, (double) 7.5);
			graph.put((double) 2, (double) 8);
			graph.put((double) 2.1, (double) 8.5);
			graph.put((double) 2.2, (double) 9);
			graph.put((double) 2.3, (double) 9.5);
			graph.put((double) 2.4, (double) 9.8);
			graph.put((double) 2.5, (double) 10.5);
			graph.put((double) 2.6, (double) 12.2);
			graph.put((double) 2.7, (double) 13.9);
			graph.put((double) 2.8, (double) 15.6);
			graph.put((double) 2.9, (double) 17.725);
			graph.put((double) 3, (double) 19);
			graph.put((double) 3.5, (double) 23);
			graph.put((double) 4, (double) 29);
			graph.put((double) 4.5, (double) 35);
			graph.put((double) 5, (double) 41);
			graph.put((double) 5.5, (double) 47.5);
			graph.put((double) 6, (double) 55);
			graph.put((double) 6.5, (double) 64);
			graph.put((double) 7, (double) 70);
			graph.put((double) 8, (double) 90);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.775) && (graphinput <= 0.85)) {
			graph.put((double) 0.1, (double) 0.4);
			graph.put((double) 0.15, (double) 0.55);
			graph.put((double) 0.2, (double) 0.75);
			graph.put((double) 0.25, (double) 0.9);
			graph.put((double) 0.3, (double) 1.1);
			graph.put((double) 0.35, (double) 1.3);
			graph.put((double) 0.4, (double) 1.45);
			graph.put((double) 0.45, (double) 1.65);
			graph.put((double) 0.5, (double) 1.75);
			graph.put((double) 0.55, (double) 1.85);
			graph.put((double) 0.6, (double) 2);
			graph.put((double) 0.65, (double) 2.1);
			graph.put((double) 0.7, (double) 2.25);
			graph.put((double) 0.75, (double) 2.5);
			graph.put((double) 0.8, (double) 2.6);
			graph.put((double) 0.85, (double) 2.75);
			graph.put((double) 0.9, (double) 2.9);
			graph.put((double) 0.95, (double) 3);
			graph.put((double) 1, (double) 3.1);
			graph.put((double) 1.1, (double) 3.3);
			graph.put((double) 1.2, (double) 3.6);
			graph.put((double) 1.3, (double) 3.8);
			graph.put((double) 1.4, (double) 4.1);
			graph.put((double) 1.5, (double) 4.35);
			graph.put((double) 1.6, (double) 4.8);
			graph.put((double) 1.7, (double) 5.1);
			graph.put((double) 1.8, (double) 5.5);
			graph.put((double) 1.9, (double) 6);
			graph.put((double) 2, (double) 6.3);
			graph.put((double) 2.1, (double) 6.8);
			graph.put((double) 2.2, (double) 7.155555556);
			graph.put((double) 2.3, (double) 7.511111111);
			graph.put((double) 2.4, (double) 7.866666667);
			graph.put((double) 2.5, (double) 8.222222222);
			graph.put((double) 2.6, (double) 8.577777778);
			graph.put((double) 2.7, (double) 8.933333333);
			graph.put((double) 2.8, (double) 9.288888889);
			graph.put((double) 2.9, (double) 9.644444444);
			graph.put((double) 3, (double) 10);
			graph.put((double) 3.5, (double) 12.5);
			graph.put((double) 4, (double) 15);
			graph.put((double) 4.5, (double) 17.5);
			graph.put((double) 5, (double) 19);
			graph.put((double) 5.5, (double) 21);
			graph.put((double) 6, (double) 24);
			graph.put((double) 6.5, (double) 27);
			graph.put((double) 7, (double) 30);
			graph.put((double) 8, (double) 35.5);
			graph.put((double) 9, (double) 42);
			graph.put((double) 10, (double) 50);
			graph.put((double) 11, (double) 57.14285714);
			graph.put((double) 12, (double) 64.28571429);
			graph.put((double) 13, (double) 71.42857143);
			graph.put((double) 14, (double) 78.57142857);
			graph.put((double) 15, (double) 85.71428571);
			graph.put((double) 16, (double) 92.85714286);
			graph.put((double) 17, (double) 100);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.85) && (graphinput <= 0.925)) {
			graph.put((double) 0.1, (double) 0.35);
			graph.put((double) 0.15, (double) 0.5);
			graph.put((double) 0.2, (double) 0.66);
			graph.put((double) 0.25, (double) 0.8);
			graph.put((double) 0.3, (double) 0.95);
			graph.put((double) 0.35, (double) 1.1);
			graph.put((double) 0.4, (double) 1.25);
			graph.put((double) 0.45, (double) 1.35);
			graph.put((double) 0.5, (double) 1.45);
			graph.put((double) 0.55, (double) 1.6);
			graph.put((double) 0.6, (double) 1.7);
			graph.put((double) 0.65, (double) 1.75);
			graph.put((double) 0.7, (double) 1.85);
			graph.put((double) 0.75, (double) 1.95);
			graph.put((double) 0.8, (double) 2);
			graph.put((double) 0.85, (double) 2.111111111);
			graph.put((double) 0.9, (double) 2.222222222);
			graph.put((double) 0.95, (double) 2.333333333);
			graph.put((double) 1, (double) 2.444444444);
			graph.put((double) 1.1, (double) 2.555555556);
			graph.put((double) 1.2, (double) 2.666666667);
			graph.put((double) 1.3, (double) 2.777777778);
			graph.put((double) 1.4, (double) 2.888888889);
			graph.put((double) 1.5, (double) 3);
			graph.put((double) 1.6, (double) 3.2);
			graph.put((double) 1.7, (double) 3.4);
			graph.put((double) 1.8, (double) 3.6);
			graph.put((double) 1.9, (double) 3.8);
			graph.put((double) 2, (double) 4);
			graph.put((double) 2.1, (double) 4.166666667);
			graph.put((double) 2.2, (double) 4.333333333);
			graph.put((double) 2.3, (double) 4.5);
			graph.put((double) 2.4, (double) 4.666666667);
			graph.put((double) 2.5, (double) 4.833333333);
			graph.put((double) 2.6, (double) 5);
			graph.put((double) 2.7, (double) 5.1);
			graph.put((double) 2.8, (double) 5.25);
			graph.put((double) 2.9, (double) 5.5);
			graph.put((double) 3, (double) 5.7);
			graph.put((double) 3.5, (double) 6.3);
			graph.put((double) 4, (double) 7.25);
			graph.put((double) 4.5, (double) 8);
			graph.put((double) 5, (double) 9);
			graph.put((double) 5.5, (double) 9.6);
			graph.put((double) 6, (double) 11);
			graph.put((double) 6.5, (double) 12);
			graph.put((double) 7, (double) 13);
			graph.put((double) 8, (double) 15);
			graph.put((double) 9, (double) 16);
			graph.put((double) 10, (double) 18);
			graph.put((double) 11, (double) 20);
			graph.put((double) 12, (double) 22);
			graph.put((double) 13, (double) 24);
			graph.put((double) 14, (double) 26);
			graph.put((double) 15, (double) 28);
			graph.put((double) 16, (double) 30);
			graph.put((double) 17, (double) 32);
			graph.put((double) 18, (double) 34);
			graph.put((double) 19, (double) 36);
			graph.put((double) 20, (double) 38);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.925) && (graphinput <= 0.975)) {
			graph.put((double) 0.1, (double) 0.335);
			graph.put((double) 0.15, (double) 0.47);
			graph.put((double) 0.2, (double) 0.63);
			graph.put((double) 0.25, (double) 0.755);
			graph.put((double) 0.3, (double) 0.9);
			graph.put((double) 0.35, (double) 1.025);
			graph.put((double) 0.4, (double) 1.175);
			graph.put((double) 0.45, (double) 1.259615385);
			graph.put((double) 0.5, (double) 1.344230769);
			graph.put((double) 0.55, (double) 1.453846154);
			graph.put((double) 0.6, (double) 1.538461538);
			graph.put((double) 0.65, (double) 1.598076923);
			graph.put((double) 0.7, (double) 1.682692308);
			graph.put((double) 0.75, (double) 1.767307692);
			graph.put((double) 0.8, (double) 1.826923077);
			graph.put((double) 0.85, (double) 1.917094017);
			graph.put((double) 0.9, (double) 2.007264957);
			graph.put((double) 0.95, (double) 2.097435897);
			graph.put((double) 1, (double) 2.187606838);
			graph.put((double) 1.1, (double) 2.277777778);
			graph.put((double) 1.2, (double) 2.378787879);
			graph.put((double) 1.3, (double) 2.47979798);
			graph.put((double) 1.4, (double) 2.580808081);
			graph.put((double) 1.5, (double) 2.681818182);
			graph.put((double) 1.6, (double) 2.827272727);
			graph.put((double) 1.7, (double) 2.972727273);
			graph.put((double) 1.8, (double) 3.118181818);
			graph.put((double) 1.9, (double) 3.263636364);
			graph.put((double) 2, (double) 3.409090909);
			graph.put((double) 2.1, (double) 3.537878788);
			graph.put((double) 2.2, (double) 3.666666667);
			graph.put((double) 2.3, (double) 3.8);
			graph.put((double) 2.4, (double) 3.933333333);
			graph.put((double) 2.5, (double) 4.066666667);
			graph.put((double) 2.6, (double) 4.2);
			graph.put((double) 2.7, (double) 4.3);
			graph.put((double) 2.8, (double) 4.425);
			graph.put((double) 2.9, (double) 4.6);
			graph.put((double) 3, (double) 4.75);
			graph.put((double) 3.5, (double) 5.1);
			graph.put((double) 4, (double) 5.725);
			graph.put((double) 4.5, (double) 6.25);
			graph.put((double) 5, (double) 6.9);
			graph.put((double) 5.5, (double) 7.3);
			graph.put((double) 6, (double) 8.125);
			graph.put((double) 6.5, (double) 8.75);
			graph.put((double) 7, (double) 9.375);
			graph.put((double) 8, (double) 10.575);
			graph.put((double) 9, (double) 11.275);
			graph.put((double) 10, (double) 12.5);
			graph.put((double) 11, (double) 13.65);
			graph.put((double) 12, (double) 14.8);
			graph.put((double) 13, (double) 15.95);
			graph.put((double) 14, (double) 17.1);
			graph.put((double) 15, (double) 18.25);
			graph.put((double) 16, (double) 19.4);
			graph.put((double) 17, (double) 20.55);
			graph.put((double) 18, (double) 21.7);
			graph.put((double) 19, (double) 22.85);
			graph.put((double) 20, (double) 24);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 0.975) && (graphinput <= 1.05)) {
			graph.put((double) 0.1, (double) 0.32);
			graph.put((double) 0.15, (double) 0.44);
			graph.put((double) 0.2, (double) 0.6);
			graph.put((double) 0.25, (double) 0.71);
			graph.put((double) 0.3, (double) 0.85);
			graph.put((double) 0.35, (double) 0.95);
			graph.put((double) 0.4, (double) 1.1);
			graph.put((double) 0.45, (double) 1.169230769);
			graph.put((double) 0.5, (double) 1.238461538);
			graph.put((double) 0.55, (double) 1.307692308);
			graph.put((double) 0.6, (double) 1.376923077);
			graph.put((double) 0.65, (double) 1.446153846);
			graph.put((double) 0.7, (double) 1.515384615);
			graph.put((double) 0.75, (double) 1.584615385);
			graph.put((double) 0.8, (double) 1.653846154);
			graph.put((double) 0.85, (double) 1.723076923);
			graph.put((double) 0.9, (double) 1.792307692);
			graph.put((double) 0.95, (double) 1.861538462);
			graph.put((double) 1, (double) 1.930769231);
			graph.put((double) 1.1, (double) 2);
			graph.put((double) 1.2, (double) 2.090909091);
			graph.put((double) 1.3, (double) 2.181818182);
			graph.put((double) 1.4, (double) 2.272727273);
			graph.put((double) 1.5, (double) 2.363636364);
			graph.put((double) 1.6, (double) 2.454545455);
			graph.put((double) 1.7, (double) 2.545454545);
			graph.put((double) 1.8, (double) 2.636363636);
			graph.put((double) 1.9, (double) 2.727272727);
			graph.put((double) 2, (double) 2.818181818);
			graph.put((double) 2.1, (double) 2.909090909);
			graph.put((double) 2.2, (double) 3);
			graph.put((double) 2.3, (double) 3.1);
			graph.put((double) 2.4, (double) 3.2);
			graph.put((double) 2.5, (double) 3.3);
			graph.put((double) 2.6, (double) 3.4);
			graph.put((double) 2.7, (double) 3.5);
			graph.put((double) 2.8, (double) 3.6);
			graph.put((double) 2.9, (double) 3.7);
			graph.put((double) 3, (double) 3.8);
			graph.put((double) 3.5, (double) 3.9);
			graph.put((double) 4, (double) 4.2);
			graph.put((double) 4.5, (double) 4.5);
			graph.put((double) 5, (double) 4.8);
			graph.put((double) 5.5, (double) 5);
			graph.put((double) 6, (double) 5.25);
			graph.put((double) 6.5, (double) 5.5);
			graph.put((double) 7, (double) 5.75);
			graph.put((double) 8, (double) 6.15);
			graph.put((double) 9, (double) 6.55);
			graph.put((double) 10, (double) 7);
			graph.put((double) 11, (double) 7.3);
			graph.put((double) 12, (double) 7.6);
			graph.put((double) 13, (double) 7.9);
			graph.put((double) 14, (double) 8.2);
			graph.put((double) 15, (double) 8.5);
			graph.put((double) 16, (double) 8.8);
			graph.put((double) 17, (double) 9.1);
			graph.put((double) 18, (double) 9.4);
			graph.put((double) 19, (double) 9.7);
			graph.put((double) 20, (double) 10);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.05) && (graphinput <= 1.15)) {
			graph.put((double) 0.1, (double) 0.24);
			graph.put((double) 0.15, (double) 0.325);
			graph.put((double) 0.2, (double) 0.45);
			graph.put((double) 0.25, (double) 0.55);
			graph.put((double) 0.3, (double) 0.64);
			graph.put((double) 0.35, (double) 0.71);
			graph.put((double) 0.4, (double) 0.8);
			graph.put((double) 0.45, (double) 0.87);
			graph.put((double) 0.5, (double) 0.9);
			graph.put((double) 0.55, (double) 0.93);
			graph.put((double) 0.6, (double) 0.98);
			graph.put((double) 0.65, (double) 1);
			graph.put((double) 0.7, (double) 1.042857143);
			graph.put((double) 0.75, (double) 1.085714286);
			graph.put((double) 0.8, (double) 1.128571429);
			graph.put((double) 0.85, (double) 1.171428571);
			graph.put((double) 0.9, (double) 1.214285714);
			graph.put((double) 0.95, (double) 1.257142857);
			graph.put((double) 1, (double) 1.3);
			graph.put((double) 1.1, (double) 1.325);
			graph.put((double) 1.2, (double) 1.35);
			graph.put((double) 1.3, (double) 1.375);
			graph.put((double) 1.4, (double) 1.4);
			graph.put((double) 1.5, (double) 1.425);
			graph.put((double) 1.6, (double) 1.45);
			graph.put((double) 1.7, (double) 1.475);
			graph.put((double) 1.8, (double) 1.5);
			graph.put((double) 1.9, (double) 1.525);
			graph.put((double) 2, (double) 1.55);
			graph.put((double) 2.1, (double) 1.569444444);
			graph.put((double) 2.2, (double) 1.588888889);
			graph.put((double) 2.3, (double) 1.608333333);
			graph.put((double) 2.4, (double) 1.627777778);
			graph.put((double) 2.5, (double) 1.647222222);
			graph.put((double) 2.6, (double) 1.666666667);
			graph.put((double) 2.7, (double) 1.686111111);
			graph.put((double) 2.8, (double) 1.705555556);
			graph.put((double) 2.9, (double) 1.725);
			graph.put((double) 3, (double) 1.744444444);
			graph.put((double) 3.5, (double) 1.763888889);
			graph.put((double) 4, (double) 1.783333333);
			graph.put((double) 4.5, (double) 1.802777778);
			graph.put((double) 5, (double) 1.822222222);
			graph.put((double) 5.5, (double) 1.841666667);
			graph.put((double) 6, (double) 1.861111111);
			graph.put((double) 6.5, (double) 1.880555556);
			graph.put((double) 7, (double) 1.9);
			graph.put((double) 8, (double) 1.92);
			graph.put((double) 9, (double) 1.94);
			graph.put((double) 10, (double) 1.97);
			graph.put((double) 11, (double) 1.983);
			graph.put((double) 12, (double) 1.996);
			graph.put((double) 13, (double) 2.009);
			graph.put((double) 14, (double) 2.022);
			graph.put((double) 15, (double) 2.035);
			graph.put((double) 16, (double) 2.048);
			graph.put((double) 17, (double) 2.061);
			graph.put((double) 18, (double) 2.074);
			graph.put((double) 19, (double) 2.087);
			graph.put((double) 20, (double) 2.1);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.15) && (graphinput <= 1.275)) {
			graph.put((double) 0.1, (double) 0.275);
			graph.put((double) 0.15, (double) 0.375);
			graph.put((double) 0.2, (double) 0.5);
			graph.put((double) 0.25, (double) 0.6);
			graph.put((double) 0.3, (double) 0.7);
			graph.put((double) 0.35, (double) 0.8);
			graph.put((double) 0.4, (double) 0.875);
			graph.put((double) 0.45, (double) 0.94);
			graph.put((double) 0.5, (double) 1);
			graph.put((double) 0.55, (double) 1.05);
			graph.put((double) 0.6, (double) 1.1);
			graph.put((double) 0.65, (double) 1.15);
			graph.put((double) 0.7, (double) 1.2);
			graph.put((double) 0.75, (double) 1.25);
			graph.put((double) 0.8, (double) 1.3);
			graph.put((double) 0.85, (double) 1.35);
			graph.put((double) 0.9, (double) 1.4);
			graph.put((double) 0.95, (double) 1.45);
			graph.put((double) 1, (double) 1.5);
			graph.put((double) 1.1, (double) 1.53);
			graph.put((double) 1.2, (double) 1.56);
			graph.put((double) 1.3, (double) 1.59);
			graph.put((double) 1.4, (double) 1.62);
			graph.put((double) 1.5, (double) 1.65);
			graph.put((double) 1.6, (double) 1.68);
			graph.put((double) 1.7, (double) 1.71);
			graph.put((double) 1.8, (double) 1.74);
			graph.put((double) 1.9, (double) 1.77);
			graph.put((double) 2, (double) 1.8);
			graph.put((double) 2.1, (double) 1.82);
			graph.put((double) 2.2, (double) 1.84);
			graph.put((double) 2.3, (double) 1.86);
			graph.put((double) 2.4, (double) 1.88);
			graph.put((double) 2.5, (double) 1.9);
			graph.put((double) 2.6, (double) 1.92);
			graph.put((double) 2.7, (double) 1.94);
			graph.put((double) 2.8, (double) 1.96);
			graph.put((double) 2.9, (double) 1.98);
			graph.put((double) 3, (double) 2);
			graph.put((double) 3.5, (double) 2.059090909);
			graph.put((double) 4, (double) 2.118181818);
			graph.put((double) 4.5, (double) 2.177272727);
			graph.put((double) 5, (double) 2.236363636);
			graph.put((double) 5.5, (double) 2.295454545);
			graph.put((double) 6, (double) 2.354545455);
			graph.put((double) 6.5, (double) 2.413636364);
			graph.put((double) 7, (double) 2.472727273);
			graph.put((double) 8, (double) 2.531818182);
			graph.put((double) 9, (double) 2.590909091);
			graph.put((double) 10, (double) 2.65);
			graph.put((double) 11, (double) 2.665);
			graph.put((double) 12, (double) 2.68);
			graph.put((double) 13, (double) 2.695);
			graph.put((double) 14, (double) 2.71);
			graph.put((double) 15, (double) 2.725);
			graph.put((double) 16, (double) 2.74);
			graph.put((double) 17, (double) 2.755);
			graph.put((double) 18, (double) 2.77);
			graph.put((double) 19, (double) 2.785);
			graph.put((double) 20, (double) 2.8);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.275) && (graphinput <= 1.425)) {
			graph.put((double) 0.1, (double) 0.275);
			graph.put((double) 0.15, (double) 0.3375);
			graph.put((double) 0.2, (double) 0.45);
			graph.put((double) 0.25, (double) 0.54);
			graph.put((double) 0.3, (double) 0.6375);
			graph.put((double) 0.35, (double) 0.72);
			graph.put((double) 0.4, (double) 0.7875);
			graph.put((double) 0.45, (double) 0.845);
			graph.put((double) 0.5, (double) 0.9);
			graph.put((double) 0.55, (double) 0.9425);
			graph.put((double) 0.6, (double) 0.9875);
			graph.put((double) 0.65, (double) 1.025);
			graph.put((double) 0.7, (double) 1.065);
			graph.put((double) 0.75, (double) 1.1);
			graph.put((double) 0.8, (double) 1.135);
			graph.put((double) 0.85, (double) 1.175);
			graph.put((double) 0.9, (double) 1.211538462);
			graph.put((double) 0.95, (double) 1.248076923);
			graph.put((double) 1, (double) 1.284615385);
			graph.put((double) 1.1, (double) 1.311153846);
			graph.put((double) 1.2, (double) 1.337692308);
			graph.put((double) 1.3, (double) 1.364230769);
			graph.put((double) 1.4, (double) 1.390769231);
			graph.put((double) 1.5, (double) 1.417307692);
			graph.put((double) 1.6, (double) 1.443846154);
			graph.put((double) 1.7, (double) 1.470384615);
			graph.put((double) 1.8, (double) 1.496923077);
			graph.put((double) 1.9, (double) 1.523461538);
			graph.put((double) 2, (double) 1.55);
			graph.put((double) 2.1, (double) 1.565769231);
			graph.put((double) 2.2, (double) 1.581538462);
			graph.put((double) 2.3, (double) 1.597307692);
			graph.put((double) 2.4, (double) 1.613076923);
			graph.put((double) 2.5, (double) 1.628846154);
			graph.put((double) 2.6, (double) 1.644615385);
			graph.put((double) 2.7, (double) 1.660384615);
			graph.put((double) 2.8, (double) 1.676153846);
			graph.put((double) 2.9, (double) 1.691923077);
			graph.put((double) 3, (double) 1.707692308);
			graph.put((double) 3.5, (double) 1.743006993);
			graph.put((double) 4, (double) 1.778321678);
			graph.put((double) 4.5, (double) 1.813636364);
			graph.put((double) 5, (double) 1.847869318);
			graph.put((double) 5.5, (double) 1.882102273);
			graph.put((double) 6, (double) 1.916335227);
			graph.put((double) 6.5, (double) 1.950568182);
			graph.put((double) 7, (double) 1.984801136);
			graph.put((double) 8, (double) 2.019034091);
			graph.put((double) 9, (double) 2.053267045);
			graph.put((double) 10, (double) 2.0875);
			graph.put((double) 11, (double) 2.09875);
			graph.put((double) 12, (double) 2.11);
			graph.put((double) 13, (double) 2.12125);
			graph.put((double) 14, (double) 2.1325);
			graph.put((double) 15, (double) 2.14375);
			graph.put((double) 16, (double) 2.155);
			graph.put((double) 17, (double) 2.16625);
			graph.put((double) 18, (double) 2.1775);
			graph.put((double) 19, (double) 2.18875);
			graph.put((double) 20, (double) 2.2);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.425) && (graphinput <= 1.625)) {
			graph.put((double) 0.1, (double) 0.275);
			graph.put((double) 0.15, (double) 0.3);
			graph.put((double) 0.2, (double) 0.4);
			graph.put((double) 0.25, (double) 0.48);
			graph.put((double) 0.3, (double) 0.575);
			graph.put((double) 0.35, (double) 0.64);
			graph.put((double) 0.4, (double) 0.7);
			graph.put((double) 0.45, (double) 0.75);
			graph.put((double) 0.5, (double) 0.8);
			graph.put((double) 0.55, (double) 0.835);
			graph.put((double) 0.6, (double) 0.875);
			graph.put((double) 0.65, (double) 0.9);
			graph.put((double) 0.7, (double) 0.93);
			graph.put((double) 0.75, (double) 0.95);
			graph.put((double) 0.8, (double) 0.97);
			graph.put((double) 0.85, (double) 1);
			graph.put((double) 0.9, (double) 1.023076923);
			graph.put((double) 0.95, (double) 1.046153846);
			graph.put((double) 1, (double) 1.069230769);
			graph.put((double) 1.1, (double) 1.092307692);
			graph.put((double) 1.2, (double) 1.115384615);
			graph.put((double) 1.3, (double) 1.138461538);
			graph.put((double) 1.4, (double) 1.161538462);
			graph.put((double) 1.5, (double) 1.184615385);
			graph.put((double) 1.6, (double) 1.207692308);
			graph.put((double) 1.7, (double) 1.230769231);
			graph.put((double) 1.8, (double) 1.253846154);
			graph.put((double) 1.9, (double) 1.276923077);
			graph.put((double) 2, (double) 1.3);
			graph.put((double) 2.1, (double) 1.311538462);
			graph.put((double) 2.2, (double) 1.323076923);
			graph.put((double) 2.3, (double) 1.334615385);
			graph.put((double) 2.4, (double) 1.346153846);
			graph.put((double) 2.5, (double) 1.357692308);
			graph.put((double) 2.6, (double) 1.369230769);
			graph.put((double) 2.7, (double) 1.380769231);
			graph.put((double) 2.8, (double) 1.392307692);
			graph.put((double) 2.9, (double) 1.403846154);
			graph.put((double) 3, (double) 1.415384615);
			graph.put((double) 3.5, (double) 1.426923077);
			graph.put((double) 4, (double) 1.438461538);
			graph.put((double) 4.5, (double) 1.45);
			graph.put((double) 5, (double) 1.459375);
			graph.put((double) 5.5, (double) 1.46875);
			graph.put((double) 6, (double) 1.478125);
			graph.put((double) 6.5, (double) 1.4875);
			graph.put((double) 7, (double) 1.496875);
			graph.put((double) 8, (double) 1.50625);
			graph.put((double) 9, (double) 1.515625);
			graph.put((double) 10, (double) 1.525);
			graph.put((double) 11, (double) 1.5325);
			graph.put((double) 12, (double) 1.54);
			graph.put((double) 13, (double) 1.5475);
			graph.put((double) 14, (double) 1.555);
			graph.put((double) 15, (double) 1.5625);
			graph.put((double) 16, (double) 1.57);
			graph.put((double) 17, (double) 1.5775);
			graph.put((double) 18, (double) 1.585);
			graph.put((double) 19, (double) 1.5925);
			graph.put((double) 20, (double) 1.6);
			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.625) && (graphinput <= 1.875)) {
			graph.put((double) 0.1, (double) 0.2225);
			graph.put((double) 0.15, (double) 0.2625);
			graph.put((double) 0.2, (double) 0.35);
			graph.put((double) 0.25, (double) 0.42);
			graph.put((double) 0.3, (double) 0.5);
			graph.put((double) 0.35, (double) 0.5575);
			graph.put((double) 0.4, (double) 0.6125);
			graph.put((double) 0.45, (double) 0.6625);
			graph.put((double) 0.5, (double) 0.7);
			graph.put((double) 0.55, (double) 0.73);
			graph.put((double) 0.6, (double) 0.7625);
			graph.put((double) 0.65, (double) 0.7875);
			graph.put((double) 0.7, (double) 0.815);
			graph.put((double) 0.75, (double) 0.83125);
			graph.put((double) 0.8, (double) 0.8475);
			graph.put((double) 0.85, (double) 0.86875);
			graph.put((double) 0.9, (double) 0.886538462);
			graph.put((double) 0.95, (double) 0.904326923);
			graph.put((double) 1, (double) 0.922115385);
			graph.put((double) 1.1, (double) 0.939903846);
			graph.put((double) 1.2, (double) 0.957692308);
			graph.put((double) 1.3, (double) 0.974855769);
			graph.put((double) 1.4, (double) 0.992019231);
			graph.put((double) 1.5, (double) 1.009182692);
			graph.put((double) 1.6, (double) 1.026346154);
			graph.put((double) 1.7, (double) 1.043509615);
			graph.put((double) 1.8, (double) 1.060673077);
			graph.put((double) 1.9, (double) 1.077836538);
			graph.put((double) 2, (double) 1.095);
			graph.put((double) 2.1, (double) 1.103269231);
			graph.put((double) 2.2, (double) 1.106538462);
			graph.put((double) 2.3, (double) 1.115141026);
			graph.put((double) 2.4, (double) 1.12374359);
			graph.put((double) 2.5, (double) 1.132346154);
			graph.put((double) 2.6, (double) 1.140948718);
			graph.put((double) 2.7, (double) 1.149551282);
			graph.put((double) 2.8, (double) 1.158153846);
			graph.put((double) 2.9, (double) 1.16675641);
			graph.put((double) 3, (double) 1.175358974);
			graph.put((double) 3.5, (double) 1.183961538);
			graph.put((double) 4, (double) 1.192564103);
			graph.put((double) 4.5, (double) 1.201166667);
			graph.put((double) 5, (double) 1.2086875);
			graph.put((double) 5.5, (double) 1.216208333);
			graph.put((double) 6, (double) 1.2265625);
			graph.put((double) 6.5, (double) 1.23275);
			graph.put((double) 7, (double) 1.2389375);
			graph.put((double) 8, (double) 1.245125);
			graph.put((double) 9, (double) 1.2513125);
			graph.put((double) 10, (double) 1.2575);
			graph.put((double) 11, (double) 1.2615);
			graph.put((double) 12, (double) 1.2655);
			graph.put((double) 13, (double) 1.2695);
			graph.put((double) 14, (double) 1.2735);
			graph.put((double) 15, (double) 1.2775);
			graph.put((double) 16, (double) 1.2815);
			graph.put((double) 17, (double) 1.2855);
			graph.put((double) 18, (double) 1.2895);
			graph.put((double) 19, (double) 1.2935);
			graph.put((double) 20, (double) 1.2975);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		} else if ((graphinput > 1.875) && (graphinput < 2.0)) {
			graph.put((double) 0.1, (double) 0.17);
			graph.put((double) 0.15, (double) 0.225);
			graph.put((double) 0.2, (double) 0.3);
			graph.put((double) 0.25, (double) 0.36);
			graph.put((double) 0.3, (double) 0.425);
			graph.put((double) 0.35, (double) 0.475);
			graph.put((double) 0.4, (double) 0.525);
			graph.put((double) 0.45, (double) 0.575);
			graph.put((double) 0.5, (double) 0.6);
			graph.put((double) 0.55, (double) 0.625);
			graph.put((double) 0.6, (double) 0.65);
			graph.put((double) 0.65, (double) 0.675);
			graph.put((double) 0.7, (double) 0.7);
			graph.put((double) 0.75, (double) 0.7125);
			graph.put((double) 0.8, (double) 0.725);
			graph.put((double) 0.85, (double) 0.7375);
			graph.put((double) 0.9, (double) 0.75);
			graph.put((double) 0.95, (double) 0.7625);
			graph.put((double) 1, (double) 0.775);
			graph.put((double) 1.1, (double) 0.7875);
			graph.put((double) 1.2, (double) 0.8);
			graph.put((double) 1.3, (double) 0.81125);
			graph.put((double) 1.4, (double) 0.8225);
			graph.put((double) 1.5, (double) 0.83375);
			graph.put((double) 1.6, (double) 0.845);
			graph.put((double) 1.7, (double) 0.85625);
			graph.put((double) 1.8, (double) 0.8675);
			graph.put((double) 1.9, (double) 0.87875);
			graph.put((double) 2, (double) 0.89);
			graph.put((double) 2.1, (double) 0.895);
			graph.put((double) 2.2, (double) 0.89);
			graph.put((double) 2.3, (double) 0.895666667);
			graph.put((double) 2.4, (double) 0.901333333);
			graph.put((double) 2.5, (double) 0.907);
			graph.put((double) 2.6, (double) 0.912666667);
			graph.put((double) 2.7, (double) 0.918333333);
			graph.put((double) 2.8, (double) 0.924);
			graph.put((double) 2.9, (double) 0.929666667);
			graph.put((double) 3, (double) 0.935333333);
			graph.put((double) 3.5, (double) 0.941);
			graph.put((double) 4, (double) 0.946666667);
			graph.put((double) 4.5, (double) 0.952333333);
			graph.put((double) 5, (double) 0.958);
			graph.put((double) 5.5, (double) 0.963666667);
			graph.put((double) 6, (double) 0.975);
			graph.put((double) 6.5, (double) 0.978);
			graph.put((double) 7, (double) 0.981);
			graph.put((double) 8, (double) 0.984);
			graph.put((double) 9, (double) 0.987);
			graph.put((double) 10, (double) 0.99);
			graph.put((double) 11, (double) 0.9905);
			graph.put((double) 12, (double) 0.991);
			graph.put((double) 13, (double) 0.9915);
			graph.put((double) 14, (double) 0.992);
			graph.put((double) 15, (double) 0.9925);
			graph.put((double) 16, (double) 0.993);
			graph.put((double) 17, (double) 0.9935);
			graph.put((double) 18, (double) 0.994);
			graph.put((double) 19, (double) 0.9945);
			graph.put((double) 20, (double) 0.995);

			if ((tDivideTn > 0.1) && (tDivideTn <= 1.0)) {
				float coeff = 20f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 20.0);
				return (graph.get(nearestValue));

			} else if ((tDivideTn >= 1.0) && (tDivideTn <= 3.0)) {
				float coeff = 10f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 10.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 3.0) && (tDivideTn <= 7.0)) {
				float coeff = 4f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 4.0);
				return (graph.get(nearestValue));
			} else if ((tDivideTn >= 7.0) && (tDivideTn <= 20.0)) {
				float coeff = 1f;
				double nearestValue = (Math.round(tDivideTn * coeff) / 1.0);
				return (graph.get(nearestValue));
			}

			throw new RuntimeException("Review T/Tn & ru/P");
		}
		return graphinput;
	}

	public static double peakResponseParameterPlastic(final double te,
			final double tn, final double ru, final double uy, final double pr) {

		double x = retrievingGraphData(te, tn, ru, uy, pr);

		return x * uy;
	}

	public static String plasticCheckFinal(final double te, final double tn,
			final double ru, final double uy, final double pr) {

		double um = peakResponseParameterPlastic(te, tn, ru, uy, pr);

		if ((um <= uy)) {

			return "Column PASSES for specified blast parameters";

		} else {

			return "EXCEEDS Plastic limits, Re-Design or Structure Assessment is required";

		}

	}

}
