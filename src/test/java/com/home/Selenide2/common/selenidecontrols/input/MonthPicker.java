package com.home.Selenide2.common.selenidecontrols.input;

import com.codeborne.selenide.SelenideElement;

import java.awt.event.KeyEvent;

public class MonthPicker extends AbstractPicker
{
    public MonthPicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static MonthPicker of(SelenideElement selenideElement)
    {
        return new MonthPicker(selenideElement);
    }

    public MonthPicker setMonthAndYear(String month, String year)
    {
        selenideElement.click();
        robotWrapper.sendKey(KeyEvent.VK_LEFT);
        robotWrapper.sendKey(month);
        robotWrapper.sendKey(KeyEvent.VK_RIGHT);
        robotWrapper.sendKey(year);
        return this;
    }
}
