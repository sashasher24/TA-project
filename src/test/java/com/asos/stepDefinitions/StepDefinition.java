package com.asos.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class StepDefinition {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingBagPage shoppingBagPage;
    WishListPage wishListPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;

//    private WebDriver driver;
    private static final String ASOS_URL = "https://www.asos.com/";

//    @BeforeTest
//    public void profileSetUp() {
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//    }

    @Before
    public void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
//        driver.get(ASOS_URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.typeTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() throws InterruptedException {
        sleep(1500);
        homePage.clickSearchButton();
    }

    @And("User opens first product")
    public void userOpensFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.openFirstProductPage();
    }


    @And("User chooses size of the product")
    public void userChoosesSizeOfTheProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.areSizeOptionsVisible();
        productPage.clickSelectSizeButton();
        productPage.clickOnSize();
    }


    @And("User clicks on add to bag button")
    public void userClicksOnAddToBagButton() {
        productPage.clickAddToBagButton();
    }

    @Then("User checks that the number of products in bag is {string}")
    public void userChecksThatTheNumberOfProductsInBagIsNumberOfProducts(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getNumberOfProductsInBag());
        assertEquals(homePage.getNumberOfProductsInBag().getText(), expectedAmount);
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.isHeaderVisible();
    }


    @And("User checks bag icon visibility")
    public void userChecksBagIconVisibility() {
        homePage.isBagIconVisible();
    }

    @And("User checks wishList icon visibility")
    public void userChecksWishListIconVisibility() {
        homePage.isWishListIconVisible();
    }

    @And("User checks my account icon visibility")
    public void userChecksMyAccountIconVisibility() {
        homePage.isMyAccountIconVisible();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User clicks on my account icon")
    public void userClicksOnMyAccountIcon() {
        homePage.clickMyAccountIcon();
    }


    @And("User checks account dropdown visibility")
    public void userChecksAccountDropdownVisibility() {
        homePage.isMyAccountDropdownVisible();
    }


    @And("User clicks sign in button")
    public void userClicksSignInButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountDropdown());
        homePage.clickSignInButton();
    }

    @And("User checks that page title is {string}")
    public void userChecksThatPageTitleIsSignInTitle(final String expectedTitle) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(signInPage.getPageTitle().equals(expectedTitle));
    }


    @And("User checks username field visibility")
    public void userChecksUsernameFieldVisibility() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.isUsernameFieldVisible();
    }


    @And("User checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
        signInPage.isPasswordFieldVisible();
    }

    @And("User checks sign in button visibility")
    public void userChecksSignInButtonVisibility() {
        signInPage.isSigninButtonFieldVisible();
    }


    @When("User enters {string} into username field")
    public void userEntersEmailIntoUsernameField(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterEmailToUsernameField(email);
    }


    @And("User enters {string} into password field")
    public void userEntersPasswordIntoPasswordField(final String password) {
        signInPage.enterPasswordToPasswordField(password);
    }


    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {
        signInPage.clickSignInButton();
    }

    @And("User checks greeting visibility")
    public void userChecksGreetingVisibility() {
        homePage.isSignedInUserGreetingVisible();
    }

    @Then("User checks that the message says {string}")
    public void userChecksThatTheMessageSaysGreeting(final String expectedMessage) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountDropdown());
        assertTrue(homePage.getSignedInUserGreeting().equals(expectedMessage));
    }

    @And("User clicks on add to wish list button")
    public void userClicksOnAddToWishListButton() {
        productPage.clickAddToWishlistButton();
    }

    @And("User goes to wish list page")
    public void userGoesToWishListPage() {
        homePage.clickWishListButton();
    }

    @Then("User checks that the number of products in list is {string}")
    public void userChecksThatTheNumberOfProductsInListIsNumberOfProducts(final String expectedCount) {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(wishListPage.getItemsCount().equals(expectedCount));
    }

    @When("User clicks move to bag button")
    public void userClicksMoveToBagButton() {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.moveItemToBag();
    }

    @And("User checks that no items message is displayed")
    public void userChecksThatNoItemsMessageIsDisplayed() {
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getNoItemsMessage());
        assertTrue(wishListPage.getNoItemsMessage().isDisplayed());
    }

    @And("User sees added to bag popup")
    public void userSeesAddedToBagPopup() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getAddedToBagPopup());
        assertTrue(homePage.isAddedToBagPopupVisible());
    }

//    @And("User checks that pup up message says {string}")
//    public void userChecksThatPupUpMessageSaysMessage(final String expectedMessage) {
//        assertTrue(productPage.getAddedToBagPopupText().equals(expectedMessage));
//    }

    @When("User clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        productPage.clickContinueToCheckoutButton();
    }

    @Then("User checks that the page title is {string}")
    public void userChecksThatThePageTitleIsCheckoutTitle(final String expectedTitle) {
        assertTrue(driver.getTitle().equals(expectedTitle));
    }

    @And("User checks that pup up message says {string}")
    public void userChecksThatPupUpMessageSaysMessage(final String expectedMessage) {
        assertTrue(productPage.getAddedToBagPopupText().equals(expectedMessage));
    }

    @And("User clicks on bag icon")
    public void userClicksOnBagIcon() {
        homePage.clickBagButton();
    }

    @And("User sees bag dropdown")
    public void userSeesBagDropdown() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getBagDropdown());
        assertTrue(homePage.isDropdownVisible());
    }

    @When("User clicks on view bag button")
    public void userClicksOnViewBagButton() {
        homePage.clickViewBagButton();
    }

    @Then("User checks that the heading says {string}")
    public void userChecksThatTheHeadingSaysTitle(final String title) {
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(shoppingBagPage.getBagTitle().getText().equals(title));
    }

    @And("User clicks checkout button")
    public void userClicksCheckoutButton() {
        shoppingBagPage.clickCheckoutButton();
    }

    @When("User clicks on selected brand")
    public void userClicksOnSelectedBrand() {

        homePage.clickOnSelectedBrand();
    }

    @And("User makes sure that logo list is visible")
    public void userMakesSureThatLogoListIsVisible() throws InterruptedException {
//        JavascriptExecutor js = ;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", homePage.getLogoList());
        Thread.sleep(500);
    }

    @And("User scrolls to footer")
    public void userScrollsToFooter() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", homePage.getFooter());
        Thread.sleep(500);
    }


    @When("User clicks on about us")
    public void userClicksOnAboutUs() {
        homePage.clickAboutUs();
    }
}
