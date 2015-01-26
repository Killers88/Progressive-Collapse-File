/**
 * 
 */
package com.killers88.progressivecollapse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.mit.civil.blastassessment.calculation.PeakIncidentOverPressurePso;

/**
 * @author koleary
 *
 */
public class ProgressCollapseTest {

	static double EXPECTED_RESULT = 20.141196752804316;
	static double Z = 6;

	/**
	 * 
	 */
	@Test
	public void testCalculatePeakIncidentOverPressurePso() {

		double result = PeakIncidentOverPressurePso
				.findPeakIncidentOverPressureWith(Z);
		System.out.println(result);
		assertEquals(EXPECTED_RESULT, result, 0);

		try {
			PeakIncidentOverPressurePso.findPeakIncidentOverPressureWith(-1);
			fail();
		} catch (RuntimeException e) {
			assertTrue(e.getMessage(), e != null);
		}

	}
}
