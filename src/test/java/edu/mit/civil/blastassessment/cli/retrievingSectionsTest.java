/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class retrievingSectionsTest {

	@Test
	public void test() {

		Double result = retrievingBeamSections.findBeam(30, 10, 200, 120, 50,
				10, 1);

		System.out.println("result: " + result);

	}

}
