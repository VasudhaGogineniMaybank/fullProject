package StepDefinitions;

import org.junit.Assert;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String ActualPageTitle ;

	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("^user gets the title of the page$")
	public void user_gets_the_title_of_the_page() {
		ActualPageTitle = loginPage.getCurrentPageTitle();
		System.out.println("Page title is: " + ActualPageTitle);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
	    Assert.assertTrue(ActualPageTitle.contains(expectedPageTitle));
	}

	@Then("forget your password link should be displayed")
	public void forget_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterEmailAddress(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);	  
	}

	@When("user clicks on Sign in button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clickSigninButton();
	}

}
