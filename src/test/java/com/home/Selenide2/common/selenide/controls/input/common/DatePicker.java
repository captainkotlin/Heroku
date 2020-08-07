package com.home.Selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.selenide.controls.input.AbstractPicker;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePicker extends AbstractPicker
{
    public DatePicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static DatePicker of(SelenideElement selenideElement)
    {
        return new DatePicker(selenideElement);
    }

    public DatePicker setDate(LocalDate localDate)
    {
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String expectedString = expectedFormatter.format(localDate);
        String[] parts = expectedString.split("-");
        selenideElement.click();
        int i = 0;
        robotWrapper.sendKey(KeyEvent.VK_LEFT, 3);
        robotWrapper.sendKey(parts[i++]);
        robotWrapper.sendKey(parts[i++]);
        robotWrapper.sendKey(parts[i]);
        return this;
    }
}
