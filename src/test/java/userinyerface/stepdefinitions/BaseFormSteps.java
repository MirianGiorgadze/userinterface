package userinyerface.stepdefinitions;

import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static userinyerface.Constants.CONFIG_FILE;
import static userinyerface.utils.BrowserUtils.navigateTo;


public class BaseFormSteps {

    @Step
    @Given("Navigate to welcome page")
    public void navigateToWelcomePage() {
        String url = CONFIG_FILE.getValue("/baseUrl").toString();
        navigateTo(url);
        Allure.link("Tested Website", url);
    }
}
