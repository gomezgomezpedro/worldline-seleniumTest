package StepDefinitions;
import Pages.GoogleMainPage;
import Pages.GoogleResultsPage;
import UtilityClasses.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GoogleSteps {
    WebDriver driver;
    WebDriverManager manager = new WebDriverManager();
    GoogleMainPage mainPage;
    GoogleResultsPage resultsPage;

    //This method initializes the driver and all the website pages required in the test case
    @Before
    public void setup(){
        driver = manager.startDriver();
        mainPage = new GoogleMainPage(driver);
        resultsPage = new GoogleResultsPage(driver);
    }

    @When("the user inputs {string} as a search value")
    public void the_user_inputs_as_a_search_value(String searchValue) throws InterruptedException {
        mainPage.acceptTerms();
        Thread.sleep(2000);
        mainPage.inputSearchValue(searchValue);
        Thread.sleep(2000);
    }

    @When("the user clicks the Search button")
    public void the_user_clicks_the_search_button() throws InterruptedException {
        mainPage.clickSearchButton();
        Thread.sleep(2000);
    }

    @Then("at least one result is displayed")
    public void at_least_one_result_is_displayed() {
        Assert.assertTrue(resultsPage.isFirstResultDisplayed());
    }

    @After
    public void tearDown(){
        manager.quitDriver(driver);
    }
}
