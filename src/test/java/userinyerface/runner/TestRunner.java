package userinyerface.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/userinyerface/features"},
        glue = {
                "userinyerface.hooks",
                "userinyerface.transformations",
                "userinyerface.stepdefinitions"
        }
)
public class TestRunner {
}
