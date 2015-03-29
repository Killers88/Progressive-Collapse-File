/**
 * 
 */
package edu.mit.civil.memberdesign.calculation;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class beamDesignTest {

	@Test
	public void test() {

		String result = beamDesign.sectionDesign(30, 10, 200, 120, 50, 10, 1);

		System.out.println("result: " + result);

	}

}
