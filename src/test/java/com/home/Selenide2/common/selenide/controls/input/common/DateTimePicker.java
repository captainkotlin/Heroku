package com.home.Selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.selenide.controls.InBrowserControl;
import com.home.Selenide2.common.selenide.controls.input.AbstractPicker;
import com.home.Selenide2.common.selenide.controls.input.chrome.DateTimePickerChrome;
import com.home.Selenide2.common.selenide.controls.input.firefox.DateTimePickerFirefox;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.home.Selenide2.common.selenide.actions.InBrowsersAction.inBrowserAction;
import static com.home.Selenide2.common.selenide.controls.InBrowserControl.inBrowserControl;

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
        String localDateTimeStr = localDateTime.toString();
        String[] dateAndTime = localDateTimeStr.split("T");
        int i = 0;
        String[] dateParts = dateAndTime[i++].split("-");
        String[] timeParts = dateAndTime[i].split(":");
        selenideElement.click();
        robotWrapper.sendKey(KeyEvent.VK_LEFT, 3);
        i = 0;
        String year = dateParts[i++];
        String month = dateParts[i++];
        String day = dateParts[i];
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
