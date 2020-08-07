package com.home.Selenide2.cucumber.common.steps;

import com.codeborne.selenide.Selenide;
import com.home.Selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Given;

public class Steps
{
    @Given("url = {string}")
    public void open(String url)
    {
        SelenideUtils.open(url);
    }
}
