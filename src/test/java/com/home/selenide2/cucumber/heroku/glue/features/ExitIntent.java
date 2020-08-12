package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.home.selenide2.cucumber.heroku.glue.other.actions.CustomizedActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ExitIntent
{
    @When("cursor is out of vision")
    public void cursorIsOutOfVision()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        var action = new CustomizedActions(driver)
                .moveMouseY(0)
                .build();
        action.perform();
    }

    @Then("modal window is shown")
    public void modalWindowIsShown()
    {
        String modalTitleSelector = ".modal";
        $(modalTitleSelector).should(Condition.visible);
    }
}
