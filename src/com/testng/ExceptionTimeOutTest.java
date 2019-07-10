package com.testng;

//import org.junit.rules.ExpectedException;
import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
//	@Test(timeOut = 2000, expectedExceptions = NumberFormatException.class)
//	public void infinitLoopTest() {
//		int i = 1;
//		while (i == 1) {
//			System.out.println(i);
//		}
//	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}

}
