/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.IOException;

import edu.mit.civil.beamassessment.calculation.beamChecks;
import edu.mit.civil.beamassessment.calculation.beamDesignForces;
import edu.mit.civil.blastassessment.calculation.EquivalentDurationTrAlpha;
import edu.mit.civil.blastassessment.calculation.ImpulseIralpha;
import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;
import edu.mit.civil.blastassessment.calculation.ReflectedPressurePr;
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
import edu.mit.civil.memberdesign.calculation.externalColumnForcesandDesignA;
import edu.mit.civil.memberdesign.calculation.internalColumnForcesAndDesignA;
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

		// /**
		// * SYSTEM EXIT - TEMPORARY
		// */
		// Dada.Varying_Weight.scenario();
		// System.exit(0);

		/**
		 * Frame Title
		 */
		String heading = dataStorage.heading();
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
		 * Wind Region
		 */
		double windspeed = dataStorage.windspeed();
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
		double windDisplacementFactor = dataStorage.windDisplacementFactor();
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
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnSx = retrievingColumnSections.Sx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, numberOfStorys, floorHeight, kFactor,
				yieldStrength, compressionFactor, numberOfBays, targetColumn,
				columnFactorOfSafety, windspeed);
		double columnZx = retrievingColumnSections.Zx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, numberOfStorys, floorHeight, kFactor,
				yieldStrength, compressionFactor, numberOfBays, targetColumn,
				columnFactorOfSafety, windspeed);
		double columnLinearWeight = retrievingColumnSections.Wgt(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnFlangeWidth = retrievingColumnSections.Bf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		/**
		 * Progressive Collapse Load Factors
		 */
		double deadLoadFactorPC = dataStorage.dlCombPC();
		double liveLoadFactorPC = dataStorage.llCombPC();
		double noOfFloorsBeamSupports = dataStorage.noOfFloorsBeamSupports();
		/**
		 * Beam Details for Column Removed Check
		 */
		double beamaxial = windForces.beamAxialForce(floorHeight,
				numberOfStorys, tributaryWidth, windspeed);
		double beamLengthColumnRemoved = bayWidth * 2;
		double beamFlangeWidth = retrievingBeamSections.bf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamFlangeThickness = retrievingBeamSections.tf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamWebThickness = retrievingBeamSections.tw(bayWidth,
				tributaryWidth, deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamDepth = retrievingBeamSections.d(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamArea = retrievingBeamSections.a(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamZx = retrievingBeamSections.zx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamRx = retrievingBeamSections.rx(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
		double beamRy = retrievingBeamSections.ry(bayWidth, tributaryWidth,
				deadLoad, liveLoad, yieldStrength, beamaxial,
				beamFactorOfSafety, floorHeight, numberOfStorys, numberOfBays,
				windspeed);
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

		// /**
		// * SYSTEM EXIT - TEMPORARY
		// */
		// Dada.Varying_Weight.scenario();
		// System.exit(0);

		System.out.println();

		System.out.println("PROJECT TITLE: " + heading);

		System.out.println();

		System.out.println("DESIGN WIND PRESSURE:");

		System.out.println("Average wind pressure = "
				+ windForces.designWindPressure(floorHeight, numberOfStorys,
						tributaryWidth, windspeed) + " psf");

		System.out.println();

		System.out.println("FRAME DESIGN:");

		System.out.println("Beam Size = "
				+ beamDesign.sectionDesign(bayWidth, tributaryWidth, deadLoad,
						liveLoad, 50, beamaxial, beamFactorOfSafety,
						floorHeight, numberOfStorys, numberOfBays, windspeed));

		System.out.println("Internal Column Size = "
				+ internalColumnForcesAndDesignA.columnSizing(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, 50, compressionFactor,
						numberOfBays, columnFactorOfSafety, windspeed));

		System.out.println("External Column Size = "
				+ externalColumnForcesandDesignA.columnSizing(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, 50, compressionFactor,
						numberOfBays, columnFactorOfSafety, windspeed));

		double columnIxxInt = retrievingColumnSections.Ixx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, 2, columnFactorOfSafety, windspeed);
		double columnIxxExt = retrievingColumnSections.Ixx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, 1, columnFactorOfSafety, windspeed);

		// System.out.println("Lateral Peak Displacement = "
		// + windForces.roofDisplacement(floorHeight, numberOfStorys,
		// tributaryWidth, windspeed, youngsMod, columnIxxInt,
		// columnIxxExt, numberOfBays, windDisplacementFactor)
		// + " in");

		System.out.println(SapTextFile.sapFile(bayWidth, tributaryWidth,
				deadLoad, liveLoad, numberOfStorys, numberOfBays, floorHeight,
				heading, targetColumn, deadLoadFactorPC, liveLoadFactorPC,
				yieldStrength, beamaxial, kFactor, compressionFactor,
				columnFactorOfSafety, beamFactorOfSafety, windspeed));

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

		// // System.out.println("Blast Analysis - Clearing Time 'tc' = "
		// // + ClearingTimeTc.calculateclearingTimeTc(buildingWidth,
		// // buildingHeight, SoundVelocityCr
		// // .caculateCrWithPso(PeakIncidentOverPressurePso
		// // .findPeakIncidentOverPressureWith(z)))
		// // + " ms");
		// //
		// //
		// System.out.println("Blast Analysis - Positive Phase Duration 'to' = "
		// // + PositivePhaseDurationTo.findPositivePhaseDurationForZ(z,
		// // weightTNT) + " ms");
		// //
		// // System.out.println("Blast Analysis - Wave Length 'Lw' = "
		// // + WaveLengthLw.findWaveLengthWithZ(z, weightTNT) + " ft");
		//
		// // System.out.println("Blast Analysis - Stagnation Pressure 'Ps' = "
		// // + StagnationPressurePs.calculateStagnationPressureWithPsoandqo(
		// // PeakIncidentOverPressurePso
		// // .findPeakIncidentOverPressureWith(z),
		// // PeakDynamicPressureQo
		// // .calculatQoWithPso(PeakIncidentOverPressurePso
		// // .findPeakIncidentOverPressureWith(z)))
		// // + " psi");
		// //
		// // System.out.println("Blast Analysis - Equivalent Duration 'te' = "
		// // + EquivalentDurationTe.calculateEquivalentDurationWithIsAndPso(
		// // ImpulseIs.findPeakImpulseIsWith(z, w),
		// // PeakIncidentOverPressurePso
		// // .findPeakIncidentOverPressureWith(z)) + " ms");

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

		System.out.println("Pin Pin:");

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
												floorHeight)) + " in");

		System.out
				.println("Target Column Analysis - Yield Displacement 'uy' = "
						+ YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSx, yieldStrength,
								youngsMod, columnIxx) + " in");

		System.out.println("Fixed - Fixed:");

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
						+ ActualStiffnessK.stiffnessFIX(youngsMod, columnIxx,
								floorHeight) + " kipf.ft^-1");

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
								ActualStiffnessK.stiffnessFIX(youngsMod,
										columnIxx, floorHeight)) + " in");

		System.out
				.println("Target Column Analysis - Yield Displacement 'uy' = "
						+ YieldDisplacementUy
								.calculateYieldDisplacementUyFIXED(floorHeight,
										columnSx, yieldStrength, youngsMod,
										columnIxx) + " in");

		System.out.println();

		System.out.println("COLUMN - ELASTIC ASSESSMENT");

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
														floorHeight))) + " in");

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

		// System.out.println("COLUMN - ELASTIC ASSESSMENT (FIX - FIX):");
		//
		// System.out
		// .println("Elastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF 'ke' = "
		// + EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(youngsMod, columnIxx,
		// floorHeight)) + " kipf.ft^-1");
		//
		// System.out
		// .println("Elastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF 'me' = "
		// + EquivalentSDOFPropertiesElastic.massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(columnLinearWeight,
		// floorHeight)) + " kipf.s^2.ft^-1");
		//
		// System.out
		// .println("Elastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF 'Tn' = "
		// + EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesElastic.stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(youngsMod, columnIxx,
		// floorHeight))) + " s");
		//
		// System.out
		// .println("Target Column Analysis - T/Tn used for UFC 3-340 graphs to determnine whether column remains elastic = "
		// + ParameterForElasticCheck.tEquivDividedByTnFIX(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight)))));
		//
		// System.out
		// .println("Elastic Parameter - Peak Response Parameter 'um' = "
		// + EquivalentSDOFElasticResponseUm.elasticResponseParameterCheck(
		// (ParameterForElasticCheck
		// .tEquivDividedByTn(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))))),
		// StaticDisplacementUs.CalculateStaticDisplacement(
		// AppliedLoadingToColumnQ
		// .calculateAppliedLoading(
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth,
		// floorHeight),
		// ActualStiffnessK.stiffnessFIX(
		// youngsMod, columnIxx,
		// floorHeight))) + " in");

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

		// System.out
		// .println("|Elastic Check| - "
		// + EquivalentSDOFElasticCheck.determiningDynamicLoadFactor(
		// EquivalentSDOFElasticResponseUm.elasticResponseParameterCheck(
		// (ParameterForElasticCheck
		// .tEquivDividedByTnFIX(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesElastic
		// .naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))))),
		// StaticDisplacementUs.CalculateStaticDisplacement(
		// AppliedLoadingToColumnQ
		// .calculateAppliedLoading(
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth,
		// floorHeight),
		// ActualStiffnessK.stiffnessFIX(
		// youngsMod, columnIxx,
		// floorHeight))),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx)));

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
						+ EquivalentSDOFPlasticResponseUm.TeDivideTn(
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
				.println("Peak Displacement  = "
						+ EquivalentSDOFPlasticResponseUm.maximumPlasticDeflection(
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
												floorHeight)) + " in");

		System.out
				.println("End Rotation of Column (Degrees)  = "
						+ EquivalentSDOFPlasticResponseUm.beamPlasticRotation(
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

		// System.out.println("COLUMN - PLASTIC ASSESSMENT FIX-FIX");
		//
		// System.out
		// .println("Plastic Equivalent - Target Column Analysis - Stiffness of Equivalent SDOF (k'e) = "
		// + EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(youngsMod, columnIxx,
		// floorHeight)) + " kipf.ft^-1");
		//
		// System.out
		// .println("Plastic Equivalent - Target Column Analysis - Mass of Equivalent SDOF (m'e) = "
		// + EquivalentSDOFPropertiesPlastic.massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(columnLinearWeight,
		// floorHeight)) + " kipf.s^2.ft^-1");
		//
		// System.out
		// .println("Plastic Equivalent - Target Column Analysis - Natural Period of Equivalent SDOF (T'n) = "
		// + EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(youngsMod, columnIxx,
		// floorHeight))) + " s");
		//
		// System.out.println("Plastic Parameter - Ultimate Resistance = "
		// + UltimateUnitResistance.calculatingPlasticMoment(
		// yieldStrength, columnZx, floorHeight) + " kipf.ft^-1");
		//
		// System.out
		// .println("Plastic Parameter - T/T'n = "
		// + EquivalentSDOFPlasticResponseUm.TeDivideTn(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight)))));
		//
		// System.out
		// .println("Plastic Parameter - Ultimate Resistance ru / Peak Reflected Pressure = "
		// +
		// EquivalentSDOFPlasticResponseUm.maxDeflectionPlasticInputsRuDivideP(
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight));
		//
		// System.out
		// .println("Plastic Parameter - Max Ductility Ratio 'Xm/Xe'  = "
		// + EquivalentSDOFPlasticResponseUm.peakResponseParameterPlastic(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight));
		//
		// System.out
		// .println("Peak Displacement  = "
		// + EquivalentSDOFPlasticResponseUm.maximumPlasticDeflection(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight,
		// ActualStiffnessK.stiffnessFIX(youngsMod,
		// columnIxx, floorHeight)) + " in");
		//
		// System.out
		// .println("End Rotation of Column (Degrees)  = "
		// + EquivalentSDOFPlasticResponseUm.beamPlasticRotation(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight,
		// ActualStiffnessK.stiffnessFIX(youngsMod,
		// columnIxx, floorHeight)) + " degrees");
		//
		// double ductilityRatioF = EquivalentSDOFPlasticResponseUm
		// .peakResponseParameterPlastic(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha.calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle, weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(youngsMod, columnIxx,
		// floorHeight))),
		// UltimateUnitResistance.calculatingPlasticMoment(
		// yieldStrength, columnZx, floorHeight),
		// YieldDisplacementUy.calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx, yieldStrength,
		// youngsMod, columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle, PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight);
		//
		// System.out
		// .println("|Plastic Check| -  = "
		// + EquivalentSDOFPlasticResponseUm.plasticCheckFinal(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight, ductilityLimit)
		// + ". Max Ductility Ratio Xm/Xe = " + ductilityRatioF
		// + " Allowable Ductility Ratio Specified by User = "
		// + ductilityLimit);

		if (ductilityRatio > ductilityLimit) {

			double i = 0;

			while (ductilityRatio > ductilityLimit) {

				i = i + 0.01;

				columnFactorOfSafety = columnFactorOfSafety + i;

				columnIxx = retrievingColumnSections.Ixx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnSx = retrievingColumnSections.Sx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnZx = retrievingColumnSections.Zx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnLinearWeight = retrievingColumnSections.Wgt(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnFlangeWidth = retrievingColumnSections.Bf(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);

				ductilityRatio = EquivalentSDOFPlasticResponseUm
						.peakResponseParameterPlastic(
								EquivalentDurationTrAlpha
										.calculateEquivalentDurationWithIsAndPr(
												ImpulseIralpha
														.calculateImpulseIsUFCGraph(
																PeakIncidentOverPressurePso
																		.findPeakIncidentOverPressureWith(z),
																(int) blastAngle,
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
								columnFlangeWidth, floorHeight);

			}

			System.out.println("");

			System.out.println("COLUMN RE-DESIGN Pin - Pin:");

			// System.out.println("Blast Internal Column Size = "
			// + internalColumnForcesAndDesignA.columnSizing(bayWidth,
			// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
			// floorHeight, kFactor, 50, compressionFactor,
			// numberOfBays, columnFactorOfSafety, windspeed));

			System.out.println("Blast Column Size = "
					+ externalColumnForcesandDesignA.columnSizing(bayWidth,
							tributaryWidth, deadLoad, liveLoad, numberOfStorys,
							floorHeight, kFactor, 50, compressionFactor,
							numberOfBays, columnFactorOfSafety, windspeed));

			System.out.println("Column Increase Factor = " + (i + 1));

			System.out.println("Updated Ductility Ratio = " + ductilityRatio);

			double rotation = EquivalentSDOFPlasticResponseUm
					.beamPlasticRotation(
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
									EquivalentSDOFPropertiesPlastic.massOfEquivSDOF(TotalActalMassM
											.calculatingTotalActualMass(
													columnLinearWeight,
													floorHeight)),
									EquivalentSDOFPropertiesPlastic
											.stiffnessOfEquivSDOF(ActualStiffnessK
													.calculateColumnActualStiffness(
															youngsMod,
															columnIxx,
															floorHeight))),
							UltimateUnitResistance.calculatingPlasticMoment(
									yieldStrength, columnZx, floorHeight),
							YieldDisplacementUy.calculateYieldDisplacementUy(
									floorHeight, columnSx, yieldStrength,
									youngsMod, columnIxx),
							ReflectedPressurePr.findReflectedPressureWith(
									blastAngle,
									PeakIncidentOverPressurePso
											.findPeakIncidentOverPressureWith(z)),
							columnFlangeWidth, floorHeight, ActualStiffnessK
									.calculateColumnActualStiffness(youngsMod,
											columnIxx, floorHeight));

			System.out.println("Rotation " + rotation);

			System.out
					.println("Peak Displacement "
							+ EquivalentSDOFPlasticResponseUm.maximumPlasticDeflection(
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
									ReflectedPressurePr
											.findReflectedPressureWith(
													blastAngle,
													PeakIncidentOverPressurePso
															.findPeakIncidentOverPressureWith(z)),
									columnFlangeWidth, floorHeight,
									ActualStiffnessK
											.calculateColumnActualStiffness(
													youngsMod, columnIxx,
													floorHeight)));

		}

		// if (ductilityRatioF > ductilityLimit) {
		//
		// double j = 0;
		//
		// while (ductilityRatioF > ductilityLimit) {
		//
		// j = j + 0.01;
		//
		// columnFactorOfSafety = columnFactorOfSafety + j;
		//
		// columnIxx = retrievingColumnSections.Ixx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnSx = retrievingColumnSections.Sx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnZx = retrievingColumnSections.Zx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnLinearWeight = retrievingColumnSections.Wgt(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnFlangeWidth = retrievingColumnSections.Bf(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		//
		// ductilityRatioF = EquivalentSDOFPlasticResponseUm
		// .peakResponseParameterPlastic(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .stiffnessFIX(
		// youngsMod,
		// columnIxx,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZx,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx,
		// yieldStrength, youngsMod,
		// columnIxx),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth, floorHeight);
		//
		// double um = EquivalentSDOFElasticResponseUm
		// .elasticResponseParameterCheck(
		// (ParameterForElasticCheck
		// .tEquivDividedByTn(
		// EquivalentDurationTrAlpha
		// .calculateEquivalentDurationWithIsAndPr(
		// ImpulseIralpha
		// .calculateImpulseIsUFCGraph(
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z),
		// (int) blastAngle,
		// weightTNT),
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z))),
		// EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesElastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeight,
		// floorHeight)),
		// EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .calculateColumnActualStiffness(
		// youngsMod,
		// columnIxx,
		// floorHeight))))),
		// StaticDisplacementUs.CalculateStaticDisplacement(
		// AppliedLoadingToColumnQ
		// .calculateAppliedLoading(
		// ReflectedPressurePr
		// .findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidth,
		// floorHeight),
		// ActualStiffnessK
		// .calculateColumnActualStiffness(
		// youngsMod, columnIxx,
		// floorHeight)));
		//
		// double uyF = YieldDisplacementUy
		// .calculateYieldDisplacementUyFIXED(floorHeight,
		// columnSx, yieldStrength, youngsMod, columnIxx);
		//
		// }
		//
		// double keF = EquivalentSDOFPropertiesElastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK.stiffnessFIX(
		// youngsMod, columnIxx, floorHeight));
		//
		// double uyF = YieldDisplacementUy.calculateYieldDisplacementUyFIXED(
		// floorHeight, columnSx, yieldStrength, youngsMod, columnIxx);
		//
		// double ruF = UltimateUnitResistance.calculatingPlasticMoment(
		// yieldStrength, columnZx, floorHeight);
		//
		// System.out.println("COLUMN RE-DESIGN Fix - Fix:");
		//
		// System.out.println("Blast Column Size = "
		// + externalColumnForcesandDesignA.columnSizing(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor,
		// numberOfBays, columnFactorOfSafety, windspeed));
		//
		// System.out.println("Column Increase Factor = " + (j + 1));
		//
		// System.out.println("Updated Ductility Ratio = " + ductilityRatio);
		//
		// System.out.println(ductilityRatio * (ruF / keF) * 12);
		// }

		System.out.println();

		System.out.println("BEAM CHECK - COLUMN REMOVED:");

		System.out.println("Max Shear with Column Removed = "
				+ beamDesignForces.maxBeamShear(bayWidth, tributaryWidth,
						deadLoad, liveLoad, dynamicAmpFactor, numberOfStorys,
						deadLoadFactorPC, liveLoadFactorPC) + " Kips");

		System.out.println("Max Bending Moment with Column Removed = "
				+ beamDesignForces.maxBeamMoment(bayWidth, tributaryWidth,
						deadLoad, liveLoad, dynamicAmpFactor, numberOfStorys,
						deadLoadFactorPC, liveLoadFactorPC,
						noOfFloorsBeamSupports) + " Kip-ft");

		System.out.println(beamChecks.localBucklingCheck(beamFlangeWidth,
				beamFlangeThickness));

		System.out.println(beamChecks.localshearCheck(beamaxial, beamArea,
				yieldStrength, beamFlangeWidth, beamFlangeThickness));

		System.out.println(beamChecks.shearcheck(yieldStrength,
				beamFlangeThickness, beamWebThickness, beamDepth,
				beamDesignForces.maxBeamShear(bayWidth, tributaryWidth,
						deadLoad, liveLoad, dynamicAmpFactor, numberOfStorys,
						deadLoadFactorPC, liveLoadFactorPC)));

		System.out.println("Ultimate Axial Compressive Load "
				+ beamChecks.flexuralCheck(beamZx, bayWidth, beamLy,
						yieldStrength, beamRx, beamRy, youngsMod, beamArea)
				+ " Kips");

		System.out.println("Factor for determining Mmx with Mpx"
				+ beamChecks.momentMmxFactor(beamZx, bayWidth, beamLy,
						yieldStrength, beamRx, beamRy, youngsMod, beamArea));

		System.out.println(beamChecks.momentMmxCheck(beamZx, bayWidth, beamLy,
				yieldStrength, beamRx, beamRy, youngsMod, beamArea));

		System.out.println("Buckling Capacity "
				+ beamChecks.eulerBucklingStresses(youngsMod, bayWidth, beamRx)
				+ " Ksi");

		System.out.println("Euler Buckling Load about X-Axis "
				+ beamChecks.eulerBucklingLoads(youngsMod, bayWidth, beamRx,
						beamArea) + " Kips");

		System.out.println("Ultimate Capacity for Dynamic Axial Load "
				+ beamChecks.ultCapacityForDynAxialLoadPp(yieldStrength,
						beamArea) + " Kips");

		System.out.println("Combined Check One "
				+ beamChecks.combinedChcekOne(beamZx, bayWidth, beamLy,
						yieldStrength, beamRx, beamRy, youngsMod, beamArea,
						beamaxial, beamDesignForces.maxBeamMoment(bayWidth,
								tributaryWidth, deadLoad, liveLoad,
								dynamicAmpFactor, numberOfStorys,
								deadLoadFactorPC, liveLoadFactorPC,
								noOfFloorsBeamSupports)));

		System.out.println("Combined Check Two "
				+ beamChecks.combinedChcekTwo(beamZx, bayWidth, beamLy,
						yieldStrength, beamRx, beamRy, youngsMod, beamArea,
						beamaxial, beamDesignForces.maxBeamMoment(bayWidth,
								tributaryWidth, deadLoad, liveLoad,
								dynamicAmpFactor, numberOfStorys,
								deadLoadFactorPC, liveLoadFactorPC,
								noOfFloorsBeamSupports)));

		System.out.println(beamChecks.combinedChcekOnePassOrFail(beamZx,
				bayWidth, beamLy, yieldStrength, beamRx, beamRy, youngsMod,
				beamArea, beamaxial, beamDesignForces.maxBeamMoment(bayWidth,
						tributaryWidth, deadLoad, liveLoad, dynamicAmpFactor,
						numberOfStorys, deadLoadFactorPC, liveLoadFactorPC,
						noOfFloorsBeamSupports)));

		System.out.println();

		// System.out.println(SapTextFile.sapFile(bayWidth, tributaryWidth,
		// deadLoad, liveLoad, numberOfStorys, numberOfBays, floorHeight,
		// heading, targetColumn, deadLoadFactorPC, liveLoadFactorPC,
		// yieldStrength, beamaxial, kFactor, compressionFactor,
		// columnFactorOfSafety, beamFactorOfSafety, windspeed));

		// } else if (ductilityRatio <= ductilityLimit) {
		//
		// System.exit(0);
		// }

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

