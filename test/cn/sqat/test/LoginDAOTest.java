package cn.sqat.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cn.sqat.model.LoginBean;
import cn.sqat.model.LoginDao;

/**
 * Test class for testing the LoginDAO where the user input is checked
 * against the DB and authorized or not.
 * @author David Buö
 *
 */
public class LoginDAOTest {
	public static LoginBean loggedInUser;
	
	/**
	 * This method will run before the test case and
	 * initiate the loginBean with the user credentials.
	 */
	@BeforeClass
	public static void testSetup() {
		loggedInUser = new LoginBean();
		loggedInUser.setUserName("zup3rzt4r");
		loggedInUser.setPassword("david");
	}
	
	/**
	 * This is the actual test method that will test
	 * that the user is valid in the system since
	 * it's a correct user.
	 */
//	@Test(timeout=1000)
	@Test
	public void testUserAuthentication() {
		/* We expect the parameter to be true otherwise the test will fail */
		assertTrue("Username/Password incorrect", LoginDao.login(loggedInUser).isValid());
	}
	
	/**
	 * This method will be ignored, if not we will see a failure in the
	 * execution of the test class since Hi != Good bye.
	 */
	@Ignore
	public void testToIgnore(){
		String message = "Good bye";
		assertEquals("Hi", message);
	}
}
