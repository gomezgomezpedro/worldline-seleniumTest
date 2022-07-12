package UtilityClasses;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    public void takeScreenshot (WebDriver driver, Scenario scenario){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE );
        try {
            FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenario.getName() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
