package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class Inputs
{
    @When("{string} is typed")
    public void isTyped(String arg0)
    {
        $x("/html/body/div[2]/div/div/div/div/input").setValue(arg0);
    }

    @Then("field is filled with {string}")
    public void fieldIsFilledWith(String arg0)
    {
        Assertions.assertEquals(arg0, $x("/html/body/div[2]/div/div/div/div/input").getValue());
    }
}
