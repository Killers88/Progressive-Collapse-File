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
public class EquivalentSDOFElasticResponseBTest {

	@Test
	public void test() {

		double result = EquivalentSDOFElasticResponseUm
				.findPeakResponseParameter(0.6125634176);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);

	}
}
