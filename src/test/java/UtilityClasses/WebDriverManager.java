package UtilityClasses;
import StepDefinitions.GoogleSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    public WebDriver startDriver (){
        WebDriver driver;
        Properties props = new GetConfigProperties().configProperties();
        System.setProperty("webdriver.chrome.driver", props.getProperty("webdriverPath"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        logger.debug("Initializing Google Chrome browser and navigating to {} ", props.getProperty("websiteUrl"));
        driver = new ChromeDriver(options);
        driver.get(props.getProperty("websiteUrl"));

        return driver;
    }

    public void quitDriver (WebDriver driver) {
        logger.debug("Closing browser and chromedriver task");
        driver.quit();
    }
}
