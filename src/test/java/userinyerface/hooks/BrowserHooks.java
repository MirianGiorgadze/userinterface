package userinyerface.hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserHooks {
    @Before("@ConfigureDriver")
    public void setUp() {
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @After
    public void tearDown() {
        Browser browser = AqualityServices.getBrowser();
        browser.quit();
    }
}
