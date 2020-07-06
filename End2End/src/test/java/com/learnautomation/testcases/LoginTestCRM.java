package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp()
	{
		logger=report.createTest("Login Functionality");
		LoginPage loginPage=PageFactory.initElements(driver,  LoginPage.class);
		logger.log(Status.INFO, "Starting application");
		loginPage.loginToCRM(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		logger.pass("Login successfully");
	}
	
	

}
