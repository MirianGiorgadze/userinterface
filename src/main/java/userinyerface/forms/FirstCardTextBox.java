package userinyerface.forms;

public enum FirstCardTextBox {
    PASSWORD("Password"),
    EMAIL("email"),
    DOMAIN("Domain");

    private final String textBoxType;

    FirstCardTextBox(String placeholder) {
        this.textBoxType = placeholder;
    }

    public String getValue() {
        return textBoxType;
    }
}
