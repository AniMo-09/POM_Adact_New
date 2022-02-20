package com.adact.tests;

import static com.adact.utilities.ExtentReportClass.closeReport;
import static com.adact.utilities.ExtentReportClass.closeTest;
import static com.adact.utilities.ExtentReportClass.extentReportFileName;
import static com.adact.utilities.ExtentReportClass.openReport;
import static com.adact.utilities.ExtentReportClass.openTest;
import static com.adact.utilities.ExtentReportClass.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adact.base.BaseClass;
import com.adact.pages.LoginPage;
import com.adact.utilities.ExtentReportClass;
import com.adact.utilities.GetScreenShot;
import com.adact.utilities.ReadExcelSheet;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends BaseClass
{
	public String imagePath;
	public String methodName;

//	@BeforeSuite
//	public void beforeSuite()
//	{
//		ExtentReportClass.openReport(extentReportFileName());
//	}
//
//	@BeforeMethod
//	public void beforeMethod(ITestResult result)
//	{
//		methodName = result.getMethod().getMethodName();
//		ExtentReportClass.openTest(methodName);
//	}

	@Test(dataProvider = "testdata", invocationCount = 1)
	public void loginTest(String u,String p)
	{
		System.out.println(Thread.currentThread().getId());
		WebDriver initialization = initialization("chrome");
		initialization.get("http://adactinhotelapp.com/HotelAppBuild2/");
		LoginPage loginPage=new LoginPage(initialization);
		loginPage.enterUsername(u);
		loginPage.enterPassword(p);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		loginPage=null;
	}


//	@AfterMethod
//	public void afterMethod(ITestResult result) throws IOException
//	{
//		if (result.getStatus()==ITestResult.SUCCESS) 
//		{
//			ExtentReportClass.test.log(LogStatus.PASS, "Passed");
//		}
//		else if (result.getStatus()==ITestResult.FAILURE)
//		{
//			String screenShot = GetScreenShot.screenShot(driver, methodName);
//			ExtentReportClass.test.log(LogStatus.FAIL, "Failed",ExtentReportClass.test.addScreenCapture(screenShot));
//		}
//		else if (result.getStatus()==ITestResult.SKIP)
//		{
//
//		}
//		closeTest();
//	}
//
//	@AfterSuite
//	public void afterSuite()
//	{
//		closeReport();
//	}

	@DataProvider(name="testdata",parallel = true)
	public Object[][] dp()
	{
		Object[][] readExcelSheet = ReadExcelSheet.readExcelSheet(System.getProperty("user.dir")+"\\src\\main\\java\\com\\adact\\excel\\testdata.xlsx");
		return readExcelSheet;
	}

}
