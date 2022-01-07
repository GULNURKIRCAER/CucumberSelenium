package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/vytrack/step_definitions"

       // To rerun failed tests only,
        // we created FailedTestRunner under runner package.
        // Then we use maven verify phase to execute both CukesRunner and FailedTestRunner

)
public class FailedTestRunner {
}