package com.home.selenide2.cucumber.techlistic.glue.background;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Page
{
    private static final By FIRSTNAME_LOCATOR = By.name("firstname");
    private static final By LASTNAME_LOCATOR = By.name("lastname");
    private static final String GENDER_MALE_LOCATOR = "#sex-0";
    private static final String GENDER_FEMALE_LOCATOR = "#sex-1";

    public SelenideElement firstname()
    {
        return $(FIRSTNAME_LOCATOR);
    }

    public SelenideElement lastname()
    {
        return $(LASTNAME_LOCATOR);
    }

    public SelenideElement maleRadio()
    {
        return $(GENDER_MALE_LOCATOR);
    }

    public SelenideElement femaleRadio()
    {
        return $(GENDER_FEMALE_LOCATOR);
    }
}
