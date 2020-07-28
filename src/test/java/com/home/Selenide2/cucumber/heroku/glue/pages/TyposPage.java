package com.home.Selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TyposPage
{
    private static final String SENTENCE_LOCATOR = "//*[@id=\"content\"]/div/p[2]";

    public SelenideElement sentence()
    {
        return $x(SENTENCE_LOCATOR);
    }
}
