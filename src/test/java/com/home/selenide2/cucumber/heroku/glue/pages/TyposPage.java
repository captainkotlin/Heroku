package com.home.selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$x;

@Component
public class TyposPage
{
    public SelenideElement sentence()
    {
        return $x("//*[@id=\"content\"]/div/p[2]");
    }
}
