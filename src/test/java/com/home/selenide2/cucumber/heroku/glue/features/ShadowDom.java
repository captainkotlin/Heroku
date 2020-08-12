package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDom
{
    @Then("span contains text: {string}")
    public void spanContainsText(String expectedText)
    {
        var actualText = $x("//my-paragraph/span").getText();
        assertEquals(expectedText, actualText);
    }
}
