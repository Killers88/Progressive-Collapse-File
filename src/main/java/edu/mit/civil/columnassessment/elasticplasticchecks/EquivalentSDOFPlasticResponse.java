/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFPlasticResponse {

	public static double CONSTANT_1A = 296.43;
	public static double CONSTANT_1B = 61.643;
	public static double CONSTANT_1C = 4.1;
	public static double CONSTANT_21 = 94.811;
	public static double CONSTANT_22 = 3.9992;
	public static double CONSTANT_23 = 0.4783;
	public static double CONSTANT_3D = 38.632;
	public static double CONSTANT_3E = 0.3162;
	public static double CONSTANT_3F = 1.2624;
	public static double CONSTANT_44 = 14.84;
	public static double CONSTANT_45 = 4.0933;
	public static double CONSTANT_46 = 0.3619;
	public static double CONSTANT_5G = 7.2741;
	public static double CONSTANT_5H = 2.2816;
	public static double CONSTANT_5I = 0.85;
	public static double CONSTANT_67 = 2.8238;
	public static double CONSTANT_68 = 3.8444;
	public static double CONSTANT_69 = 0.123;
	public static double CONSTANT_7J = 1.0387;
	public static double CONSTANT_7K = 2.9041;
	public static double CONSTANT_7L = 0.4607;
	public static double CONSTANT_810 = 0.2174;
	public static double CONSTANT_811 = 2.7733;
	public static double CONSTANT_812 = 0.1635;
	public static double CONSTANT_9M = 0.0122;
	public static double CONSTANT_9N = 1.626;
	public static double CONSTANT_9O = 0.5908;
	public static double CONSTANT_1013 = 0.0195;
	public static double CONSTANT_1014 = 0.84;
	public static double CONSTANT_1015 = 0.8789;
	public static double CONSTANT_11P = 0.514;
	public static double CONSTANT_11Q = 1.3984;
	public static double CONSTANT_1216 = 0.3709;
	public static double CONSTANT_1217 = 1.0407;
	public static double CONSTANT_12R = 0.0018;
	public static double CONSTANT_12S = 0.0578;
	public static double CONSTANT_12T = 1.15;
	public static double CONSTANT_1318 = 0.514;
	public static double CONSTANT_1319 = 1.3984;
	public static double CONSTANT_13U = 0.3709;
	public static double CONSTANT_13V = 1.0407;
	public static double CONSTANT_13W = 0.0018;
	public static double CONSTANT_1320 = 0.0578;
	public static double CONSTANT_1321 = 1.15;

	public static double maxDeflectionPlasticInputsTeDivideTn(final double te,
			final double tn) {

		return (te / 1000) / tn;
	}

	public static double maxDeflectionPlasticInputsFyDivideQ(final double ru,
			final double q) {

		return (ru) / (q / 6.944);

	}

	public static double determiningMaxDeflectionResponse(final double te,
			final double tn, final double ru, final double uy, final double q) {

		double graphinput = maxDeflectionPlasticInputsFyDivideQ(ru, q);

		double tDivideTn = maxDeflectionPlasticInputsTeDivideTn(te, tn);

		if (graphinput < 0.15) {

			return CONSTANT_1A * Math.pow(tDivideTn, 2) + CONSTANT_1B
					* tDivideTn - CONSTANT_1C;

		} else if ((graphinput > 0.15) && (graphinput <= 0.25)) {

			return CONSTANT_21 * Math.pow(tDivideTn, 2) + CONSTANT_22
					* tDivideTn + CONSTANT_23;

		} else if ((graphinput > 0.25) && (graphinput <= 0.35)) {

			return CONSTANT_3D * Math.pow(tDivideTn, 2) - CONSTANT_3E
					* tDivideTn + CONSTANT_3F;

		} else if ((graphinput > 0.35) && (graphinput <= 0.45)) {

			return CONSTANT_44 * Math.pow(tDivideTn, 2) + CONSTANT_45
					* tDivideTn + CONSTANT_46;

		} else if ((graphinput > 0.45) && (graphinput <= 0.55)) {

			return CONSTANT_5G * Math.pow(tDivideTn, 2) + CONSTANT_5H
					* tDivideTn + CONSTANT_5I;

		} else if ((graphinput > 0.55) && (graphinput <= 0.65)) {

			return CONSTANT_67 * Math.pow(tDivideTn, 2) + CONSTANT_68
					* tDivideTn + CONSTANT_69;

		} else if ((graphinput > 0.65) && (graphinput <= 0.75)) {

			return CONSTANT_7J * Math.pow(tDivideTn, 2) + CONSTANT_7K
					* tDivideTn + CONSTANT_7L;

		} else if ((graphinput > 0.75) && (graphinput <= 0.85)) {

			return CONSTANT_810 * Math.pow(tDivideTn, 2) + CONSTANT_811
					* tDivideTn + CONSTANT_812;

		} else if ((graphinput > 0.85) && (graphinput <= 0.95)) {

			return CONSTANT_9M * Math.pow(tDivideTn, 2) + CONSTANT_9N
					* tDivideTn + CONSTANT_9O;

		} else if ((graphinput > 0.95) && (graphinput <= 1.1)) {

			return -CONSTANT_1013 * Math.pow(tDivideTn, 2) + CONSTANT_1014
					* tDivideTn + CONSTANT_1015;

		} else if ((graphinput > 1.1) && (graphinput <= 1.35)) {

			return CONSTANT_11P * Math.log(tDivideTn) + CONSTANT_11Q;

		} else if ((graphinput > 1.35) && (graphinput <= 1.75)) {

			if ((tDivideTn >= 0.1) && (tDivideTn < 1.5)) {

				return CONSTANT_1216 * Math.log(graphinput) + CONSTANT_1217;

			} else if ((tDivideTn > 1.5) && (tDivideTn <= 20)) {

				return -CONSTANT_12R * Math.pow(tDivideTn, 2) + CONSTANT_12S
						* tDivideTn + CONSTANT_12T;
			}

			throw new RuntimeException("invalid value, review calculations");

		} else if ((graphinput > 1.75) && (graphinput <= 2.0)) {

			if ((tDivideTn >= 0.1) && (tDivideTn < 1.5)) {

				return CONSTANT_1318 * Math.log(graphinput) + CONSTANT_1319;

			} else if ((tDivideTn > 1.5) && (tDivideTn < 9.5)) {

				return -CONSTANT_13U * Math.pow(tDivideTn, 2) + CONSTANT_13V
						* tDivideTn + CONSTANT_13W;

			} else if ((tDivideTn >= 9.5) && (tDivideTn < 20)) {

				return CONSTANT_1320 * graphinput + CONSTANT_1321;
			}

			throw new RuntimeException("invalid value, review calculations");
		}

		throw new RuntimeException("invalid value, review calculations");

	}

	public static double peakResponseParameterPlastic(final double te,
			final double tn, final double ru, final double uy, final double q) {

		double A = determiningMaxDeflectionResponse(te, tn, ru, uy, q);

		return A * uy;
	}

	public static String plasticCheckFinal(final double te, final double tn,
			final double ru, final double uy, final double q) {

		double um = peakResponseParameterPlastic(te, tn, ru, uy, q);

		if ((um <= uy)) {

			return "Column PASSES for specified blast parameters";

		} else {

			return "EXCEEDS Plastic limits, Re-Design or Structure Assessment is required";

		}

	}

}
