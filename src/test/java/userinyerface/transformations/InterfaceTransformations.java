package userinyerface.transformations;

import io.cucumber.java.ParameterType;

public class InterfaceTransformations {
    @ParameterType("opened|closed")
    public static Boolean isOpen(String value){
        return value.equals("opened");
    }
}
