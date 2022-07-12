package StepDefinitions;
import Hooks.GlobalHooks;
import Pages.GoogleMainPage;
import Pages.GoogleResultsPage;
import UtilityClasses.BrowserUtils;
import UtilityClasses.JsonReader;
import UtilityClasses.WebDriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    /**
     * The constructor initializes all the website pages required in the test case
     *
     */
    public GoogleSteps(){
        this.driver = GlobalHooks.driver;
        mainPage = new GoogleMainPage();
        resultsPage = new GoogleResultsPage();
    }

    @When("the user inputs Hola as a search value")
    public void the_user_inputs_hola_as_a_search_value() throws InterruptedException {
        logger.info("When the user inputs Hola as a search value");
        logger.debug("Accept use terms");
        mainPage.acceptTerms();
        Thread.sleep(2000);
        logger.debug("Get search data as string from testData.json and input said data");
        String searchValue = jsonReader.getValueFromJson("testData", "searchValue",
                "src/test/resources/testData.json");
        mainPage.inputSearchValue(searchValue);
        Thread.sleep(2000);
    }

    @When("the user clicks the Search button")
    public void the_user_clicks_the_search_button() throws InterruptedException {
        logger.info("And the user clicks the Search button");
        logger.debug("Input ENTER key");
        mainPage.clickSearchButton();
        Thread.sleep(2000);
    }

    @Then("at least one result is displayed")
    public void at_least_one_result_is_displayed() {
        logger.info("Then at least one result is displayed");
        logger.debug("Assert first search result is displayed");
        Assert.assertTrue(resultsPage.isFirstResultDisplayed());
    }

    @AfterStep
    public void getPageSource(Scenario scenario){
        if (scenario.isFailed()){
            utils.takeScreenshot(driver, scenario);
        }
    }
}
