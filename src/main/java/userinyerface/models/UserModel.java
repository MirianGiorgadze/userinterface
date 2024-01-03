package userinyerface.models;

import lombok.Data;

@Data
public class UserModel {
    private String password;
    private String email;
    private String domain;
    private String tld;

    public UserModel(String password, String email, String domain, String tld) {
        this.password = password;
        this.email = email;
        this.domain = domain;
        this.tld = tld;
    }
}
