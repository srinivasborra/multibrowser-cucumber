package com.test.qa.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefinition {
	@Given("^User is on Account Page$")
	public void user_is_on_Account_Page() throws Throwable {
		System.out.println("user is on Account page");
	}

	@When("^User clicks on Register link$")
	public void user_clicks_on_Register_link() throws Throwable {
	}

	@Then("^Confirm User is on Register Page$")
	public void confirm_User_is_on_Register_Page() throws Throwable {
	}

	@Then("^Check inputs and register buttons are enabled$")
	public void check_inputs_and_register_buttons_are_enabled() throws Throwable {
	}

	@Then("^Check empty values$")
	public void check_empty_values() throws Throwable {
	}

	@Then("^Check invalid username$")
	public void check_invalid_username() throws Throwable {
	}

	@Then("^Check invalid email$")
	public void check_invalid_email() throws Throwable {
	}

	@Then("^Enter Username and Email$")
	public void enter_Username_and_Email() throws Throwable {
	}

	@Then("^User clicks Register button$")
	public void user_clicks_Register_button() throws Throwable {
	}
	
}
