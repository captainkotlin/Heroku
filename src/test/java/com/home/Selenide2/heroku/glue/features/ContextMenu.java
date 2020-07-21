package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class ContextMenu
{
    @When("right click is done on field")
    public void rightClickIsDoneOnField()
    {
        $("#hot-spot").contextClick();
    }

    @When("handle alert")
    public void handleAlert()
    {
        Selenide.confirm();
    }
}
