package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadSecure
{
    @When("url = {string} with {string} and {string}")
    public void popupIsFilledWithAnd(String url, String user, String pass) throws InterruptedException
    {
        Selenide.open(url, AuthenticationType.BASIC, user, pass);
        Thread.sleep(3000);
    }

    @Then("list of files is displayed")
    public void listOfFilesIsDisplayed()
    {
        assertTrue($x("/html/body/div[2]/div/div/h3").exists());
    }
}