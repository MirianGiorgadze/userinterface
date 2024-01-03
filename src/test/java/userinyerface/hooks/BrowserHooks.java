package userinyerface.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static userinyerface.utils.BrowserUtils.maximizeBrowser;
import static userinyerface.utils.BrowserUtils.quitBrowser;

public class BrowserHooks {
    @Before("@ConfigureDriver")
    public void setUp() {
        maximizeBrowser();
    }

    @After
    public void tearDown() {
        quitBrowser();
    }
}
