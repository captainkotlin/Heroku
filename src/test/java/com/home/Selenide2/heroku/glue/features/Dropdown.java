package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class Dropdown
{
    @When("{string} is selected")
    public void isSelected(String value)
    {
        $("select").selectOption(value);
    }

    @Then("selected value is {string}")
    public void selectedValueIs(String value)
    {
        $("select").getSelectedOption().should(Condition.exactText(value));
    }
}
