package edu.mit.civil.columnassessment.calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ActualStiffnessKTest {

	@Test
	public void test() {

		double result = ActualStiffnessK.calculateColumnActualStiffness(29000,
				400, 14);

		double result1 = ActualStiffnessK.stiffnessFIX(29000, 400, 14);

		System.out.println("result: " + result);
		System.out.println("result: " + result1);
		assertTrue(result > 0);
		assertEquals(0.123, result, 0);

	}
}
