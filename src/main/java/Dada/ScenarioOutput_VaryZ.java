/**
 * 
 */
package Dada;

import edu.mit.civil.blastassessment.calculation.EquivalentDurationTrAlpha;
import edu.mit.civil.blastassessment.calculation.ImpulseIralpha;
import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;
import edu.mit.civil.blastassessment.calculation.ReflectedPressurePr;
import edu.mit.civil.blastassessment.cli.dataStorage;
import edu.mit.civil.blastassessment.cli.retrievingColumnSections;
import edu.mit.civil.columnassessment.calculation.ActualStiffnessK;
import edu.mit.civil.columnassessment.calculation.AppliedLoadingToColumnQ;
import edu.mit.civil.columnassessment.calculation.ParameterForElasticCheck;
import edu.mit.civil.columnassessment.calculation.StaticDisplacementUs;
import edu.mit.civil.columnassessment.calculation.TotalActalMassM;
import edu.mit.civil.columnassessment.calculation.YieldDisplacementUy;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFElasticResponseUm;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPlasticResponseUm;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPropertiesElastic;
import edu.mit.civil.columnassessment.elasticplasticchecks.EquivalentSDOFPropertiesPlastic;
import edu.mit.civil.columnassessment.elasticplasticchecks.UltimateUnitResistance;
import edu.mit.civil.memberdesign.calculation.externalColumnForcesandDesignA;
import edu.mit.civil.memberdesign.calculation.internalColumnForcesAndDesignA;
import edu.mit.civil.memberdesign.calculation.windForces;

/**
 * @author koleary
 *
 */
public class ScenarioOutput_VaryZ {

	public static String scenario() {

		// double z = 2.65;
		/**
		 * Variables
		 */
		double floorHeight = 13.5;
		double windspeed = 150;
		double weightTNT = 400;
		double standoffDist = 25;
		int numberOfStorys = 12;
		double numberOfBays = 6;
		double bayWidth = 25;
		int targetColumn = 2;
		double tributaryWidth = 12.5;
		double youngsMod = 29000;
		double yieldStrength = 50;
		double ductilityLimit = 2.5;
		double kFactor = 1;
		double compressionFactor = 1.7;
		double columnFactorOfSafety = 1;

		double deadLoad = 120;
		double liveLoad = 90;

		double blastAngle = 0;

		/**
		 * Retrieving Column Details for Blast Analysis
		 */
		double columnIxxI = retrievingColumnSections.Ixx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnSxI = retrievingColumnSections.Sx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnZxI = retrievingColumnSections.Zx(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnLinearWeightI = retrievingColumnSections.Wgt(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);
		double columnFlangeWidthI = retrievingColumnSections.Bf(bayWidth,
				tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, yieldStrength, compressionFactor,
				numberOfBays, targetColumn, columnFactorOfSafety, windspeed);

		/**
		 * Progressive Collapse Load Factors
		 */
		double deadLoadFactorPC = dataStorage.dlCombPC();
		double liveLoadFactorPC = dataStorage.llCombPC();
		/**
		 * Beam Details for Column Removed Check
		 */
		double beamaxial = windForces.beamAxialForce(floorHeight,
				numberOfStorys, tributaryWidth, windspeed);

		double z = (double) ((standoffDist) / Math.pow(weightTNT, 0.33333));

		System.out.println(internalColumnForcesAndDesignA.columnSizing(
				bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, 50, compressionFactor, numberOfBays,
				columnFactorOfSafety, windspeed));

		System.out.println(externalColumnForcesandDesignA.columnSizing(
				bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
				floorHeight, kFactor, 50, compressionFactor, numberOfBays,
				columnFactorOfSafety, windspeed));

		// System.out.println(internalColumnForcesAndDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 125));
		//
		// System.out.println(externalColumnForcesandDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 125));
		//
		// System.out.println(internalColumnForcesAndDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 150));
		//
		// System.out.println(externalColumnForcesandDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 150));
		//
		// System.out.println(internalColumnForcesAndDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 175));
		//
		// System.out.println(externalColumnForcesandDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, 50, compressionFactor, numberOfBays,
		// columnFactorOfSafety, 175));

		// System.out.println(columnFlangeWidthI);

		System.out.println(PeakIncidentOverPressurePso
				.findPeakIncidentOverPressureWith(z));
		System.out
				.println(ReflectedPressurePr.findReflectedPressureWith(
						blastAngle, PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z)));
		System.out
				.println(ImpulseIralpha.calculateImpulseIsUFCGraph(
						PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z),
						(int) blastAngle, weightTNT));

		System.out.println(EquivalentDurationTrAlpha
				.calculateEquivalentDurationWithIsAndPr(ImpulseIralpha
						.calculateImpulseIsUFCGraph(PeakIncidentOverPressurePso
								.findPeakIncidentOverPressureWith(z),
								(int) blastAngle, weightTNT),
						ReflectedPressurePr.findReflectedPressureWith(
								blastAngle, PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z))));

		double ke = EquivalentSDOFPropertiesElastic
				.stiffnessOfEquivSDOF(ActualStiffnessK
						.calculateColumnActualStiffness(youngsMod, columnIxxI,
								floorHeight));

		double um = EquivalentSDOFElasticResponseUm
				.elasticResponseParameterCheck(
						(ParameterForElasticCheck
								.tEquivDividedByTn(
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
										EquivalentSDOFPropertiesElastic.naturalPeriodSDOF(
												EquivalentSDOFPropertiesElastic
														.massOfEquivSDOF(TotalActalMassM
																.calculatingTotalActualMass(
																		columnLinearWeightI,
																		floorHeight)),
												EquivalentSDOFPropertiesElastic
														.stiffnessOfEquivSDOF(ActualStiffnessK
																.calculateColumnActualStiffness(
																		youngsMod,
																		columnIxxI,
																		floorHeight))))),
						StaticDisplacementUs.CalculateStaticDisplacementPIN_PIN(
								AppliedLoadingToColumnQ.calculateAppliedLoading(
										ReflectedPressurePr
												.findReflectedPressureWith(
														blastAngle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z)),
										columnFlangeWidthI, floorHeight),
								ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxxI,
												floorHeight)));

		System.out
				.println(StaticDisplacementUs.CalculateStaticDisplacementPIN_PIN(
						AppliedLoadingToColumnQ.calculateAppliedLoading(
								ReflectedPressurePr
										.findReflectedPressureWith(
												blastAngle,
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidthI, floorHeight),
						ActualStiffnessK.calculateColumnActualStiffness(
								youngsMod, columnIxxI, floorHeight)) * 12);

		System.out
				.println(YieldDisplacementUy.calculateYieldDisplacementUy(
						floorHeight, columnSxI, yieldStrength, youngsMod,
						columnIxxI) * 12);

		System.out.println(YieldDisplacementUy
				.calculateYieldDisplacementUyFIXED(floorHeight, columnSxI,
						yieldStrength, youngsMod, columnIxxI) * 12);

		System.out.println(um * 12);

		double ru = UltimateUnitResistance.calculatingPlasticMoment(
				yieldStrength, columnZxI, floorHeight);

		double rotation = EquivalentSDOFPlasticResponseUm
				.equivalentElastDeflection(
						EquivalentDurationTrAlpha
								.calculateEquivalentDurationWithIsAndPr(
										ImpulseIralpha.calculateImpulseIsUFCGraph(
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z),
												(int) blastAngle, weightTNT),
										ReflectedPressurePr
												.findReflectedPressureWith(
														blastAngle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z))),
						EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesPlastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														columnLinearWeightI,
														floorHeight)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxxI,
												floorHeight))),
						UltimateUnitResistance.calculatingPlasticMoment(
								yieldStrength, columnZxI, floorHeight),
						YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSxI, yieldStrength,
								youngsMod, columnIxxI),
						ReflectedPressurePr.findReflectedPressureWith(
								blastAngle, PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)),
						columnFlangeWidthI, floorHeight, ActualStiffnessK
								.calculateColumnActualStiffness(youngsMod,
										columnIxxI, floorHeight));

		System.out.println(rotation);

		double ductilityRatio = EquivalentSDOFPlasticResponseUm
				.peakResponseParameterPlastic(
						EquivalentDurationTrAlpha
								.calculateEquivalentDurationWithIsAndPr(
										ImpulseIralpha.calculateImpulseIsUFCGraph(
												PeakIncidentOverPressurePso
														.findPeakIncidentOverPressureWith(z),
												(int) blastAngle, weightTNT),
										ReflectedPressurePr
												.findReflectedPressureWith(
														blastAngle,
														PeakIncidentOverPressurePso
																.findPeakIncidentOverPressureWith(z))),
						EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
								EquivalentSDOFPropertiesPlastic
										.massOfEquivSDOF(TotalActalMassM
												.calculatingTotalActualMass(
														columnLinearWeightI,
														floorHeight)),
								EquivalentSDOFPropertiesPlastic.stiffnessOfEquivSDOF(ActualStiffnessK
										.calculateColumnActualStiffness(
												youngsMod, columnIxxI,
												floorHeight))),
						UltimateUnitResistance.calculatingPlasticMoment(
								yieldStrength, columnZxI, floorHeight),
						YieldDisplacementUy.calculateYieldDisplacementUy(
								floorHeight, columnSxI, yieldStrength,
								youngsMod, columnIxxI),
						ReflectedPressurePr.findReflectedPressureWith(
								blastAngle, PeakIncidentOverPressurePso
										.findPeakIncidentOverPressureWith(z)),
						columnFlangeWidthI, floorHeight);

		System.out.println(ductilityRatio * (ru / ke) * 12);

		System.out.println();

		if (ductilityRatio > ductilityLimit) {

			double i = 0;

			while (ductilityRatio > ductilityLimit) {

				i = i + 0.01;

				columnFactorOfSafety = columnFactorOfSafety + i;

				columnIxxI = retrievingColumnSections.Ixx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnSxI = retrievingColumnSections.Sx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnZxI = retrievingColumnSections.Zx(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnLinearWeightI = retrievingColumnSections.Wgt(bayWidth,
						tributaryWidth, deadLoad, liveLoad, numberOfStorys,
						floorHeight, kFactor, yieldStrength, compressionFactor,
						numberOfBays, targetColumn, columnFactorOfSafety,
						windspeed);
				columnFlangeWidthI = retrievingColumnSections.Bf(bayWidth,
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
																columnLinearWeightI,
																floorHeight)),
										EquivalentSDOFPropertiesPlastic
												.stiffnessOfEquivSDOF(ActualStiffnessK
														.calculateColumnActualStiffness(
																youngsMod,
																columnIxxI,
																floorHeight))),
								UltimateUnitResistance
										.calculatingPlasticMoment(
												yieldStrength, columnZxI,
												floorHeight),
								YieldDisplacementUy
										.calculateYieldDisplacementUy(
												floorHeight, columnSxI,
												yieldStrength, youngsMod,
												columnIxxI),
								ReflectedPressurePr.findReflectedPressureWith(
										blastAngle,
										PeakIncidentOverPressurePso
												.findPeakIncidentOverPressureWith(z)),
								columnFlangeWidthI, floorHeight);

			}

			System.out.println(externalColumnForcesandDesignA.columnSizing(
					bayWidth, tributaryWidth, deadLoad, liveLoad,
					numberOfStorys, floorHeight, kFactor, 50,
					compressionFactor, numberOfBays, columnFactorOfSafety,
					windspeed));

			System.out.println((i + 1));

			System.out.println(ductilityRatio);

			rotation = EquivalentSDOFPlasticResponseUm
					.equivalentElastDeflection(
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
									EquivalentSDOFPropertiesPlastic.massOfEquivSDOF(TotalActalMassM
											.calculatingTotalActualMass(
													columnLinearWeightI,
													floorHeight)),
									EquivalentSDOFPropertiesPlastic
											.stiffnessOfEquivSDOF(ActualStiffnessK
													.calculateColumnActualStiffness(
															youngsMod,
															columnIxxI,
															floorHeight))),
							UltimateUnitResistance.calculatingPlasticMoment(
									yieldStrength, columnZxI, floorHeight),
							YieldDisplacementUy.calculateYieldDisplacementUy(
									floorHeight, columnSxI, yieldStrength,
									youngsMod, columnIxxI),
							ReflectedPressurePr.findReflectedPressureWith(
									blastAngle,
									PeakIncidentOverPressurePso
											.findPeakIncidentOverPressureWith(z)),
							columnFlangeWidthI, floorHeight, ActualStiffnessK
									.calculateColumnActualStiffness(youngsMod,
											columnIxxI, floorHeight));

			System.out.println(rotation);

			System.out.println(ductilityRatio * (ru / ke) * 12);

		}

		// if (rotation > 2) {
		//
		// double j = 0;
		// columnFactorOfSafety = 1;
		//
		// while (rotation > 2) {
		//
		// j = j + 0.01;
		//
		// columnFactorOfSafety = columnFactorOfSafety + j;
		//
		// columnIxxI = retrievingColumnSections.Ixx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnSxI = retrievingColumnSections.Sx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnZxI = retrievingColumnSections.Zx(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnLinearWeightI = retrievingColumnSections.Wgt(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		// columnFlangeWidthI = retrievingColumnSections.Bf(bayWidth,
		// tributaryWidth, deadLoad, liveLoad, numberOfStorys,
		// floorHeight, kFactor, yieldStrength, compressionFactor,
		// numberOfBays, targetColumn, columnFactorOfSafety,
		// windspeed);
		//
		// rotation = EquivalentSDOFPlasticResponseUm
		// .equivalentElastDeflection(
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
		// EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
		// EquivalentSDOFPropertiesPlastic
		// .massOfEquivSDOF(TotalActalMassM
		// .calculatingTotalActualMass(
		// columnLinearWeightI,
		// floorHeight)),
		// EquivalentSDOFPropertiesPlastic
		// .stiffnessOfEquivSDOF(ActualStiffnessK
		// .calculateColumnActualStiffness(
		// youngsMod,
		// columnIxxI,
		// floorHeight))),
		// UltimateUnitResistance
		// .calculatingPlasticMoment(
		// yieldStrength, columnZxI,
		// floorHeight),
		// YieldDisplacementUy
		// .calculateYieldDisplacementUy(
		// floorHeight, columnSxI,
		// yieldStrength, youngsMod,
		// columnIxxI),
		// ReflectedPressurePr.findReflectedPressureWith(
		// blastAngle,
		// PeakIncidentOverPressurePso
		// .findPeakIncidentOverPressureWith(z)),
		// columnFlangeWidthI, floorHeight,
		// ActualStiffnessK
		// .calculateColumnActualStiffness(
		// youngsMod, columnIxxI,
		// floorHeight));
		//
		// }
		//
		// System.out.println(internalColumnForcesAndDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad,
		// numberOfStorys, floorHeight, kFactor, 50,
		// compressionFactor, numberOfBays, columnFactorOfSafety,
		// windspeed));
		//
		// System.out.println(externalColumnForcesandDesignA.columnSizing(
		// bayWidth, tributaryWidth, deadLoad, liveLoad,
		// numberOfStorys, floorHeight, kFactor, 50,
		// compressionFactor, numberOfBays, columnFactorOfSafety,
		// windspeed));
		//
		// System.out.println((j + 1));
		//
		// System.out.println(rotation);
		// }

		return "kjasdckajydc";

	}
}
