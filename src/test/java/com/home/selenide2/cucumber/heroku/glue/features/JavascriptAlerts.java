package com.home.selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class JavascriptAlerts
{
    @When("{string} is clicked")
    public void isClicked(String buttonText)
    {
        $x("//button[text() = '" +  buttonText + "']").click();
    }

    @Then("alert is shown")
    public void alertIsShown()
    {
        confirm();
    }

    @Then("confirm is shown")
    public void confirmIsShown()
    {
        dismiss();
    }

    @Then("prompt is shown")
    public void promptIsShown()
    {
        prompt("Well done");
    }
}
