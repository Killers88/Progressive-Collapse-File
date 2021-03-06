/**
 * 
 */
package edu.mit.civil.columnassessment.calculation;

/**
 * @author koleary
 *
 */
public class AppliedLoadingToColumnQ {

	public static double UNIT_CONVERSIONA = 12;
	public static double UNIT_CONVERSIONB = 6.94444444444;

	public static double calculateAppliedLoading(final double pr,
			final double colwidth, final double colhgt) {

		return (pr / UNIT_CONVERSIONB) * (colwidth / UNIT_CONVERSIONA) * colhgt;
	}

}
