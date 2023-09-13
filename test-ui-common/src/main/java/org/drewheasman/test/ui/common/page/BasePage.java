package org.drewheasman.test.ui.common.page;

import org.drewheasman.test.ui.common.driver.DriverManager;

public abstract class BasePage {
    public final DriverManager driverManager;

    protected BasePage(DriverManager driverManager) {
        this.driverManager = driverManager;
        driverManager.initialiseElements(this);
    }
}
