/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.mit.civil.blastassessment.calculation.ClearingTimeTc;
import edu.mit.civil.blastassessment.calculation.EquivalentDurationTe;
import edu.mit.civil.blastassessment.calculation.ImpulseIs;
import edu.mit.civil.blastassessment.calculation.PeakDynamicPressureQo;
import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;
import edu.mit.civil.blastassessment.calculation.PositivePhaseDurationTo;
import edu.mit.civil.blastassessment.calculation.ReflectedPressurePr;
import edu.mit.civil.blastassessment.calculation.SoundVelocityCr;
import edu.mit.civil.blastassessment.calculation.StagnationPressurePs;
import edu.mit.civil.blastassessment.calculation.WaveLengthLw;
import edu.mit.civil.columnassessment.calculation.ActualStiffnessK;
import edu.mit.civil.columnassessment.calculation.AppliedLoadingToColumnQ;
import edu.mit.civil.columnassessment.calculation.EquivalentSDOFPropertiesElastic;
import edu.mit.civil.columnassessment.calculation.ParameterForElasticCheck;
import edu.mit.civil.columnassessment.calculation.StaticDisplacementUs;
import edu.mit.civil.columnassessment.calculation.TotalActalMassM;
import edu.mit.civil.columnassessment.calculation.YieldDisplacementUy;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticCheck;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticResponseA;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticResponseB;

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
		// get the W-Wgt of TNT from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		w = Double.parseDouble(br.readLine());

		// Standoff Distance from Target Column
		double r = 0.000;
		System.out.println("Standoff distance from target column");
		// get the R-Dist from console
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(System.in));
		r = Double.parseDouble(br1.readLine());

		// Angle of Incidence
		int angle = 0;
		System.out.println("Angle of Incidence");
		// get the Angle-Dist from console
		BufferedReader br4 = new BufferedReader(
				new InputStreamReader(System.in));
		angle = (int) Double.parseDouble(br4.readLine());

		// Building Height
		double h = 0.000;
		System.out.println("Building Height 'H' (ft)");
		// get the Height-Dist from console
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(System.in));
		h = Double.parseDouble(br2.readLine());

		// Building Width
		double width = 0.000;
		System.out.println("Building Width 'W' (ft)");
		// get the Width-Dist from console
		BufferedReader br3 = new BufferedReader(
				new InputStreamReader(System.in));
		width = Double.parseDouble(br3.readLine());

		// Steel Modulous
		double e = 0.000;
		System.out.println("Youngs Modulous 'E' (ksi)");
		// get the Modulous from console
		BufferedReader br5 = new BufferedReader(
				new InputStreamReader(System.in));
		e = Double.parseDouble(br5.readLine());

		// Yield Stress
		double yield = 0.000;
		System.out.println("Steel Yield Strength (ksi)");
		// get the Modulous from console
		BufferedReader br6 = new BufferedReader(
				new InputStreamReader(System.in));
		yield = Double.parseDouble(br6.readLine());

		// Ixx
		double i = 0.000;
		System.out.println("Second Moment of Inertia 'I' (in^4)");
		// get the Modulous from console
		BufferedReader br7 = new BufferedReader(
				new InputStreamReader(System.in));
		i = Double.parseDouble(br7.readLine());

		// S - Section Modulus
		double s = 0.000;
		System.out.println("Section Modulous 'S' (in^3)");
		// get the Section Modulous from console
		BufferedReader br8 = new BufferedReader(
				new InputStreamReader(System.in));
		s = Double.parseDouble(br8.readLine());

		// Steel Section - Linear Weight
		double colweight = 0.000;
		System.out.println("Column Linear Weight (lbf/ft)");
		// get the linear weight from console
		BufferedReader br9 = new BufferedReader(
				new InputStreamReader(System.in));
		colweight = Double.parseDouble(br9.readLine());

		// Width of section in perpendicular to the blast
		double colwidth = 0.000;
		System.out.println("Column width perpendicular to the blast (in)");
		// get the Column Width from console
		BufferedReader br10 = new BufferedReader(new InputStreamReader(
				System.in));
		colwidth = Double.parseDouble(br10.readLine());

		// Height of Column
		double colhgt = 0.000;
		System.out.println("Height of Column (ft)");
		// get the Column Height from console
		BufferedReader br12 = new BufferedReader(new InputStreamReader(
				System.in));
		colhgt = Double.parseDouble(br12.readLine());

		double z = (double) ((r) / Math.pow(w, 0.33333));

		System.out.println("Blast Analysis - Scaled Distance 'Z' " + z);

		System.out.println("Blast Analysis - Over Pressure 'Pso' = "
				+ PeakIncidentOverPressurePso
						.findPeakIncidentOverPressureWith(z) + " psi");

		System.out.println("Blast Analysis - Peak Dynamic Pressure 'qo' = "
				+ PeakDynamicPressureQo
						.calculatQoWithPso(PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z)) + " psi");

		System.out.println("Blast Analysis - Sound Velocity 'Cr' = "
				+ SoundVelocityCr.caculateCrWithPso(PeakIncidentOverPressurePso
						.findPeakIncidentOverPressureWith(z)) + " psi");

		System.out
				.println("Blast Analysis - Peak Reflected Pressure 'Pr' = "
						+ ReflectedPressurePr.findingPrWithZAndAngle(z, angle)
						+ " psi");

		System.out.println("Blast Analysis - Clearing Time 'tc' = "
				+ ClearingTimeTc.calculateclearingTimeTc(h, width,
						SoundVelocityCr
								.caculateCrWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " ms");

		System.out.println("Blast Analysis - Positive Phase Duration 'to' = "
				+ PositivePhaseDurationTo.findPositivePhaseDurationForZ(z, w)
				+ " ms");

		System.out.println("Blast Analysis - Wave Length 'Lw' = "
				+ WaveLengthLw.findWaveLengthWithZ(z, w) + " ft");

		System.out.println("Blast Analysis - Stagnation Pressure 'Ps' = "
				+ StagnationPressurePs.calculateStagnationPressureWithPsoandqo(
						PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z),
						PeakDynamicPressureQo
								.calculatQoWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " psi");

		System.out
				.println("Blast Analysis - Blast Analysis - Impulse 'Is' = "
						+ ImpulseIs.calculateImpulseIsWithPrPsTcTo(
								ReflectedPressurePr.findingPrWithZAndAngle(z,
										angle),
								StagnationPressurePs
										.calculateStagnationPressureWithPsoandqo(
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z),
												PeakDynamicPressureQo
														.calculatQoWithPso(PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z))),
								ClearingTimeTc.calculateclearingTimeTc(
										h,
										width,
										SoundVelocityCr
												.caculateCrWithPso(PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z))),
								PositivePhaseDurationTo
										.findPositivePhaseDurationForZ(z, w))
						+ " psi-ms");

		System.out
				.println("Blast Analysis - Equivalent Duration 'te' = "
						+ EquivalentDurationTe.calculateEquivalentDurationWithIsAndPr(
								ImpulseIs.calculateImpulseIsWithPrPsTcTo(
										ReflectedPressurePr
												.findingPrWithZAndAngle(z,
														angle),
										StagnationPressurePs
												.calculateStagnationPressureWithPsoandqo(
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z),
														PeakDynamicPressureQo
																.calculatQoWithPso(PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
										ClearingTimeTc.calculateclearingTimeTc(
												h,
												width,
												SoundVelocityCr
														.caculateCrWithPso(PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z))),
										PositivePhaseDurationTo
												.findPositivePhaseDurationForZ(
														z, w)),
								ReflectedPressurePr.findingPrWithZAndAngle(z,
										angle)) + " ms");

		System.out
				.println("Target Column Analysis - Applied Column Loading 'Q*' = "
						+ AppliedLoadingToColumnQ.calculateAppliedLoading(
								ReflectedPressurePr.findingPrWithZAndAngle(z,
										angle), colwidth, colhgt) + " kipf");

		System.out
				.println("Target Column Analysis - Actual Column Stiffness 'k' = "
						+ ActualStiffnessK.calculateColumnActualStiffness(e, i,
								colhgt) + " kipf.ft^-1");

		System.out.println("Target Column Analysis - Total Actual Mass 'm' = "
				+ TotalActalMassM.calculatingTotalActualMass(colweight, colhgt)
				+ " kipf.s^2.ft^-1");

		System.out
				.println("Target Column Analysis - Static Displacement 'us' = "
						+ StaticDisplacementUs.CalculateStaticDisplacement(
								AppliedLoadingToColumnQ.calculateAppliedLoading(
										ReflectedPressurePr
												.findingPrWithZAndAngle(z,
														angle), colwidth,
										colhgt), ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " ft");

		System.out
				.println("Target Column Analysis - Yield Displacement 'uy' = "
						+ YieldDisplacementUy.calculateYieldDisplacementUy(
								colhgt, s, yield, e, i) + " ft");

		System.out
				.println("Target Column Analysis - Stiffness of Equivalent SDOF 'ke' = "
						+ EquivalentSDOFPropertiesElastic
								.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " kipf.ft^-1");

		System.out
				.println("Target Column Analysis - Mass of Equivalent SDOF 'me' = "
						+ EquivalentSDOFPropertiesElastic
								.massOfEquivSDOF(TotalActalMassM
										.calculatingTotalActualMass(colweight,
												colhgt)) + " kipf.s^2.ft^-1");

		System.out
				.println("Target Column Analysis - Natural Period of Equivalent SDOF 'Tn' = "
						+ EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesElastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														colweight, colhgt)),
								EquivalentSDOFPropertiesElastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt))) + " s");

		System.out
				.println("Target Column Analysis - T/Tn used for UFC 3-340 graphs to determnine whether column remains elastic = "
						+ ParameterForElasticCheck.tEquivDividedByTn(
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsWithPrPsTcTo(
																ReflectedPressurePr
																		.findingPrWithZAndAngle(
																				z,
																				angle),
																StagnationPressurePs
																		.calculateStagnationPressureWithPsoandqo(
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z),
																				PeakDynamicPressureQo
																						.calculatQoWithPso(PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z))),
																ClearingTimeTc
																		.calculateclearingTimeTc(
																				h,
																				width,
																				SoundVelocityCr
																						.caculateCrWithPso(PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z))),
																PositivePhaseDurationTo
																		.findPositivePhaseDurationForZ(
																				z,
																				w)),
												ReflectedPressurePr
														.findingPrWithZAndAngle(
																z, angle)),
								EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesElastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																colweight,
																colhgt)),
										EquivalentSDOFPropertiesElastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																e, i, colhgt)))));

		System.out
				.println("Elastic Parameter - Peak Response Parameter 'um' = "
						+ EquivalentSDOFElasticResponseB.elasticResponseParameterCheck(
								(ParameterForElasticCheck
										.tEquivDividedByTn(
												EquivalentDurationTe
														.calculateEquivalentDurationWithIsAndPr(
																ImpulseIs
																		.calculateImpulseIsWithPrPsTcTo(
																				ReflectedPressurePr
																						.findingPrWithZAndAngle(
																								z,
																								angle),
																				StagnationPressurePs
																						.calculateStagnationPressureWithPsoandqo(
																								PeakIncidentOverPressurePso
																										.findPeakIncidentOverPressureWith(z),
																								PeakDynamicPressureQo
																										.calculatQoWithPso(PeakIncidentOverPressurePso
																												.findPeakIncidentOverPressureWith(z))),
																				ClearingTimeTc
																						.calculateclearingTimeTc(
																								h,
																								width,
																								SoundVelocityCr
																										.caculateCrWithPso(PeakIncidentOverPressurePso
																												.findPeakIncidentOverPressureWith(z))),
																				PositivePhaseDurationTo
																						.findPositivePhaseDurationForZ(
																								z,
																								w)),
																ReflectedPressurePr
																		.findingPrWithZAndAngle(
																				z,
																				angle)),
												EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
														EquivalentSDOFPropertiesElastic
																.massOfEquivSDOF(TotalActalMassM
																		.calculatingTotalActualMass(
																				colweight,
																				colhgt)),
														EquivalentSDOFPropertiesElastic
																.stiffnessOfEquivSDOF(ActualStiffnessK
																		.calculateColumnActualStiffness(
																				e,
																				i,
																				colhgt))))),
								StaticDisplacementUs.CalculateStaticDisplacement(
										AppliedLoadingToColumnQ.calculateAppliedLoading(
												ReflectedPressurePr
														.findingPrWithZAndAngle(
																z, angle),
												colwidth, colhgt),
										ActualStiffnessK
												.calculateColumnActualStiffness(
														e, i, colhgt))) + " ft");

		System.out
				.println("Elastic Parameter - Peak Response Parameter 'tm' = "
						+ EquivalentSDOFElasticResponseA.elasticResponseParameterCheck(
								(ParameterForElasticCheck
										.tEquivDividedByTn(
												EquivalentDurationTe
														.calculateEquivalentDurationWithIsAndPr(
																ImpulseIs
																		.calculateImpulseIsWithPrPsTcTo(
																				ReflectedPressurePr
																						.findingPrWithZAndAngle(
																								z,
																								angle),
																				StagnationPressurePs
																						.calculateStagnationPressureWithPsoandqo(
																								PeakIncidentOverPressurePso
																										.findPeakIncidentOverPressureWith(z),
																								PeakDynamicPressureQo
																										.calculatQoWithPso(PeakIncidentOverPressurePso
																												.findPeakIncidentOverPressureWith(z))),
																				ClearingTimeTc
																						.calculateclearingTimeTc(
																								h,
																								width,
																								SoundVelocityCr
																										.caculateCrWithPso(PeakIncidentOverPressurePso
																												.findPeakIncidentOverPressureWith(z))),
																				PositivePhaseDurationTo
																						.findPositivePhaseDurationForZ(
																								z,
																								w)),
																ReflectedPressurePr
																		.findingPrWithZAndAngle(
																				z,
																				angle)),
												EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
														EquivalentSDOFPropertiesElastic
																.massOfEquivSDOF(TotalActalMassM
																		.calculatingTotalActualMass(
																				colweight,
																				colhgt)),
														EquivalentSDOFPropertiesElastic
																.stiffnessOfEquivSDOF(ActualStiffnessK
																		.calculateColumnActualStiffness(
																				e,
																				i,
																				colhgt))))),
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsWithPrPsTcTo(
																ReflectedPressurePr
																		.findingPrWithZAndAngle(
																				z,
																				angle),
																StagnationPressurePs
																		.calculateStagnationPressureWithPsoandqo(
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z),
																				PeakDynamicPressureQo
																						.calculatQoWithPso(PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z))),
																ClearingTimeTc
																		.calculateclearingTimeTc(
																				h,
																				width,
																				SoundVelocityCr
																						.caculateCrWithPso(PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z))),
																PositivePhaseDurationTo
																		.findPositivePhaseDurationForZ(
																				z,
																				w)),
												ReflectedPressurePr
														.findingPrWithZAndAngle(
																z, angle)))
						+ " ms");

		System.out
				.println("Elastic Check - "
						+ EquivalentSDOFElasticCheck.determiningDynamicLoadFactor(
								EquivalentSDOFElasticResponseB
										.elasticResponseParameterCheck(
												(ParameterForElasticCheck
														.tEquivDividedByTn(
																EquivalentDurationTe
																		.calculateEquivalentDurationWithIsAndPr(
																				ImpulseIs
																						.calculateImpulseIsWithPrPsTcTo(
																								ReflectedPressurePr
																										.findingPrWithZAndAngle(
																												z,
																												angle),
																								StagnationPressurePs
																										.calculateStagnationPressureWithPsoandqo(
																												PeakIncidentOverPressurePso
																														.findPeakIncidentOverPressureWith(z),
																												PeakDynamicPressureQo
																														.calculatQoWithPso(PeakIncidentOverPressurePso
																																.findPeakIncidentOverPressureWith(z))),
																								ClearingTimeTc
																										.calculateclearingTimeTc(
																												h,
																												width,
																												SoundVelocityCr
																														.caculateCrWithPso(PeakIncidentOverPressurePso
																																.findPeakIncidentOverPressureWith(z))),
																								PositivePhaseDurationTo
																										.findPositivePhaseDurationForZ(
																												z,
																												w)),
																				ReflectedPressurePr
																						.findingPrWithZAndAngle(
																								z,
																								angle)),
																EquivalentSDOFPropertiesElastic
																		.naturalPeriodSDOF(
																				EquivalentSDOFPropertiesElastic
																						.massOfEquivSDOF(TotalActalMassM
																								.calculatingTotalActualMass(
																										colweight,
																										colhgt)),
																				EquivalentSDOFPropertiesElastic
																						.stiffnessOfEquivSDOF(ActualStiffnessK
																								.calculateColumnActualStiffness(
																										e,
																										i,
																										colhgt))))),
												StaticDisplacementUs
														.CalculateStaticDisplacement(
																AppliedLoadingToColumnQ
																		.calculateAppliedLoading(
																				ReflectedPressurePr
																						.findingPrWithZAndAngle(
																								z,
																								angle),
																				colwidth,
																				colhgt),
																ActualStiffnessK
																		.calculateColumnActualStiffness(
																				e,
																				i,
																				colhgt))),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(colhgt,
												s, yield, e, i)));

	}
}
