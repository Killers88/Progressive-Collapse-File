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
import edu.mit.civil.blastassessment.calculation.EquivalentDurationTrAlpha;
import edu.mit.civil.blastassessment.calculation.ImpulseIralpha;
import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;
import edu.mit.civil.blastassessment.calculation.PositivePhaseDurationTo;
import edu.mit.civil.blastassessment.calculation.ReflectedPressurePr;
import edu.mit.civil.blastassessment.calculation.SoundVelocityCr;
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
import edu.mit.civil.memberdesign.calculation.beamDesign;
import edu.mit.civil.memberdesign.calculation.externalColumnForcesandDesign;
import edu.mit.civil.memberdesign.calculation.internalColumnForcesAndDesign;
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

		/**
		 * INPUT CRITERIA FROM SPREADSHEET
		 */
		String heading = "TrialA_FIXER";

		int targetcol = 3; // Target Column - From LHS of building

		// double w = dataStorage.structure(w);

		double w = 2000;

		double blastfact = 1.0;

		double r = 30;

		int angle = 20;

		double h = 72;

		double width = 130;

		double e = 29000;

		double yield = 50;

		double i = 795;

		double s = 112;

		double zxx = 126;

		double colweight = 74.0;

		double colwidth = 10.1;

		double colhgt = 12;

		int numstorys = 12;

		double bays = 5;

		double span = 25;

		double trib = 20;

		double dead = 120;

		double live = 90;

		double deadcombo = 1.1;

		double livecombo = 0.25;

		double beamaxial = 10;

		double bf = 12;

		double depth = 12.3;

		double tf = 0.67;

		double tw = 0.43;

		double beamarea = 21.1;

		double beamzx = 108;

		double beamrx = 5.31;

		double beamry = 3.04;

		double beamlx = 25;

		double beamly = 5;

		double daf = 2;

		double mu = 1;

		double k = 1;

		double factCOMP = 1.7;

		double z = (double) ((r) / Math.pow(w * blastfact, 0.33333));

		// double colnumber = retrievingSections.findColumn(span, trib, dead,
		// live, numstorys, colhgt, k, 50, factCOMP, bays).doubleValue();
		//
		// if (colnumber < 12) {
		// double colwidth = 8.03;
		// double colweight = 48.0;
		// double i = 484;
		// double s = 70.2;
		// double zxx = 78.4;
		// }

		System.out.println("FRAME DESIGN:");

		System.out.println("Beam Size = "
				+ beamDesign.sectionDesign(span, trib, dead, live, 50,
						beamaxial));

		System.out.println("Internal Column Size = "
				+ internalColumnForcesAndDesign.columnSizing(span, trib, dead,
						live, numstorys, colhgt, k, 50, factCOMP, bays));

		System.out.println("External Column Size = "
				+ externalColumnForcesandDesign.columnSizing(span, trib, dead,
						live, numstorys, colhgt, k, 50, factCOMP, bays));

		// System.out.println(extefficiencyColumnForcesandDesign.columnSizing(
		// span, trib, dead, live, numstorys, colhgt, k, 50, factCOMP,
		// bays));

		System.out.println("");

		System.out.println("BLAST ANALYSIS:");

		System.out.println("Blast Analysis - Scaled Distance 'Z' " + z);

		System.out.println("Blast Analysis - Over Pressure 'Pso' = "
				+ PeakIncidentOverPressurePso
						.findPeakIncidentOverPressureWith(z) + " psi");

		// System.out.println("Blast Analysis - Peak Dynamic Pressure 'qo' = "
		// + PeakDynamicPressureQo
		// .calculatQoWithPso(PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)) + " psi");
		//
		// System.out.println("Blast Analysis - Sound Velocity 'Cr' = "
		// + SoundVelocityCr.caculateCrWithPso(PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)) + " psi");

		// System.out.println("Blast Analysis - Impulse 'is' = "
		// + ImpulseIs.findPeakImpulseIsWith(z, w) + " ms");

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

		// System.out.println("Blast Analysis - Stagnation Pressure 'Ps' = "
		// + StagnationPressurePs.calculateStagnationPressureWithPsoandqo(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// PeakDynamicPressureQo
		// .calculatQoWithPso(PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)))
		// + " psi");
		//
		// System.out.println("Blast Analysis - Equivalent Duration 'te' = "
		// + EquivalentDurationTe.calculateEquivalentDurationWithIsAndPso(
		// ImpulseIs.findPeakImpulseIsWith(z, w),
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)) + " ms");

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

		System.out.println();

		System.out.println("COLUMN LOADING & CAPACITIES:");

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

		System.out.println();

		System.out.println("COLUMN - ELASTIC ASSESSMENT:");

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
				.println("|Elastic Check| - "
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

		System.out.println();

		System.out
				.println(EquivalentSDOFElasticCheck.programFinish(
						EquivalentSDOFElasticResponseUm.elasticResponseParameterCheck(
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
														e, i, colhgt))),
						YieldDisplacementUy.calculateYieldDisplacementUy(
								colhgt, s, yield, e, i)));

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

		double ductilityRatio = EquivalentSDOFPlasticResponseUm
				.peakResponseParameterPlastic(
						EquivalentDurationTrAlpha
								.calculateEquivalentDurationWithIsAndPr(
										ImpulseIralpha.calculateImpulseIsUFCGraph(
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
														colweight, colhgt)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(e, i,
												colhgt))),
						UltimateUnitResistance.calculatingPlasticMoment(yield,
								zxx, colhgt), YieldDisplacementUy
								.calculateYieldDisplacementUy(colhgt, s, yield,
										e, i),
						ReflectedPressurePr.findReflectedPressureWith(angle,
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)),
						colwidth, colhgt);

		System.out
				.println("|Plastic Check| -  = "
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
								colwidth, colhgt, mu)
						+ ". Max Ductility Ratio Xm/Xe = " + ductilityRatio
						+ " Allowable Ductility Ratio Specified by User = "
						+ mu);

		if (ductilityRatio > mu) {

			System.out.println();

			System.out.println(SapTextFile.sapFile(span, trib, dead, live,
					numstorys, bays, colhgt, heading, targetcol, deadcombo,
					livecombo, 50, beamaxial, k, factCOMP));

			System.out.println();

			System.out.println("BEAM CHECK - COLUMN REMOVED:");

			System.out.println("Max Shear with Column Removed = "
					+ beamDesignForces.maxBeamShear(span, trib, dead, live,
							daf, numstorys, deadcombo, livecombo) + " Kips");

			System.out.println("Max Bending Moment with Column Removed = "
					+ beamDesignForces.maxBeamMoment(span, trib, dead, live,
							daf, numstorys, deadcombo, livecombo) + " Kip-ft");

			System.out.println(beamChecks.localBucklingCheck(bf, tf));

			System.out.println(beamChecks.localshearCheck(beamaxial, beamarea,
					yield, bf, tf));

			System.out.println(beamChecks.shearcheck(yield, tf, tw, depth,
					beamDesignForces.maxBeamShear(span, trib, dead, live, daf,
							numstorys, deadcombo, livecombo)));

			System.out.println("Ultimate Axial Compressive Load "
					+ beamChecks.flexuralCheck(beamzx, beamlx, beamly, yield,
							beamrx, beamry, e, beamarea) + " Kips");

			System.out.println("Factor for determining Mmx with Mpx"
					+ beamChecks.momentMmxFactor(beamzx, beamlx, beamly, yield,
							beamrx, beamry, e, beamarea));

			System.out.println(beamChecks.momentMmxCheck(beamzx, beamlx,
					beamly, yield, beamrx, beamry, e, beamarea));

			System.out.println("Ultimate Axial Compressive Load "
					+ beamChecks.eulerBucklingStresses(e, beamlx, beamrx)
					+ " Ksi");

			System.out.println("Euler Buckling Load about X-Axis "
					+ beamChecks
							.eulerBucklingLoads(e, beamlx, beamrx, beamarea)
					+ " Kips");

			System.out.println("Ultimate Capacity for Dynamic Axial Load "
					+ beamChecks.ultCapacityForDynAxialLoadPp(yield, beamarea)
					+ " Kips");

			System.out.println("Combined Check One "
					+ beamChecks
							.combinedChcekOne(beamzx, beamlx, beamly, yield,
									beamrx, beamry, e, beamarea, beamaxial,
									beamDesignForces.maxBeamMoment(span, trib,
											dead, live, daf, numstorys,
											deadcombo, livecombo)));

			System.out.println("Combined Check Two "
					+ beamChecks
							.combinedChcekTwo(beamzx, beamlx, beamly, yield,
									beamrx, beamry, e, beamarea, beamaxial,
									beamDesignForces.maxBeamMoment(span, trib,
											dead, live, daf, numstorys,
											deadcombo, livecombo)));

			System.out.println(beamChecks.combinedChcekOnePassOrFail(beamzx,
					beamlx, beamly, yield, beamrx, beamry, e, beamarea,
					beamaxial, beamDesignForces.maxBeamMoment(span, trib, dead,
							live, daf, numstorys, deadcombo, livecombo)));

		} else if (ductilityRatio <= mu) {

			System.exit(0);
		}

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
