package userinyerface.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class SecondCardForm extends Form {
    private final String checkboxLocator = "//div[contains(@class,'list')][%d]//span[contains(@class,'checkbox_')]";
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload')]"), "Upload button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next button");

    public SecondCardForm() {
        super(By.xpath("//a[contains(@class,'upload')]"), "Second card form");
    }

    public void clickOnUploadButton() {
        uploadButton.click();
    }

    private ICheckBox getCheckbox(Integer index) {
        String locator = String.format(checkboxLocator, index);
        return getElementFactory().getCheckBox(By.xpath(locator), "Random checkbox index:" + index.toString());
    }

    public void clickCheckboxOnGivenIndices(List<Integer> chosenIndices) {
        for (int index : chosenIndices) {
            getCheckbox(index).toggle();
        }
    }

    public void clickOnNextButton() {
        nextButton.getJsActions().scrollToTheCenter();
        nextButton.clickAndWait();
    }

    public void SendPicture() {
        AqualityServices.getLogger().info("Upload picture on the site");
        File file = new File("src/test/resources/Koshi.jpg");
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
            Robot r = new Robot();
            r.delay(500);
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(500);
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Can't press buttons with Robot class");
            throw new RuntimeException(e);
        }
    }
}