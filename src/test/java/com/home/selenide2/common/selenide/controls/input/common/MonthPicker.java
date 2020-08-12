package com.home.selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.SelenideElement;
import com.home.selenide2.common.selenide.controls.InBrowserControl;
import com.home.selenide2.common.selenide.controls.input.AbstractPicker;
import com.home.selenide2.common.selenide.controls.input.chrome.MonthPickerChrome;
import com.home.selenide2.common.selenide.controls.input.firefox.MonthPickerFirefox;

import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class MonthPicker extends AbstractPicker
{
    public MonthPicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static MonthPicker of(SelenideElement selenideElement)
    {
        return InBrowserControl.<MonthPicker>inBrowserControl(selenideElement)
                .add(CHROME, MonthPickerChrome::new)
                .add(FIREFOX, MonthPickerFirefox::new)
                .get();
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
