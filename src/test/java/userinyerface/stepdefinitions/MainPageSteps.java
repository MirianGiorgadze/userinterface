package userinyerface.stepdefinitions;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.forms.Form;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.FirstCard;
import userinyerface.forms.pages.MainPage;
import userinyerface.forms.pages.WelcomePage;

import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.*;

public class MainPageSteps {

    private final MainPage mainPage;

    public MainPageSteps(){
        this.mainPage = new MainPage();
    }

    @Then("Card one is {isOpen}")
    public void card_one_is_opened(boolean isOpen) {
        assertEquals(mainPage.state().isDisplayed(), isOpen, "The '1' card is not opened.");
    }

    @When("I click on hide help button")
    public void click_on_hide_help_button(){
        mainPage.clickOnHideHelpFormButton();
    }

    @Then("Help form is hidden")
    public void help_form_is_hidden(){
        assertTrue(mainPage.upperHelpFormButtonIsNotDisplayed(), "Form content is not hidden.");
    }

    @When("Click accept cookies button")
    public void click_accept_cookies_button() {
        mainPage.clickOnAcceptCookiesButton();
    }

    @Then("Cookie form is {isOpen}")
    public void cookie_form_is_closed(boolean isOpen) {
        assertEquals(mainPage.acceptCookiesButtonIsDisplayed(), isOpen, "Cookie form is not closed");
    }

    @Then("Timer is started from \"00:00\"")
    public void time_is_started_from_zero(){
        ISettingsFile testData = new JsonSettingsFile("TestData.json");
        assertEquals(mainPage.getTimerValue(), testData.getValue("/startTime"), "Timer is not started from \"00:00\"");
    }
}
