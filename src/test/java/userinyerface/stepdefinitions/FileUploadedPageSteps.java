package userinyerface.stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import userinyerface.forms.pages.FileUploadedPage;

public class FileUploadedPageSteps {
    FileUploadedPage fileUploadedPage;

    public FileUploadedPageSteps() {
        this.fileUploadedPage = new FileUploadedPage();
    }

    @Then("There is File Uploaded message with name of {string}")
    public void verifyFileUploadedMessage(String fileName) {
        Assert.assertTrue(fileUploadedPage.isFileUploaded(fileName) && fileUploadedPage.isMessagePresent(), "Messages are not present");
    }

    @Then("File upload page is opened")
    public void verifyFileUploadPageIsOpened() {
        Assert.assertTrue(fileUploadedPage.state().waitForDisplayed(), "Verify File upload page is not opened");
    }
}
