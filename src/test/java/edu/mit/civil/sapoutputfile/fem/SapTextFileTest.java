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

		String result = SapTextFile.sapFile(15, 4, 12, 24, 0.08, 0.095, 10);

		System.out.println(result);

	}
}
