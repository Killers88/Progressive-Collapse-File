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

		double f = 1;

		double result = windForces.windPressure(13, 12, 12.5, 100);

		double result1 = windForces.roofDisplacement(13.5, 12, 12.5, 150,
				29000, 1240, 722, 6, 0.6);

		// double result1 = windForces.designWindPressure(12, f, 12.5, 150);
		// double result2 = windForces.designWindPressure(12, f, 12.5, 175);
		// double result3 = windForces.designWindPressure(12, f, 12.5, 200);
		//
		// double result4 = windForces.designWindPressure(13, f, 12.5, 100);
		// double result5 = windForces.designWindPressure(13, f, 12.5, 150);
		// double result6 = windForces.designWindPressure(13, f, 12.5, 175);
		// double result7 = windForces.designWindPressure(13, f, 12.5, 200);
		//
		// double result8 = windForces.designWindPressure(14, f, 12.5, 100);
		// double result9 = windForces.designWindPressure(14, f, 12.5, 150);
		// double result10 = windForces.designWindPressure(14, f, 12.5, 175);
		// double result11 = windForces.designWindPressure(14, f, 12.5, 200);
		//
		// double result12 = windForces.designWindPressure(15, f, 12.5, 100);
		// double result13 = windForces.designWindPressure(15, f, 12.5, 150);
		// double result14 = windForces.designWindPressure(15, f, 12.5, 175);
		// double result15 = windForces.designWindPressure(15, f, 12.5, 200);
		//
		// double result16 = windForces.designWindPressure(16, f, 12.5, 100);
		// double result17 = windForces.designWindPressure(16, f, 12.5, 150);
		// double result18 = windForces.designWindPressure(16, f, 12.5, 175);
		// double result19 = windForces.designWindPressure(16, f, 12.5, 200);

		System.out.println(result);
		System.out.println(result1);
		// System.out.println(result2);
		// System.out.println(result3);
		// System.out.println();
		// System.out.println(result4);
		// System.out.println(result5);
		// System.out.println(result6);
		// System.out.println(result7);
		// System.out.println();
		// System.out.println(result8);
		// System.out.println(result9);
		// System.out.println(result10);
		// System.out.println(result11);
		// System.out.println();
		// System.out.println(result12);
		// System.out.println(result13);
		// System.out.println(result14);
		// System.out.println(result15);
		// System.out.println();
		// System.out.println(result16);
		// System.out.println(result17);
		// System.out.println(result18);
		// System.out.println(result19);

	}
}
