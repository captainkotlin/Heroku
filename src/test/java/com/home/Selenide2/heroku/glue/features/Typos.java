package com.home.Selenide2.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import com.home.Selenide2.common.steps.Steps;
import com.home.Selenide2.heroku.glue.pages.TyposPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Typos
{
    @Autowired
    private Steps abstractPage;
    @Autowired
    private TyposPage page;
    private int repeatCount = 0;
    private Function<TyposPage, String> repeatFunc;

    @Given("Repeat count = {int}")
    public void repeatCount(int count)
    {
        repeatCount = count;
    }

    @Given("repeat action is refresh")
    public void pageIsRefreshed()
    {
        repeatFunc = (TyposPage page) ->
        {
            Selenide.refresh();
            return page.sentence().getText();
        };
    }

    @Then("text is:")
    public void textIs(String expectedText)
    {
        IntStream.range(0, repeatCount)
                .mapToObj(i -> repeatFunc.apply(page))
                .forEach(actualText ->
                {
                    assertEquals(actualText, expectedText);
                });
    }
}
