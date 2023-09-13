package org.drewheasman.test.rest.reqres.step.login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.drewheasman.test.rest.common.pojo.PojoHelper;
import org.drewheasman.test.rest.common.step.RestStep;
import org.drewheasman.test.rest.common.step.RestStepState;
import org.drewheasman.test.rest.reqres.pojo.reqres.login.LoginPost;
import org.drewheasman.test.rest.reqres.pojo.reqres.login.LoginResponse;
import org.drewheasman.test.rest.reqres.request.login.LoginRequest;

import static org.junit.Assert.assertFalse;

public class LoginStep extends RestStep {
    public LoginStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call POST login with username {string}, email {string}, password {string}")
    public void postLogin(String username, String email, String password) {
        LoginPost loginPost = new LoginPost();

        if (PojoHelper.defined(username)) {
            loginPost.setUsername(username);
        }
        if (PojoHelper.defined(email)) {
            loginPost.setEmail(email);
        }
        if (PojoHelper.defined(password)) {
            loginPost.setPassword(password);
        }

        stepState.setResponse(LoginRequest.postLogin(loginPost));
    }

    @Then("The endpoint returns a login response")
    public void returnsLoginResponse() {
        LoginResponse loginResponse = stepState.getResponse().as(LoginResponse.class);

        assertFalse(loginResponse.getToken().isEmpty());
    }
}
