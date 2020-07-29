package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import com.home.Selenide2.common.RobotWrapper;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

import static com.codeborne.selenide.Selenide.$x;

public class InfiniteScroll
{
    private final RobotWrapper robotWrapper = RobotWrapper.build();

    @Then("scroll eternally")
    @SneakyThrows
    public void scrollEternally()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebElement target = $x("/html/body/div[2]/div/div/div/div/div/div[2]");
        Action action = new Actions(driver)
                .moveToElement(target)
                .pause(1000)
                .build();
        action.perform();
        Robot robotWrapper = RobotWrapper.build();
        robotWrapper.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robotWrapper.mouseWheel(50);
        robotWrapper.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
