package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSlider
{
    private final WebElement slider = $x("/html/body/div[2]/div/div/div/input");

    @When("slider moved to top right")
    public void sliderMovedToTopRight()
    {
        var action = actions().dragAndDropBy(slider, 100, 0).build();
        action.perform();
    }

    @Then("slider value is {string}")
    public void sliderValueIs(String expectedValue)
    {
        var actualValue = slider.getAttribute("value");
        assertEquals(expectedValue, actualValue);
    }
}
