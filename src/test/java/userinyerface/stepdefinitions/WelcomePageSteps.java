package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.pages.WelcomePage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.assertEquals;

public class WelcomePageSteps {

    private final WelcomePage welcomePage;

    public WelcomePageSteps() {
        this.welcomePage = new WelcomePage();
    }

    @Then("Welcome page is {isOpen}")
    public void isWelcomePageOpen(boolean isOpen) {
        assertEquals(welcomePage.state().isDisplayed(), isOpen, "Welcome Page was not opened");
    }

    @When("I click on here link")
    public void clickOnHereLink() {
        getLogger().info("Step 2: Click the link (in text 'Please click HERE to GO to the next page') to navigate the next page.");
        welcomePage.clickOnHereLink();
        getBrowser().waitForPageToLoad();
    }
}
