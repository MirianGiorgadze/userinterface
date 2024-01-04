package userinyerface;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import userinyerface.forms.pages.MainPage;
import userinyerface.forms.pages.WelcomePage;
import userinyerface.forms.FirstCardForm;
import userinyerface.forms.SecondCardForm;
import userinyerface.forms.ThirdCardForm;
import org.testng.annotations.Test;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getLogger;
import static org.testng.Assert.*;
import static userinyerface.utils.RandomTestDataUtils.getIndicesListForCheckbox;

public class UserinyerfaceTest extends UserinyerfaceBaseTest {
    @Test(testName = "Test case 1")
    public void cardsTest() {
        ISettingsFile testData = new JsonSettingsFile("testData.json");
        getLogger().info("Step 1: Navigate to home page.");
        WelcomePage welcomePage = new WelcomePage();
        assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened.");

        getLogger().info("Step 2: Click the link (in text 'Please click HERE to GO to the next page') to navigate the next page.");
        welcomePage.clickOnHereLink();
        getBrowser().waitForPageToLoad();

        MainPage mainPage = new MainPage();
        assertTrue(mainPage.state().isDisplayed(), "The '1' card is not opened.");

        getLogger().info("Step 3: Input random valid password, email, accept the terms of use and click \"next\" button.");
        FirstCardForm firstCardForm = new FirstCardForm();
        int emailLength = Integer.parseInt(testData.getValue("/firstCard/emailLength").toString());
        int domainLength = Integer.parseInt(testData.getValue("/firstCard/domainLength").toString());
        firstCardForm.fillFormWithRandomValues(emailLength, domainLength);
        firstCardForm.clickOnDropDownOpenerButton();
        firstCardForm.scrollTldButtonAndClick(".com");
        firstCardForm.checkTermCheckbox();
        firstCardForm.clickOnNextButton();

        SecondCardForm secondCardForm = new SecondCardForm();
        assertTrue(secondCardForm.state().isDisplayed(), "The '2' card is not opened.");
        getLogger().info("Step 4: Choose 2 random interests, upload image, click \"Next\" button.");
        int quantity  = Integer.parseInt(testData.getValue("/secondCard/quantityToCheck").toString());
        int bound = Integer.parseInt(testData.getValue("/secondCard/checkboxOverallQuantity").toString());
        int selectIndex = Integer.parseInt(testData.getValue("/secondCard/selectAllCheckboxIndex").toString());
        int unselectIndex = Integer.parseInt(testData.getValue("/secondCard/unselectAllCheckboxIndex").toString());
        List<Integer> indices = getIndicesListForCheckbox(quantity, bound, unselectIndex, selectIndex);
        secondCardForm.clickCheckboxOnGivenIndices(indices);
        secondCardForm.clickOnUploadButton();
        secondCardForm.SendPicture();
        secondCardForm.clickOnNextButton();

        ThirdCardForm thirdCardForm = new ThirdCardForm();
        assertTrue(thirdCardForm.state().waitForDisplayed(), "The '3' card is not opened.");
    }

    @Test(testName = "Test case 2")
    public void helpFormTest() {
        getLogger().info("Step 1: Navigate to home page.");
        WelcomePage welcomePage = new WelcomePage();
        assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened.");

        getLogger().info("Step 2: Hide help form.");
        welcomePage.clickOnHereLink();
        getBrowser().waitForPageToLoad();

        MainPage mainPage = new MainPage();
        mainPage.clickOnHideHelpFormButton();
        assertTrue(mainPage.upperHelpFormButtonIsNotDisplayed(), "Form content is not hidden.");
    }

    @Test(testName = "Test case 3")
    public void acceptCookiesTest() {
        getLogger().info("Step 1: Navigate to home page.");
        WelcomePage welcomePage = new WelcomePage();
        assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not opened.");
        welcomePage.clickOnHereLink();
        MainPage mainPage = new MainPage();
        mainPage.clickOnAcceptCookiesButton();
        assertFalse(mainPage.acceptCookiesButtonIsDisplayed(), "Cookie form is not closed");
    }

    @Test(testName = "Test case 4")
    public void timerTest() {
        getLogger().info("Step 1: Navigate to home page.");
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickOnHereLink();
        MainPage mainPage = new MainPage();
        ISettingsFile testData = new JsonSettingsFile("testData.json");
        assertEquals(mainPage.getTimerValue(), testData.getValue("/mainPage/startTime"), "Timer is not started from \"00:00\"");
    }
}
