package org.drewheasman.test.ui.saucedemo.page;

import org.drewheasman.test.ui.common.driver.DriverManager;
import org.drewheasman.test.ui.common.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(className = "login_logo")
    private WebElement header;
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement error;
    @FindBy(className = "error-button")
    private WebElement errorButton;

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    public boolean checkHeaderVisibility() {
        return header.isDisplayed();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public Boolean checkUsernameVisibility() {
        return usernameInput.isDisplayed();
    }

    public String getUsernamePlaceholder() {
        return usernameInput.getAttribute("placeholder");
    }

    public Boolean checkUsernameEnabled() {
        return usernameInput.isEnabled();
    }

    public Boolean checkPasswordVisibility() {
        return passwordInput.isDisplayed();
    }

    public Boolean checkPasswordEnabled() {
        return passwordInput.isEnabled();
    }

    public String getPasswordPlaceholder() {
        return passwordInput.getAttribute("placeholder");
    }

    public Boolean checkLoginButtonVisibility() {
        return loginButton.isDisplayed();
    }

    public String getLoginButtonText() {
        return loginButton.getAttribute("value");
    }

    public Boolean checkLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public Boolean checkErrorVisibility() {
        return error.isDisplayed();
    }

    public Boolean checkErrorButtonVisibility() {
        return errorButton.isDisplayed();
    }

    public Boolean checkErrorButtonEnabled() {
        return errorButton.isEnabled();
    }

    public void clickErrorButton() {
        errorButton.click();
    }

    public void submitUsernamePassword(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorText() {
        return error.getText();
    }
}
