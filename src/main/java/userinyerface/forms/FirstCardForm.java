package userinyerface.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstCardForm extends Form {
    private enum FirstCardTextBox {
        PASSWORD("Password"),
        EMAIL("email"),
        DOMAIN("Domain");

        private final String textBoxType;

        FirstCardTextBox(String placeholder) {
            this.textBoxType = placeholder;
        }

        private String getXpath() {
            return String.format("//input[contains(@placeholder,'%s')]", textBoxType);
        }
    }

    private final IButton dropDownOpenerButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "Drop-down opener button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next button");
    private final ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath(FirstCardTextBox.PASSWORD.getXpath()), "Password form");
    private final ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath(FirstCardTextBox.EMAIL.getXpath()), "Email form");
    private final ITextBox domainTextBox = getElementFactory().getTextBox(By.xpath(FirstCardTextBox.DOMAIN.getXpath()), "Domain form");
    private final ICheckBox termsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox')]"), "Terms & Conditions checkbox");
    private static final String TLD_BUTTON_LOCATOR = "//div[contains(text(),'%s')]";

    public FirstCardForm() {
        super(By.xpath("//span[contains(@class, 'terms')]"), "First card form");
    }

    public void clickOnDropDownOpenerButton() {
        dropDownOpenerButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void enterPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void enterEmail(String email) {
        emailTextBox.clearAndType(email);
    }

    public void enterDomain(String domain) {
        domainTextBox.clearAndType(domain);
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
