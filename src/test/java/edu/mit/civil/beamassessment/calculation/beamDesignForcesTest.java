/**
 * 
 */
package edu.mit.civil.beamassessment.calculation;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class beamDesignForcesTest {

	@Test
	public void test1() {

		double result = beamDesignForces.maxBeamShear(25, 12.5, 120, 90, 1, 12,
				2, 0.25);

		double result1 = beamDesignForces.maxBeamMoment(25, 12.5, 120, 90, 2,
				12, 1, 0.25, 0);

		System.out.println("result: " + result);
		System.out.println("result: " + result1);

	}

}
