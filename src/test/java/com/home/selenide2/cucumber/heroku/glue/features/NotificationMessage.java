package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessage
{
    @Then("^header text matches regex (.*)$")
    public void get(String regex)
    {
        $x("//a[@href='/notification_message']").click();
        assertTrue($("#flash").getText().matches(regex));
    }
}
