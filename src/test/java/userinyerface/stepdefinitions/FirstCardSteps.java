package userinyerface.stepdefinitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import userinyerface.forms.FirstCardForm;
import userinyerface.forms.FirstCardTextBox;
import userinyerface.models.UserModel;

public class FirstCardSteps {
    private final FirstCardForm firstCardForm;

    public FirstCardSteps() {
        this.firstCardForm = new FirstCardForm();
    }

    @When("I fill form using data:")
    public void fillFormUsingData(@Transpose UserModel userModel) {
        firstCardForm.fillTextBox(FirstCardTextBox.PASSWORD, userModel.password());
        firstCardForm.fillTextBox(FirstCardTextBox.EMAIL, userModel.email());
        firstCardForm.fillTextBox(FirstCardTextBox.DOMAIN, userModel.domain());
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
