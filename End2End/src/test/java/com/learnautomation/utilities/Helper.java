package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenShot(WebDriver driver)
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dst=new File("./Screenshots/"+filename+"_"+getCurrentDateTime()+".png");
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		try {
			FileUtils.copyFile(src,  new File(screenshotPath));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	
	

}
