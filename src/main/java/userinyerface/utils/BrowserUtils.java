package userinyerface.utils;

import aquality.selenium.browser.AqualityServices;

public class BrowserUtils {

    public static void maximizeBrowser() {
        AqualityServices.getBrowser().maximize();
    }

    public static void quitBrowser() {
        AqualityServices.getBrowser().quit();
    }

    public static void navigateTo(String url) {
        AqualityServices.getBrowser().goTo(url);
    }
}
