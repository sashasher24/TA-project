package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void isUsernameFieldVisible() {
        usernameInputField.isDisplayed();
    }

    public void isPasswordFieldVisible() {
        passwordInputField.isDisplayed();
    }

    public void isSigninButtonFieldVisible() {
        signInButton.isDisplayed();
    }

    public void enterEmailToUsernameField(String email) {
        usernameInputField.sendKeys(email);
    }

    public void enterPasswordToPasswordField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
