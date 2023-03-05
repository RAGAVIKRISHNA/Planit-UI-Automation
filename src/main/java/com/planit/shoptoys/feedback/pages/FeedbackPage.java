package com.planit.shoptoys.feedback.pages;

import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.shoptoys.utility.Hook;

public class FeedbackPage {
  public WebDriver driver;
  String userForeName;
  String userSurName;
  String userPhone;
  String userEmail;
  String userFeedbackMessage;
  
  private StringBuffer verificationErrors = new StringBuffer();
  
  @FindBy(xpath="//a[contains(text(),'Contact')]")
  public WebElement contact;
  
  @FindBy(xpath="//a[contains(text(),'Submit')]")
  public WebElement submitFeedback;
  
  @FindBy(xpath="//input[@id='forename']")
  public WebElement enterForename;
  
  @FindBy(xpath="//input[@id='email']")
  public WebElement enterEmail;
  
  @FindBy(xpath="//textarea[@id='message']")
  public WebElement enterFeedbackMessage;
	    
  @FindBy(xpath="//span[contains(text(),'Forename is required')]")
  public WebElement requiredName;
  
  @FindBy(xpath="//span[contains(text(),'Email is required')]")
  public WebElement requiredEmail;
  
  @FindBy(xpath="//span[contains(text(),'Message is required')]")
  public WebElement requiredMessage;
  
  @FindBy(xpath="/html/body/div[2]/div/div")
  public WebElement successFeedbackResponse;
  
  public FeedbackPage()  {
	 this.driver = Hook.getDriver();
	 PageFactory.initElements(driver, this);
  }
  
  public void click_contact() throws InterruptedException {
	  Thread.sleep(100);
	  contact.click();
	  Thread.sleep(20);
  }
 
  public void submit_feedback() throws InterruptedException {
	 submitFeedback.click();
	 Thread.sleep(20);
  }
  
  public void validate_errors() {
	 
	 try {
	       assertTrue(requiredName.getText().matches("^[\\s\\S]is required[\\s\\S]*$"));
	     } catch (Error e) {
	       verificationErrors.append(e.toString());
	     }
	   }
	 
  public void enter_foreName() throws InterruptedException {
		 enterForename.sendKeys(userForeName);
		 Thread.sleep(10);
  }
  public void enter_message() throws InterruptedException {
		 enterFeedbackMessage.sendKeys(userFeedbackMessage);
		 Thread.sleep(10);
  }
  public void enter_email() throws InterruptedException {
		 enterEmail.sendKeys(userEmail);
		 Thread.sleep(10);
  }
  
  public void validate_successResponse() {
		 
		 try {
		       assertTrue(successFeedbackResponse.getText().matches("^Thanks" + userForeName + ", we appreciate your feedback.*$"));
		     } catch (Error e) {
		       verificationErrors.append(e.toString());
		     }
		   }
		     
  public void provide_foreName(String forename)
  {
	  userForeName = forename;
  }
  
  public void provide_message(String message)
  {
	  userFeedbackMessage = message;
  }
  
  public void provide_email(String email)
  {
	  userEmail = email;
  }

public String getUserForeName() {
	return userForeName;
}

public void setUserForeName(String userForeName) {
	this.userForeName = userForeName;
}

public String getUserSurName() {
	return userSurName;
}

public void setUserSurName(String userSurName) {
	this.userSurName = userSurName;
}

public String getUserPhone() {
	return userPhone;
}

public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public String getUserFeedbackMessage() {
	return userFeedbackMessage;
}

public void setUserFeedbackMessage(String userFeedbackMessage) {
	this.userFeedbackMessage = userFeedbackMessage;
} 
  
}
