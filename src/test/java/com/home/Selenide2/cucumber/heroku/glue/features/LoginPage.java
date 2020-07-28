package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class LoginPage
{
    @When("^(.*) and (.*) entered")
    public void usernameAndPasswordEntered(String login, String password)
    {
        $("#username").setValue(login);
        $("#password").setValue(password);
        $(".radius").click();
    }

    @Then("^login result = false")
    public void loginResultFalse()
    {
        assertTrue($("#flash").exists());
    }

    @Then("^login result = true")
    public void loginResultTrue()
    {
        boolean urlChanged = WebDriverRunner.getWebDriver().getCurrentUrl().equals("http://the-internet.herokuapp.com/secure");
        assertTrue(urlChanged);
    }
}
