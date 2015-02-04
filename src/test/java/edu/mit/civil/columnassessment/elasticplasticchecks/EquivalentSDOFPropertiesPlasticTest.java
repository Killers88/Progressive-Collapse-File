/**
 * 
 */
package edu.mit.civil.columnassessment.elasticplasticchecks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class EquivalentSDOFPropertiesPlasticTest {

	@Test
	public void test() {

		double result = EquivalentSDOFPropertiesPlastic.naturalPeriodSDOF(
				0.03025, 6797);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);
	}
}
