package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class HorizontalSlider
{
    private final WebElement slider = $x("/html/body/div[2]/div/div/div/input");

    @When("slider moved to top right")
    public void sliderMovedToTopRight()
    {
        Action action = actions().dragAndDropBy(slider, 80, 0).build();
        action.perform();
    }

    @Then("slider value is {string}")
    public void sliderValueIs(String expectedValue)
    {
        String actualValue = slider.getAttribute("value");
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
