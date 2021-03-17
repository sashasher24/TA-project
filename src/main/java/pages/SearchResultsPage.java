package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> wishListIcons;

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void openFirstProductPage() {
        searchResults.get(0).click();
    }
}
