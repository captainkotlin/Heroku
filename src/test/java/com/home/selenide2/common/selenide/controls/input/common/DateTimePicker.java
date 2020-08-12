package com.home.selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.SelenideElement;
import com.home.selenide2.common.selenide.controls.InBrowserControl;
import com.home.selenide2.common.selenide.controls.input.AbstractPicker;
import com.home.selenide2.common.selenide.controls.input.chrome.DateTimePickerChrome;
import com.home.selenide2.common.selenide.controls.input.firefox.DateTimePickerFirefox;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class DateTimePicker extends AbstractPicker
{
    public DateTimePicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static DateTimePicker of(SelenideElement selenideElement)
    {
        return new InBrowserControl<DateTimePicker>(selenideElement)
                .add(CHROME, DateTimePickerChrome::new)
                .add(FIREFOX, DateTimePickerFirefox::new)
                .get();
    }

    public DateTimePicker setDateTime(LocalDateTime localDateTime)
    {
        var localDateTimeStr = localDateTime.toString();
        var dateAndTime = localDateTimeStr.split("T");
        var i = 0;
        var dateParts = dateAndTime[i++].split("-");
        var timeParts = dateAndTime[i].split(":");
        selenideElement.click();
        robotWrapper.sendKey(KeyEvent.VK_LEFT, 3);
        i = 0;
        var year = dateParts[i++];
        var month = dateParts[i++];
        var day = dateParts[i];
        robotWrapper.sendKey(month);
        robotWrapper.sendKey(day);
        robotWrapper.sendKey(year);
        robotWrapper.sendKey(KeyEvent.VK_RIGHT);
        i = 0;
        robotWrapper.sendKey(timeParts[i++]);
        robotWrapper.sendKey(timeParts[i]);
        return this;
    }
}
