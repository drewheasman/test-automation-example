package org.drewheasman.test.ui.common.step;

import io.cucumber.java.After;
import org.drewheasman.test.ui.common.driver.DriverManager;

public class Hooks extends UIStep {
    public Hooks(UIStepState stepState) {
        super(stepState);
    }

    @After
    public void closeAllBrowserSessions() {
        for (DriverManager driverManager : stepState.getDriverManagers()) {
            driverManager.quit();
        }
    }
}
