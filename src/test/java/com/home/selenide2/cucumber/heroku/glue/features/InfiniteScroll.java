package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.robot.RobotUtils;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;

import java.awt.event.InputEvent;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class InfiniteScroll
{
    @Then("scroll eternally")
    @SneakyThrows
    public void scrollEternally()
    {
        var target = $x("/html/body/div[2]/div/div/div/div/div/div[2]");
        var action = actions()
                .moveToElement(target)
                .pause(1000)
                .build();
        action.perform();
        var robotWrapper = RobotUtils.build();
        robotWrapper.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robotWrapper.mouseWheel(50);
        robotWrapper.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
