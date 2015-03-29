package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

public class beamForcesTest {

	@Test
	public void test() {

		// double result = beamForces.maxMoment(25, 10, 120, 90);
		//
		// double result1 = beamForces.serviceIReq(25, 10, 120, 90);

		String result = beamDesign.sectionDesign(37, 10, 120, 90, 50, 10, 1);

		double result1 = beamForces.maxMoment(37, 10, 120, 90);

		double result2 = beamForces.serviceIReq(37, 10, 120, 90);

		System.out.println("result: " + result1);
		System.out.println("result: " + result2);
		System.out.println("result: " + result);

	}

}
