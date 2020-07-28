package com.home.Selenide2.common.selenidecontrols.input;

import com.codeborne.selenide.SelenideElement;

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
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String expectedString = expectedFormatter.format(localDate);
        selenideElement.setValue(expectedString);
        return this;
    }
}
