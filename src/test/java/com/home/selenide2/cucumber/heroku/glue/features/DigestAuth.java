package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Browsers;
import com.home.selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static com.home.selenide2.common.selenide.actions.InBrowsersAction.inBrowsersAction;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        SelenideUtils.open(url, AuthenticationType.BASIC, user, password);
    }

    @Then("login is successful")
    public void loginIsSuccessful()
    {
        inBrowsersAction(Browsers.CHROME).add(s ->
        {
            assertTrue($x("//h3[text()='Digest Auth']").isDisplayed());
            return null;
        }).execute();
        // Empty white page on firefox
    }
}
