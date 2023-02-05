package Pages;

import Hooks.GlobalHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPDPage {
    WebDriver driver;
    @FindBy(id = "add-to-cart-button")
    WebElement addCartButton;

    @FindBy(xpath = "//span[contains(text(), 'No, gracias')]")
    WebElement rejectRecommendationsButton;

    /**
     * Constructor method, initializes all the web elements declared above
     */
    public AmazonPDPage() {
        this.driver = GlobalHooks.driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddCartButton() {
        addCartButton.click();
    }

    public void clickRejectRecommendationsButton() {
        rejectRecommendationsButton.click();
    }
}
