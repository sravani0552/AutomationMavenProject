package stepDefinition;

import hooks.TestHooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SearchSteps {

    WebDriver driver = TestHooks.driver;
    HomePage homepage;
    SearchResultsPage resultpage;
    String SelectedValue;


    @Given("I am on the Amazon home page")
    public void i_am_on_the_Amazon_home_page() throws InterruptedException {
      driver.get("https://www.amazon.in");
      driver.manage().window().maximize();
      Thread.sleep(3000);
      homepage = new HomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String keyword)
    {
        homepage.SearchFor(keyword);
        resultpage = new SearchResultsPage(driver);
    }

    @Then("I should see result for {string}")
    public void i_should_see_result_for(String Keyword)

    {
       assertTrue(resultpage.getSearchHeader().contains(Keyword));
    }


    @When("I click on {string} in category dropdown")
    public void i_click_on_category_dropdown(String CategoryValue)
    {
       SelectedValue =  homepage.SelectCategory(CategoryValue);

    }

    @Then("I should see {string} category is selected")
    public void i_should_see_category_is_selected()
    {
        assertEquals(SelectedValue,"Baby");
    }

    @When("I click on Your Account in Accounts dropdown")
    public void i_click_on_your_account_in_accounts_dropdown()
    {
        homepage.AccountsPage();
    }

    @Then("I should land on Accounts page")
    public void i_should_land_on_accounts_page()
    {
        assertTrue(homepage.AccountsPage().contains("Your Account"));
    }
}
