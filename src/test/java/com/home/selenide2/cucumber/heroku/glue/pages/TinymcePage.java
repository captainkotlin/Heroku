package com.home.selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class TinymcePage
{
    public void switchToMCEU14()
    {
        WebDriverRunner.getWebDriver().switchTo().frame("mce_0_ifr");
    }

    public SelenideElement tinymce()
    {
        return $("#tinymce");
    }
}
