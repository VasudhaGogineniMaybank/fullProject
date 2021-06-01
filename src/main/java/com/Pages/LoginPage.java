package com.Pages;

import org.openqa.selenium.*;

import com.qa.factory.DriverFactory;

public class LoginPage {
	
	//1. By Locator
	private WebDriver driver;

	private By createAccount_EmailID_Locator = By.id("email_create");
	private By createAccount_Button_Locator = By.id("SubmitCreate");

	private By emailID_Locator = By.id("email");
	private By password_Locator = By.id("passwd");
	private By forgotYourPassword_Locator = By.linkText("Forgot your password?");
	private By signinButton_Locator = By.id("SubmitLogin");

	//2. Constructor of the page class: Which holds driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	//3.Page actions: features(behavior) of the page form of methods

	public String getCurrentPageTitle()
	{
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist()
	{
		return driver.findElement(forgotYourPassword_Locator).isDisplayed();
	}

	public void enterEmailAddress(String userName)
	{
		driver.findElement(emailID_Locator).sendKeys(userName);
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(password_Locator).sendKeys(pwd);
	}

	public void clickSigninButton()
	{
		driver.findElement(signinButton_Locator).click();
	}

	public AccountPage doLogin(String un, String pwd)
	{
		driver.findElement(emailID_Locator).sendKeys(un);
		driver.findElement(password_Locator).sendKeys(pwd);
		driver.findElement(signinButton_Locator).click();	
		return new AccountPage(driver);
	}
}
