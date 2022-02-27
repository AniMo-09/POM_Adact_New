package com.adact.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adact.base.BaseClass;
import com.adact.pages.LoginPage;
import com.adact.utilities.ReadExcelSheet;


public class LoginTest extends BaseClass
{
	public String imagePath;
	public String methodName;
	public LoginPage loginPage;
	public WebDriver initialization;

	@BeforeMethod
	public void beforeMethod()
	{
		initialization = initialization("chrome");
	}

	@Test(dataProvider = "testdata")
	public void loginTest(String u,String p)
	{
		initialization.get("http://adactinhotelapp.com/HotelAppBuild2/");
		loginPage=new LoginPage(initialization);
		loginPage.enterUsername(u);
		loginPage.enterPassword(p);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
	}

	@AfterMethod
	public void afterMethod()
	{
		initialization.quit();
	}

	@DataProvider(name="testdata")
	public Object[][] dp()
	{
		Object[][] readExcelSheet = ReadExcelSheet.readExcelSheet(System.getProperty("user.dir")+"//src//main//java//com//adact//excel//testdata.xlsx");
		return readExcelSheet;

		//		Object[][] obj = new Object[2][2];
		//		obj[0][0]="harshit111";
		//		obj[0][1]="aaa12345";
		//		obj[1][0]="iamaniket007";
		//		obj[1][1]="SN1QXC";
		//
		//		return obj;
	}

}
