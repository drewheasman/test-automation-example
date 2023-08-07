package org.drewheasman.step;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class RestStepState implements StepState {
    private Response response;
}
