package com.home.Selenide2.common.selenide.controls.input.firefox;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.selenide.controls.input.common.MonthPicker;

public class MonthPickerFirefox extends MonthPicker
{
    public MonthPickerFirefox(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    @Override
    public MonthPicker setMonthAndYear(String month, String year)
    {
        selenideElement.setValue(year + "-" + month);
        return this;
    }
}
