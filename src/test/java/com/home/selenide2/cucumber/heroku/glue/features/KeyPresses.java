package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyPresses
{
    @When("{string} pressed")
    public void pressed(String strToPress)
    {
        $("#target").sendKeys(strToPress);
    }

    @Then("element contains text {string}")
    public void elementContainsText(String expectedTest)
    {
        assertEquals(expectedTest, $("#target").getValue());
    }
}
