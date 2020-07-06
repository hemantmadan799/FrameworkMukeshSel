package com.learnautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsUtil {
	Actions actions;
	public KeyBoardActionsUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		actions.dragAndDrop(src,  dst).build().perform();;
	}
	
	

}
