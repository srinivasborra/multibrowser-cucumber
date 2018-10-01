package com.test.qa.stepdefinition;

import org.apache.log4j.Logger;

import com.test.qa.util.WebSiteBase;

import cucumber.api.java.en.Then;

public class QuitBrowserStepDefinition extends WebSiteBase{
	
	private final static Logger logger = Logger.getLogger(QuitBrowserStepDefinition.class);
	
	@Then("^close browser$")
	public void close_browser() throws Throwable {
		logger.info("Thank you! Happy Testing");
		if(webdriver != null){
			webdriver.quit();
		}
	}
}
