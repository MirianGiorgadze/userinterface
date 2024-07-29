package userinyerface.forms.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FileUploadedPage extends Form {
    private static final String LOC_FILE_NAME = "//div[@id='uploaded-files'][contains(text(), 'Koshi.jpg')]";

    public FileUploadedPage(){
        super(By.xpath("//h3[text()='File Uploaded!']"), "fileuploaded");
    }

    public boolean isMessagePresent(){
        return AqualityServices.getElementFactory().getLabel(By.xpath("//h3[text()='File Uploaded!']"), "File Uploaded")
                .state().waitForDisplayed();
    }

    public boolean isFileUploaded(String fileName){
        return AqualityServices.getElementFactory().getLabel(By.xpath(String.format(LOC_FILE_NAME, fileName)), "File Uploaded")
                .state().waitForDisplayed();
    }
}
