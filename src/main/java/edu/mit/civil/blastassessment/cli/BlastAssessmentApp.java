/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.IOException;

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
import edu.mit.civil.memberdesign.calculation.windForces;
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
		 * Frame Title
		 */
		String heading = "TrialA_FIXER";
		/**
		 * Frame Geometry
		 */
		int numberOfStorys = dataStorage.numbStorys();
		double numberOfBays = dataStorage.numbBays();
		double bayWidth = dataStorage.bayWidth();
		double floorHeight = dataStorage.floorHeight();
		double tributaryWidth = dataStorage.tribWidth();
		/**
		 * Gravity Loads
		 */
		double deadLoad = dataStorage.deadLoad();
		double liveLoad = dataStorage.liveLoad();
		/**
		 * Steel Properties
		 */
		double youngsMod = dataStorage.steelE();
		double yieldStrength = dataStorage.steelYield();
		/**
		 * Factors
		 */
		double ductilityLimit = dataStorage.ductilityLimit();
		double dynamicAmpFactor = dataStorage.dynamicAmpFactor();
		double kFactor = dataStorage.kFactor();
		double compressionFactor = dataStorage.compressionFactor();
		double columnFactorOfSafety = dataStorage.columnSafetyFactor();
		double beamFactorOfSafety = dataStorage.beamSafetyFactor();
		/**
		 * Blast Criteria
		 */
		double weightTNT = dataStorage.weightTNT();
		double blastFactor = dataStorage.blastFactor();
		double standoffDist = dataStorage.standoffDist();
		int blastAngle = dataStorage.blastAngle();
		int targetColumn = dataStorage.targetColumn();
		/**
		 * Retrieving Column Details for Blast Analysis
		 */
		double columnIxx = retrievingColumnSections.Ixx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety);
		double columnSx = retrievingColumnSections.Sx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, numberOfStorys, floorHeight, kFactor,
				yieldStrength, compressionFactor, numberOfBays, targetColumn,
				columnFactorOfSafety);
		double columnZx = retrievingColumnSections.Zx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, numberOfStorys, floorHeight, kFactor,
				yieldStrength, compressionFactor, numberOfBays, targetColumn,
				columnFactorOfSafety);
		double columnLinearWeight = retrievingColumnSections.Wgt(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety);
		double columnFlangeWidth = retrievingColumnSections.Bf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety);
		/**
		 * Progressive Collapse Load Factors
		 */
		double deadLoadFactorPC = dataStorage.dlCombPC();
		double liveLoadFactorPC = dataStorage.llCombPC();
		/**
		 * Beam Details for Column Removed Check
		 */
		double beamaxial = windForces.beamAxialForce(floorHeight,
				numberOfStorys, tributaryWidth);
		double beamLengthColumnRemoved = bayWidth * 2;
		double beamFlangeWidth = retrievingBeamSections.bf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamFlangeThickness = retrievingBeamSections.tf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamWebThickness = retrievingBeamSections.tw(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamDepth = retrievingBeamSections.d(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamArea = retrievingBeamSections.a(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamZx = retrievingBeamSections.zx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamRx = retrievingBeamSections.rx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamRy = retrievingBeamSections.ry(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety);
		double beamLy = dataStorage.beamLy();
		/**
		 * Building Dimensions
		 */
		double buildingWidth = numberOfBays * bayWidth;
		double buildingHeight = numberOfStorys * floorHeight;
		/**
		 * Scaled Distance Z
		 */
		double z = (double) ((standoffDist) / Math.pow(weightTNT * blastFactor,
				0.33333));

		System.out.println("FRAME DESIGN:");

		System.out.println("Beam Size = "
				+ beamDesign.sectionDesign(bayWidth, tributaryWidth, deadLoad,
						liveLoad, 50, beamaxial, beamFactorOfSafety));

		System.out.println("Internal Column Size = "
				+ internalColumnForcesAndDesign.columnSizing(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, 50, compressionFactor,
						numberOfBays, columnFactorOfSafety));

		System.out.println("External Column Size = "
				+ externalColumnForcesandDesign.columnSizing(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, 50, compressionFactor,
						numberOfBays, columnFactorOfSafety));

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
				+ ClearingTimeTc.calculateclearingTimeTc(buildingWidth,
						buildingHeight, SoundVelocityCr
								.caculateCrWithPso(PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)))
				+ " ms");

		System.out.println("Blast Analysis - Positive Phase Duration 'to' = "
				+ PositivePhaseDurationTo.findPositivePhaseDurationForZ(z,
						weightTNT) + " ms");

		System.out.println("Blast Analysis - Wave Length 'Lw' = "
				+ WaveLengthLw.findWaveLengthWithZ(z, weightTNT) + " ft");

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
						+ ReflectedPressurePr.findReflectedPressureWith(
								blastAngle, PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z))
						+ " psi");

		System.out
				.println("Blast Analysis - Blast Analysis - Impulse 'Ir(alpha)' = "
						+ ImpulseIralpha.calculateImpulseIsUFCGraph(
								PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z),
								blastAngle, weightTNT) + " psi-ms");

		System.out
				.println("Blast Analysis - Equivalent Duration 'tr(alpha)' = "
						+ EquivalentDurationTrAlpha.calculateEquivalentDurationWithIsAndPr(
								ImpulseIralpha.calculateImpulseIsUFCGraph(
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z),
										blastAngle, weightTNT),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
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
												blastAngle,
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidth, floorHeight) + " kipf");

		System.out
				.println("Target Column Analysis - Actual Column Stiffness 'k' = "
						+ ActualStiffnessK.calculateColumnActualStiffness(
								youngsMod, columnIxx, floorHeight)
						+ " kipf.ft^-1");

		System.out.println("Target Column Analysis - Total Actual Mass 'm' = "
				+ TotalActalMassM.calculatingTotalActualMass(
						columnLinearWeight, floorHeight) + " kipf.s^2.ft^-1");

		System.out
				.println("Target Column Analysis - Static Displacement 'us' = "
						+ StaticDisplacementUs.CalculateStaticDisplacement(
								AppliedLoadingToColumnQ.calculateAppliedLoading(
										ReflectedPressurePr
												.findReflectedPressureWith(
														blastAngle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z)),
										columnFlangeWidth, floorHeight),
								ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight)) + " ft");

		System.out
				.println("Target Column Analysis - Yield Displacement 'uy' = "
						+ YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSx, yieldStrength,
								youngsMod, columnIxx) + " ft");

		System.out.println();

		System.out.println("COLUMN - ELASTIC ASSESSMENT:");

		System.out
				.println("Elastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF 'ke' = "
						+ EquivalentSDOFPropertiesElastic
								.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight)) + " kipf.ft^-1");

		System.out
				.println("Elastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF 'me' = "
						+ EquivalentSDOFPropertiesElastic.massOfEquivSDOF(TotalActalMassM
								.calculatingTotalActualMass(columnLinearWeight,
										floorHeight)) + " kipf.s^2.ft^-1");

		System.out
				.println("Elastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF 'Tn' = "
						+ EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesElastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														columnLinearWeight,
														floorHeight)),
								EquivalentSDOFPropertiesElastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight))) + " s");

		System.out
				.println("Target Column Analysis - T/Tn used for UFC 3-340 graphs to determnine whether column remains elastic = "
						+ ParameterForElasticCheck.tEquivDividedByTn(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																blastAngle,
																weightTNT),
												ReflectedPressurePr
														.findReflectedPressureWith(
																blastAngle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesElastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																columnLinearWeight,
																floorHeight)),
										EquivalentSDOFPropertiesElastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight)))));

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
																				blastAngle,
																				weightTNT),
																ReflectedPressurePr
																		.findReflectedPressureWith(
																				blastAngle,
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z))),
												EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
														EquivalentSDOFPropertiesElastic
																.massOfEquivSDOF(TotalActalMassM
																		.calculatingTotalActualMass(
																				columnLinearWeight,
																				floorHeight)),
														EquivalentSDOFPropertiesElastic
																.stiffnessOfEquivSDOF(ActualStiffnessK
																		.calculateColumnActualStiffness(
																				youngsMod,
																				columnIxx,
																				floorHeight))))),
								StaticDisplacementUs.CalculateStaticDisplacement(
										AppliedLoadingToColumnQ
												.calculateAppliedLoading(
														ReflectedPressurePr
																.findReflectedPressureWith(
																		blastAngle,
																		PeakIncidentOverPressurePso
																				.findPeakIncidentOverPressureWith(z)),
														columnFlangeWidth,
														floorHeight),
										ActualStiffnessK
												.calculateColumnActualStiffness(
														youngsMod, columnIxx,
														floorHeight))) + " ft");

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
								EquivalentSDOFElasticResponseUm.elasticResponseParameterCheck(
										(ParameterForElasticCheck
												.tEquivDividedByTn(
														EquivalentDurationTrAlpha
																.calculateEquivalentDurationWithIsAndPr(
																		ImpulseIralpha
																				.calculateImpulseIsUFCGraph(
																						PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z),
																						blastAngle,
																						weightTNT),
																		ReflectedPressurePr
																				.findReflectedPressureWith(
																						blastAngle,
																						PeakIncidentOverPressurePso
																								.findPeakIncidentOverPressureWith(z))),
														EquivalentSDOFPropertiesElastic
																.naturalPeriodSDOF(
																		EquivalentSDOFPropertiesElastic
																				.massOfEquivSDOF(TotalActalMassM
																						.calculatingTotalActualMass(
																								columnLinearWeight,
																								floorHeight)),
																		EquivalentSDOFPropertiesElastic
																				.stiffnessOfEquivSDOF(ActualStiffnessK
																						.calculateColumnActualStiffness(
																								youngsMod,
																								columnIxx,
																								floorHeight))))),
										StaticDisplacementUs.CalculateStaticDisplacement(
												AppliedLoadingToColumnQ
														.calculateAppliedLoading(
																ReflectedPressurePr
																		.findReflectedPressureWith(
																				blastAngle,
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z)),
																columnFlangeWidth,
																floorHeight),
												ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight))),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(
												floorHeight, columnSx,
												yieldStrength, youngsMod,
												columnIxx)));

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
																				blastAngle,
																				weightTNT),
																ReflectedPressurePr
																		.findReflectedPressureWith(
																				blastAngle,
																				PeakIncidentOverPressurePso
																						.findPeakIncidentOverPressureWith(z))),
												EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
														EquivalentSDOFPropertiesElastic
																.massOfEquivSDOF(TotalActalMassM
																		.calculatingTotalActualMass(
																				columnLinearWeight,
																				floorHeight)),
														EquivalentSDOFPropertiesElastic
																.stiffnessOfEquivSDOF(ActualStiffnessK
																		.calculateColumnActualStiffness(
																				youngsMod,
																				columnIxx,
																				floorHeight))))),
								StaticDisplacementUs.CalculateStaticDisplacement(
										AppliedLoadingToColumnQ
												.calculateAppliedLoading(
														ReflectedPressurePr
																.findReflectedPressureWith(
																		blastAngle,
																		PeakIncidentOverPressurePso
																				.findPeakIncidentOverPressureWith(z)),
														columnFlangeWidth,
														floorHeight),
										ActualStiffnessK
												.calculateColumnActualStiffness(
														youngsMod, columnIxx,
														floorHeight))),
						YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSx, yieldStrength,
								youngsMod, columnIxx)));

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF (k'e) = "
						+ EquivalentSDOFPropertiesPlastic
								.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight)) + " kipf.ft^-1");

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF (m'e) = "
						+ EquivalentSDOFPropertiesPlastic.massOfEquivSDOF(TotalActalMassM
								.calculatingTotalActualMass(columnLinearWeight,
										floorHeight)) + " kipf.s^2.ft^-1");

		System.out
				.println("Plastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF (T'n) = "
						+ EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesPlastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														columnLinearWeight,
														floorHeight)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight))) + " s");

		System.out.println("Plastic Parameter - Ultimate Resistance = "
				+ UltimateUnitResistance.calculatingPlasticMoment(
						yieldStrength, columnZx, floorHeight) + " kipf.ft^-1");

		System.out
				.println("Plastic Parameter - T/T'n = "
						+ EquivalentSDOFPlasticResponseUm.maxDeflectionPlasticInputsTeDivideTn(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																blastAngle,
																weightTNT),
												ReflectedPressurePr
														.findReflectedPressureWith(
																blastAngle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																columnLinearWeight,
																floorHeight)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight)))));

		System.out
				.println("Plastic Parameter - Ultimate Resistance ru / Peak Reflected Pressure = "
						+ EquivalentSDOFPlasticResponseUm.maxDeflectionPlasticInputsRuDivideP(
								UltimateUnitResistance
										.calculatingPlasticMoment(
												yieldStrength, columnZx,
												floorHeight),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidth, floorHeight));

		System.out
				.println("Plastic Parameter - Max Ductility Ratio 'Xm/Xe'  = "
						+ EquivalentSDOFPlasticResponseUm.peakResponseParameterPlastic(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																blastAngle,
																weightTNT),
												ReflectedPressurePr
														.findReflectedPressureWith(
																blastAngle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																columnLinearWeight,
																floorHeight)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight))),
								UltimateUnitResistance
										.calculatingPlasticMoment(
												yieldStrength, columnZx,
												floorHeight),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(
												floorHeight, columnSx,
												yieldStrength, youngsMod,
												columnIxx),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidth, floorHeight));

		System.out
				.println("End Rotation of Column (Degrees)  = "
						+ EquivalentSDOFPlasticResponseUm.equivalentElastDeflection(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																blastAngle,
																weightTNT),
												ReflectedPressurePr
														.findReflectedPressureWith(
																blastAngle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																columnLinearWeight,
																floorHeight)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight))),
								UltimateUnitResistance
										.calculatingPlasticMoment(
												yieldStrength, columnZx,
												floorHeight),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(
												floorHeight, columnSx,
												yieldStrength, youngsMod,
												columnIxx),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidth, floorHeight,
								ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight)) + " degrees");

		double ductilityRatio = EquivalentSDOFPlasticResponseUm
				.peakResponseParameterPlastic(
						EquivalentDurationTrAlpha
								.calculateEquivalentDurationWithIsAndPr(
										ImpulseIralpha.calculateImpulseIsUFCGraph(
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z),
												blastAngle, weightTNT),
										ReflectedPressurePr
												.findReflectedPressureWith(
														blastAngle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z))),
						EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesPlastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														columnLinearWeight,
														floorHeight)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxx,
												floorHeight))),
						UltimateUnitResistance.calculatingPlasticMoment(
								yieldStrength, columnZx, floorHeight),
						YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSx, yieldStrength,
								youngsMod, columnIxx),
						ReflectedPressurePr.findReflectedPressureWith(
								blastAngle, PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)),
						columnFlangeWidth, floorHeight);

		System.out
				.println("|Plastic Check| -  = "
						+ EquivalentSDOFPlasticResponseUm.plasticCheckFinal(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																blastAngle,
																weightTNT),
												ReflectedPressurePr
														.findReflectedPressureWith(
																blastAngle,
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z))),
								EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
										EquivalentSDOFPropertiesPlastic
												.massOfEquivSDOF(TotalActalMassM
														.calculatingTotalActualMass(
																columnLinearWeight,
																floorHeight)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxx,
																floorHeight))),
								UltimateUnitResistance
										.calculatingPlasticMoment(
												yieldStrength, columnZx,
												floorHeight),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(
												floorHeight, columnSx,
												yieldStrength, youngsMod,
												columnIxx),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidth, floorHeight, ductilityLimit)
						+ ". Max Ductility Ratio Xm/Xe = " + ductilityRatio
						+ " Allowable Ductility Ratio Specified by User = "
						+ ductilityLimit);

		if (ductilityRatio > ductilityLimit) {

			System.out.println();

			System.out.println(SapTextFile
					.sapFile(bayWidth, tributaryWidth, deadLoad, liveLoad,
							numberOfStorys, numberOfBays, floorHeight, heading,
							targetColumn, deadLoadFactorPC, liveLoadFactorPC,
							50, beamaxial, kFactor, compressionFactor,
							columnFactorOfSafety, beamFactorOfSafety));

			System.out.println();

			System.out.println("BEAM CHECK - COLUMN REMOVED:");

			System.out.println("Max Shear with Column Removed = "
					+ beamDesignForces.maxBeamShear(bayWidth, tributaryWidth,
							deadLoad, liveLoad, dynamicAmpFactor,
							numberOfStorys, deadLoadFactorPC, liveLoadFactorPC)
					+ " Kips");

			System.out.println("Max Bending Moment with Column Removed = "
					+ beamDesignForces.maxBeamMoment(bayWidth, tributaryWidth,
							deadLoad, liveLoad, dynamicAmpFactor,
							numberOfStorys, deadLoadFactorPC, liveLoadFactorPC)
					+ " Kip-ft");

			System.out.println(beamChecks.localBucklingCheck(beamFlangeWidth,
					beamFlangeThickness));

			System.out.println(beamChecks.localshearCheck(beamaxial, beamArea,
					yieldStrength, beamFlangeWidth, beamFlangeThickness));

			System.out
					.println(beamChecks.shearcheck(yieldStrength,
							beamFlangeThickness, beamWebThickness, beamDepth,
							beamDesignForces.maxBeamShear(bayWidth,
									tributaryWidth, deadLoad, liveLoad,
									dynamicAmpFactor, numberOfStorys,
									deadLoadFactorPC, liveLoadFactorPC)));

			System.out.println("Ultimate Axial Compressive Load "
					+ beamChecks.flexuralCheck(beamZx, beamLengthColumnRemoved,
							beamLy, yieldStrength, beamRx, beamRy, youngsMod,
							beamArea) + " Kips");

			System.out.println("Factor for determining Mmx with Mpx"
					+ beamChecks.momentMmxFactor(beamZx,
							beamLengthColumnRemoved, beamLy, yieldStrength,
							beamRx, beamRy, youngsMod, beamArea));

			System.out.println(beamChecks.momentMmxCheck(beamZx,
					beamLengthColumnRemoved, beamLy, yieldStrength, beamRx,
					beamRy, youngsMod, beamArea));

			System.out.println("Ultimate Axial Compressive Load "
					+ beamChecks.eulerBucklingStresses(youngsMod,
							beamLengthColumnRemoved, beamRx) + " Ksi");

			System.out.println("Euler Buckling Load about X-Axis "
					+ beamChecks.eulerBucklingLoads(youngsMod,
							beamLengthColumnRemoved, beamRx, beamArea)
					+ " Kips");

			System.out.println("Ultimate Capacity for Dynamic Axial Load "
					+ beamChecks.ultCapacityForDynAxialLoadPp(yieldStrength,
							beamArea) + " Kips");

			System.out.println("Combined Check One "
					+ beamChecks.combinedChcekOne(beamZx,
							beamLengthColumnRemoved, beamLy, yieldStrength,
							beamRx, beamRy, youngsMod, beamArea, beamaxial,
							beamDesignForces.maxBeamMoment(bayWidth,
									tributaryWidth, deadLoad, liveLoad,
									dynamicAmpFactor, numberOfStorys,
									deadLoadFactorPC, liveLoadFactorPC)));

			System.out.println("Combined Check Two "
					+ beamChecks.combinedChcekTwo(beamZx,
							beamLengthColumnRemoved, beamLy, yieldStrength,
							beamRx, beamRy, youngsMod, beamArea, beamaxial,
							beamDesignForces.maxBeamMoment(bayWidth,
									tributaryWidth, deadLoad, liveLoad,
									dynamicAmpFactor, numberOfStorys,
									deadLoadFactorPC, liveLoadFactorPC)));

			System.out.println(beamChecks.combinedChcekOnePassOrFail(beamZx,
					beamLengthColumnRemoved, beamLy, yieldStrength, beamRx,
					beamRy, youngsMod, beamArea, beamaxial, beamDesignForces
							.maxBeamMoment(bayWidth, tributaryWidth, deadLoad,
									liveLoad, dynamicAmpFactor, numberOfStorys,
									deadLoadFactorPC, liveLoadFactorPC)));

		} else if (ductilityRatio <= ductilityLimit) {

			System.exit(0);
		}

	}
}

// /**
// *
// * @param label
// * @return
// * @throws IOException
// */
// private static double collectInputWithLabel(String label)
// throws IOException {
// System.out.println(label);
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// double input = Double.parseDouble(br.readLine());
// // br.close();
// return input;
// }

