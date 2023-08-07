package org.drewheasman.rest.reqres.step.register;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.drewheasman.rest.reqres.pojo.reqres.register.RegisterPost;
import org.drewheasman.rest.reqres.pojo.reqres.register.RegisterResponse;
import org.drewheasman.rest.reqres.request.register.RegisterRequest;
import org.drewheasman.step.RestStep;
import org.drewheasman.step.RestStepState;

import static org.drewheasman.pojo.PojoHelper.defined;
import static org.junit.Assert.assertTrue;

public class RegisterStep extends RestStep {
    public RegisterStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call POST register with username {string}, email {string}, password {string}")
    public void postRegister(String username, String email, String password) {
        RegisterPost registerPost = new RegisterPost();

        if (defined(username)) {
            registerPost.setUsername(username);
        }
        if (defined(email)) {
            registerPost.setEmail(email);
        }
        if (defined(password)) {
            registerPost.setPassword(password);
        }

        stepState.setResponse(RegisterRequest.postRegister(registerPost));
    }

    @Then("The endpoint returns a register response")
    public void returnsRegisterResponse() {
        RegisterResponse registerResponse = stepState.getResponse().as(RegisterResponse.class);

        assertTrue(registerResponse.getId() > 0);
        assertTrue(registerResponse.getToken().length() > 0);
    }
}
