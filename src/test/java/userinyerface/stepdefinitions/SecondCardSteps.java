package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.SecondCardForm;

import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.assertEquals;

public class SecondCardSteps {

    private final SecondCardForm secondCardForm;

    public SecondCardSteps(){
        this.secondCardForm = new SecondCardForm();
    }

    @Then("Second card is {isOpen}")
    public void secondCardIsDisplayed(boolean isOpen){
        assertEquals(secondCardForm.state().isDisplayed(), isOpen, "The '2' card is not opened.");
    }

    @When("I click on three checkbox")
    public void clickOnThreeCheckbox(){
        getLogger().info("Step 4: Choose 2 random interests, upload image, click \"Next\" button.");
        secondCardForm.clickOnThreeCheckbox();
    }

    @When("Click upload button")
    public void clickUploadButton(){
        secondCardForm.clickOnUploadButton();
    }

    @When("Send picture")
    public void sendPicture(){
        secondCardForm.SendPicture();
    }

    @When("Click on second card next button")
    public void clickNextButton(){
        secondCardForm.clickOnNextButton();
    }
}
