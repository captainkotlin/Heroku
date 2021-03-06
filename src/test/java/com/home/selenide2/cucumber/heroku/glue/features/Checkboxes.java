package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$x;

public class Checkboxes
{
    private final String checkbox1 = "//form/input[@type='checkbox'][1]";
    private final String checkbox2 = "//form/input[@type='checkbox'][2]";

    @When("checkbox1 was selected")
    public void checkboxWasSelected()
    {
        $x(checkbox1).click();
    }

    @Then("checkbox1 is selected")
    public void checkboxIsSelected()
    {
        $x(checkbox1).should(checked);
    }

    @When("checkbox2 was selected")
    public void checkbox2WasSelected()
    {
        $x(checkbox2).click();
    }

    @Then("checkbox2 is selected")
    public void checkbox2IsDeselected()
    {
        $x(checkbox2).shouldNot(checked);
    }
}
