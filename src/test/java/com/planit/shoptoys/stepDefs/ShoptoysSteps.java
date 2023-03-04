package com.planit.shoptoys.stepDefs;

import com.planit.shoptoys.feedback.pages.ShoptoysPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoptoysSteps extends ShoptoysPage {
	
	public ShoptoysSteps() {
		super();		
    	}

	@Given("^If I wish to shop toys$")
    public void browser_is_opened() {
    	}
	
	@When("^I navigate to the jupitertoys \"([^\"]*)\" URL$")
    public void user_is_navigated_to_URL(String a) throws InterruptedException {
        driver.get(a);    
        Thread.sleep(20);
    }
    
    @When("I click Shop option")
    public void click_shop() throws InterruptedException {
    	Thread.sleep(20);
    	super.click_shop();
    	Thread.sleep(20);
    	}
    
    @When("^I add \"([^\"]*)\" stuffed frogs$")
    public void add_frogs(int noOfFrogs) throws InterruptedException {
    	super.add_itemFrog(noOfFrogs);
    }
    
    @When("^I add \"([^\"]*)\" fluffy bunnies$")
    public void add_itemBunny(int noOfBunnies) throws InterruptedException {
    	super.add_itemBunny(noOfBunnies);
    }
    
    @When("^I add \"([^\"]*)\" Valentine bear$")
    public void add_itemBear(int noOfBears) throws InterruptedException {
    	super.add_itemBear(noOfBears);
    }
    
    @Then("^I click on cart$")
    public void click_cart() throws InterruptedException {
    	super.click_cart();
    }
    
    @Then("^I validate the subtotal of each product$")
    public void validate_subtotal() {
    	super.validate_subtotal();
    }
    
    @Then("^I verify the price of each product$")
    public void validate_price() {
    	super.validate_price();
    }
    
    @Then("^I verify the total is correct$")
    public void verify_total() {
    	super.verify_total();
    }
    
    @Then("^I close the browser instance$")
    public void closeBrowser() throws InterruptedException {
    	driver.quit();
    }
    
    
}
