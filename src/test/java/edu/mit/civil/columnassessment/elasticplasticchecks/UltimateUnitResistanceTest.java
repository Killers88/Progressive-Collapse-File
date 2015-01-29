package edu.mit.civil.columnassessment.elasticplasticchecks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UltimateUnitResistanceTest {

	@Test
	public void testCalculatingPlasticMoment() {
		double result = UltimateUnitResistance.calculatingPlasticMoment(50,
				113, 11.6);
		System.out.println("result: " + result);
		System.out.println(Math.log(18));
		assertTrue(result > 0);
		assertEquals(123, result, 0);

	}

}
