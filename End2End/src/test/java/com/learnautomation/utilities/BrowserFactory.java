package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			ChromeDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			
		}
		else if (browserName.equals("IE")) {
			
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
