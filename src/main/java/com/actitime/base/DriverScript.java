package com.actitime.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Name: Driver Script
 * Author: Upama
 * Description: Driver Driver 
 * Date Last Modified: 02/02/2022
 */


public class DriverScript {
	
	public static WebDriver driver;
	Properties prop;
	
	public DriverScript()
	{
		try
		{
		File src = new File("./acconfig/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		}
		
		catch(Exception e)
		{
			System.out.println("Properties file not found. Please check"+e.getMessage());
		}
		
	}
	

	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./acbrowsers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./acbrowsers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./acbrowsers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./acbrowsers/IEDriverServer.exe");
		}
		
		else
		{
			System.out.println("this browser is not supported please check config file");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String url = prop.getProperty("testurl");
		driver.get(url);
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
	

}
