package com.adact.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public static WebDriver driver;
	
	public static WebDriver initialization(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return driver;
	}
}
