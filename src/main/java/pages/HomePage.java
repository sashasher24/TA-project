package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    //bag
    @FindBy(xpath = "//header//li//a[@data-testid='miniBagIcon']")
    private WebElement bagIcon;

    @FindBy(xpath = "//div[@id='minibag-dropdown']/div[@class='_33s2s-y']")
    private WebElement bagDropdown;

//    Boolean result = driver.findElement(By.xpath("//span[text()=’Coding Ground’]")).isDisplayed();
//    if(result) {
//
//    }
    //bagItemCount
//    @FindBy(xpath = "//header//li//a[@data-testid='miniBagIcon']/span[@class='_1z5n7CN']")
//    private WebElement numberOfItemsInBag;

    //wishlist
    @FindBy(xpath = "//header//li//a[@data-testid='savedItemsIcon']")
    private WebElement wishListIcon;


    //account
    @FindBy(xpath = "//header//li//button[@data-testid='myAccountIcon']")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//div[@data-testid='myaccount-dropdown']")
    private WebElement myAccountDropdown;

    //signin button
    @FindBy(xpath = "//header//li//div[@data-testid='myaccount-dropdown']//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@data-testid='myaccount-dropdown']//span[@class='tiqiyps']")
    private WebElement signedInUserGreeting;

    //email field
    //passwordfield
    //enterbutton


    //search field + button
    @FindBy(xpath = "//header//form//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//header//form//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='_12ChTgQ']//div[@class='_1F1C1jC']")
    private WebElement itemAddedToBagMessage;

    @FindBy(xpath = "//div[@data-test-id='miniBagFooter']//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//img[@class='logoLinks__logos']")
    private List<WebElement> brandsLinks;

    @FindBy(xpath = "//ul[@class='logoLinks__list']")
    private WebElement logoList;

    @FindBy(xpath = "//a[text() = 'About Us']")
    private WebElement aboutUsButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isBagIconVisible() {
        bagIcon.isDisplayed();
    }

    public WebElement getNumberOfProductsInBag() {
        WebElement numberOfItemsInBag = driver.findElement(By.xpath("//header//li//a[@data-testid='miniBagIcon']/span[@class='_1z5n7CN']"));
        if(numberOfItemsInBag.isDisplayed()) {
            return numberOfItemsInBag;
        } else return null;
    }

    public void isWishListIconVisible() {
        wishListIcon.isDisplayed();
    }

    public void isMyAccountIconVisible() {
        myAccountIcon.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void typeTextToSearchField(final String textToSearch) {
        searchField.clear();
        searchField.sendKeys(textToSearch);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickBagButton() {
        bagIcon.click();
    }

    public WebElement getBagDropdown() {
        return bagDropdown;
    }

    public boolean isDropdownVisible() {
        return bagDropdown.isDisplayed();
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public void clickWishListButton() {
        wishListIcon.click();
    }

    public void clickMyAccountIcon() {
        myAccountIcon.click();
    }

    public void isMyAccountDropdownVisible() {
        myAccountDropdown.isDisplayed();
    }

    public WebElement getMyAccountDropdown() {
        return myAccountDropdown;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void isSignedInUserGreetingVisible() {
        signedInUserGreeting.isDisplayed();
    }

    public String getSignedInUserGreeting() {
        return signedInUserGreeting.getText();
    }

    public boolean isAddedToBagPopupVisible() {
        return itemAddedToBagMessage.isDisplayed();
    }

    public WebElement getAddedToBagPopup() {
        return itemAddedToBagMessage;
    }

    public WebElement getLogoList() {
        return logoList;
    }

    public WebElement getFooter() {
        return footer;
    }

    public void clickOnSelectedBrand() {
        brandsLinks.get(4).click();
    }

    public void clickAboutUs() {
        aboutUsButton.click();
    }
}