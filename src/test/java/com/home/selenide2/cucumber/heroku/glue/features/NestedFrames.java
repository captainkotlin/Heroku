package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Function;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrames
{
    @When("{list} frame is selected")
    public void srcFrameIsSelected(List<String> frameNames)
    {
        Function<String, WebDriver> goToFrame = WebDriverRunner.getWebDriver().switchTo()::frame;
        frameNames.forEach(goToFrame::apply);
    }

    @Then("^body tags is (.*)")
    public void bodyTagsIsText(String text)
    {
        assertEquals(text, $(By.tagName("body")).getText());
    }
}
