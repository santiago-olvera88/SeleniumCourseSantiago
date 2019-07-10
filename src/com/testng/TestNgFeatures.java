package com.testng;

import org.testng.annotations.Test;

public class TestNgFeatures {
	
	@Test
	public void loginTest() {
		System.out.println("Logitn Test");
		//int i = 9/0;
	}

	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void SearchPage() {
		System.out.println("Search Page Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void RegPageTest() {
		System.out.println("Reg Page Test");
	}
}
