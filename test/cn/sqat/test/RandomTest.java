package cn.sqat.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomTest {

	@Before //This is called an Annotation
	public void setup(){
		/* Initialize something */
		
	}

	@Test
	public void test() {
		assertEquals("hi","hi"); // This is called an Assertion
	}

	@After 
	public void clean(){
		/* Clean something */
	}

}
