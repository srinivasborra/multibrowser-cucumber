package com.test.qa.seltest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.qa.page.HomePage;

public class HomePageTest {
	private HomePage ghp;
	
	@Parameters("browser")
	@BeforeClass
	public void testBeforeClass(String browser) throws Exception{
		ghp = new HomePage(browser);
		System.out.println("beforeClass");
		
	}
	@Test
	public void testHomePage(){
		ghp.homePage();
		System.out.println("testHomePage");
		Assert.assertTrue(Boolean.TRUE);
	}
	@Test
	public void testCloseBrowser(){
		ghp.closeBrowser();
	}
	@AfterClass
	public void testAfterClass(){
		
		System.out.println("After class is called");
	}
}
