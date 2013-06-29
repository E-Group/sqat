package cn.sqat.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cn.sqat.model.QueryDao;
import cn.sqat.model.ReportBean;

/**
 * Test class for testing that an IllegalStateException is thrown
 * when trying to insert an already reported month into the database.
 * @author David Buö
 *
 */
public class ReportTest {
	public static ReportBean reportBeanToSend;

	/**
	 * This method will run before the test case and
	 * initiate the ReportBean with a reported month.
	 */
	@BeforeClass
	public static void testSetup() {
		reportBeanToSend = new ReportBean();
		reportBeanToSend.setId(2);
	}

	/**
	 * Our test method that will expect an IllegalStateException.
	 * If that exceptions isn't thrown the test will fail.
	 */
	@Test(expected = IllegalStateException.class)
	public void testException() {
		/* This month is already reported and should throw and exception. */
		reportBeanToSend.setMonth("2013-01-01");
		/* This is the method we expect to throw an IllegalStateException */
		QueryDao.submitReport(reportBeanToSend);
	}

	@Rule
	/* With @Rule you can create objects which can be used and
	 * configured in your test methods.*/
	public ExpectedException exception = ExpectedException.none();

	@Ignore//	@Test
	public void testEmptyMonthExceptionMessage() {
		exception.expect(IllegalStateException.class);
		/* The exception message we expect for this kind of exception */
		exception.expectMessage("Please select a Month.");
		/* An empty month that will should the message above */
		reportBeanToSend.setMonth("-01");
		QueryDao.submitReport(reportBeanToSend);
	}
}
