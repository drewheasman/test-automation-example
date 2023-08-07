package org.drewheasman.rest.reqres.step.logout;

import io.cucumber.java.en.When;
import org.drewheasman.rest.reqres.request.logout.LogoutRequest;
import org.drewheasman.step.RestStep;
import org.drewheasman.step.RestStepState;

public class LogoutStep extends RestStep {
    public LogoutStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call POST logout")
    public void postLogout() {
        stepState.setResponse(LogoutRequest.postLogout());
    }
}
