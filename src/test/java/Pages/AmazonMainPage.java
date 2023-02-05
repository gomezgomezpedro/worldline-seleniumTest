package Pages;

import Hooks.GlobalHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {
    WebDriver driver;
    @FindBy(id = "sp-cc-accept")
    WebElement acceptCookiesButton;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchInput;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchSubmitButton;

    @FindBy(id = "nav-cart")
    WebElement cartButton;

    /**
     * Constructor method, initializes all the web elements declared above
     */
    public AmazonMainPage() {
        this.driver = GlobalHooks.driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void searchProduct(String product) {
        searchInput.sendKeys(product);
    }

    public void submitSearch() {
        searchSubmitButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }
}
