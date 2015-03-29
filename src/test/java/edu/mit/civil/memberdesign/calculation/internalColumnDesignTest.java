package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

public class internalColumnDesignTest {

	@Test
	public void test() {

		String result = externalColumnForcesandDesign.columnSizing(25, 20, 120,
				90, 12, 12, 1, 50, 1.67, 7, 1);

		double result1 = externalColumnForcesandDesign.maxMx(25, 20, 120, 90,
				12, 12, 1, 50, 1.67, 7);

		double result2 = externalColumnForcesandDesign.maxAxial(25, 10, 120,
				90, 8);

		// String result = internalColumnForcesAndDesign.columnSizing(25, 10,
		// 120,
		// 90, 8, 12, 1, 50, 2);
		//
		// double result1 = internalColumnForcesAndDesign.maxMx(25, 10, 120,
		// 90);
		//
		// double result2 = internalColumnForcesAndDesign.maxAxial(25, 10, 120,
		// 90, 8);

		System.out.println("result: " + result1);
		System.out.println("result: " + result2);
		System.out.println("result: " + result);
	}

}
