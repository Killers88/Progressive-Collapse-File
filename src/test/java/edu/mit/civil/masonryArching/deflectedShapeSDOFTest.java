package edu.mit.civil.masonryArching;

import org.junit.Test;

public class deflectedShapeSDOFTest {

	@Test
	public void test() {

		double result = masonryChecks.masonryCapacityBasedNonRigidUPPER(10,
				0.833, 1, 10000, 360);

		double resultA = masonryChecks.masonryCapacityBasedNonRigidUPPER(14,
				0.833, 1, 10000, 360);

		double result2 = masonryChecks.masonryCapacityBasedNonRigidUPPER(10,
				0.833, 1, 10000, 700);

		double result3 = masonryChecks.masonryCapacityBasedNonRigidUPPER(14,
				0.833, 1, 10000, 700);

		double result4 = masonryChecks.masonryCapacityBasedNonRigidUPPER(10,
				0.833, 1, 10000, 810);

		double result5 = masonryChecks.masonryCapacityBasedNonRigidUPPER(14,
				0.833, 1, 10000, 810);

		System.out.println("result1: " + result);
		System.out.println("result2: " + resultA);
		System.out.println("result3: " + result2);
		System.out.println("result4: " + result3);
		System.out.println("result4: " + result4);
		System.out.println("result4: " + result5);

	}

}
