/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.mit.civil.beamassessment.calculation.beamChecks;
import edu.mit.civil.beamassessment.calculation.beamDesignForces;
import edu.mit.civil.blastassessment.calculation.ClearingTimeTc;
import edu.mit.civil.blastassessment.calculation.EquivalentDurationTe;
import edu.mit.civil.blastassessment.calculation.EquivalentDurationTrAlpha;
import edu.mit.civil.blastassessment.calculation.ImpulseIralpha;
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
import edu.mit.civil.sapoutputfile.fem.SapTextFile;

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
		double w = collectInputWithLabel("Blast Details - Weight of explosive (TNT equiv, lbs)");

		// Weight of TNT Input
		double blastfact = collectInputWithLabel("Factor of Safety for Blast (UFC indicate a 20% increase, i.e. 1.2)");

		// Standoff Distance from Target Column
		double r = collectInputWithLabel("Blast Details - Standoff distance from target column (ft)");

		// Angle of Incidence
		int angle = (int) collectInputWithLabel("Blast Details - Angle of Incidence");

		// Building Height
		double h = collectInputWithLabel("Building Height 'H' (ft)");

		// Building Width
		double width = collectInputWithLabel("Building Width 'W' (ft))");

		// Steel Modulus
		double e = collectInputWithLabel("Youngs Modulous 'E' (ksi)");

		// Yield Stress
		double yield = collectInputWithLabel("Steel Yield Strength (ksi)");

		// Ixx
		double i = collectInputWithLabel("Column Details - Second Moment of Inertia 'I' (in^4)");

		// S - Section Modulus
		double s = collectInputWithLabel("Column Details - Section Modulous 'S' (in^3)");

		// Z - Plastic Modulus
		double zxx = collectInputWithLabel("Column Details - Plastic Section Modulus 'Z' (in^3)");

		// Steel Section - Linear Weight
		double colweight = collectInputWithLabel("Column Details - Linear Weight (lbf/ft)");

		// Width of section in perpendicular to the blast
		double colwidth = collectInputWithLabel("Column Details - width perpendicular to the blast (in)");

		// Height of Column
		double colhgt = collectInputWithLabel("Column Details - Height (ft)");

		// Number of Storys
		double numstorys = collectInputWithLabel("Number of storys incl. 1st floor excl. roof");

		// Number of bays
		double bays = collectInputWithLabel("Total number of bays");

		// Span LHS
		double spanlhs = collectInputWithLabel("Beam span, left hand side of target column (ft)");

		// Span LHS
		double spanrhs = collectInputWithLabel("Beam span, right hand side of target column (ft)");

		// Tributary Width
		double trib = collectInputWithLabel("Beam tributary width, perpindicular to beam span direction (ft)");

		// Dead Load
		double dead = collectInputWithLabel("Typical floor dead load (psf)");

		// Live Load
		double live = collectInputWithLabel("Typical floor live load (psf)");

		// Roof Dead Load
		double roofdead = collectInputWithLabel("Typical roof dead load (psf)");

		// Roof Live Load
		double rooflive = collectInputWithLabel("Typical roof live load (psf)");

		// Dead Load Combination
		double deadcombo = collectInputWithLabel("Dead Load Combination for Blast Assessment (Generally 1.2 or 1.1)");

		// Live Load Combination
		double livecombo = collectInputWithLabel("Live Load Combination for Blast Assessment (Generally 0.25 - 0.5)");

		// Beam Axial
		double beamaxial = collectInputWithLabel("Axial force in beam at time of explosion (i.e. trib area x 0.2Wind) - Kips");

		// Beam Details : Flange Breadth
		double bf = collectInputWithLabel("Beam Details - Breadth of Flange (in)");

		// Beam Details : Beam Depth
		double depth = collectInputWithLabel("Beam Details - Depth (in)");

		// Beam Details : Flange thickness
		double tf = collectInputWithLabel("Beam Details - Thickness of Flange (in)");

		// Beam Details : Flange thickness
		double tw = collectInputWithLabel("Beam Details - Thickness of Web (in)");

		// Beam Details : Area
		double beamarea = collectInputWithLabel("Beam Details - Cross Sectional Area (in^2)");

		// Beam Details : Plastic Sectional Area Zx
		double beamzx = collectInputWithLabel("Beam Details - Plastic Section Modulus 'Zx' (in^3)");

		// // Beam Details : Plastic Sectional Area Zy
		// double beamzy =
		// collectInputWithLabel("Beam Details - Plastic Section Modulus 'Zy' (in^3)");

		// Beam Details : Radius of Gyration rx
		double beamrx = collectInputWithLabel("Beam Details - Radius of Gyration 'rx' (in)");

		// Beam Details : Radius of Gyration ry
		double beamry = collectInputWithLabel("Beam Details - Radius of Gyration 'ry' (in)");

		// Beam Details : Effective Length Lx
		double beamlx = collectInputWithLabel("Beam Details - Effective Length, Major Axis 'Lx' (ft)");

		// Beam Details : Effective Length Ly
		double beamly = collectInputWithLabel("Beam Details - Effective Length, Major Axis 'Ly' (ft)");

		// Dynamic Amplification Factor
		double daf = collectInputWithLabel("Dynamic Amplification Factor 'DAF' for static loads (approx. - 2.0)");

		double z = (double) ((r) / Math.pow(w * blastfact, 0.33333));

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

		System.out.println("Blast Analysis - Impulse 'is' = "
				+ ImpulseIs.findPeakImpulseIsWith(z, w) + " ms");

		System.out.println("Blast Analysis - Clearing Time 'tc' = "
				+ ClearingTimeTc.calculateclearingTimeTc(h, width,
						SoundVelocityCr
								.caculateCrWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " ms");

		System.out.println("Blast Analysis - Positive Phase Duration 'to' = "
				+ PositivePhaseDurationTo.findPositivePhaseDurationForZ(z, w)
				+ " ms");

		System.out.println("Blast Analysis - Wave Length 'Lw' = REVIEW"
				+ WaveLengthLw.findWaveLengthWithZ(z, w) + " ft");

		System.out.println("Blast Analysis - Stagnation Pressure 'Ps' = "
				+ StagnationPressurePs.calculateStagnationPressureWithPsoandqo(
						PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z),
						PeakDynamicPressureQo
								.calculatQoWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " psi");

		System.out.println("Blast Analysis - Equivalent Duration 'te' = "
				+ EquivalentDurationTe.calculateEquivalentDurationWithIsAndPso(
						ImpulseIs.findPeakImpulseIsWith(z, w),
						PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z)) + " ms");

		System.out
				.println("Blast Analysis - Peak Reflected Pressure 'Pr(alpha)' = "
						+ ReflectedPressurePr.findReflectedPressureWith(angle,
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z))
						+ " psi");

		System.out
				.println("Blast Analysis - Blast Analysis - Impulse 'Ir(alpha)' = "
						+ ImpulseIralpha.calculateImpulseIsUFCGraph(
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z),
								angle, w) + " psi-ms");

		System.out
				.println("Blast Analysis - Equivalent Duration 'tr(alpha)' = "
						+ EquivalentDurationTrAlpha.calculateEquivalentDurationWithIsAndPr(
								ImpulseIralpha.calculateImpulseIsUFCGraph(
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
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												EquivalentDurationTrAlpha
														.calculateEquivalentDurationWithIsAndPr(
																ImpulseIralpha
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
																EquivalentDurationTrAlpha
																		.calculateEquivalentDurationWithIsAndPr(
																				ImpulseIralpha
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
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt));

		System.out
				.println("Plastic Parameter - Max Ductility Ratio 'Xm/Xe'  = "
						+ EquivalentSDOFPlasticResponseUm.peakResponseParameterPlastic(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt));

		System.out
				.println("***Plastic Check*** -  = "
						+ EquivalentSDOFPlasticResponseUm.plasticCheckFinal(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt)
						+ ". Max Ductility Ratio Xm/Xe = "
						+ EquivalentSDOFPlasticResponseUm.peakResponseParameterPlastic(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt));

		System.out
				.println("End Rotation of Column (Degrees)  = "
						+ EquivalentSDOFPlasticResponseUm.equivalentElastDeflection(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
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
												.findPeakIncidentOverPressureWith(z)),
								colwidth, colhgt, ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt)) + " degrees");

		System.out.println("Max Shear with Column Removed = "
				+ beamDesignForces.maxBeamShear(spanlhs, spanrhs, trib, dead,
						live, roofdead, rooflive, daf, numstorys, deadcombo,
						livecombo) + " Kips");

		System.out.println("Max Bending Moment with Column Removed = "
				+ beamDesignForces.maxBeamMoment(spanlhs, spanrhs, trib, dead,
						live, roofdead, rooflive, daf, numstorys, deadcombo,
						livecombo) + " Kip-ft");

		System.out.println(beamChecks.localBucklingCheck(bf, tf));

		System.out.println(beamChecks.localshearCheck(beamaxial, beamarea,
				yield, bf, tf));

		System.out.println(beamChecks.shearcheck(yield, tf, tw, depth,
				beamDesignForces.maxBeamShear(spanlhs, spanrhs, trib, dead,
						live, roofdead, rooflive, daf, numstorys, deadcombo,
						livecombo)));

		System.out.println("Ultimate Axial Compressive Load "
				+ beamChecks.flexuralCheck(beamzx, beamlx, beamly, yield,
						beamrx, beamry, e, beamarea) + " Kips");

		System.out.println("Factor for determining Mmx with Mpx"
				+ beamChecks.momentMmxFactor(beamzx, beamlx, beamly, yield,
						beamrx, beamry, e, beamarea));

		System.out.println(beamChecks.momentMmxCheck(beamzx, beamlx, beamly,
				yield, beamrx, beamry, e, beamarea));

		System.out.println("Ultimate Axial Compressive Load "
				+ beamChecks.eulerBucklingStresses(e, beamlx, beamrx) + " Ksi");

		System.out.println("Euler Buckling Load about X-Axis "
				+ beamChecks.eulerBucklingLoads(e, beamlx, beamrx, beamarea)
				+ " Kips");

		System.out.println("Ultimate Capacity for Dynamic Axial Load "
				+ beamChecks.ultCapacityForDynAxialLoadPp(yield, beamarea)
				+ " Kips");

		System.out.println("Combined Check One "
				+ beamChecks.combinedChcekOne(beamzx, beamlx, beamly, yield,
						beamrx, beamry, e, beamarea, beamaxial,
						beamDesignForces.maxBeamMoment(spanlhs, spanrhs, trib,
								dead, live, roofdead, rooflive, daf, numstorys,
								deadcombo, livecombo)));

		System.out.println("Combined Check Two "
				+ beamChecks.combinedChcekTwo(beamzx, beamlx, beamly, yield,
						beamrx, beamry, e, beamarea, beamaxial,
						beamDesignForces.maxBeamMoment(spanlhs, spanrhs, trib,
								dead, live, roofdead, rooflive, daf, numstorys,
								deadcombo, livecombo)));

		System.out.println(beamChecks.combinedChcekOnePassOrFail(beamzx,
				beamlx, beamly, yield, beamrx, beamry, e, beamarea, beamaxial,
				beamDesignForces.maxBeamMoment(spanlhs, spanrhs, trib, dead,
						live, roofdead, rooflive, daf, numstorys, deadcombo,
						livecombo)));

		System.out.println(SapTextFile.sapFile(numstorys, bays, colhgt, width,
				live, dead, trib));

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
