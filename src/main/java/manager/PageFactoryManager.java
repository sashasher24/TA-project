package manager;

import org.openqa.selenium.WebDriver;
import pages.WishListPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingBagPage;
import pages.SignInPage;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingBagPage getShoppingBagPage() {
        return new ShoppingBagPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public SignInPage getSignInPage() { return new SignInPage(driver); }
}
