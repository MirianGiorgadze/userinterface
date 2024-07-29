package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

import static userinyerface.utils.RegexUtils.getMatchingString;

public class MainPage extends Form {

    private final ILink fileUploadLink = getElementFactory().getLink(By.xpath("//a[text()='File Upload']"), "File Upload link");

    public MainPage() {
        super(By.xpath("//h1[contains(text(), 'Welcome')]"), "Main page");
    }

    public void clickFileUploadLink() {
        fileUploadLink.clickAndWait();
    }
}
