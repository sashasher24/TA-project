package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'toBagButton_3wcKB')]")
    private List<WebElement> moveToBagButtons;

    @FindBy(xpath = "//div[@class = 'itemCount_1ZeG5']")
    private WebElement wishlistItemsCount;



    @FindBy(xpath = "//h2[contains(@class, 'noItemsPrompt')]")
    private WebElement noItemsMessage;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void moveItemToBag() {
        moveToBagButtons.get(0).click();
    }

//    public void isItemsCountVisible() {
//        wishlistItemsCount.isDisplayed();
//    }

    public String getItemsCount() {
        return wishlistItemsCount.getText();
    }

    public WebElement getNoItemsMessage() {
        return noItemsMessage;
    }
}
