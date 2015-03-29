/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

/**
 * @author koleary
 *
 */
public class beamDesign {

	public static String sectionDesign(final double span, final double trib,
			final double sdl, final double live, final double fy,
			final double pr, final double beamFoS) {

		// double size = findPeakResponseParameter(span, trib, sdl, live, fy);

		double iReq = beamForces.serviceIReq(span, trib, sdl, live);

		double mMax = beamForces.maxMoment(span, trib, sdl, live);

		/**
		 * W12x45
		 */
		double ix = 348;
		double ry = 1.95;
		double zx = 64.2;
		double a = 13.1;
		double slenderness = (0.75 * span * 12) / ry;

		if (slenderness <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * a;
			double mcx = 0.9 * fy * zx / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W12x45";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W12x45";
				}
			}

		} else if (slenderness > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * a;
			double mcx = 0.9 * fy * zx / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W12x45";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W12x45";
				}
			}
		}

		/**
		 * W12X58
		 */
		double ixA = 475;
		double ryA = 2.51;
		double zxA = 86.4;
		double aA = 17;
		double slendernessA = (0.75 * span * 12) / ryA;

		if (slendernessA <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessA, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aA;
			double mcx = 0.9 * fy * zxA / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W12X58";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W12X58";
				}
			}

		} else if (slendernessA > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessA, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aA;
			double mcx = 0.9 * fy * zxA / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W12X58";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W12X58";
				}
			}
		}

		/**
		 * W12X65
		 */
		double ixB = 533;
		double ryB = 3.02;
		double zxB = 96.8;
		double aB = 19.1;
		double slendernessB = (0.75 * span * 12) / ryB;

		if (slendernessB <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessB, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aB;
			double mcx = 0.9 * fy * zxB / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W12X65";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W12X65";
				}
			}

		} else if (slendernessB > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessB, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aB;
			double mcx = 0.9 * fy * zxB / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W12X65";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W12X65";
				}
			}
		}

		/**
		 * W12X72
		 */
		double ixC = 597;
		double ryC = 3.04;
		double zxC = 108;
		double aC = 21.1;
		double slendernessC = (0.75 * span * 12) / ryC;

		if (slendernessC <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessC, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aC;
			double mcx = 0.9 * fy * zxC / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X72";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X72";
				}
			}

		} else if (slendernessC > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessC, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aC;
			double mcx = 0.9 * fy * zxC / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X72";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X72";
				}
			}
		}

		/**
		 * W12X79
		 */
		double ixD = 662;
		double ryD = 3.05;
		double zxD = 119;
		double aD = 23.2;
		double slendernessD = (0.75 * span * 12) / ryD;

		if (slendernessD <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessD, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aD;
			double mcx = 0.9 * fy * zxD / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W12X79";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W12X79";
				}
			}

		} else if (slendernessD > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessD, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aD;
			double mcx = 0.9 * fy * zxD / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W12X79";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W12X79";
				}
			}
		}

		/**
		 * W12X87
		 */
		double ixE = 740;
		double ryE = 3.07;
		double zxE = 118;
		double aE = 25.6;
		double slendernessE = (0.75 * span * 12) / ryE;

		if (slendernessE <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessE, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aE;
			double mcx = 0.9 * fy * zxE / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W12X87";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W12X87";
				}
			}

		} else if (slendernessE > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessE, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aE;
			double mcx = 0.9 * fy * zxE / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W12X87";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W12X87";
				}
			}
		}

		/**
		 * W12X96
		 */
		double ixF = 833;
		double ryF = 3.09;
		double zxF = 147;
		double aF = 28.2;
		double slendernessF = (0.75 * span * 12) / ryF;

		if (slendernessF <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessF, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aF;
			double mcx = 0.9 * fy * zxF / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W12X96";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W12X96";
				}
			}

		} else if (slendernessF > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessF, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aF;
			double mcx = 0.9 * fy * zxF / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (8 / 9) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W12X96";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W12X96";
				}
			}
		}

		return "NO MEMBER PASSES";
	}
}
