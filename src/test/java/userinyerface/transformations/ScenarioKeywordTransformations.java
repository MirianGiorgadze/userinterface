package userinyerface.transformations;

import io.cucumber.java.ParameterType;

public class ScenarioKeywordTransformations {
    private static final String OPENED = "opened";

    @ParameterType(OPENED + "|closed")
    public static Boolean isOpen(String value) {
        return value.equals(OPENED);
    }
}
