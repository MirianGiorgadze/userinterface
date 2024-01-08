package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.pages.MainPage;
import userinyerface.forms.pages.MainPageButton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static userinyerface.Constants.CONFIG_FILE;
import static userinyerface.Constants.TEST_DATA;

public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps() {
        this.mainPage = new MainPage();
    }

    @Then("Card one is {isOpen}")
    public void isCardOneOpened(boolean isOpen) {
        assertEquals(mainPage.state().isDisplayed(), isOpen, "The '1' card is not opened.");
    }

    @When("I click on hide help button")
    public void clickOnHideHelpButton() {
        mainPage.clickButton(MainPageButton.HIDE_HELP);
    }

    @Then("Help form is hidden")
    public void helpFormIsHidden() {
        int secondsToWait = Integer.parseInt(CONFIG_FILE.getValue("/waits/waitToFormHide").toString());
        assertTrue(mainPage.isButtonHiddenAfterWait(MainPageButton.UPPER_HELP, secondsToWait), "Form content is not hidden.");
    }

    @When("Click accept cookies button")
    public void clickAcceptCookiesButton() {
        mainPage.clickButton(MainPageButton.ACCEPT_COOKIES);
    }

    @Then("Cookie form is {isOpen}")
    public void isCookieFormClosed(boolean isOpen) {
        assertEquals(mainPage.buttonIsDisplayed(MainPageButton.ACCEPT_COOKIES), isOpen, "Cookie form is not closed");
    }

    @Then("Timer is started from the value stored in json path {string}")
    public void isTimeStartedFromZero(String path) {
        String expectedTime = TEST_DATA.getValue(path).toString();
        assertEquals(mainPage.getTimerValue(), expectedTime, "Timer is not started from " + expectedTime);
    }
}
