package org.drewheasman.test.ui.saucedemo.step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.drewheasman.test.ui.common.step.UIStep;
import org.drewheasman.test.ui.common.step.UIStepState;
import org.drewheasman.test.ui.saucedemo.page.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStep extends UIStep {
    private final LoginPage loginPage;

    public LoginStep(UIStepState stepState) {
        super(stepState);

        loginPage = new LoginPage(stepState.getDriverManager());
    }

    @When("I Login with username {string}, password {string}")
    public void login(String username, String password) {
        loginPage.submitUsernamePassword(username, password);
    }

    @When("I click the Login error button")
    public void clickErrorButton() {
        loginPage.clickErrorButton();
    }

    @Then("The Login page is displayed")
    public void loginPageDisplayed() {
        assertTrue(loginPage.checkHeaderVisibility());
        assertTrue(loginPage.checkUsernameVisibility());
        assertTrue(loginPage.checkPasswordVisibility());
        assertTrue(loginPage.checkLoginButtonVisibility());

        assertTrue(loginPage.checkUsernameEnabled());
        assertTrue(loginPage.checkPasswordEnabled());
        assertTrue(loginPage.checkLoginButtonEnabled());

        assertEquals("Swag Labs", loginPage.getHeaderText());
        assertEquals("Username", loginPage.getUsernamePlaceholder());
        assertEquals("Password", loginPage.getPasswordPlaceholder());
        assertEquals("Login", loginPage.getLoginButtonText());
    }

    @Then("A Login error is displayed with text {string}")
    public void loginErrorDisplayed(String errorText) {
        assertTrue(loginPage.checkErrorVisibility());
        assertTrue(loginPage.checkErrorButtonVisibility());

        assertEquals(errorText, loginPage.getErrorText());
    }
}
