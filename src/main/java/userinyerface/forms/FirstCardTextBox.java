package userinyerface.forms;

import lombok.Getter;

@Getter
public enum FirstCardTextBox {
    PASSWORD("Password"),
    EMAIL("email"),
    DOMAIN("Domain");

    private final String value;

    FirstCardTextBox(String placeholder) {
        this.value = placeholder;
    }
}
