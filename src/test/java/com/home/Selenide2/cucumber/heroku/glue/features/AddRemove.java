package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class AddRemove
{
    private final String addButtonLocator = "//button[text()='Add Element']";
    private final String deleteButtonLocator = "//button[text()='Delete']";

    @When("button {string} is pressed")
    public void addbuttonIsPressed(String arg0)
    {
        $x(addButtonLocator).click();
    }

    @Then("{string} button is shown")
    public void buttonIsShown(String arg0)
    {
        $x(deleteButtonLocator).isDisplayed();
    }

    @When("{string} button is pressed")
    public void deletebuttonIsPressed(String arg0)
    {
        $x(deleteButtonLocator).click();
    }

    @Then("Then {string} button is removed")
    public void thenButtonIsRemoved(String arg0)
    {
        $x(deleteButtonLocator).shouldNot(exist);
    }
}
