package com.test.qa.seltest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.qa.page.HomePage;
import com.test.qa.util.WebSiteBase;

public class HomePageTest {
	private HomePage ghp;
	private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void testBeforeClass(String browser) throws Exception{
		 driver = new WebSiteBase().initiateBrowser(browser);
		//ghp = new HomePage(browser);
		System.out.println("beforeClass");
		
	}
	@Test
	public void testHomePage(){
		try{
		ghp.homePage();
		System.out.println("testHomePage");
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.name("nameTxt")).getText();
		//Assert.assertTrue(Boolean.FALSE);
		softAssert.assertTrue(false);
		
		}catch(Exception ex){
			System.out.println("There is some exception: "+ex.getMessage());
		}
	}
	@Test
	public void testCloseBrowser(){
		System.out.println("close BROWSER is called *************************");
		//driver.quit();
		ghp.closeBrowser();
	}
	@AfterClass
	public void testAfterClass(){
		
		System.out.println("After class is called");
	}
}
