package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

public class beamDesignTest {

	@Test
	public void test() {

		String result = beamDesign.sectionDesign(25, 12.5, 120 * 1.1 + 0.1, 90,
				50, 10, 1, 13, 12, 6, 150);

		Double result1 = beamForces.serviceIReq(25, 12.5, 120 * 1.1 + 0.1, 90);

		Double result2 = windForces.intMoment(13, 12.5, 12, 6, 150);

		System.out.println("result: " + result);
		System.out.println("result1: " + result1);
		System.out.println("result: " + result2);

	}
}
