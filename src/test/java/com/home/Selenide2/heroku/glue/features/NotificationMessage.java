package com.home.Selenide2.heroku.glue.features;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationMessage
{
    @Then("^header text matches regex (.*)$")
    public void get(String regex)
    {
        $x("//a[@href='/notification_message']").click();
        Assertions.assertTrue($("#flash").getText().matches(regex));
    }
}
