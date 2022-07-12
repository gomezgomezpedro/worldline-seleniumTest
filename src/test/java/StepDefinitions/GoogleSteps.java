package StepDefinitions;
import Pages.GoogleMainPage;
import Pages.GoogleResultsPage;
import UtilityClasses.BrowserUtils;
import UtilityClasses.JsonReader;
import UtilityClasses.WebDriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSteps {
    WebDriver driver;
    WebDriverManager manager = new WebDriverManager();
    BrowserUtils utils = new BrowserUtils();
    GoogleMainPage mainPage;
    GoogleResultsPage resultsPage;
    Logger logger = LoggerFactory.getLogger(GoogleSteps.class);
    JsonReader jsonReader = new JsonReader();

    //This method initializes the driver and all the website pages required in the test case
    @Before
    public void setup(Scenario scenario){
        logger.info("Scenario: " + scenario.getName());
        driver = manager.startDriver();
        mainPage = new GoogleMainPage(driver);
        resultsPage = new GoogleResultsPage(driver);
    }

    @When("the user inputs Hola as a search value")
    public void the_user_inputs_hola_as_a_search_value() throws InterruptedException {
        logger.info("When the user inputs Hola as a search value");
        mainPage.acceptTerms();
        Thread.sleep(2000);
        String searchValue = jsonReader.getValueFromJson("searchValue",
                "src/test/resources/testData.json");
        mainPage.inputSearchValue(searchValue);
        Thread.sleep(2000);
    }

    @When("the user clicks the Search button")
    public void the_user_clicks_the_search_button() throws InterruptedException {
        logger.info("And the user clicks the Search button");
        mainPage.clickSearchButton();
        Thread.sleep(2000);
    }

    @Then("at least one result is displayed")
    public void at_least_one_result_is_displayed() {
        logger.info("Then at least one result is displayed");
        Assert.assertTrue(resultsPage.isFirstResultDisplayed());
    }

    @AfterStep
    public void getPageSource(Scenario scenario){
        if (scenario.isFailed()){
            utils.takeScreenshot(driver);
        }
    }
    @After
    public void logTestResult(Scenario scenario){
        logger.info("TEST RESULT: " + scenario.getStatus().toString());
    }
    @After
    public void tearDown(){
        manager.quitDriver(driver);
    }
}
