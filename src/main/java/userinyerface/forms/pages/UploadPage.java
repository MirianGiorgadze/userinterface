package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class UploadPage extends Form {
    private final IButton uploadButton = getElementFactory().getButton(By.id("file-submit"), "Upload Button");
    private final IButton chooseFileButton = getElementFactory().getButton(By.xpath("//input[@id='file-upload']"), "Choose File");

    public UploadPage() {
        super(By.xpath("//h3[text()='File Uploader']"), "File Upload page");
    }

    public void clickUploadButton() {
        uploadButton.getJsActions().clickAndWait();
    }

    @Step("Clicking choose file button")
    public void clickChooseFileButton(){
        chooseFileButton.getMouseActions().moveMouseToElement();
        chooseFileButton.getMouseActions().click();
    }
}
