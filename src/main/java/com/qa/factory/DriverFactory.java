package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the ThreadLocal driver on the basis of given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser Value is: " +browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari"))
		{
			//For safari we don't have binary
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies(); //This will delete all the cookies from the browser
		getDriver().manage().window().maximize();  // This will maximize the browser
		return getDriver(); // It gets the driver and whatever the current instance is going on of the WebDriver will be given
	}
	
	/**
	 * This is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() //Multiple threads are running in parallel execution five threads are running together and they all will be calling this getDriver method. So all the threads should be in sync so i am using Synchronized here 
	{
		return tlDriver.get();
		
	}
}
