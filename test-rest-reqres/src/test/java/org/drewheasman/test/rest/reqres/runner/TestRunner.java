package org.drewheasman.test.rest.reqres.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/drewheasman/test/rest/reqres",
        glue = {
                "org.drewheasman.test.rest.common.step",
                "org.drewheasman.test.rest.reqres.step"
        })
public class TestRunner {
}
