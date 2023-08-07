package org.drewheasman.test.rest.common.step;

import io.cucumber.java.en.Then;
import org.drewheasman.test.rest.common.pojo.api.Empty;
import org.junit.Assert;

import static org.junit.Assert.assertNotNull;

public class CommonStep extends RestStep {
    public CommonStep(RestStepState stepState) {
        super(stepState);
    }

    @Then("The endpoint returns status code {int}")
    public void returnsStatusCode(int code) {
        Assert.assertEquals(code, stepState.getResponse().getStatusCode());
    }

    @Then("The endpoint returns an empty object")
    public void returnsEmptyObject() {
        Empty emptyObject = stepState.getResponse().as(Empty.class);

        assertNotNull(emptyObject);
    }
}
