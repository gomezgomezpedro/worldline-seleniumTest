package Pages;
import Hooks.GlobalHooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    WebDriver driver;

    @FindBy(id = "L2AGLb")
    WebElement acceptTermsButton;
    @FindBy(name = "q")
    WebElement searchInput;

    /**
     * Constructor method, initializes all the web elements declared above
     */

    public GoogleMainPage () {
        this.driver = GlobalHooks.driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptTerms (){
        acceptTermsButton.click();
    }

    public void inputSearchValue (String searchValue){
        searchInput.sendKeys(searchValue);
    }

    public void clickSearchButton(){
        searchInput.sendKeys(Keys.ENTER);
    }
}
