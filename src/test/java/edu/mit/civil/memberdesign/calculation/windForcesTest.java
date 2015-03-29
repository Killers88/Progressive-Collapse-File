/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class windForcesTest {

	@Test
	public void test() {

		double result1 = windForces.windPressure(12, 10, 10);

		double result = windForces.intMoment(12, 10, 10, 8);

		double result2 = windForces.extMoment(12, 10, 10, 8);

		double result3 = windForces.axialInt(25, 10, 120, 90, 8);

		double result4 = windForces.axialExt(25, 10, 120, 90, 8);

		System.out.println("result: " + result1);
		System.out.println("result: " + result);
		System.out.println("result: " + result2);
		System.out.println("result: " + result3);
		System.out.println("result: " + result4);

	}
}
