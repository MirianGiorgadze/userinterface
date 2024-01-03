package userinyerface.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.cucumber.java.en.Given;

public class BaseFormSteps {
    public final ISettingsFile CONFIG_FILE = new JsonSettingsFile("config.json");

    @Given("Navigate to welcome page")
    public void navigateToWelcomePage() {
        AqualityServices.getBrowser().goTo(String.valueOf(CONFIG_FILE.getValue("/baseUrl")));
    }
}
