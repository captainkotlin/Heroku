package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;

public class JqueryMenu
{
    @Then("able to click {string} button")
    public void pressed(String str)
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        SelenideElement enabledButton = $("#ui-id-2");
        SelenideElement downloadButton = $("#ui-id-4");
        SelenideElement excelButton = $("#ui-id-8");
        Action action = new Actions(driver)
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
