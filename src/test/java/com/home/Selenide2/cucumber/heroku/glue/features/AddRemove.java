package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRemove
{
    private final String deleteButtonLocator = "//button[text()='Delete']";

    @When("button {string} is pressed")
    public void addbuttonIsPressed(String arg0)
    {
        String addButtonLocator = "//button[text()='Add Element']";
        $x(addButtonLocator).click();
    }

    @Then("{string} button is shown")
    public void buttonIsShown(String arg0)
    {
        assertTrue($x(deleteButtonLocator).isDisplayed());
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
