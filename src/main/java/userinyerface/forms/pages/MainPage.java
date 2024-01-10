package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import userinyerface.utils.RegexConstants;

import java.time.Duration;

import static userinyerface.utils.RegexUtils.getMatchingString;

public class MainPage extends Form {
    private static final String BUTTON_LOCATOR = "//button[contains(@class,'%s')]";
    private final ILabel timer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "Timer");

    public MainPage() {
        super(By.xpath("//span[contains(@class,'terms')]"), "Main page");
    }

    public boolean isButtonHiddenAfterWait(MainPageButton button, int waitSeconds) {
        String buttonName = button.getValue();
        return getElementFactory().getButton(By.xpath(String.format(BUTTON_LOCATOR, buttonName)), buttonName + "Button")
                .state().waitForNotDisplayed(Duration.ofSeconds(waitSeconds));
    }

    public boolean buttonIsDisplayed(MainPageButton button) {
        String buttonName = button.getValue();
        return getElementFactory().getButton(By.xpath(String.format(BUTTON_LOCATOR, buttonName)), buttonName + "Button").state().waitForDisplayed();
    }

    public void clickButton(MainPageButton button) {
        String buttonName = button.getValue();
        getElementFactory().getButton(By.xpath(String.format(BUTTON_LOCATOR, buttonName)), buttonName + "Button").clickAndWait();
    }

    public String getTimerValue() {
        return getMatchingString(timer.getText(), RegexConstants.TIME_REG_EXP);
    }
}
