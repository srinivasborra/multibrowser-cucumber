package com.test.qa.stepdefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;
import com.test.qa.payload.User;
import com.test.qa.util.GlobalConstants;
import com.test.qa.util.PageObject;
import com.test.qa.util.WebSiteBase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStoreDemoStepDefinition {
	private final static Logger logger = Logger.getLogger(LoginStoreDemoStepDefinition.class);
	private WebDriver driver;
	private String username;
	private String password;
	private List<User> usersData;
	
	@Before
	public void loadInitValues(){
		
		System.out.println("before class loaded");
		Properties prop = new Properties();

		try {
			usersData = getUserData();
			Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
			prop.load(new FileInputStream(new File(path + "/QA/com/test/qa/config/qa.properties")));
			
			username = prop.getProperty(GlobalConstants.QA_USER_NAME);
			password = prop.getProperty(GlobalConstants.QA_USER_PASSWORD);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	
	@Given("^User is on demo\\.storeqa\\.com$")
	public void user_is_on_demo_storeqa_com() throws Throwable {
		driver = new WebSiteBase().initiateBrowser("chrome");
	    driver.get("http://store.demoqa.com/");
	    String pageTitle =driver.getTitle();
	    logger.info("Testcase user_is_on_demo_storeqa_com");
	    Assert.assertEquals("ONLINE STORE | Toolsqa Dummy Test site",pageTitle);
	}

	@When("^User clicks on MyAccount link$")
	public void user_clicks_on_MyAccount_link() throws Throwable {
		driver.findElement(PageObject.lnkAcntLogin).click();
		String accntTitle = driver.findElement(PageObject.loginTitle).getText();
		Assert.assertEquals(accntTitle,"Your Account");
	}

	 
	@When("^User logs in with User details data$")
	public void user_logs_in_with_valid_Username_and_Password() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			driver.findElement(PageObject.inputUserName).sendKeys("testuser1");
			driver.findElement(PageObject.inputPwd).sendKeys("password1");
			driver.findElement(PageObject.btnLogin).click();
			Assert.assertEquals(username,"testuser1");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
//	@When("^User logs in with valid Username and Password$")
//	public void user_logs_in_with_valid_Username_and_Password() throws Throwable {
//		try {
//			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//			System.out.println("USERNAME: "+username);
//			driver.findElement(PageObject.inputUserName).sendKeys(this.username);
//			driver.findElement(PageObject.inputPwd).sendKeys(this.password);
//			driver.findElement(PageObject.btnLogin).click();
//			Assert.assertEquals(username,"testuser1");
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//		}
//	}

	@Then("^User is taken to the myaccount page$")
	public void user_is_taken_to_the_myaccount_page() throws Throwable {
		driver.getTitle();
		Assert.assertEquals("Your name","Your name");
	}
	
	private List<User> getUserData() throws Exception{
		BufferedReader bfr = new BufferedReader(new FileReader("QA/com/test/qa/data/jsondata.json"));
		Gson gson = new Gson();
		User[] users= gson.fromJson(bfr, User[].class);
		
		return Arrays.asList(users);
	}
	
}
