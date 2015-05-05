package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

public class externalColumnForcesandDesignATest {

	@Test
	public void test() {

		String result = internalColumnForcesAndDesign.columnSizing(25, 20, 120,
				90, 12, 12, 1, 50, 1.67, 7, 1, 150);

		double result1 = externalColumnForcesandDesign.maxMx(25, 20, 120, 90,
				12, 12, 1, 50, 1.67, 7, 150);

		double result2 = externalColumnForcesandDesign.maxAxial(25, 10, 120,
				90, 8);

		String result3 = externalColumnForcesandDesignA.columnSizing(25, 20,
				120, 90, 10, 24, 1, 50, 1, 4, 1, 150);

		String result4 = internalColumnForcesAndDesignA.columnSizing(25, 20,
				120, 90, 14, 14, 1, 50, 1.7, 4, 1, 150);

		Double result5 = windForces.intMoment(24, 10, 10, 4, 150);

		Double result6 = windForces.extMoment(24, 10, 10, 4, 150);

		System.out.println("result: " + result);
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		System.out.println("result3: " + result4);
		System.out.println("Internal Moment " + result5);
		System.out.println("External Moment " + result6);

	}

}
