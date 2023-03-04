package com.planit.shoptoys.stepDefs;

import java.util.concurrent.TimeUnit;

import com.planit.shoptoys.feedback.pages.FeedbackPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeedbackSteps extends FeedbackPage{
		
	public FeedbackSteps() {
		super();		
    	}

    @Given("^If you wish to submit a feedback$")
    public void browser_is_opened() {
    	}
    
    @When("^I navigate to \"([^\"]*)\" URL$")
    public void user_is_navigated_to_URL(String a) throws InterruptedException {
        driver.get(a);    
        Thread.sleep(20);
    }
    
    @When("I click Contact Option")
    public void click_contact() throws InterruptedException {
    	Thread.sleep(20);
    	super.click_contact();
    	Thread.sleep(20);
    	}
    
    @Then("^I submit the feedback form without filling mandatory fields$")
    public void submit_feedback() throws InterruptedException {
    	super.submit_feedback();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }	
    
    @Then("^I validate the errors appear on the screen$")
    public void validate_errors() {    		
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	super.validate_errors();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @When("^I provide the forename as \"([^\"]*)\"$")
    public void enter_foreName(String foreName) throws InterruptedException {
    	super.provide_foreName(foreName);
    	super.enter_foreName();
    }
    
    @When("^I provide the message as \"([^\"]*)\"$")
    public void enter_message(String message) throws InterruptedException {
    	super.provide_message(message);
    	super.enter_message();
    }
    
    @When("^I provide the email as \"([^\"]*)\"$")
    public void enter_email(String email) throws InterruptedException {
    	super.provide_email(email);
    	super.enter_email();
    }
    
    @Then("^I click on Submit button$")
    public void submitFeedback() throws InterruptedException {
    	super.submit_feedback();
    }
    
    @Then("^I close the browser$")
    public void closeBrowser() throws InterruptedException {
    	driver.quit();
    }
    
    @Then("^I validate the feedback has been submitted successfully$")
    public void validate_successResponse() {
    	super.validate_successResponse();
    }
    
}