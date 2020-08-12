package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.cucumber.common.steps.Steps;
import com.home.selenide2.cucumber.heroku.glue.pages.TyposPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            refresh();
            return page.sentence().getText();
        };
    }

    @Then("text is:")
    public void textIs(String expectedText)
    {
        boolean expectedTextWasFound = IntStream.range(0, repeatCount)
                .mapToObj(i -> repeatFunc.apply(page))
                .anyMatch(expectedText::equals);
        assertTrue(expectedTextWasFound);
    }
}
