package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Redirection
{
    @When("url requested {string}")
    public void urlRequested(String url)
    {
        Selenide.open(url);
    }

    @Then("url opened {string}")
    public void urlOpened(String expectedUrl)
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
