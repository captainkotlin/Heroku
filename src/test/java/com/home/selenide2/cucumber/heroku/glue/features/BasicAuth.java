package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.AuthenticationType;
import com.home.selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        SelenideUtils.open(url, AuthenticationType.BASIC, user, pass);
    }

    @Then("authorization successful")
    public void authorizationSuccessful()
    {
        boolean successful = $x("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]").isDisplayed();
        assertTrue(successful);
    }
}
