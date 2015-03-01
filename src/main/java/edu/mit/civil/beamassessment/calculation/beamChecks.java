/**
 * 
 */
package edu.mit.civil.beamassessment.calculation;

/**
 * @author koleary
 *
 */
public class beamChecks {

	public static String localBucklingCheck(final double bf, final double tf) {

		double buckle = bf / (2 * tf);

		if (buckle < 7.0) {

			return "Section size is sufficient to prevent local buckling and enable plastic moment to be achieved";

		} else if (buckle >= 7.0) {

			return "Section size is insufficient to prevent local buckling occurring before plastic moment";

		}
		throw new RuntimeException("Check Input Data");
	}

	public static String localshearCheck(final double p, final double a,
			final double fy, final double bf, final double tf) {

		double py = a * fy;

		double axialratio = p / py;

		if (axialratio <= 0.27) {

			double webratio = (412 / (Math.pow(fy, 0.5)))
					* (1 - 1.4 * (axialratio));

			if (webratio > 47.5) {

				return "Section size is sufficient to prevent local buckling and enable plastic moment to be achieved";

			} else {

				return "Section size is insufficient to prevent local buckling occurring before plastic moment";

			}
		} else {

			double webratio = 257 / fy;

			if (webratio > 47.5) {

				return "Section size is sufficient to prevent local buckling and enable plastic moment to be achieved";

			} else {

				return "Section size is insufficient to prevent local buckling occurring before plastic moment";

			}
		}

	}

	public static String shearcheck(final double fy, final double tf,
			final double tw, final double d, final double vmax) {

		double fds = 1.29 * 1.1 * fy;

		double fdv = 0.55 * fds;

		double aw = (d - (2 * tf)) * tw;

		double vp = fdv * aw;

		if (vp > vmax) {

			return "Adaquate for Shear, Vp > Vmax";

		} else {

			return "Section fails for Shear, Vp < Vmax";

		}
	}

	public static double flexuralCheck(final double zx, final double lx,
			final double ly, final double fy, final double rx, final double ry,
			final double e, final double a) {

		double fds = 1.29 * 1.1 * fy;

		double slendernessx = (0.75 * lx * 12) / rx;

		double slendernessy = (0.75 * ly * 12) / ry;

		double cc = Math.pow(((2 * Math.pow(Math.PI, 2) * e) / fds), 0.5);

		if (slendernessx > slendernessy) {

			double fa = (1 - (Math.pow(slendernessx, 2) / (2 * Math.pow(cc, 2))))
					* fds
					/ ((slendernessx / cc) * 0.375 + 1.6666667 - Math.pow(
							slendernessx, 3) / (Math.pow(cc, 3)));

			return 1.7 * fa * a;

		} else if (slendernessy > slendernessx) {

			double fa = (1 - (Math.pow(slendernessy, 2) / (2 * Math.pow(cc, 2))))
					* fds
					/ ((slendernessy / cc) * 0.375 + 1.6666667 - Math.pow(
							slendernessy, 3) / (Math.pow(cc, 3)));

			return 1.7 * fa * a;
		}
		throw new RuntimeException("Check Input Data");

	}

	public static double momentMmxFactor(final double zx, final double lx,
			final double ly, final double fy, final double rx, final double ry,
			final double e, final double a) {

		double fds = 1.29 * 1.1 * fy;

		double factor = (1.07 - (((lx * 12) / ry) * Math.pow(fds, 0.5)) / 3160);

		return factor;
	}

	public static String momentMmxCheck(final double zx, final double lx,
			final double ly, final double fy, final double rx, final double ry,
			final double e, final double a) {

		double fds = 1.29 * 1.1 * fy;

		double mpx = (fds * zx) / 12;

		double mmx = (momentMmxFactor(zx, lx, ly, fy, rx, ry, e, a)) * mpx;

		if (mmx <= mpx) {

			return "Mmx < Mpx, therefore beam is adaquate";

		} else {

			return "Mmx > Mpx, therefore beam FAILS check";

		}

	}

	public static double eulerBucklingStresses(final double e, final double lx,
			final double rx) {

		double slendernessx = (0.75 * lx * 12) / rx;

		double fex = (Math.pow((Math.PI), 2) * e * 0.521739)
				/ (Math.pow(slendernessx, 2));

		return fex;

	}

	public static double eulerBucklingLoads(final double e, final double lx,
			final double rx, final double a) {

		double fex = eulerBucklingStresses(e, lx, rx);

		double pex = a * fex * 1.916667;

		return pex;
	}

	public static double ultCapacityForDynAxialLoadPp(final double fy,
			final double a) {

		return (1.29 * 1.1 * fy) * a;
	}

	public static Double combinedChcekOne(final double zx, final double lx,
			final double ly, final double fy, final double rx, final double ry,
			final double e, final double a, final double p, final double mx) {

		double pu = flexuralCheck(zx, lx, ly, fy, rx, ry, e, a);

		double fds = 1.29 * 1.1 * fy;

		double mpx = (fds * zx) / 12;

		double mmx = (momentMmxFactor(zx, lx, ly, fy, rx, ry, e, a)) * mpx;

		double pex = eulerBucklingLoads(e, lx, rx, a);

		double cmx = 0.85; // TODO

		double checkOne = p / pu + (cmx * mx) / ((1 - (p / pex)) * mmx);

		return checkOne;

	}

	public static Double combinedChcekTwo(final double zx, final double lx,
			final double ly, final double fy, final double rx, final double ry,
			final double e, final double a, final double p, final double mx) {

		double pp = ultCapacityForDynAxialLoadPp(fy, a);

		double fds = 1.29 * 1.1 * fy;

		double mpx = (fds * zx) / 12;

		if (p / pp < 0.15) {

			return mx / mpx;

		} else if (p / pp > 0.15) {

			return p / pp + mx / (1.18 * mpx);

		}
		throw new RuntimeException("Check Input Data");

	}

	public static String combinedChcekOnePassOrFail(final double zx,
			final double lx, final double ly, final double fy, final double rx,
			final double ry, final double e, final double a, final double p,
			final double mx) {

		double checkOne = combinedChcekOne(zx, lx, ly, fy, rx, ry, e, a, p, mx);

		double checkTwo = combinedChcekTwo(zx, lx, ly, fy, rx, ry, e, a, p, mx);

		if (checkOne < 1.0) {

			if (checkTwo < 1.0) {

				return "Section is within allowable limits for Combined Benading & Axial Plastic Checks";

			} else {

				return "Section FAILS for Combined Bending & Axial Plastic Check";

			}

		} else if (checkOne > 1.0) {

			return "Section FAILS for Combined Bending & Axial Plastic Check";

		}

		throw new RuntimeException("Check Input Data");
	}
}
