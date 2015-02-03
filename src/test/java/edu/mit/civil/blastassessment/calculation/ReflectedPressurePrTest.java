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
public class ReflectedPressurePrTest {

	@Test
	public void test() {

		double result = ReflectedPressurePr.findReflectedPressureWith(25,
				237.287462);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(1000, result, 0);

	}
}
