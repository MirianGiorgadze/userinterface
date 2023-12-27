package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.SecondCard;

import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.assertEquals;

public class SecondCardSteps {

    private final SecondCard secondCard;

    public SecondCardSteps(){
        this.secondCard = new SecondCard();
    }

    @Then("Second card is {isOpen}")
    public void second_card_is_displayed(boolean isOpen){
        assertEquals(secondCard.state().isDisplayed(), isOpen, "The '2' card is not opened.");
    }

    @When("I click on three checkbox")
    public void click_on_three_checkbox(){
        getLogger().info("Step 4: Choose 2 random interests, upload image, click \"Next\" button.");
        secondCard.clickOnThreeCheckbox();
    }

    @When("Click upload button")
    public void click_upload_button(){
        secondCard.clickOnUploadButton();
    }

    @When("Send picture")
    public void send_picture(){
        secondCard.SendPicture();;
    }

    @When("Click on secondcard next button")
    public void click_on_next_button(){
        secondCard.clickOnNextButton();
    }
}
