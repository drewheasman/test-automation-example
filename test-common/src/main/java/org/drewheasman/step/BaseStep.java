package org.drewheasman.step;

public abstract class BaseStep<T extends StepState> {
    protected final T stepState;

    protected BaseStep(T stepState) {
        this.stepState = stepState;
    }
}
