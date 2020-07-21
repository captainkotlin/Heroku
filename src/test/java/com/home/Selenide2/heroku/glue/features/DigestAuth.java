package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class DigestAuth
{
    private String url;

    @Given("url is {string}")
    public void urlIs(String url)
    {
        this.url = url;
    }

    @When("login is tried with user = {string} and password = {string}")
    public void loginIsTriedWithUserAndPassword(String user, String password)
    {
        Selenide.open(url, AuthenticationType.BASIC, user, password);
    }

    @Then("login is successful")
    public void loginIsSuccessful()
    {
        Assertions.assertTrue($x("//h3[text()='Digest Auth']").isDisplayed());
    }
}
