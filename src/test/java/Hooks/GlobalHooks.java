package Hooks;

import UtilityClasses.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalHooks {

    public static WebDriver driver;
    Logger logger = LoggerFactory.getLogger(GlobalHooks.class);
    WebDriverManager manager = new WebDriverManager();

    @Before
    public void setup(Scenario scenario){
        logger.info("Scenario: " + scenario.getName());
        driver = manager.startDriver();
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
