package org.drewheasman.test.ui.saucedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/drewheasman/test/ui/saucedemo",
        glue = {
                "org.drewheasman.test.ui.common.step",
                "org.drewheasman.test.ui.saucedemo.step"
        })
public class TestRunner {
}
