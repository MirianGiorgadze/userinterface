package userinyerface;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Constants {
    public static final ISettingsFile CONFIG_FILE = new JsonSettingsFile("config.json");
    public static final ISettingsFile TEST_DATA = new JsonSettingsFile("testData.json");

}
