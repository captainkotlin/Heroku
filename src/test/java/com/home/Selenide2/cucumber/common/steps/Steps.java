package com.home.Selenide2.cucumber.common.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class Steps
{
    @Given("url = {string}")
    public void open(String url)
    {
        Selenide.open(url);
    }
}
