package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import userinyerface.forms.pages.WelcomePage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomePageSteps {
    private final WelcomePage welcomePage;

    public WelcomePageSteps() {
        this.welcomePage = new WelcomePage();
    }

    @Step
    @Then("Welcome page is {isOpen}")
    public void isWelcomePageOpen(boolean isOpen) {
        assertEquals(welcomePage.state().isDisplayed(), isOpen, "Welcome Page was not opened");
    }

    @Step
    @When("I click on here link")
    public void clickOnHereLink() {
        getLogger().info("Step 2: Click the link (in text 'Please click HERE to GO to the next page') to navigate the next page.");
        welcomePage.clickOnHereLink();
        getBrowser().waitForPageToLoad();
    }
}
