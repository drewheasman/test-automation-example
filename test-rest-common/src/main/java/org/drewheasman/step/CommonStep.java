package org.drewheasman.step;

import io.cucumber.java.en.Then;
import org.drewheasman.pojo.api.Empty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommonStep extends RestStep {
    public CommonStep(RestStepState stepState) {
        super(stepState);
    }

    @Then("The endpoint returns status code {int}")
    public void returnsStatusCode(int code) {
        assertEquals(code, stepState.getResponse().getStatusCode());
    }

    @Then("The endpoint returns an empty object")
    public void returnsEmptyObject() {
        Empty emptyObject = stepState.getResponse().as(Empty.class);

        assertNotNull(emptyObject);
    }
}
