package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import userinyerface.forms.pages.UploadPage;

public class UploadPageSteps {
    private final UploadPage uploadPage;

    public UploadPageSteps() {
        this.uploadPage = new UploadPage();
    }

    @When("I click the choose file button")
    public void uploadFile() {
        uploadPage.clickChooseFileButton();
    }

    @Step("Clicking upload Button")
    @When("I click the upload button")
    public void clickUploadButton() {
        uploadPage.clickUploadButton();
    }

    @Step("Checking if upload page is open")
    @Then("Upload page is opened")
    public void verifyUploadPageOpened() {
        uploadPage.state().waitForDisplayed();
    }
}
