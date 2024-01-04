package userinyerface.stepdefinitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import userinyerface.forms.FirstCardForm;
import userinyerface.models.UserModel;


public class FirstCardSteps {

    private final FirstCardForm firstCardForm;

    public FirstCardSteps() {
        this.firstCardForm = new FirstCardForm();
    }

    @When("I fill form using data:")
    public void fillFormUsingData(@Transpose UserModel userModel) {
        firstCardForm.fillFormWithCustomValues(userModel.getPassword(), userModel.getEmail(), userModel.getDomain());
        firstCardForm.clickOnDropDownOpenerButton();
        firstCardForm.scrollTldButtonAndClick(userModel.getTld());
    }

    @When("Check term checkBox")
    public void checkTermCheckbox() {
        firstCardForm.checkTermCheckbox();
    }

    @And("Click on first card next button")
    public void clickOnNextButton() {
        firstCardForm.clickOnNextButton();
    }
}
