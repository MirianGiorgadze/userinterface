package userinyerface.stepdefinitions;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.SecondCardForm;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.assertEquals;
import static userinyerface.utils.RandomTestDataUtils.getIndicesListForCheckbox;

public class SecondCardSteps {

    private final SecondCardForm secondCardForm;
    private final ISettingsFile testData = new JsonSettingsFile("testData.json");

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
        int quantity  = Integer.parseInt(testData.getValue("/secondCard/quantityToCheck").toString());
        int bound = Integer.parseInt(testData.getValue("/secondCard/checkboxOverallQuantity").toString());
        int selectIndex = Integer.parseInt(testData.getValue("/secondCard/selectAllCheckboxIndex").toString());
        int unselectIndex = Integer.parseInt(testData.getValue("/secondCard/unselectAllCheckboxIndex").toString());
        List<Integer> indices = getIndicesListForCheckbox(quantity, bound, unselectIndex, selectIndex);
        secondCardForm.clickCheckboxOnGivenIndices(indices);
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
