package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Log;

public class LoginPage {
	WebDriver driver;
	
	//this is new commit from Hemant
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
//		PageFactory.initElements(driver, LoginPage.class);
	}
	@FindBy(xpath="//span[text()='Log In']") WebElement btnLogin;
	@FindBy(xpath="//input[@name='email']") WebElement uName;
	@FindBy(xpath="//input[@name='password']") WebElement pword;
	@FindBy(xpath="//div[text()='Login']") WebElement loginButton;
	public void loginToCRM(String uname, String pass) 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnLogin.click();
		uName.sendKeys(uname);
		pword.sendKeys(pass);
		loginButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
