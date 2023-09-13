package org.drewheasman.test.ui.common.step;

import org.drewheasman.test.step.StepState;
import org.drewheasman.test.ui.common.driver.DriverManager;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class UIStepState implements StepState {
    private final List<DriverManager> driverManagers = new ArrayList<>();

    void addDriverManager(DriverManager driverManager) {
        driverManagers.add(driverManager);
    }

    public DriverManager getDriverManager() {
        Assert.assertEquals(1, driverManagers.size());
        return driverManagers.get(0);
    }

    List<DriverManager> getDriverManagers() {
        return driverManagers;
    }
}
