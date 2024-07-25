package userinyerface.hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

import static userinyerface.utils.BrowserUtils.maximizeBrowser;
import static userinyerface.utils.BrowserUtils.quitBrowser;

public class BrowserHooks {

    @Before("@ConfigureDriver")
    public void setUp() {
        maximizeBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] screenshot = AqualityServices.getBrowser().getScreenshot();
        Allure.addAttachment(scenario.getName() + " test Scenario screenshot", new ByteArrayInputStream(screenshot));
        quitBrowser();
    }
}
