package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import com.home.selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class Redirection
{
    @When("url requested {string}")
    public void urlRequested(String url)
    {
        SelenideUtils.open(url);
    }

    @Then("url opened {string}")
    public void urlOpened(String expectedUrl)
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(urlToBe(expectedUrl));
    }
}
