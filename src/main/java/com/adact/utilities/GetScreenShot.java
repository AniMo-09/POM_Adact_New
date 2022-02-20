package com.adact.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;

public class GetScreenShot 
{
	public static String screenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest =System.getProperty("user.dir")+screenshotName+".png";
		File finalDest=new File(dest);
		Files.copy(source, finalDest);
		return dest;
	}
}
