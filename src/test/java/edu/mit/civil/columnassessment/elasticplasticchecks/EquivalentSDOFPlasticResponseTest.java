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
public class EquivalentSDOFPlasticResponseTest {

	@Test
	public void test() {

		double result = EquivalentSDOFPlasticResponse
				.peakResponseParameterPlastic(24.65, 0.009749, 3693, 0.0489,
						375.84);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(123, result, 0);

	}
}