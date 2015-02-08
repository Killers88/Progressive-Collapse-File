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
				.equivalentElastDeflection(1.51, 0.0097, 374, 0.0428, 630.5,
						10, 11, 5505);

		System.out.println("result: " + result);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);
	}

}
