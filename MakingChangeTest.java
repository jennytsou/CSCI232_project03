package Project03;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


import org.junit.jupiter.api.Test;

class MakingChangeTest {

	@Test
	void test1() {
		JUnitTesting test1 = new JUnitTesting();
		try {
			int[] arr = null;
			test1.coinChange(arr, 42);
		} catch(NullPointerException exception) {
			System.out.print("NullPointerException Caught");
		}		
	}
	
	@Test
	void test2() {
		JUnitTesting test2 = new JUnitTesting();
		int arr[] = {1,5,10,25};
		int output = test2.coinChange(arr, 42);
		assertEquals("failure output", 5, output);
	}
	
	@Test
	void test3() {
		JUnitTesting test3 = new JUnitTesting();	
		int arr[] = {1,5,10,25};
		int output = test3.coinChange(arr, 100);
		assertEquals("failure output", 4, output);
	}
	
	@Test
	void test4() {
		JUnitTesting test4 = new JUnitTesting();	
		int arr[] = {1,5,10,25};
		int output = test4.coinChange(arr, 59);
		assertEquals("failure output", 7, output);
		}
	
	@Test
	void test5() {
		JUnitTesting test5 = new JUnitTesting();
		int arr[] = {5,10,25};
		int output = test5.coinChange(arr, 59);
		assertEquals("failur output", -1, output);

	}
}
