package org.drewheasman.test.ui.common.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.drewheasman.test.ui.common.driver.DriverManager;
import org.drewheasman.test.ui.common.driver.DriverType;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class CommonStep extends UIStep {
    public CommonStep(UIStepState stepState) {
        super(stepState);
    }

    @Given("I start a browser session for url {string}")
    public void startBrowserSession(URL url) {
        DriverManager driverManager = new DriverManager(DriverType.CHROME); // Choose the driver type (from loaded config) if you need to support different browser runs
        stepState.addDriverManager(driverManager);
        driverManager.loadUrl(url);
    }

    @Then("The current url is {string}")
    public void currentUrl(String url) {
        assertEquals(url, stepState.getDriverManager().getCurrentUrl());
    }
}
