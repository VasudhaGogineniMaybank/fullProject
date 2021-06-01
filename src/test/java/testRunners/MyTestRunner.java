package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src//test//resources//Features"},
					glue = {"StepDefinitions", "AppHooks"},
					plugin = { "pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"timeline:test-output-thread/"},
					monochrome = true)

public class MyTestRunner {

}
