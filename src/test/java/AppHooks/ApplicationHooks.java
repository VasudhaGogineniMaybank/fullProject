package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop; //Initializing this for holding properties.
	
	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfigReader(); //For getting the properties from configReader class
		prop = configReader.init_prop(); //This method we are calling from ConfigReader class. This will initialize the property. Store this value is prop object
		
	}
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser"); //This browser is coming from config.properties file browser = chrome
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	/**
	 * This tearDown method is for tacking the screenshot of failed scenario
	 */
	@After(order =1) 
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//Take screenshot logic here
			String ScreenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); //It will take screenshot and store it on SourcePath
			
			scenario.attach(SourcePath, "image/png", ScreenshotName);
		}
	}
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit(); //This will give null. To avoid this error store driver value as: driver = driverFactory.init_driver(browserName); in launchBrowser method
	}

}
