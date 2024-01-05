package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

import static userinyerface.utils.RegexUtils.getMatchingString;

public class MainPage extends Form {
    private enum MainPageElement {
        SEND("send"),
        TRANSPARENT("transparent"),
        CLOSE("close");

        private final String elementKeyword;

        MainPageElement(String elementKeyword) {
            this.elementKeyword = elementKeyword;
        }

        private String getXpath() {
            return String.format("//button[contains(@class,'%s')]", elementKeyword);
        }
    }

    private final IButton hideHelpFormButton = getElementFactory().getButton(By.xpath(MainPageElement.SEND.getXpath()), "Hide help form button");
    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath(MainPageElement.TRANSPARENT.getXpath()), "Accept cookies button");
    private final IButton upperHelpFormButton = getElementFactory().getButton(By.xpath(MainPageElement.CLOSE.getXpath()), "Upper help form button");
    private final ILabel timer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "Timer");

    public MainPage() {
        super(By.xpath("//span[contains(@class,'terms')]"), "Main page");
    }

    public void clickOnHideHelpFormButton() {
        hideHelpFormButton.click();
    }

    public boolean acceptCookiesButtonIsDisplayed() {
        return acceptCookiesButton.state().isDisplayed();
    }

    public boolean upperHelpFormButtonIsNotDisplayed(int waitSeconds) {
        return upperHelpFormButton.state().waitForNotDisplayed(Duration.ofSeconds(waitSeconds));
    }

    public void clickOnAcceptCookiesButton() {
        acceptCookiesButton.clickAndWait();
    }

    public String getTimerValue() {
        return getMatchingString(timer.getText(), "^\\d{2}:\\d{2}");
    }
}
