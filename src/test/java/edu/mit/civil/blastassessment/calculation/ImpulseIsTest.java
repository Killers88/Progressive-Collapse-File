/**
 * 
 */
package edu.mit.civil.blastassessment.calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class ImpulseIsTest {

	@Test
	public void test() {

		double result = ImpulseIs.findPeakImpulseIsWith(14.5, 0);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(123, result, 0);

	}

}
