package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class KeyPresses
{
    @When("{string} pressed")
    public void pressed(String arg0)
    {
        $("#target").sendKeys(arg0);
    }

    @Then("element contains text {string}")
    public void elementContainsText(String arg0)
    {
        Assertions.assertEquals(arg0, $("#target").getValue());
    }
}
