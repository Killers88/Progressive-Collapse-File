/**
 * 
 */
package edu.mit.civil.blastassessment.cli;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @author koleary
 *
 */
public class SpreadsheetOutput {

	public static void test() throws IOException, RowsExceededException,
			WriteException {

		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				"///Users/koleary/Desktop/output.xls"));
		WritableSheet sheet = workbook.createSheet("Data", 0);

		Label label = new Label(0, 0, "lksdfbnvlwjb");
		sheet.addCell(label);

		Number number = new Number(1, 0, 1.618);
		sheet.addCell(number);

		Label label1 = new Label(2, 0, "Ali Gajani");
		sheet.addCell(label1);

		workbook.write();
		workbook.close();

	}
}
