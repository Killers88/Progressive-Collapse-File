/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.IOException;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.Test;

/**
 * @author koleary
 *
 */
public class SpreadsheetOutputTest {

	@Test
	public void test() throws RowsExceededException, WriteException,
			IOException {

		SpreadsheetOutput.test();

	}

}
