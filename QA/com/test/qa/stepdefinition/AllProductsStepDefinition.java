package com.test.qa.stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.test.qa.util.PageObject;
import com.test.qa.util.WebSiteBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllProductsStepDefinition extends WebSiteBase{
	
	private static final Logger logger= Logger.getLogger(AllProductsStepDefinition.class);
	
	@Given("^Page has All Products option$")
	public void page_has_All_Products_option() throws Throwable {
		List<WebElement> eles = webdriver.findElements(PageObject.mnuAllProudcts);
		if(eles != null){
			for(WebElement el : eles){
				String txt = el.getText();
				if(txt !=null && txt.equalsIgnoreCase("All Product")){
					el.click();
				}
			}
		}
	}

	@When("^User clicks on All Products$")
	public void user_clicks_on_All_Products() throws Throwable {
		
	}

	@Then("^User is on all products$")
	public void user_is_on_all_products() throws Throwable {
	}
}
