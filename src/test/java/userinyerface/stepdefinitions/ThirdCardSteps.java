package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import userinyerface.forms.ThirdCard;

import static org.testng.Assert.assertEquals;

public class ThirdCardSteps {

    private final ThirdCard thirdCard;

    public ThirdCardSteps(){
        this.thirdCard = new ThirdCard();
    }

    @Then("Third card is {isOpen}")
    public void third_card_is_opened(boolean isOpen){
        assertEquals(thirdCard.state().waitForDisplayed(), isOpen, "The '3' card is not opened.");
    }
}
