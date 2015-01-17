/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;

/**
 * @author koleary
 *
 */
public class BlastAssessmentApp {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		// Weight of TNT Input
		double w = 0.000;
		System.out.println("Weight of explosive (TNT equiv)");

		// Standoff Distance from Target Column
		double r = 0.000;
		System.out.println("Standoff distance from target column");

		// get the W-Wgt of TNT from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		w = Double.parseDouble(br.readLine());

		// get the R-Dist from console
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(System.in));
		r = Double.parseDouble(br1.readLine());

		// Finding Scaled Distance
		// Z = R/(W^1/3)

		double z = (double) ((r) / Math.pow(w, 0.33333));

		System.out.println("Scaled Distance 'Z' " + z);
		System.out.println("Over Pressure Pso = "
				+ PeakIncidentOverPressurePso.calculatePso(z));

	}

}
