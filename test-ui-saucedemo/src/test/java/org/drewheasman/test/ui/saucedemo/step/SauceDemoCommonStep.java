package org.drewheasman.test.ui.saucedemo.step;

import io.cucumber.java.en.Given;
import org.drewheasman.test.ui.common.step.CommonStep;
import org.drewheasman.test.ui.common.step.UIStep;
import org.drewheasman.test.ui.common.step.UIStepState;
import org.drewheasman.test.ui.saucedemo.pojo.config.SauceDemoConfig;
import org.drewheasman.test.util.ReadEnvironmentConfig;

public class SauceDemoCommonStep extends UIStep {
    public SauceDemoCommonStep(UIStepState stepState) {
        super(stepState);
    }

    @Given("I start a browser session for SauceDemo")
    public void startBrowserSauceDemo() {
        SauceDemoConfig config = ReadEnvironmentConfig.getConfig(SauceDemoConfig.class);

        CommonStep commonStep = new CommonStep(stepState);
        commonStep.startBrowserSession(config.getWebsiteUrl());
    }
}
