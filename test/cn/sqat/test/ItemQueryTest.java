package cn.sqat.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cn.sqat.model.ItemBean;
import cn.sqat.model.QueryDao;

/**
 * Test class to test the DB query of items.
 * @author David Buö
 *
 */
@RunWith(Parameterized.class)
public class ItemQueryTest {

	private int number;
	
	/**
	 * When using the @RunWith annotation you must have an constructor.
	 * Since we're going to test a different number of item id's we need 
	 * the constructor to take an integer as input.
	 * @param number - The integer that we want to vary
	 */
	public ItemQueryTest(int number) {
		this.number = number;
	}
	
	/**
	 * Our actual test method where the testing is performed. We will try
	 * to query the DB with the different item id and print their name and
	 * price in the console.
	 */
	@Test
	public void testQueryItems() {
		List<ItemBean> temp;
		
		/* Query the DB with the different item id */
		temp = QueryDao.queryItems("SELECT * FROM item WHERE id="+number);
		for(ItemBean ib : temp){
			/* For every Item that is returned we print the name and price*/
			System.out.println("Item name: "+ib.getName()+", price: $"+ib.getPrice());
		}
	}
	
	/**
	 * This is the method were we define the parameter to use as input.
	 * This method must return a collection.
	 * @return A collection of parameters
	 */
	@Parameters
	public static Collection<Object[]> data() {
		/* This is our input parameters, we will test item id: 1, 2 and 3.*/
		Object[][] data = new Object[][] { { 1 }, { 2 }, { 3 } };
		return Arrays.asList(data);
	}
}

