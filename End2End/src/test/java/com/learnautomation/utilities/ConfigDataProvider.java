package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider()
	{
		File configFile=new File("./Config/Config.properties");
		try {
		FileInputStream configInputStream=new FileInputStream(configFile);
			prop = new Properties();
			prop.load(configInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load config file"+e.getMessage());
		}
	}
	public String getDataFromConfig(String key)
	{
		return prop.getProperty(key);
	}
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	public String getQAUrl() {
		return prop.getProperty("QaURL");
	}
}
