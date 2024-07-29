package userinyerface.stepdefinitions;

import io.cucumber.java.en.When;
import userinyerface.utils.BrowserUtils;
import userinyerface.utils.FileUtils;

public class SystemSteps {
    @When("I upload file")
    public void uploadFile() {
        FileUtils.attachFile("src/test/resources/Koshi.jpg");
    }

    @When("I Navigate to Main page")
    public void navigateToMainPage() {
        BrowserUtils.navigateTo("https://the-internet.herokuapp.com/");
        BrowserUtils.maximizeBrowser();
    }
}
