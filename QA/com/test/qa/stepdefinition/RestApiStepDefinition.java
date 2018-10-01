package com.test.qa.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class RestApiStepDefinition {
	
	@Given("^api request to the server$")
	public void api_request_to_the_server() throws Throwable {
	   System.out.println("Rest API Test begining");
	   
	}

	@When("^api loaded confirmation$")
	public void api_loaded_confirmation() throws Throwable {
	}

	@Then("^select specific user details$")
	public void select_specifi_user_details() throws Throwable {
	}
}
