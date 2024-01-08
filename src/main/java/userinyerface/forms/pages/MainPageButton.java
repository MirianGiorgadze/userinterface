package userinyerface.forms.pages;

public enum MainPageButton {
    HIDE_HELP("send"),
    ACCEPT_COOKIES("transparent"),
    UPPER_HELP("close");

    private final String buttonKeyword;

    MainPageButton(String keyword) {
        this.buttonKeyword = keyword;
    }

    public String getValue() {
        return buttonKeyword;
    }
}
