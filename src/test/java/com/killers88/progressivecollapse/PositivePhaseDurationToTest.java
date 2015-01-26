package com.killers88.progressivecollapse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.mit.civil.blastassessment.calculation.PositivePhaseDurationTo;

public class PositivePhaseDurationToTest {

	@Test
	public void testCalculateTimeDurationForZ() {

		assertEquals(PositivePhaseDurationTo.findPositivePhaseDurationForZ(
				0.25, 500),
				PositivePhaseDurationTo
						.findPositivePhaseDurationForZ(0.23, 500), 0);
		assertEquals(PositivePhaseDurationTo.findPositivePhaseDurationForZ(1.0,
				500), PositivePhaseDurationTo.findPositivePhaseDurationForZ(
				0.99, 500), 0);

		System.out.println(PositivePhaseDurationTo
				.findPositivePhaseDurationForZ(0.9343434343433, 500));
	}
}
