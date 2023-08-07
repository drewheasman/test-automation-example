package org.drewheasman.test.rest.common.step;

import io.restassured.response.Response;
import lombok.Data;
import org.drewheasman.test.step.StepState;

@Data
public class RestStepState implements StepState {
    private Response response;
}
