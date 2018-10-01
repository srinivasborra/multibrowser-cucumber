Feature: Login tests 

	This feature file contains all login tests

@SmokeTest @EndToEndTest 
Scenario: Verify that user is able to login with valid username and password 
	Given User is on demo.storeqa.com 
	When User clicks on MyAccount link 
	#And User logs in with valid Username and Password
	Then User logs in with User details data
	Then User is taken to the myaccount page 
	
@RegressionTest 
Scenario: Verify list of products in storeqa 
	Given Page has All Products option 
	When User clicks on All Products 
	Then User is on all products 
	
@RegressionTest 
Scenario: Register as a new user by clicking Register link 
	Given User is on Account Page 
	When User clicks on Register link 
	Then Confirm User is on Register Page 
	Then Check inputs and register buttons are enabled 
	Then Check empty values 
	Then Check invalid username 
	Then Check invalid email 
	Then Enter Username and Email 
	Then User clicks Register button 

@RestTest 
Scenario: select user details from api
	Given api request to the server
	When api loaded confirmation
	Then select specific user details
	

@RegressionTest	
Scenario: Close browser at the end 
	Then close browser 
	
