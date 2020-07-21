package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class BasicAuth
{
    private String url;

    @Given("basic auth url is {string}")
    public void basicAuthUrlIs(String url)
    {
        this.url = url;
    }

    @When("requested with user = {string} and pass = {string}")
    public void requestedWithUserAndPass(String user, String pass)
    {
        Selenide.open(url, AuthenticationType.BASIC, user, pass);
    }

    @Then("authorization successful")
    public void authorizationSuccessful()
    {
        boolean successful = $x("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]").isDisplayed();
        Assertions.assertTrue(successful);
    }
}
