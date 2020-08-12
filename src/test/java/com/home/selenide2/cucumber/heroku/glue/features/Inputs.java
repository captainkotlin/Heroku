package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Inputs
{
    @When("{string} is typed")
    public void isTyped(String str)
    {
        $x("/html/body/div[2]/div/div/div/div/input").setValue(str);
    }

    @Then("field is filled with {string}")
    public void fieldIsFilledWith(String expectedStr)
    {
        assertEquals(expectedStr, $x("/html/body/div[2]/div/div/div/div/input").getValue());
    }
}
