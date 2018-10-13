package com.test.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HWBrowser {
	private static WebDriver driver;
	
	
	public static void waitTillDataLoads() throws Exception{
		driver = new WebSiteBase().initiateBrowser("chrome");
		driver.get("https://www.pge.com/");
		if(driver.findElement(By.xpath("//div[@class='container']/child::div/child::div/child::div/button")).isDisplayed()){
			driver.findElement(By.xpath("//div[@class='container']/child::div/child::div/child::div/button")).click();
		}
	    WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement input = driver.findElement(By.name("username"));
		input.click();
		input.sendKeys("username1111");
		//((JavascriptExecutor) driver).executeScript("$(arguments[0]).change(); return true;", input);
	}
	public static void main(String ag[]) throws Exception{
		waitTillDataLoads();
	}
}
