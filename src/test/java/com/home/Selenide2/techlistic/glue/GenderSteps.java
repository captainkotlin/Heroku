package com.home.Selenide2.techlistic.glue;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.techlistic.glue.background.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GenderSteps
{
    @Autowired
    private Page back;

    private SelenideElement elementToSelect;
    private SelenideElement elementToDeselect;

    @When("^(.*) was pressed$")
    public void male_was_pressed(String genderButton)
    {
        switch (genderButton)
        {
            case "Male":
                elementToSelect = back.maleRadio();
                elementToDeselect = back.femaleRadio();
                break;
            case "Female":
                elementToSelect = back.femaleRadio();
                elementToDeselect = back.maleRadio();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        elementToSelect.click();
    }

    @Then("related item is selected")
    public void related_item_is_selected()
    {
        Assertions.assertTrue(elementToSelect.isSelected());
        Assertions.assertFalse(elementToDeselect.isSelected());
    }

}
