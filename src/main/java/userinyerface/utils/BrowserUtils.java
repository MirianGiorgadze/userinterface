package userinyerface.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class BrowserUtils {

    public static void maximizeBrowser(){
        AqualityServices.getBrowser().maximize();
    }

    public static void quitBrowser(){
        AqualityServices.getBrowser().quit();
    }
}
