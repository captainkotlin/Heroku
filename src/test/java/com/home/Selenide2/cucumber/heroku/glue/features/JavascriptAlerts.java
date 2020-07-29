package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class JavascriptAlerts
{
    @When("{string} is clicked")
    public void isClicked(String arg0)
    {
        $x("//button[text() = '" +  arg0 + "']").click();
    }

    @Then("alert is shown")
    public void alertIsShown()
    {
        Selenide.confirm();
    }

    @Then("confirm is shown")
    public void confirmIsShown()
    {
        Selenide.dismiss();
    }

    @Then("prompt is shown")
    public void promptIsShown()
    {
        Selenide.prompt("Well done");
    }
}
