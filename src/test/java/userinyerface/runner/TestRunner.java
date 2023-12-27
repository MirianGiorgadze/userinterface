package userinyerface.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/userinyerface/features"},
        glue = {
                "userinyerface.hooks",
                "userinyerface.transformations",
                "userinyerface.stepdefinitions"
        },
        plugin = {"pretty"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
