package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import userinyerface.forms.ThirdCardForm;

import static org.testng.Assert.assertEquals;

public class ThirdCardSteps {

    private final ThirdCardForm thirdCardForm;

    public ThirdCardSteps(){
        this.thirdCardForm = new ThirdCardForm();
    }

    @Then("Third card is {isOpen}")
    public void isThirdCardOpened(boolean isOpen){
        assertEquals(thirdCardForm.state().waitForDisplayed(), isOpen, "The '3' card was not opened.");
    }
}
