package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@class='save-button']")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//ul[@class='_12ChTgQ']//div[@class='_1F1C1jC']")
    private WebElement itemAddedToBagMessage;

    @FindBy(xpath = "//div[@class='_3mygsrG']//a[@data-test-id='checkout-link']")
    private WebElement continueToCheckoutButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']/option")
    private List<WebElement> selectSizeOptions;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean areSizeOptionsVisible() {
        return selectSizeButton.isDisplayed();
    }

    public void clickSelectSizeButton() {
        selectSizeButton.click();
    }

    public void clickOnSize() {
        selectSizeOptions.get(2).click();
    }

    public void clickAddToBagButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToBagButton);
    }

//    public boolean isAddedToBagPopupVisible() {
//        return itemAddedToBagMessage.isDisplayed();
//    }

    public String getAddedToBagPopupText() {
        return itemAddedToBagMessage.getText();
    }

//    public void isContiniueToCheckoutButtonVisible() {
//        continueToCheckoutButton.isDisplayed();
//    }

    public void clickContinueToCheckoutButton() {
        continueToCheckoutButton.click();
    }

    public void clickAddToWishlistButton() {
        addToWishlistButton.click();
    }
}
