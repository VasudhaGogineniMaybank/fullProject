package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountsPage = new AccountPage(DriverFactory.getDriver());
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName,password);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
		String accountPageTitle = accountsPage.getAccountPageTitle();
		System.out.println("Accounts Page Title is: " +accountPageTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expectedAccountsSectionList = sectionsTable.asList();
		System.out.println("Expected Accounts Section List: "+expectedAccountsSectionList);
		List<String> actualAccountsSectionList = accountsPage.getAccountSectionsList();
		System.out.println("Actual Accounts Section List: "+actualAccountsSectionList);
		Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
