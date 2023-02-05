package StepDefinitions;

import Hooks.GlobalHooks;
import Pages.AmazonCartPage;
import Pages.AmazonMainPage;
import Pages.AmazonPDPage;
import Pages.AmazonPLPage;
import UtilityClasses.BrowserUtils;
import UtilityClasses.JsonReader;
import UtilityClasses.WebDriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmazonSteps {
    WebDriver driver;
    WebDriverManager manager = new WebDriverManager();
    BrowserUtils utils = new BrowserUtils();
    AmazonMainPage mainPage;
    AmazonPLPage productListPage;
    AmazonPDPage productDetailPage;
    AmazonCartPage cartPage;
    Logger logger = LoggerFactory.getLogger(AmazonSteps.class);
    JsonReader jsonReader = new JsonReader();

    /**
     * The constructor initializes all the website pages required in the test case
     */
    public AmazonSteps() {
        this.driver = GlobalHooks.driver;
        mainPage = new AmazonMainPage();
        productListPage = new AmazonPLPage();
        productDetailPage = new AmazonPDPage();
        cartPage = new AmazonCartPage();
    }

    @Given("the user accepts the cookie preferences")
    public void the_user_accepts_the_cookie_preferences() throws InterruptedException {
        //logger.info("Given the user accepts the cookie preferences");
        logger.debug("Click Accept cookies button");
        mainPage.acceptCookies();
        Thread.sleep(2000);
    }

    @When("the user types {} in the search bar")
    public void the_user_types_search_term_in_the_search_bar(String search_term) throws InterruptedException {
        //logger.info("When the user types " + searchTerm + " in the search bar");
        logger.debug("Type searchTerm in the search bar");
        mainPage.searchProduct(search_term);
        Thread.sleep(2000);
    }

    @When("clicks the submit search button")
    public void clicks_the_submit_search_button() throws InterruptedException {
        //logger.info("And clicks the submit search button");
        logger.debug("Click submit search button");
        mainPage.submitSearch();
        Thread.sleep(2000);
    }

    @Then("at least one result is displayed")
    public void at_least_one_result_is_displayed() {
        //logger.info("Then at least one result is displayed");
        logger.debug("Assert first search result is displayed");
        Assert.assertTrue(productListPage.isFirstResultDisplayed());
    }

    @When("the user accesses the first result product page")
    public void the_user_accesses_the_first_result_product_page() throws InterruptedException {
        //logger.info("When the user accesses the first result product page");
        logger.debug("Click first result title");
        productListPage.clickFirstResult();
        Thread.sleep(2000);
    }

    @When("adds the product to the cart")
    public void adds_the_product_to_the_cart() throws InterruptedException {
        //logger.info("And adds the product to the cart");
        logger.debug("Click Add to cart button");
        productDetailPage.clickAddCartButton();
        Thread.sleep(2000);
    }

    @When("accesses the cart page")
    public void accesses_the_cart_page() throws InterruptedException {
        //logger.info("And accesses the cart page");
        logger.debug("Click Access cart button");
        mainPage.clickCartButton();
        Thread.sleep(2000);
        /*productDetailPage.clickRejectRecommendationsButton();
        Thread.sleep(2000);*/
    }

    @Then("the product previously added to the cart is displayed correctly")
    public void the_product_previously_added_to_the_cart_is_displayed_correctly() {
        //logger.info("Then the product previously added to the cart is displayed correctly");
        logger.debug("Product added to the cart is displayed correctly");
        Assert.assertTrue(cartPage.isFirstAddedProductDisplayed());
    }

    @AfterStep
    public void getPageSource(Scenario scenario) {
        if (scenario.isFailed()) {
            utils.takeScreenshot(driver, scenario);
        }
    }
}
