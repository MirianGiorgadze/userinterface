package userinyerface.stepdefinitions;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.pages.MainPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageSteps {

    private final MainPage mainPage;
    private final ISettingsFile testData = new JsonSettingsFile("testData.json");

    public MainPageSteps() {
        this.mainPage = new MainPage();
    }

    @Then("Card one is {isOpen}")
    public void isCardOneopened(boolean isOpen) {
        assertEquals(mainPage.state().isDisplayed(), isOpen, "The '1' card is not opened.");
    }

    @When("I click on hide help button")
    public void clickOnHideHelpButton() {
        mainPage.clickOnHideHelpFormButton();
    }

    @Then("Help form is hidden")
    public void helpFormIsHidden() {
        assertTrue(mainPage.upperHelpFormButtonIsNotDisplayed(), "Form content is not hidden.");
    }

    @When("Click accept cookies button")
    public void clickAcceptCookiesButton() {
        mainPage.clickOnAcceptCookiesButton();
    }

    @Then("Cookie form is {isOpen}")
    public void isCookieFormClosed(boolean isOpen) {
        assertEquals(mainPage.acceptCookiesButtonIsDisplayed(), isOpen, "Cookie form is not closed");
    }

    @Then("Timer is started from the value stored in json path {string}")
    public void isTimeStartedFromZero(String path) {
        String expectedTime = testData.getValue(path).toString();
        assertEquals(mainPage.getTimerValue(), expectedTime, "Timer is not started from " + expectedTime);
    }
}
