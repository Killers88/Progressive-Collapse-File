/**
 * 
 */
package edu.mit.civil.sapoutputfile.fem;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class SapTextFileTest {

	@Test
	public void test() {

		String result = SapTextFile.sapFile(25, 10, 120, 90, 8, 4, 12, "TEST2",
				3, 1.1, 0.25, 50, 5, 1, 1.7, 1, 1);

		System.out.println(result);

	}
}
