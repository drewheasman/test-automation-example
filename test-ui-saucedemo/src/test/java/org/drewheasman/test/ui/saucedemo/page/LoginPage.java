package org.drewheasman.test.ui.saucedemo.page;

import org.drewheasman.test.ui.common.driver.DriverManager;
import org.drewheasman.test.ui.common.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
    @FindBy(className = "login_logo")
    private WebElement header;
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    protected Login(DriverManager driverManager) {
        super(driverManager);
    }

    public boolean checkHeaderVisibility() {
        return header.isDisplayed();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public boolean checkUsernameVisibility() {
        return usernameInput.isDisplayed();
    }

    public String getUsernamePlaceholder() {
        return usernameInput.getAttribute("placeholder");
    }

    public boolean checkPasswordVisibility() {
        return passwordInput.isDisplayed();
    }

    public String getPassowrdPlaceholder() {
        return passwordInput.getAttribute("placeholder");
    }

    public boolean checkLoginVisibility() {
        return loginButton.isDisplayed();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public void submitUsernamePassword(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
