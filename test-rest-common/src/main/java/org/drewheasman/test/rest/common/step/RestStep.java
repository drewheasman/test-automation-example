package org.drewheasman.test.rest.common.step;

import org.drewheasman.test.step.BaseStep;

public abstract class RestStep extends BaseStep<RestStepState> {
    protected RestStep(RestStepState stepState) {
        super(stepState);
    }
}
