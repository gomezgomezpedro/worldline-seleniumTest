package UtilityClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public WebDriver startDriver (){
        WebDriver driver;
        Properties props = new GetConfigProperties().configProperties();
        System.setProperty("webdriver.chrome.driver", props.getProperty("webdriverPath"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(props.getProperty("websiteUrl"));

        return driver;
    }

    public void quitDriver (WebDriver driver) {
        driver.quit();
    }
}
