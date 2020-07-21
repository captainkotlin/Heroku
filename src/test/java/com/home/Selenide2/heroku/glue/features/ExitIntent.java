package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import com.home.Selenide2.heroku.glue.other.actions.CustomizedActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;

import static com.codeborne.selenide.Selenide.$;

public class ExitIntent
{
    @When("cursor is out of vision")
    public void cursorIsOutOfVision()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Action a = new CustomizedActions(driver)
                .moveMouseY(0)
                .build();
        a.perform();
    }

    @Then("modal window is shown")
    public void modalWindowIsShown()
    {
        Assertions.assertTrue($(".modal-title").isDisplayed());
    }
}
