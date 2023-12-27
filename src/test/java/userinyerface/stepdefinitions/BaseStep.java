package userinyerface.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.cucumber.java.en.Given;

public class BaseStep {

    @Given("Navigate to welcome page")
    public void navigate_to_welcome_page() {
        ISettingsFile configFile = new JsonSettingsFile("config.json");
        AqualityServices.getBrowser().goTo(String.valueOf(configFile.getValue("/baseUrl")));
    }
}
