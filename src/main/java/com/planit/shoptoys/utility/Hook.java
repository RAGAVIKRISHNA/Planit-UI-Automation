package com.planit.shoptoys.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {

	private static WebDriver driver;
	

	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
    		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.setHeadless(true);
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
