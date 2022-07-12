package UtilityClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

import static UtilityClasses.ProjectConstants.CONFIG_PROPERTIES;

public class WebDriverManager {

    Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    public WebDriver startDriver (){
        WebDriver driver;
        Properties config = new GetProperties().getProperties(CONFIG_PROPERTIES);
        System.setProperty("webdriver.chrome.driver", config.getProperty("webdriverPath"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        logger.debug("Initializing Google Chrome browser and navigating to {} ", config.getProperty("websiteUrl"));
        driver = new ChromeDriver(options);
        driver.get(config.getProperty("websiteUrl"));

        return driver;
    }

    public void quitDriver (WebDriver driver) {
        logger.debug("Closing browser and chromedriver task");
        driver.quit();
    }
}
