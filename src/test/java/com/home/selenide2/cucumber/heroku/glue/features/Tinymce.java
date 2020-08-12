package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.SelenideElement;
import com.home.selenide2.cucumber.heroku.glue.pages.TinymcePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tinymce
{
    @Autowired
    private TinymcePage page;
    private SelenideElement tinymce;
    private String expectedText;

    @Given("^iFrame is selected$")
    public void iFrameSelected()
    {
        page.switchToMCEU14();
    }

    @When("^text is typed:$")
    public void textIsTyped(String messageText)
    {
        expectedText = messageText;
        tinymce = page.tinymce();
        tinymce.clear();
        tinymce.sendKeys(expectedText);
    }

    @Then("^relevant field contais same text$")
    public void checkText()
    {
        var actualText = tinymce.getText();
        assertEquals(expectedText, actualText);
    }
}
