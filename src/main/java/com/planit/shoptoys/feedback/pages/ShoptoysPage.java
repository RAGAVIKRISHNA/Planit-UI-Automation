package com.planit.shoptoys.feedback.pages;

import org.junit.Assert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.planit.shoptoys.utility.Hook;

public class ShoptoysPage {
	
  private static final String valentineBearPrice = "14.99";

  private static final String fluffyBunnyPrice = "9.99";

  private static final String stuffedFrogPrice = "10.99";

  private StringBuffer verificationErrors = new StringBuffer();
  
  public WebDriver driver;
  
  public Float product1;
  public Float product2;
  public Float product3;
  
  public Float frogPrice;
  public Float bunnyPrice;
  public Float bearPrice;
  
  @FindBy(xpath="//a[contains(text(),'Shop')]")
  public WebElement shop;
  
  @FindBy(xpath="//li[@id='product-2']//a")
  public WebElement stuffedFrog;
  
  @FindBy(xpath="//li[@id='product-4']//a")
  public WebElement fluffyBunny;
  
  @FindBy(xpath="//li[@id='product-7']//a")
  public WebElement valentineBear;
  
  @FindBy(xpath="//a[contains(text(),'Cart')]")
  public WebElement cart;
  
  @FindBy(xpath="(//td[3])[1]//input")
  public WebElement quantity_product1;
  
  @FindBy(xpath="(//td[3])[2]//input")
  public WebElement quantity_product2;
  
  @FindBy(xpath="(//td[3])[3]//input")
  public WebElement quantity_product3;
  
  @FindBy(xpath="(//td[4])[1]")
  public WebElement subTotal_product1;
  
  @FindBy(xpath="(//td[4])[2]")
  public WebElement subTotal_product2;
  
  @FindBy(xpath="(//td[4])[3]")
  public WebElement subTotal_product3;
  
  @FindBy(xpath="(//td[2])[1]")
  public WebElement product1_price;
  
  @FindBy(xpath="(//td[2])[2]")
  public WebElement product2_price;
  
  @FindBy(xpath="(//td[2])[3]")
  public WebElement product3_price;
  
  @FindBy(xpath="//strong[contains(text(),'Total')]")
  public WebElement total;
  	
  public ShoptoysPage()  {
		 this.driver = Hook.getDriver();
		 PageFactory.initElements(driver, this);
	  }

  public void click_shop() throws InterruptedException {
	  shop.click();
  }
  

  public void click_cart() throws InterruptedException {
	  cart.click();
  }
  
  public void add_itemFrog(int noOfTimes) throws InterruptedException {
  for (int i = 0; i < noOfTimes; i++) {
		stuffedFrog.click();
	}
  }
  
  public void add_itemBunny(int noOfTimes) throws InterruptedException {
	  for (int i = 0; i < noOfTimes; i++) {
			fluffyBunny.click();
		}
	  }
  
  public void add_itemBear(int noOfTimes) throws InterruptedException {
	  for (int i = 0; i < noOfTimes; i++) {
			valentineBear.click();
		}
	  }
  
  public void validate_subtotal() {
	  try {
		   product1 = Float.valueOf(subTotal_product1.getText().substring(1));
		   product2 = Float.valueOf(subTotal_product2.getText().substring(1));
		   product3 = Float.valueOf(subTotal_product3.getText().substring(1));
		   
		   Float product1_quantity = Float.valueOf(quantity_product1.getAttribute("value"));
	       Float product2_quantity = Float.valueOf(quantity_product2.getAttribute("value"));
		   Float product3_quantity = Float.valueOf(quantity_product3.getAttribute("value"));
		   
		   Assert.assertTrue("Product1 subtotal is incorrect", (product1).equals(product1_quantity * frogPrice));
		   Assert.assertTrue("Product2 subtotal is incorrect", (product2).equals(product2_quantity * bunnyPrice));
		   Assert.assertTrue("Product3 subtotal is incorrect", (product3).equals(product3_quantity * bearPrice));
		
  }
	  catch (Error e) {
	       verificationErrors.append(e.toString());
	     }
  }
  
  public void validate_price() {
	  try {
		  
		  frogPrice = Float.parseFloat(product1_price.getText().substring(1));
		  bunnyPrice = Float.valueOf(product2_price.getText().substring(1));
		  bearPrice = Float.valueOf(product3_price.getText().substring(1));
		  
		  Assert.assertTrue("price of product1 is incorrect", (product1_price).equals(stuffedFrogPrice));
		  Assert.assertTrue("price of product2 is incorrect", (product2_price).equals(fluffyBunnyPrice));
		  Assert.assertTrue("price of product3 is incorrect", (product3_price).equals(valentineBearPrice));
  }
	  catch (Error e) {
	       verificationErrors.append(e.toString());
	     }
  }
  
  
  public void verify_total() {
	  Assert.assertTrue("The total for three products is incorrect", Float.valueOf(total.getText().substring(7)).equals(Float.sum(Float.sum(product1, product2), product3)));
  }
  
}
