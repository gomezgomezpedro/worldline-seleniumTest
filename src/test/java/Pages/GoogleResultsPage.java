package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {
    WebDriver driver;

    @FindBy(className = "yuRUbf")
    WebElement firstResult;

    //Constructor method, initializes all the web elements declared above
    public GoogleResultsPage (WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstResult (){
        firstResult.click();
    }

    public boolean isFirstResultDisplayed(){
        return firstResult.isDisplayed();
    }
}
