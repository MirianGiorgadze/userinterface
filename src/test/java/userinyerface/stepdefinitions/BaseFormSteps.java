package userinyerface.stepdefinitions;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

import static userinyerface.Constants.CONFIG_FILE;
import static userinyerface.utils.BrowserUtils.navigateTo;


public class BaseFormSteps {

    @Step
    @Given("Navigate to welcome page")
    public void navigateToWelcomePage() {
        navigateTo(String.valueOf(CONFIG_FILE.getValue("/baseUrl").toString()));
    }
}
