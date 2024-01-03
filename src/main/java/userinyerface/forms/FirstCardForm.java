package userinyerface.forms;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import userinyerface.utils.RandomTestDataUtils;

public class FirstCardForm extends Form {
    private final IButton dropDownOpenerButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "Drop-down opener button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next button");
    private final ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password form");
    private final ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email form");
    private final ITextBox domainTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain form");
    private final ICheckBox termsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox')]"), "Terms & Conditions checkbox");
    private final String tldButtonLocator = "//div[contains(text(),'%s')]";

    public FirstCardForm() {
        super(By.xpath("//span[contains(@class, 'terms')]"), "First card form");
    }

    public void clickOnDropDownOpenerButton() {
        dropDownOpenerButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void fillForm() {
        passwordTextBox.clearAndType(RandomTestDataUtils.generateRandomValidPassword());
        emailTextBox.clearAndType(RandomTestDataUtils.generateRandomEmail(5));
        domainTextBox.clearAndType(RandomTestDataUtils.generateRandomDomain(5));
    }

    public void fillForm(String password, String email, String domain) {
        passwordTextBox.clearAndType(password);
        emailTextBox.clearAndType(email);
        domainTextBox.clearAndType(domain);
    }

    public void scrollTldButtonAndClick(String chosenTld) {
        IButton tldButton = getElementFactory().getButton(By.xpath(String.format(tldButtonLocator, chosenTld)), chosenTld + " button from Drop-down list");
        tldButton.getJsActions().scrollToTheCenter();
        tldButton.click();
    }

    public void checkTermCheckbox() {
        termsCheckBox.check();
    }

    private void deleteDataFromField(IElement textBox) {
        textBox.sendKeys(Keys.CONTROL + "A");
        textBox.sendKeys(Keys.DELETE);
    }
}