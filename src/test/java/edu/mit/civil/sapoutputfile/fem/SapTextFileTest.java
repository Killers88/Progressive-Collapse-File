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

		String result = SapTextFile.sapFile(7, 8, 10, 20, 0.08, 0.095, 10);

		System.out.println(result);

	}
}
