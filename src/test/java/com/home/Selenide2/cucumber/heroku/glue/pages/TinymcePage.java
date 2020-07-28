package com.home.Selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class TinymcePage
{
    private static final String MCEU_14_NAME = "mce_0_ifr";
    private static final String TINYMCE_LOCATOR = "#tinymce";

    public TinymcePage switchToMCEU14()
    {
        WebDriverRunner.getWebDriver().switchTo().frame(MCEU_14_NAME);
        return this;
    }

    public SelenideElement tinymce()
    {
        return $(TINYMCE_LOCATOR);
    }
}
