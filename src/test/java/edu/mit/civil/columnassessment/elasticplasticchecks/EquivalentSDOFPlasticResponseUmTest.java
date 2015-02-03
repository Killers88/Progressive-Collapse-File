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
public class EquivalentSDOFPlasticResponseUmTest {

	@Test
	public void test() {

		double result = EquivalentSDOFPlasticResponseUm
				.peakResponseParameterPlastic(13.1, 0.0262, 5, 69.44, 3);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);
	}

}
