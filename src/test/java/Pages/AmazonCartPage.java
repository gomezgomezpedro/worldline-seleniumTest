package Pages;

import Hooks.GlobalHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@data-item-count='1']")
    WebElement firstAddedProduct;

    /**
     * Constructor method, initializes all the web elements declared above
     */
    public AmazonCartPage() {
        this.driver = GlobalHooks.driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFirstAddedProductDisplayed() {
        return(firstAddedProduct.isDisplayed());
    }
}
