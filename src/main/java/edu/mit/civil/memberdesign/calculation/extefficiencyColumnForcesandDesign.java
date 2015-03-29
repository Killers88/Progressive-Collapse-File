/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

/**
 * @author koleary
 *
 */
public class extefficiencyColumnForcesandDesign {

	public static Double maxMx(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays) {

		return windForces.extMoment(colhgt, numstorys, trib, bays);

	}

	public static Double maxAxial(final double span, final double trib,
			final double sdl, final double live, final double numstorys) {

		double ultUdl = trib * ((sdl * 1.2 + live * 1.6) / 1000);

		return span * numstorys * ultUdl * 0.5;

	}

	public static String columnSizing(final double span, final double trib,
			final double sdl, final double live, final double numstorys,
			final double colhgt, final double k, final double fy,
			final double factCOMP, final double bays) {

		double ultAxial = maxAxial(span, trib, sdl, live, numstorys);

		double deadAxial = windForces
				.axialExt(span, trib, sdl, live, numstorys);

		double windMoment = windForces.extMoment(colhgt, numstorys, trib, bays);

		/**
		 * W14x48
		 */
		double a = 14.1;
		double ry = 1.91;
		double zx = 78.4;
		double slenderness = ((k * colhgt * 12) / (ry));

		double landaC = (slenderness / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC, 2))) * fy);
			double pn = fcr * a;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC, 2)) * fy;
			double pn = fcr * a;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x53
		 */
		double a1 = 15.6;
		double ry1 = 1.92;
		double zx1 = 87.1;
		double slenderness1 = ((k * colhgt * 12) / (ry1));

		double landaC1 = (slenderness1 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness1 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC1, 2))) * fy);
			double pn = fcr * a1;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx1 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness1 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC1, 2)) * fy;
			double pn = fcr * a1;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx1 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x61
		 */
		double a2 = 17.9;
		double ry2 = 2.45;
		double zx2 = 102;
		double slenderness2 = ((k * colhgt * 12) / (ry2));

		double landaC2 = (slenderness2 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness2 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC2, 2))) * fy);
			double pn = fcr * a2;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx2 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness2 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC2, 2)) * fy;
			double pn = fcr * a2;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx2 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}
		/**
		 * W14x68
		 */
		double a3 = 20;
		double ry3 = 2.46;
		double zx3 = 115;
		double slenderness3 = ((k * colhgt * 12) / (ry3));

		double landaC3 = (slenderness3 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness3 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC3, 2))) * fy);
			double pn = fcr * a3;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx3 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness3 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC3, 2)) * fy;
			double pn = fcr * a3;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx3 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x74
		 */
		double a4 = 21.8;
		double ry4 = 2.48;
		double zx4 = 126;
		double slenderness4 = ((k * colhgt * 12) / (ry4));

		double landaC4 = (slenderness4 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness4 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC4, 2))) * fy);
			double pn = fcr * a4;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx4 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness4 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC4, 2)) * fy;
			double pn = fcr * a4;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx4 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x82
		 */
		double a5 = 24;
		double ry5 = 2.48;
		double zx5 = 139;
		double slenderness5 = ((k * colhgt * 12) / (ry5));

		double landaC5 = (slenderness5 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness5 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC5, 2))) * fy);
			double pn = fcr * a5;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx5 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness5 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC5, 2)) * fy;
			double pn = fcr * a5;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx5 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}
		/**
		 * W14x90
		 */
		double a6 = 26.5;
		double ry6 = 3.7;
		double zx6 = 157;
		double slenderness6 = ((k * colhgt * 12) / (ry6));

		double landaC6 = (slenderness6 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness6 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC6, 2))) * fy);
			double pn = fcr * a6;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx6 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness6 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC6, 2)) * fy;
			double pn = fcr * a6;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx6 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x99
		 */
		double a7 = 29.1;
		double ry7 = 3.71;
		double zx7 = 173;
		double slenderness7 = ((k * colhgt * 12) / (ry7));

		double landaC7 = (slenderness7 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness7 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC7, 2))) * fy);
			double pn = fcr * a7;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx7 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness7 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC7, 2)) * fy;
			double pn = fcr * a7;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx7 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}
		/**
		 * W14x109
		 */
		double a8 = 32;
		double ry8 = 3.73;
		double zx8 = 192;
		double slenderness8 = ((k * colhgt * 12) / (ry8));

		double landaC8 = (slenderness8 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness8 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC8, 2))) * fy);
			double pn = fcr * a8;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx8 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness8 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC8, 2)) * fy;
			double pn = fcr * a8;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx8 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x120
		 */
		double a9 = 35.3;
		double ry9 = 3.74;
		double zx9 = 212;
		double slenderness9 = ((k * colhgt * 12) / (ry9));

		double landaC9 = (slenderness9 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness9 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC9, 2))) * fy);
			double pn = fcr * a9;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx9 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness9 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC9, 2)) * fy;
			double pn = fcr * a9;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx9 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x132
		 */
		double a10 = 38.8;
		double ry10 = 3.76;
		double zx10 = 234;
		double slenderness10 = ((k * colhgt * 12) / (ry10));

		double landaC10 = (slenderness10 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness10 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC10, 2))) * fy);
			double pn = fcr * a10;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx10 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness10 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC10, 2)) * fy;
			double pn = fcr * a10;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx10 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x145
		 */
		double a11 = 42.7;
		double ry11 = 3.98;
		double zx11 = 260;
		double slenderness11 = ((k * colhgt * 12) / (ry11));

		double landaC11 = (slenderness11 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness11 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC11, 2))) * fy);
			double pn = fcr * a11;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx11 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness11 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC11, 2)) * fy;
			double pn = fcr * a11;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx11 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}
		/**
		 * W14x159
		 */
		double a12 = 46.7;
		double ry12 = 4;
		double zx12 = 287;
		double slenderness12 = ((k * colhgt * 12) / (ry12));

		double landaC12 = (slenderness12 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness12 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC12, 2))) * fy);
			double pn = fcr * a12;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx12 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness12 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC12, 2)) * fy;
			double pn = fcr * a12;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx12 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x176
		 */
		double a13 = 51.8;
		double ry13 = 4.02;
		double zx13 = 320;
		double slenderness13 = ((k * colhgt * 12) / (ry13));

		double landaC13 = (slenderness13 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness13 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC13, 2))) * fy);
			double pn = fcr * a13;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx13 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness13 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC13, 2)) * fy;
			double pn = fcr * a13;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx13 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x193
		 */
		double a14 = 56.8;
		double ry14 = 4.05;
		double zx14 = 355;
		double slenderness14 = ((k * colhgt * 12) / (ry14));

		double landaC14 = (slenderness14 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness14 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC14, 2))) * fy);
			double pn = fcr * a14;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx14 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness14 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC14, 2)) * fy;
			double pn = fcr * a14;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx14 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}
		/**
		 * W14x211
		 */
		double a15 = 62;
		double ry15 = 4.07;
		double zx15 = 390;
		double slenderness15 = ((k * colhgt * 12) / (ry15));

		double landaC15 = (slenderness15 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness15 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC15, 2))) * fy);
			double pn = fcr * a15;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx15 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness15 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC15, 2)) * fy;
			double pn = fcr * a15;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx15 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x233
		 */
		double a16 = 68.5;
		double ry16 = 4.1;
		double zx16 = 436;
		double slenderness16 = ((k * colhgt * 12) / (ry16));

		double landaC16 = (slenderness16 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness16 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC16, 2))) * fy);
			double pn = fcr * a16;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx16 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness16 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC16, 2)) * fy;
			double pn = fcr * a16;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx16 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		/**
		 * W14x257
		 */
		double a17 = 75.6;
		double ry17 = 4.13;
		double zx17 = 487;
		double slenderness17 = ((k * colhgt * 12) / (ry17));

		double landaC17 = (slenderness17 / Math.PI) * Math.sqrt((fy / 29000));

		if (slenderness17 <= (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (Math.pow(0.658, (Math.pow(landaC17, 2))) * fy);
			double pn = fcr * a17;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx17 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		} else if (slenderness17 > (4.71 * Math.sqrt(29000 / fy))) {
			double fcr = (0.877 / Math.pow(landaC17, 2)) * fy;
			double pn = fcr * a17;
			double pc = pn * 0.9;
			double mcx = 0.9 * fy * zx17 / 12;
			if (deadAxial / pc >= 0.2) {
				double check = deadAxial / pc + (8 / 9) * (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			} else if (deadAxial / pc < 0.2) {
				double check = deadAxial / (2 * pc) + (windMoment / mcx);
				if (check < 1.0 && ultAxial < pc) {
					return "Efficiency (Combined, Buckling) = " + check
							+ ultAxial / pc;
				}
			}
		}

		return "NO MEMBER PASSES";

	}
}
