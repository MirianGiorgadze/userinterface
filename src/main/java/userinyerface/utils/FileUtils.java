package userinyerface.utils;

import aquality.selenium.browser.AqualityServices;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUtils {
    public static void sendPicture() {
        AqualityServices.getLogger().info("Upload picture on the site");
        File file = new File("src/test/resources/Koshi.jpg");
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(1000);
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Can't press buttons with Robot class");
            throw new RuntimeException(e);
        }
    }
}
