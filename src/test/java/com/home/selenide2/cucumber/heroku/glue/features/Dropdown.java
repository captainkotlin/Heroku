package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exactText;
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
        $("select").getSelectedOption().should(exactText(value));
    }
}
