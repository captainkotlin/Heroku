package com.home.Selenide2.cucumber.heroku.glue.features;

import com.home.Selenide2.common.robot.RobotUtils;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.awt.*;
import java.awt.event.InputEvent;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class InfiniteScroll
{
    private final RobotUtils robotWrapper = RobotUtils.build();

    @Then("scroll eternally")
    @SneakyThrows
    public void scrollEternally()
    {
        WebElement target = $x("/html/body/div[2]/div/div/div/div/div/div[2]");
        Action action = actions()
                .moveToElement(target)
                .pause(1000)
                .build();
        action.perform();
        Robot robotWrapper = RobotUtils.build();
        robotWrapper.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robotWrapper.mouseWheel(50);
        robotWrapper.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
