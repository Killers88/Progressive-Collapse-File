package edu.mit.civil.beamassessment.calculation;

import org.junit.Test;

public class beamChecksTest {

	@Test
	public void test() {

		String result = beamChecks.localBucklingCheck(10.01, 0.64);

		System.out.println("result: " + result);

		// assertTrue(result > "Error");
		// assertEquals("OKAY", result, 0);
	}

	@Test
	public void test1() {

		String result1 = beamChecks.localshearCheck(88, 39.9, 50, 12.4, 1.25);

		System.out.println("result1: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test2() {

		String result1 = beamChecks.shearcheck(50, 1.25, 0.79, 12, 122.5);

		System.out.println("result2: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test3() {

		double result1 = beamChecks.flexuralCheck(214, 20, 5, 50, 5.58, 3.16,
				29000, 39.9);

		System.out.println("result3: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test4() {

		String result1 = beamChecks.momentMmxCheck(214, 40, 5, 50, 5.58, 3.16,
				29000, 39.9);

		System.out.println("result4: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test5() {

		double result1 = beamChecks.eulerBucklingStresses(29000, 20, 5.58);

		System.out.println("result4: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test6() {

		double result1 = beamChecks.eulerBucklingLoads(29000, 20, 5.58, 39.9);

		System.out.println("result4: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test7() {

		double result1 = beamChecks.ultCapacityForDynAxialLoadPp(50, 39.9);

		System.out.println("result4: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test8() {

		Double result1 = beamChecks.combinedChcekOne(214, 20, 5, 50, 5.58,
				3.16, 29000, 39.9, 88, 1065);

		System.out.println("Check One: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test9() {

		Double result1 = beamChecks.combinedChcekTwo(214, 20, 5, 50, 5.58,
				3.16, 29000, 39.9, 88, 1065);

		System.out.println("Check Two: " + result1);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

	@Test
	public void test10() {

		String result11 = beamChecks.combinedChcekOnePassOrFail(214, 20, 5, 50,
				5.58, 3.16, 29000, 39.9, 88, 1065);

		System.out.println("Final Check: " + result11);
		// assertTrue(result > 0);
		// assertEquals(0.123, result, 0);
	}

}
