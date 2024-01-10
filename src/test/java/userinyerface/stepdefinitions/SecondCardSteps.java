package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userinyerface.forms.SecondCardForm;
import userinyerface.utils.FileUtils;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.assertEquals;
import static userinyerface.Constants.TEST_DATA;
import static userinyerface.utils.RandomTestDataUtils.getIndexListForCheckbox;

public class SecondCardSteps {
    private final SecondCardForm secondCardForm;

    public SecondCardSteps() {
        this.secondCardForm = new SecondCardForm();
    }

    @Then("Second card is {isOpen}")
    public void secondCardIsDisplayed(boolean isOpen) {
        assertEquals(secondCardForm.state().isDisplayed(), isOpen, "The '2' card is not opened.");
    }

    @When("I click on three checkbox")
    public void clickOnThreeCheckbox() {
        getLogger().info("Step 4: Choose 2 random interests, upload image, click \"Next\" button.");
        int quantity = Integer.parseInt(TEST_DATA.getValue("/secondCard/quantityToCheck").toString());
        int bound = Integer.parseInt(TEST_DATA.getValue("/secondCard/checkboxOverallQuantity").toString());
        int selectIndex = Integer.parseInt(TEST_DATA.getValue("/secondCard/selectAllCheckboxIndex").toString());
        int unselectIndex = Integer.parseInt(TEST_DATA.getValue("/secondCard/unselectAllCheckboxIndex").toString());
        List<Integer> indexes = getIndexListForCheckbox(quantity, bound, unselectIndex, selectIndex);
        for (int index : indexes) {
            secondCardForm.clickCheckboxOnGivenIndex(index);
        }
    }

    @When("Click upload button")
    public void clickUploadButton() {
        secondCardForm.clickOnUploadButton();
    }

    @When("Send picture")
    public void sendPicture() {
        FileUtils.attachFile(String.valueOf(TEST_DATA.getValue("/secondCard/imagePath")));
    }

    @When("Click on second card next button")
    public void clickNextButton() {
        secondCardForm.clickOnNextButton();
    }
}
