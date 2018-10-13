package com.test.qa.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RediffRegStepDefinition {
	
	@Given("^load user registration page$")
	public void load_user_registration_page() throws Throwable {
		System.out.println("user Registration");
	}

	@When("^click on new user link$")
	public void click_on_new_user_link() throws Throwable {
		System.out.println("click new user link");
	}

	@Then("^enter user details$")
	public void enter_user_details() throws Throwable {
		System.out.println("user details");
	}

	@Then("^click submit$")
	public void click_submit() throws Throwable {
		System.out.println("click submit");
	}
}
