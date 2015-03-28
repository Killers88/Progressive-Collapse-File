/**
 * 
 */
package edu.mit.civil.beamassessment.calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class beamDesignForcesTest {

	@Test
	public void test1() {

		double result = beamDesignForces.maxBeamShear(20, 20, 12.5, 95, 80, 0,
				0, 1.5);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);
	}

	@Test
	public void test() {

		double result = beamDesignForces.maxBeamMoment(20, 20, 12.5, 95, 80, 0,
				0, 1.5);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);
	}

}
