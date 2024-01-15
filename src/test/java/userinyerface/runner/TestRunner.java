package userinyerface.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/userinyerface/features"},
        glue = {
                "userinyerface.hooks",
                "userinyerface.transformations",
                "userinyerface.stepdefinitions"
        },
        plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner {
}
