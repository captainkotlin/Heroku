package com.home.Selenide2.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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
        boolean displayed = $x("/html/body/div[2]/div/div/div[1]/div/a").isDisplayed();
        Assertions.assertTrue(displayed);
    }
}
