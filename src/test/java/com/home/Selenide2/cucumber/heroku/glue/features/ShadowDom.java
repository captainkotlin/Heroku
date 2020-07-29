package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class ShadowDom
{
    @Then("span contains text: {string}")
    public void spanContainsText(String expectedText)
    {
        String actualText = $x("//my-paragraph/span").getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}
