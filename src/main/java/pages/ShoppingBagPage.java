package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage extends BasePage {

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'holder')]/h2[contains(@class,'title')]")
    private WebElement bagTitle;

    @FindBy(xpath = "//a[contains(@class, 'button--checkout--total')]")
    private WebElement checkoutButton;

    public WebElement getBagTitle() {
        return bagTitle;
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
