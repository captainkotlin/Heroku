package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Action;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class JqueryMenu
{
    @Then("able to click {string} button")
    public void pressed(String str)
    {
        var enabledButton = $("#ui-id-2");
        var downloadButton = $("#ui-id-4");
        var excelButton = $("#ui-id-8");
        Action action = actions()
                .moveToElement(enabledButton)
                .click()
                .pause(1000)
                .moveToElement(downloadButton)
                .click()
                .pause(1000)
                .moveToElement(excelButton)
                .build();
        action.perform();
    }
}
