package cn.sqat.test;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cn.sqat.model.QueryDao;
import cn.sqat.model.ReportBean;

public class ReportTest {
	static ReportBean rb;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@BeforeClass
	public static void testSetup() {
		rb = new ReportBean();
	}
	
	/**
	 * Test for an "empty" month. The queryDao should throw and
	 * illegalstateexception and not proceed with the operations.
	 */
	@Test(expected = IllegalStateException.class)
	public void testExceptionIsThrown() {
		QueryDao tester = new QueryDao();
		rb = new ReportBean();
		/* Format of an empty month is "-01" */
		rb.setMonth("-01");
		tester.submitReport(rb);
	}
	/**
	 * Test for and already reported month. We expect a certain message
	 * with the exception.
	 */
	  @Test
	  public void throwsIllegalArgumentExceptionIfIconIsNull() {
	    exception.expect(IllegalStateException.class);
	    exception.expectMessage("A sales report already exist for 2013-01, please" +
				" select another month.");
	    QueryDao t = new QueryDao();
	    rb.setMonth("2013-01-1");
	    rb.setId(2);
	    t.submitReport(rb);
	  }
}
