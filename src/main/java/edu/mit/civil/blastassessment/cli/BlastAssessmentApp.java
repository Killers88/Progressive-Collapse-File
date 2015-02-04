/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.mit.civil.blastassessment.calculation.EquivalentDurationTe;
import edu.mit.civil.blastassessment.calculation.ImpulseIs;
import edu.mit.civil.blastassessment.calculation.PeakDynamicPressureQo;
import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;
import edu.mit.civil.blastassessment.calculation.ReflectedPressurePr;
import edu.mit.civil.blastassessment.calculation.StagnationPressurePs;
import edu.mit.civil.columnassessment.calculation.ActualStiffnessK;
import edu.mit.civil.columnassessment.calculation.AppliedLoadingToColumnQ;
import edu.mit.civil.columnassessment.calculation.ParameterForElasticCheck;
import edu.mit.civil.columnassessment.calculation.StaticDisplacementUs;
import edu.mit.civil.columnassessment.calculation.TotalActalMassM;
import edu.mit.civil.columnassessment.calculation.YieldDisplacementUy;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticCheck;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticResponseUm;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPlasticResponseUm;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPropertiesElastic;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPropertiesPlastic;
import edu.mit.civil.columnassessment.elasticplasticchecks.UltimateUnitResistance;

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
		double w = collectInputWithLabel("Weight of explosive (TNT equiv)");

		// Standoff Distance from Target Column
		double r = collectInputWithLabel("Standoff distance from target column");

		// Angle of Incidence
		int angle = (int) collectInputWithLabel("Angle of Incidence");

		// Building Height
		double h = collectInputWithLabel("Building Height 'H' (ft)");

		// Building Width
		double width = collectInputWithLabel("Building Width 'W' (ft))");

		// Steel Modulus
		double e = collectInputWithLabel("Youngs Modulous 'E' (ksi)");

		// Yield Stress
		double yield = collectInputWithLabel("Steel Yield Strength (ksi)");

		// Ixx
		double i = collectInputWithLabel("Second Moment of Inertia 'I' (in^4)");

		// S - Section Modulus
		double s = collectInputWithLabel("Section Modulous 'S' (in^3)");

		// Z - Plastic Modulus
		double zxx = collectInputWithLabel("Plastic Section Modulus 'Z' (in^3)");

		// Steel Section - Linear Weight
		double colweight = collectInputWithLabel("Column Linear Weight (lbf/ft)");

		// Width of section in perpendicular to the blast
		double colwidth = collectInputWithLabel("Column width perpendicular to the blast (in)");

		// Height of Column
		double colhgt = collectInputWithLabel("Height of Column (ft)");

		double z = (double) ((r) / Math.pow(w, 0.33333));

		System.out.println("Blast Analysis - Scaled Distance 'Z' " + z);

		System.out.println("Blast Analysis - Over Pressure 'Pso' = "
				+ PeakIncidentOverPressurePso
						.findPeakIncidentOverPressureWith(z) + " psi");

		System.out.println("Blast Analysis - Peak Dynamic Pressure 'qo' = "
				+ PeakDynamicPressureQo
						.calculatQoWithPso(PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z)) + " psi");

		// System.out.println("Blast Analysis - Sound Velocity 'Cr' = "
		// + SoundVelocityCr.caculateCrWithPso(PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)) + " psi");

		System.out
				.println("Blast Analysis - Peak Reflected Pressure 'Pr(alpha)' = "
						+ ReflectedPressurePr.findReflectedPressureWith(angle,
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z))
						+ " psi");

		// System.out.println("Blast Analysis - Clearing Time 'tc' = "
		// + ClearingTimeTc.calculateclearingTimeTc(h, width,
		// SoundVelocityCr
		// .caculateCrWithPso(PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)))
		// + " ms");

		// System.out.println("Blast Analysis - Positive Phase Duration 'to' = "
		// + PositivePhaseDurationTo.findPositivePhaseDurationForZ(z, w)
		// + " ms");
		//
		// System.out.println("Blast Analysis - Wave Length 'Lw' = "
		// + WaveLengthLw.findWaveLengthWithZ(z, w) + " ft");
		//
		System.out.println("Blast Analysis - Stagnation Pressure 'Ps' = "
				+ StagnationPressurePs.calculateStagnationPressureWithPsoandqo(
						PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z),
						PeakDynamicPressureQo
								.calculatQoWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " psi");

		System.out
				.println("Blast Analysis - Blast Analysis - Impulse 'Ir(alpha)' = "
						+ ImpulseIs.calculateImpulseIsUFCGraph(
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z),
								angle, w) + " psi-ms");

		System.out
				.println("Blast Analysis - Equivalent Duration 'tr(alpha)' = "
						+ EquivalentDurationTe.calculateEquivalentDurationWithIsAndPr(
								ImpulseIs.calculateImpulseIsUFCGraph(
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z),
										angle, w),
								ReflectedPressurePr.findReflectedPressureWith(
										angle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)))
						+ " ms");

		System.out
				.println("Target Column Analysis - Applied Column Loading 'Q*' = "
						+ AppliedLoadingToColumnQ.calculateAppliedLoading(
								ReflectedPressurePr
										.findReflectedPressureWith(
												angle,
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt) + " kipf");

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
												.findReflectedPressureWith(
														angle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z)),
										colwidth, colhgt), ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " ft");

		System.out
				.println("Target Column Analysis - Yield Displacement 'uy' = "
						+ YieldDisplacementUy.calculateYieldDisplacementUy(
								colhgt, s, yield, e, i) + " ft");

		System.out
				.println("Target Column Analysis - T/Tn used for UFC 3-340 graphs to determnine whether column remains elastic = "
						+ ParameterForElasticCheck.tEquivDividedByTn(
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																angle, w),
												ReflectedPressurePr
														.findReflectedPressureWith(
																angle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
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
				.println("Elastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF 'ke' = "
						+ EquivalentSDOFPropertiesElastic
								.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " kipf.ft^-1");

		System.out
				.println("Elastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF 'me' = "
						+ EquivalentSDOFPropertiesElastic
								.massOfEquivSDOF(TotalActalMassM
										.calculatingTotalActualMass(colweight,
												colhgt)) + " kipf.s^2.ft^-1");

		System.out
				.println("Elastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF 'Tn' = "
						+ EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesElastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														colweight, colhgt)),
								EquivalentSDOFPropertiesElastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt))) + " s");

		System.out
				.println("Elastic Parameter - Peak Response Parameter 'um' = "
						+ EquivalentSDOFElasticResponseUm.elasticResponseParameterCheck(
								(ParameterForElasticCheck
										.tEquivDividedByTn(
												EquivalentDurationTe
														.calculateEquivalentDurationWithIsAndPr(
																ImpulseIs
																		.calculateImpulseIsUFCGraph(
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z),
																				angle,
																				w),
																ReflectedPressurePr
																		.findReflectedPressureWith(
																				angle,
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z))),
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
														.findReflectedPressureWith(
																angle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z)),
												colwidth, colhgt),
										ActualStiffnessK
												.calculateColumnActualStiffness(
														e, i, colhgt))) + " ft");

		// System.out
		// .println("Elastic Parameter - Peak Response Parameter 'tm' = "
		// + EquivalentSDOFElasticResponseA.elasticResponseParameterCheck(
		// (ParameterForElasticCheck
		// .tEquivDividedByTn(
		// EquivalentDurationTe
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIs
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// angle,
		// w),
		// ReflectedPressurePr
		// .findingPrWithZAndAngle(
		// z,
		// angle)),
		// EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// colweight,
		// colhgt)),
		// EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .calculateColumnActualStiffness(
		// e,
		// i,
		// colhgt))))),
		// EquivalentDurationTe
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIs
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// angle, w),
		// ReflectedPressurePr
		// .findingPrWithZAndAngle(
		// z, angle)))
		// + " ms");

		System.out
				.println("***Elastic Check*** - "
						+ EquivalentSDOFElasticCheck.determiningDynamicLoadFactor(
								EquivalentSDOFElasticResponseUm
										.elasticResponseParameterCheck(
												(ParameterForElasticCheck
														.tEquivDividedByTn(
																EquivalentDurationTe
																		.calculateEquivalentDurationWithIsAndPr(
																				ImpulseIs
																						.calculateImpulseIsUFCGraph(
																								PeakIncidentOverPressurePso
																										.findPeakIncidentOverPressureWith(z),
																								angle,
																								w),
																				ReflectedPressurePr
																						.findReflectedPressureWith(
																								angle,
																								PeakIncidentOverPressurePso
																										.findPeakIncidentOverPressureWith(z))),
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
																						.findReflectedPressureWith(
																								angle,
																								PeakIncidentOverPressurePso
																										.findPeakIncidentOverPressureWith(z)),
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

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF (k'e) = "
						+ EquivalentSDOFPropertiesPlastic
								.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " kipf.ft^-1");

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF (m'e) = "
						+ EquivalentSDOFPropertiesPlastic
								.massOfEquivSDOF(TotalActalMassM
										.calculatingTotalActualMass(colweight,
												colhgt)) + " kipf.s^2.ft^-1");

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF (T'n) = "
						+ EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesPlastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														colweight, colhgt)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt))) + " s");

		System.out.println("Plastic Parameter - Ultimate Resistance = "
				+ UltimateUnitResistance.calculatingPlasticMoment(yield, zxx,
						colhgt) + " kipf.ft^-1");

		System.out
				.println("Plastic Parameter - T/T'n = "
						+ EquivalentSDOFPlasticResponseUm.maxDeflectionPlasticInputsTeDivideTn(
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																angle, w),
												ReflectedPressurePr
														.findReflectedPressureWith(
																angle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																colweight,
																colhgt)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																e, i, colhgt)))));

		System.out
				.println("Plastic Parameter - Ultimate Resistance ru / Peak Reflected Pressure = "
						+ EquivalentSDOFPlasticResponseUm.maxDeflectionPlasticInputsRuDivideP(
								UltimateUnitResistance
										.calculatingPlasticMoment(yield, zxx,
												colhgt),
								ReflectedPressurePr.findReflectedPressureWith(
										angle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z))));

		System.out
				.println("Plastic Parameter - Peak Response Parameter 'um'  = "
						+ EquivalentSDOFPlasticResponseUm.peakResponseParameterPlastic(
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																angle, w),
												ReflectedPressurePr
														.findReflectedPressureWith(
																angle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																colweight,
																colhgt)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																e, i, colhgt))),
								UltimateUnitResistance
										.calculatingPlasticMoment(yield, zxx,
												colhgt),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(colhgt,
												s, yield, e, i),
								ReflectedPressurePr.findReflectedPressureWith(
										angle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z))));

		System.out
				.println("***Plastic Check*** -  = "
						+ EquivalentSDOFPlasticResponseUm.plasticCheckFinal(
								EquivalentDurationTe
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIs
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																angle, w),
												ReflectedPressurePr
														.findReflectedPressureWith(
																angle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																colweight,
																colhgt)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																e, i, colhgt))),
								UltimateUnitResistance
										.calculatingPlasticMoment(yield, zxx,
												colhgt),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(colhgt,
												s, yield, e, i),
								ReflectedPressurePr.findReflectedPressureWith(
										angle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z))));

	}

	/**
	 * 
	 * @param label
	 * @return
	 * @throws IOException
	 */
	private static double collectInputWithLabel(String label)
			throws IOException {
		System.out.println(label);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double input = Double.parseDouble(br.readLine());
		// br.close();
		return input;
	}
}
