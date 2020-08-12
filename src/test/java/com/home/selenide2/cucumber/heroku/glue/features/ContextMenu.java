package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.robot.RobotUtils;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class ContextMenu
{
    private String hotSpotSelector = "#hot-spot";

    @When("right click is done on field")
    public void rightClickIsDoneOnField()
    {
        $(hotSpotSelector).contextClick();
    }

    @When("handle alert")
    public void handleAlert()
    {
        confirm();
        RobotUtils.build().mouseClick();
    }
}
