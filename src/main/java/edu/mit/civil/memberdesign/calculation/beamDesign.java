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
			final double pr, final double beamFoS, final double colhgt,
			final double numstorys, final double bays, final double windspeed) {

		double mMax = windForces.intMoment(colhgt, numstorys, trib, bays,
				windspeed);

		// double size = findPeakResponseParameter(span, trib, sdl, live, fy);

		double iReq = beamForces.serviceIReq(span, trib, sdl, live);

		double ultUdl = trib * ((sdl * 1.2 + live * 1.6) / 1000);

		/**
		 * W21x50
		 */
		double ix3 = 984;
		double ry3 = 1.3;
		double zx3 = 110;
		double sx3 = 94.5;
		double a3 = 14.7;
		double slenderness3 = (0.75 * span * 12) / ry3;

		if (slenderness3 <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness3, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * a3;
			double mcx = 0.9 * fy * zx3 / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix3 > iReq) {
					return "W21x50";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix3 > iReq) {
					return "W21x50";
				}
			}

		} else if (slenderness3 > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness3, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * a3;
			double mcx = 0.9 * fy * zx3 / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix3 > iReq) {
					return "W21x50";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix3 > iReq) {
					return "W21x50";
				}
			}
		}

		/**
		 * W21x57
		 */
		double ix2 = 1170;
		double ry2 = 1.35;
		double zx2 = 129;
		double sx2 = 111;
		double a2 = 16.7;
		double slenderness2 = (0.75 * span * 12) / ry2;

		if (slenderness2 <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness2, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * a2;
			double mcx = 0.9 * fy * zx2 / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix2 > iReq) {
					return "W21x57" + check * beamFoS;
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix2 > iReq) {
					return "W21x57";
				}
			}

		} else if (slenderness2 > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness2, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * a2;
			double mcx = 0.9 * fy * zx2 / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix2 > iReq) {
					return "W21x57";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix2 > iReq) {
					return "W21x57";
				}
			}
		}

		/**
		 * W21x62
		 */
		double ix1 = 1330;
		double ry1 = 1.77;
		double zx1 = 144;
		double sx1 = 127;
		double a1 = 18.3;
		double slenderness1 = (0.75 * span * 12) / ry1;

		if (slenderness1 <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness1, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * a1;
			double mcx = 0.9 * fy * zx1 / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix1 > iReq) {
					return "W21x62" + check * beamFoS;
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix1 > iReq) {
					return "W21x62";
				}
			}

		} else if (slenderness1 > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness1, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * a1;
			double mcx = 0.9 * fy * zx1 / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix1 > iReq) {
					return "W21x62";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix1 > iReq) {
					return "W21x62";
				}
			}
		}

		/**
		 * W21x68
		 */
		double ix = 1480;
		double ry = 1.8;
		double zx = 160;
		double sx = 140;
		double a = 20;
		double slenderness = (0.75 * span * 12) / ry;

		if (slenderness <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * a;
			double mcx = 0.9 * fy * zx / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W21x68" + check * beamFoS;
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W21x68";
				}
			}

		} else if (slenderness > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slenderness, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * a;
			double mcx = 0.9 * fy * zx / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W21x68";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ix > iReq) {
					return "W21x68";
				}
			}
		}

		/**
		 * W21x73
		 */
		double ixA = 1600;
		double ryA = 1.82;
		double zxA = 172;
		double sxA = 151;
		double aA = 21.5;
		double slendernessA = (0.75 * span * 12) / ryA;

		if (slendernessA <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessA, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aA;
			double mcx = 0.9 * fy * zxA / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W21x73";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W21x73";
				}
			}

		} else if (slendernessA > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessA, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aA;
			double mcx = 0.9 * fy * zxA / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W21x73";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixA > iReq) {
					return "W21x73";
				}
			}
		}

		/**
		 * W21x83
		 */
		double ixB = 1830;
		double ryB = 1.83;
		double sxB = 171;
		double zxB = 196;
		double aB = 24.3;
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
					return "W21x83";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W21x83";
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
					return "W21x83";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixB > iReq) {
					return "W21x83";
				}
			}
		}

		/**
		 * W21x93
		 */
		double ixC = 2070;
		double ryC = 1.84;
		double zxC = 221;
		double sxC = 192;
		double aC = 27.3;
		double slendernessC = (0.75 * span * 12) / ryC;

		if (slendernessC <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessC, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aC;
			double mcx = 0.9 * fy * zxC / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X93";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X93";
				}
			}

		} else if (slendernessC > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessC, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aC;
			double mcx = 0.9 * fy * zxC / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X93";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixC > iReq) {
					return "W12X93";
				}
			}
		}

		/**
		 * W21x101
		 */
		double ixD = 2420;
		double ryD = 2.89;
		double zxD = 253;
		double sxD = 227;
		double aD = 29.8;
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
					return "W21x101";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W21x101";
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
					return "W21x101";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixD > iReq) {
					return "W21x101";
				}
			}
		}

		/**
		 * W21x111
		 */
		double ixE = 2670;
		double ryE = 2.9;
		double zxE = 279;
		double sxE = 249;
		double aE = 32.7;
		double slendernessE = (0.75 * span * 12) / ryE;

		if (slendernessE <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessE, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aE;
			double mcx = 0.9 * fy * zxE / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W21x111";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W21x111";
				}
			}

		} else if (slendernessE > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessE, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aE;
			double mcx = 0.9 * fy * zxE / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W21x111";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixE > iReq) {
					return "W21x111";
				}
			}
		}

		/**
		 * W21x122
		 */
		double ixF = 2960;
		double ryF = 2.92;
		double zxF = 307;
		double sxF = 273;
		double aF = 35.9;
		double slendernessF = (0.75 * span * 12) / ryF;

		if (slendernessF <= (4.71 * Math.sqrt(29000 / fy))) {

			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessF, 2));
			double fcr = (Math.pow(0.658, fy / fe)) * fy;
			double pn = 0.9 * fcr * aF;
			double mcx = 0.9 * fy * zxF / 12;

			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W21x122";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W21x122";
				}
			}

		} else if (slendernessF > (4.71 * Math.sqrt(29000 / fy))) {
			double fe = (Math.pow(Math.PI, 2) * 29000)
					/ (Math.pow(slendernessF, 2));
			double fcr = 0.877 * fe;
			double pn = 0.9 * fcr * aF;
			double mcx = 0.9 * fy * zxF / 12;
			if (pr / pn >= 0.2) {
				double check = pr / pn + (0.88889) * (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W21x122";
				}
			} else if (pr / pn < 0.2) {
				double check = pr / (2 * pn) + (mMax / mcx);
				if ((beamFoS * check) < 1.0 && ixF > iReq) {
					return "W21x122";
				}
			}
		}

		return "NO MEMBER PASSES";
	}
}
