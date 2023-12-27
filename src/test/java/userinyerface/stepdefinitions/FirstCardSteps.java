package userinyerface.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import userinyerface.forms.FirstCard;

import java.util.List;


public class FirstCardSteps {

    private final FirstCard firstCard;

    public FirstCardSteps(){
        this.firstCard = new FirstCard();
    }

    @When("I fill form using data")
    public void fill_form_using_data(DataTable table) {
        List <List <String>> data = table.asLists(String.class);
        firstCard.fillForm(data.get(1).get(0), data.get(1).get(1),data.get(1).get(2));
    }

    @When("Click on drop down opener button")
    public void click_on_drop_down_opener_button() {
        firstCard.clickOnDropDownOpenerButton();
    }

    @When("Scroll to dotcom button and click")
    public void scroll_to_dotcom_button_and_click(){
        firstCard.scrollToDotComButtonAndClick();
    }

    @When("Check term checkBox")
    public void check_term_checkbox() {
        firstCard.checkTermCheckbox();
    }

    @When("Click on firstcard next button")
    public void click_on_Next_button() {
        firstCard.clickOnNextButton();
    }
}
