package com.test.qa.page;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.qa.util.PageObject;
import com.test.qa.util.WebSiteBase;

public class HomePage extends PageObject {
	
	final static Logger logger = Logger.getLogger(HomePage.class);
	
	private WebDriver driver;
	
	public HomePage(String browser) throws Exception{
		driver = new WebSiteBase().initiateBrowser(browser);
		//driver = new AppBaseInfo().getDriver();
		System.out.println("Homepage Constructor");
	}
	
	public void homePage(){
		try{
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("test");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.tagName("body"))).build().perform();
		//driver.findElement(By.tagName("body")).click();
		
		//driver.findElement(By.xpath("//input[contains(@name,'btnK')]")).click();

		logger.info("Home Page loaded");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			logger.info(ex.getMessage());
		}
	}
	
	public void clickMore(){
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//a[contains(@jsname,'LgbsSe')]")));
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);
//		//WebDriverWait driverWait = new WebDriverWait(driver,30);
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//a[contains(@jsname,'LgbsSe')]"))).build().perform();
//		driver.findElement(By.xpath("//a[contains(@jsname,'LgbsSe')]")).click();
//		driver.findElement(By.xpath("//a[contains(@href,'tbm=shop')]")).click();
	}
	
	public void closeBrowser(){
		if(driver != null){
			driver.quit();
			logger.info("closing browser");
		}
	}
	public static void main(String ag[]) throws Exception{
		HomePage pg = new HomePage("chrome");
		pg.homePage();
		pg.clickMore();
		pg.closeBrowser();
	}
}
