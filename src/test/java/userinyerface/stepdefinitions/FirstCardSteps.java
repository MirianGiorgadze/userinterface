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
        firstCardForm.enterPassword(userModel.password());
        firstCardForm.enterEmail(userModel.email());
        firstCardForm.enterDomain(userModel.domain());
        firstCardForm.clickOnDropDownOpenerButton();
        firstCardForm.scrollTldButtonAndClick(userModel.tld());
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
