package userinyerface.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SecondCardForm extends Form {
    private static final String CHECKBOX_LOCATOR = "//div[contains(@class,'list')][%d]//span[contains(@class,'checkbox_')]";
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload')]"), "Upload button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next button");

    public SecondCardForm() {
        super(By.xpath("//a[contains(@class,'upload')]"), "Second card form");
    }

    public void clickOnUploadButton() {
        uploadButton.click();
    }

    private ICheckBox getCheckbox(Integer index) {
        String locator = String.format(CHECKBOX_LOCATOR, index);
        return getElementFactory().getCheckBox(By.xpath(locator), "Random checkbox index:" + index.toString());
    }

    public void clickCheckboxOnGivenIndex(int chosenIndex) {
        getCheckbox(chosenIndex).toggle();
    }

    public void clickOnNextButton() {
        nextButton.getJsActions().scrollToTheCenter();
        nextButton.clickAndWait();
    }
}
