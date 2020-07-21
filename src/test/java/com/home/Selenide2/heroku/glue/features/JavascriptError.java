package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class JavascriptError
{
    @Then("log contains error")
    public void logContainsError()
    {
        List<LogEntry> list = WebDriverRunner.getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        Assertions.assertTrue(list.size() > 0);
    }
}
