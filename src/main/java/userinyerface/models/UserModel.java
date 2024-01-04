package userinyerface.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserModel {
    private String password;
    private String email;
    private String domain;
    private String tld;
}
