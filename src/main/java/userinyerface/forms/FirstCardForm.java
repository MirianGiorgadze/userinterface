package userinyerface.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstCardForm extends Form {
    private static final String TEXTBOX_LOCATOR = "//input[contains(@placeholder,'%s')]";
    private static final String TLD_BUTTON_LOCATOR = "//div[contains(text(),'%s')]";
    private final IButton dropDownOpenerButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "Drop-down opener button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next button");
    private final ICheckBox termsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox')]"), "Terms & Conditions checkbox");
    public FirstCardForm() {
        super(By.xpath("//span[contains(@class, 'terms')]"), "First card form");
    }

    public void clickOnDropDownOpenerButton() {
        dropDownOpenerButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void fillTextBox(FirstCardTextBox textBox, String value){
        String textBoxName = textBox.getValue();
        getElementFactory().getTextBox(By.xpath(String.format(TEXTBOX_LOCATOR, textBoxName)), textBoxName + "Text Box").clearAndType(value);
    }

    public void scrollTldButtonAndClick(String chosenTld) {
        IButton tldButton = getElementFactory().getButton(By.xpath(String.format(TLD_BUTTON_LOCATOR, chosenTld)), chosenTld + " button from Drop-down list");
        tldButton.getJsActions().scrollToTheCenter();
        tldButton.click();
    }

    public void checkTermCheckbox() {
        termsCheckBox.check();
    }
}
