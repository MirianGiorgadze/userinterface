package userinyerface.hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.TestResultContainer;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import static userinyerface.utils.BrowserUtils.maximizeBrowser;
import static userinyerface.utils.BrowserUtils.quitBrowser;

public class BrowserHooks {

    @Step("Maximize browser")
    @Before("@ConfigureDriver")
    public void setUp() {
        maximizeBrowser();
    }

    @Step("Quit Browser")
    @After
    public void tearDown(Scenario scenario) {
        byte[] screenshot = AqualityServices.getBrowser().getScreenshot();
        Allure.addAttachment(scenario.getName() + " test Scenario screenshot", new ByteArrayInputStream(screenshot));
        quitBrowser();
    }
}
