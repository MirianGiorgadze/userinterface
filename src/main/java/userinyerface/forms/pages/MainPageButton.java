package userinyerface.forms.pages;

import lombok.Getter;

@Getter
public enum MainPageButton {
    HIDE_HELP("send"),
    ACCEPT_COOKIES("transparent"),
    UPPER_HELP("close");

    private final String value;

    MainPageButton(String keyword) {
        this.value = keyword;
    }
}
