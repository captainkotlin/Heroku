package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class NewWindow
{
    @When("button clicked")
    public void openUrl()
    {
        $x("//a[@href='/windows/new']").click();
    }

    @Then("new window was opened")
    public void newWindowWasOpened()
    {
        var windowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        var driver = WebDriverRunner.getWebDriver();
        driver.switchTo().window(windowHandles.get(0));
        WebDriverRunner.getWebDriver().switchTo().window(windowHandles.get(1));
    }
}
