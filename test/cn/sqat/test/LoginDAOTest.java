package cn.sqat.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.sqat.model.LoginBean;
import cn.sqat.model.LoginDao;

public class LoginDAOTest {
	public static LoginBean lb;
	
	@BeforeClass
	public static void testSetup() {
	}

	@Test
	public void testCorrectUserInformation() {
		lb = new LoginBean();
		lb.setUserName("david");
		lb.setPassword("david");
		
		LoginDao ld = new LoginDao();
		LoginBean lbFromDb = ld.login(lb);
		
		assertTrue("Username/Password incorrect", lbFromDb.isValid());
	}
	
	@Test
	public void testWrongUsername() {
		lb = new LoginBean();
		lb.setUserName("avid");
		lb.setPassword("david");
		
		LoginDao ld = new LoginDao();
		LoginBean lbFromDb = ld.login(lb);
		
		assertFalse("Username should not be correct",lbFromDb.isValid());
	}

	@Test
	public void testWrongPass() {
		lb = new LoginBean();
		lb.setUserName("david");
		lb.setPassword("avid");
		
		LoginDao ld = new LoginDao();
		LoginBean lbFromDb = ld.login(lb);
		
		assertFalse("Password should not be correct",lbFromDb.isValid());
	}
	
	@Test
	public void testWrong() {
		lb = new LoginBean();
		lb.setUserName("avid");
		lb.setPassword("avid");
		
		LoginDao ld = new LoginDao();
		LoginBean lbFromDb = ld.login(lb);
		
		assertFalse("Userinformation should not be correct",lbFromDb.isValid());
	}
}
