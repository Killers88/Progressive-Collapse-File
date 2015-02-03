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
public class PeakDynamicPressureQoTest {

	@Test
	public void test() {

		double result = PeakDynamicPressureQo.calculatQoWithPso(13.8293746);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(123, result, 0);

	}
}
