package userinyerface.transformations;

import io.cucumber.java.DataTableType;
import userinyerface.models.UserModel;

import java.util.Map;

public class UserEntryTransformations {

    @DataTableType
    public UserModel userEntryTransformer(Map<String, String> entry) {
        return new UserModel(entry.get("Password"), entry.get("Email"), entry.get("Domain"), entry.get("Tld"));
    }
}
