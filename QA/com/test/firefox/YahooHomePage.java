package com.test.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.qa.page.HomePage;
import com.test.qa.util.WebSiteBase;

public class YahooHomePage {
	private HomePage ghp;
	private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void testBeforeClass(String browser) throws Exception{
		driver = new WebSiteBase().initiateBrowser(browser);
		System.out.println("beforeClass");
		
	}
	@Test
	public void testHomePage(){
		try{
		driver.get("https://www.yahoo.com/");
		System.out.println("testHomePage"+driver.getTitle());
		
		Assert.assertTrue(Boolean.TRUE);
		}catch(Exception ex){
			System.out.println("There is some exception: "+ex.getMessage());
		}
	}
}
