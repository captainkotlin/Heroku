package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.base.Function;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeoutException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.util.concurrent.TimeUnit.SECONDS;

public class InfiniteScroll
{
    @Then("scroll eternally")
    public void scrollEternally()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(3, SECONDS)
//                .pollingEvery(1, SECONDS)
//                .ignoring(TimeoutException.class);
//        wait.until((Function<WebDriver, Boolean>) o -> true);

        WebElement target = $x("/html/body/div[2]/div/div/div/div/div/div[2]");
        Action action = new Actions(driver)
                .moveToElement(target)
                .pause(1000)
                .build();
        action.perform();

        try
        {
            System.setProperty("java.awt.headless", "false");
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseWheel(50);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }


    }
}
