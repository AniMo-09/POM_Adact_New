package com.adact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adact.base.BaseClass;

public class LoginPage extends BaseClass
{	
//	WebDriverWait wait=null;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
//		wait=new WebDriverWait(driver, 30);
	}

	@FindBy(css = "input#username")
	public WebElement username;

	@FindBy(css = "input#password")
	public WebElement password;

	@FindBy(css = "input#login")
	public WebElement loginbutton;

	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}

	public void enterPassword(String passwd)
	{
		password.sendKeys(passwd);
	}

	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
}
