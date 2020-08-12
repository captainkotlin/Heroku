package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.logging.LogType;

import static com.home.selenide2.common.selenide.actions.InBrowsersAction.inBrowsersAction;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavascriptError
{
    @Then("log contains error")
    public void logContainsError()
    {
        inBrowsersAction(Browsers.CHROME).add(browser ->
        {
            var list = WebDriverRunner.getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
            assertTrue(list.size() > 0);
            return null;
        })
        .execute();
    }
}
