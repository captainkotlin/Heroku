package com.home.Selenide2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SomeTest
{
    @Test
    void myTestMethod()
    {
        open("https://www.techlistic.com/p/selenium-practice-form.html");

        SelenideElement e = $(By.id("photo"));
        e.scrollTo();
        e.waitUntil(Condition.visible, 6000);
        e.sendKeys("/home/alexander/Downloads/0.jpg");
        Robot bot = null;
        try
        {
            Point pt = e.getCoordinates().inViewPort();
            bot = new Robot();
            bot.mouseMove(pt.getX(), pt.getY());
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (AWTException awtException)
        {
            awtException.printStackTrace();
        }
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
        e.click();
        e.doubleClick();
    }
    ////
}
