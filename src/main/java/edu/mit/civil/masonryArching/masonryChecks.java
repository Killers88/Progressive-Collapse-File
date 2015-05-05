/**
 * 
 */
package edu.mit.civil.masonryArching;

/**
 * @author koleary
 *
 */
public class masonryChecks {

	// Support Boundary Check - NOT RIGID WHEN COMPRESSIVE LOAD IS EXCEEDED BY
	// BLAST
	public static double masonryCapacityBasedNonRigidUPPER(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth, final double appliedCompression,
			final double mortarCompStrengthUPPER) {

		double masonryCompStrength = 0.85 * mortarCompStrengthUPPER * 0.144
				* masonryWallDepth * 0.5;// Per_1ft

		if (appliedCompression < masonryCompStrength) {

			final double Lateral_Capacity_Kips = 2 * masonryWallDepth
					* appliedCompression / masonryWallHeight;

			final double Lateral_Capacity_Psi = (Lateral_Capacity_Kips / (masonryWallHeight * masonryWallwidth)) * (6.94444);

			System.out.println("Goverened by Support Moving");
			System.out.println(masonryCompStrength);
			System.out.println(Lateral_Capacity_Psi);

		} else if (appliedCompression > masonryCompStrength) {

			final double Lateral_Capacity_Kips = 2 * masonryWallDepth
					* masonryCompStrength / masonryWallHeight;

			final double Lateral_Capacity_Psi = (Lateral_Capacity_Kips / (masonryWallHeight * masonryWallwidth)) * (6.94444);

			System.out.println("Goverened by Strength of Masonry");
			System.out.println(masonryCompStrength);
			System.out.println(Lateral_Capacity_Psi);

		}
		return 0.00;

	}

	public static double masonryCapacityBasedNonRigidLOWER(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth, final double appliedCompression,
			final double mortarCompStrengthLOWER) {

		double masonryCompStrength = 0.85 * mortarCompStrengthLOWER * 0.144
				* masonryWallDepth * 0.5;// Per_1ft

		if (appliedCompression < masonryCompStrength) {

			final double Lateral_Capacity_Kips = 2 * masonryWallDepth
					* appliedCompression / masonryWallHeight;

			final double Lateral_Capacity_Psi = (Lateral_Capacity_Kips / (masonryWallHeight * masonryWallwidth)) * 6.94444;

			System.out.println("Goverened by Support Moving");
			System.out.println(masonryCompStrength);
			System.out.println(Lateral_Capacity_Psi);

		} else if (appliedCompression > masonryCompStrength) {

			final double Lateral_Capacity_Kips = 2 * masonryWallDepth
					* masonryCompStrength / masonryWallHeight;

			final double Lateral_Capacity_Psi = (Lateral_Capacity_Kips / (masonryWallHeight * masonryWallwidth)) * 6.94444;

			System.out.println("Goverened by Strength of Masonry");
			System.out.println(masonryCompStrength);
			System.out.println(Lateral_Capacity_Psi);

		}
		return masonryCompStrength;

	}

	public static double masonryCapacityBasedOnCompressiveStrengthUPPER(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth, final double mortarCompStrengthUPPER) {

		return mortarCompStrengthUPPER * (144 / 1000) * masonryWallDepth;// Per_1ft

	}

	public static double masonryCapacityBasedOnCompressiveStrengthLOWER(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth, final double mortarCompStrengthLOWER) {

		return mortarCompStrengthLOWER * (144 / 1000) * masonryWallDepth;// Per_1ft

	}

	public static double masonryCapacityDoDGuidelines_UPBOUND(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth,
			final double mortarCompStrengthUPPER, final double mortarModOfElast) {

		final double unitStrain = (mortarCompStrengthUPPER / 1000)
				/ mortarModOfElast;// units in ksi

		final double ult_Mom_Cap = 0.25 * mortarCompStrengthUPPER
				* masonryWallDepth * masonryWallDepth;

		final double ult_Lat_Res = (2 / (masonryWallHeight * masonryWallHeight))
				* mortarCompStrengthUPPER * masonryWallDepth * masonryWallDepth;

		return ult_Lat_Res;

	}

	public static double masonryCapacityDoDGuidelines_LOWERBOUND(
			final double masonryWallHeight, final double masonryWallDepth,
			final double masonryWallwidth,
			final double mortarCompStrengthLOWER, final double mortarModOfElast) {

		final double unitStrain = (mortarCompStrengthLOWER / 1000)
				/ mortarModOfElast;// units in ksi

		final double ult_Mom_Cap = 0.25 * mortarCompStrengthLOWER
				* masonryWallDepth * masonryWallDepth;

		final double ult_Lat_Res = (2 / (masonryWallHeight * masonryWallHeight))
				* mortarCompStrengthLOWER * masonryWallDepth * masonryWallDepth;

		return ult_Lat_Res;

	}
}
