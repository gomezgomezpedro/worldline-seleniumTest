package Pages;

import Hooks.GlobalHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPLPage {
    WebDriver driver;
    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    WebElement firstResult;

    /**
     * Constructor method, initializes all the web elements declared above
     */
    public AmazonPLPage() {
        this.driver = GlobalHooks.driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFirstResultDisplayed() {
        return firstResult.isDisplayed();
    }

    public void clickFirstResult() {
        firstResult.click();
    }
}
