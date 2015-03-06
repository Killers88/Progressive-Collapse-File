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

		String result = SapTextFile.sapFile(18, 6, 14, 24, 80, 95, 10);

		System.out.println(result);

	}
}
