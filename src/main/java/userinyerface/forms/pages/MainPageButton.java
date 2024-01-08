package userinyerface.forms.pages;

public enum MainPageButton {
    HIDE_HELP("send"),
    ACCEPT_COOKIES("transparent"),
    UPPER_HELP("close");

    private final String buttonKeyword;

    MainPageButton(String elementKeyword) {
        this.buttonKeyword = elementKeyword;
    }

    public String getValue() {
        return buttonKeyword;
    }
}
