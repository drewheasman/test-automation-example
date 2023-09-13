package org.drewheasman.test.ui.common.step;

import org.drewheasman.test.step.BaseStep;

public abstract class UIStep extends BaseStep<UIStepState> {
    protected UIStep(UIStepState stepState) {
        super(stepState);
    }
}
