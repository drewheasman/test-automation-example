package org.drewheasman.test.rest.reqres.step.logout;

import io.cucumber.java.en.When;
import org.drewheasman.test.rest.common.step.RestStep;
import org.drewheasman.test.rest.common.step.RestStepState;
import org.drewheasman.test.rest.reqres.request.logout.LogoutRequest;

public class LogoutStep extends RestStep {
    public LogoutStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call POST logout")
    public void postLogout() {
        stepState.setResponse(LogoutRequest.postLogout());
    }
}
