package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM" + Helper.getCurrentDateTime() + ".html"));
		// TODO Auto-generated method stub
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getQAUrl());
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}
		else if (result.getStatus() == ITestResult.SUCCESS)
			logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		report.flush();

	}
}
