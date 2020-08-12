package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hover
{
    @When("first image hovered")
    public void firstImageHovered()
    {
        $x("/html/body/div[2]/div/div/div[1]/img").hover();
    }

    @Then("View profile link is displayed")
    public void viewProfileLinkIsDisplayed()
    {
        var displayed = $x("/html/body/div[2]/div/div/div[1]/div/a").isDisplayed();
        assertTrue(displayed);
    }
}
