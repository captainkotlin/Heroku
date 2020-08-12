package com.home.selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.SelenideElement;
import com.home.selenide2.common.selenide.controls.input.AbstractPicker;

import java.awt.event.KeyEvent;
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
        var expectedFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        var expectedString = expectedFormatter.format(localDate);
        var parts = expectedString.split("-");
        selenideElement.click();
        var i = 0;
        robotWrapper.sendKey(KeyEvent.VK_LEFT, 3);
        robotWrapper.sendKey(parts[i++]);
        robotWrapper.sendKey(parts[i++]);
        robotWrapper.sendKey(parts[i]);
        return this;
    }
}
